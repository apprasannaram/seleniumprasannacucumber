pipeline {
    agent any

    tools {
        // Configure these names in Jenkins: Manage Jenkins -> Tools
        jdk 'JDK21'
        maven 'Maven'
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome'], description: 'Browser for Selenium tests')
        booleanParam(name: 'HEADLESS', defaultValue: true, description: 'Run browser in headless mode')
    }

    environment {
        MAVEN_OPTS = 'maven.test.failure.ignore=false'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                bat 'git branch --show-current || git rev-parse --abbrev-ref HEAD'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn -version'
                bat 'mvn clean test -Dbrowser=%BROWSER% -Dheadless=%HEADLESS%'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/cucumber-reports/**/*, target/surefire-reports/**/*, screenshots/**/*', allowEmptyArchive: true
            publishHTML(target: [
                reportDir: 'target/cucumber-reports',
                reportFiles: 'cucumber.html',
                reportName: 'Cucumber HTML Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
        }
    }
}
