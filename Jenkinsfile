pipeline {
     agent any
 
     tools {
         maven 'MAVEN_HOME'
     }
 
     parameters {
         choice(
             name: 'PROJECT',
             choices: ['DemoQaWinter24', 'OrangeHRM'],
             description: 'Choose project'
         )
         string(
             name: 'TEST_CASE_ID',
             defaultValue: '',
             description: 'Test Case ID'
         )
     }
 
     stages {
         stage('Test') {
             steps {
                 script {
                     def project = params.PROJECT ?: 'DemoQaWinter24'
                     def testCaseId = params.TEST_CASE_ID ?: ''
                     
                     sh "mvn clean test -P${project} -DtestCaseId=${testCaseId} -DfailIfNoTests=false"
                 }
             }
         }
     }
 
     post {
         always {
             allure([
                 includeProperties: false,
                 jdk: '17.0.3',
                 properties: [],
                 reportBuildPolicy: 'ALWAYS',
                 results: [[path: 'target/allure-results']]
             ])
         }
     }
 }
