pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64' // замените на ваш путь
        MAVEN_HOME = '/usr/share/maven' // замените на ваш путь
    }

    parameters {
        choice(
            name: 'PROJECT',
            choices: ['DemoQAWinter24'],
            description: 'Choose project'
        )
        choice(
            name: 'TEST_SUITE',
            choices: ['Regression', 'Smoke', 'E2E'],
            description: 'Test Suite'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'

            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }

        stage('Test') {
            steps {
                script {
                    def project = params.PROJECT ?: 'DemoQAWinter24'
                    def testSuite = params.TEST_SUITE ?: 'Regression'
                    echo "Running tests for project: ${project}, test suite: ${testSuite}"
                    sh "mvn clean test -P${testSuite} -DtestCaseId=${project} -DfailIfNoTests=false"
                }
            }
            post {
                always {
                    echo 'Publishing TestNG results...'
                    publishTestNGResults(testResultsPattern: '**/target/surefire-reports/testng-results.xml')
                }
            }
        }

        stage('Static Code Analysis') {
            steps {
                echo 'Running static code analysis...'
                sh "${MAVEN_HOME}/bin/sonar-scanner"
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                sh 'ssh user@server "deploy_script.sh ${env.BUILD_ID}"'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
            // Отправить уведомление об успешном выполнении
        }
        failure {
            echo 'Pipeline failed!'
            // Отправить уведомление о неуспешном выполнении
        }
        always {
            cleanWs()
        }
    }
}
