pipeline {
    agent any

    tools {
        maven 'Maven-3.9.6'
        jdk 'JDK-17'
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'RELEASE_3.0.1', url: 'https://github.com/learningspace1813/seleniumTestCasesForDynamicAPI123.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Results') {
            steps {
                junit '**/test-output/testng-results.xml'
                archiveArtifacts artifacts: '**/test-output/*', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "Pipeline finished at ${new Date()}"
        }
    }
}
