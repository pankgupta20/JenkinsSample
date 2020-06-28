package SampleTest.Sample;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;;

public class LoginTest 
{	
    WebDriver driver;
    LoginPage loginPage; 
    HomePage homePage;
    
	
    @BeforeMethod
    public void setup() {	
    	String path = System.getProperty("user.dir");
    	System.setProperty("webdriver.chrome.driver", path+"\\Resources\\chromedriver.exe");	
		//launch chrome
    	ChromeOptions chromeOptions = new ChromeOptions();
    	//chromeOptions.addArguments("--verbose");
        chromeOptions.addArguments("--whitelisted-ips='192.168.1.14'");
		/* chromeOptions.addArguments("--proxy-server=192.68.1.14:8080"); */
    	
    	driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://executeautomation.com/demosite/Login.html");
    }
    
    @Test
    public void test() throws InterruptedException {
    	loginPage = new LoginPage(driver);
    	homePage = new HomePage(driver);
    	loginPage.Login("admin", "admin");
    	loginPage.ClickLogin();
    	Thread.sleep(2000);
    	System.out.println("text: "+homePage.getFormText());
    	Assert.assertTrue(homePage.getFormText().contains("Form"));
    	System.out.println("Test Completed Successfully");
    }
    
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}
