pipeline {
    agent any
    tools {
      maven 'maven 3.8.6' 
    }
    stages {
        stage('git check out and maven build') {
            steps {
               checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Dpham181/excali']]])
               sh 'mvn clean install'
            }
        }
       
}