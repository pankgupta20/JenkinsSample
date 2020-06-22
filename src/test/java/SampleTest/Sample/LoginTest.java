package SampleTest.Sample;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    	System.setProperty("webdriver.chrome.driver", "/Users/Shalu/eclipse-workspace/Sample/Resources/chromedriver.exe");	
		//launch chrome
    	driver = new ChromeDriver();
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
    	Assert.assertTrue(homePage.getFormText().contains("Form"));
    }
    
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}
