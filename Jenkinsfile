pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Project Build'
          }
        }

        stage('Test') {
          steps {
            bat 'mvn test'
          }
        }

      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploy Project'
      }
    }

  }
}