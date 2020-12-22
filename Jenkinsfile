pipeline{
    agent any

    stages{
        stage('Checkout') {
            steps{
                git 'https://github.com/IriinaS/jenkins-spark-pipeline.git'
            }
        }
        stage('Compile') {
            steps{
                echo "Compiling..."
                sh "/usr/bin/sbt compile"
            }
        }
        stage('Test') {
            steps{
                echo "Testing..."
                sh "/usr/bin/sbt test"
            }
        }
        stage('Code Analysis') {
            steps {
                echo "Analyzing..."
                recordIssues(tools: [checkStyle(pattern: 'checkstyle-result.xml')])
            }
        }
    }
}
