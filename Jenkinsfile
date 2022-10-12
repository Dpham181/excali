pipeline {
    agent any
    tools {
      maven 'mvn' 
    }
    stages {
        stage('git check out and maven build') {
            steps {
               checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Dpham181/excali']]])
               bat 'mvn clean install'
            }
        }
        
          stage('docker build image') {
            steps {
              bat 'docker  build -t calitour .' 
            }
        }
        
             stage('docker deploy to localhost') {
            steps {
              bat 'docker run -d -p 8081:8083 calitour' 
            }
        }
        
        
   }    
}