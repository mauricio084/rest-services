pipeline {
    
    agent {
        docker {
            image 'maven:3.9.0-eclipse-temurin-11' 
            args '-v /root/.m2:/root/.m2' 
        }
    }

    stages {
    	stage('Cloning Repository') {
            steps {
                echo 'Clonning from Github Repository...'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Docker Build') {
            steps {
                echo 'Building Docker Image....'
                sh 'docker build -t mauricio084/java-project .'
                sh 'docker push mauricio084/java-project'
            }
        }
    }
}