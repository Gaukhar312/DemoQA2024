pipeline {
    agent any

    tools {
        maven 'MAVEN'  // Укажите правильное имя инструмента Maven
    }

    parameters {
        string(name: 'SUITE_FILE', defaultValue: 'smoke_suite.xml', description: 'Path to TestNG suite file')
        string(name: 'TEST_CLASSES', defaultValue: 'TextBoxTest,PracticeFormTest,ProgressBarTest,CheckboxTest,WebTableTest', description: 'Comma-separated list of TestNG test classes')
    }

    stages {
        stage('Preparation') {
            steps {
                echo "Running Preparation Stage"
                // Клонирование репозитория
                git branch: 'master', url: 'https://github.com/Gaukhar312/DemoQA2024.git'
            }
        }

        stage('Build') {
            steps {
                echo "Running Build Stage"
                // Компиляция проекта с помощью Maven
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo "Running Test Stage"

                // Создание динамического TestNG suite файла
                def suiteFileContent = """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
                    <suite name="Smoke Suite">
                        <test verbose="2" preserve-order="true" name="TestSuite">
                            <classes>
                                ${params.TEST_CLASSES.split(',').collect { "<class name=\"$it\"></class>" }.join('\n')}
                            </classes>
                        </test>
                    </suite>
                """

                writeFile file: 'dynamic-testng.xml', text: suiteFileContent

                // Создание Regression Suite XML файла
                def regressionSuiteContent = """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
                    <suite name="Regression Suite">
                        <!--    <listeners>-->
                        <!--        <listener class-name="com.demoqa.listener.ScreenshotListener"></listener>-->
                        <!--    </listeners>-->
                        <test verbose="2" preserve-order="true" name="C:\\Users\\hayan\\DemoQaWinter24\\src\\test">
                            <classes>
                                <class name="TextBoxTest"></class>
                                <class name="PracticeFormTest"></class>
                                <class name="ProgressBarTest"></class>
                                <class name="CheckboxTest"></class>
                                <class name="WebTableTest"></class>
                            </classes>
                        </test>
                    </suite>
                """

                writeFile file: 'regression_suite.xml', text: regressionSuiteContent

                // Запуск тестов с использованием динамически созданного TestNG suite файла
                sh "mvn test -DsuiteXmlFile=dynamic-testng.xml"
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace"
            // Добавьте команды для очистки, если необходимо
            // cleanWs() - если установлен плагин для очистки рабочей директории
        }

        success {
            echo "Build succeeded"
            // Добавьте команды для уведомления об успешной сборке
            // Например: mail to: 'team@example.com', subject: 'Build Success', body: 'The build was successful.'
        }

        failure {
            echo "Build failed"
            // Добавьте команды для уведомления о неудачной сборке
            // Например: mail to: 'team@example.com', subject: 'Build Failed', body: 'The build failed.'
        }
    }
}
