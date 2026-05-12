pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Verify Java and Maven') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Clean and Run Cucumber Tests') {
            steps {
                bat 'mvn clean test -Dheadless=true'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/cucumber-reports/**', allowEmptyArchive: true

            publishHTML(target: [
                reportDir: 'target/cucumber-reports',
                reportFiles: 'cucumber.html',
                reportName: 'Cucumber HTML Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
        }

        success {
            echo 'Build passed. Selenium Cucumber tests executed successfully.'
        }

        failure {
            echo 'Build failed. Check Console Output and Cucumber HTML Report.'
        }
    }
}