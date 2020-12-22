pipeline{
    agent any

    stages{
        stage('Checkout') {
            steps{
                git 'https://github.com/IriinaS/jenkins-spark-pipeline.git'
            }
        }
        boolean compileSuccess = true
        stage('Compile') {
            steps{
                echo "Compiling..."
                try{
                      sh "/usr/bin/sbt compile"
                } catch (Exception e){
                      compileSuccess = false
                }
            }
        }
        stage('Test') {
            steps{
                if(compileSuccess){
                    echo "Testing..."
                    sh "/usr/bin/sbt test"
                }
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
