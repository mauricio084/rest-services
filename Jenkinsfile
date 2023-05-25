pipeline {
  
  environment{
    dockerimagename = "mauricio084/java-project"
  }

  agent{
    docker{
      image 'maven:3.9.0-eclipse-temurin-11'
      args '-v /root/.m2:/root/.m2'
    }
  }

  options{
    skipStagesAfterUnstable()
  }

  stages{
    stage('Build'){
      steps{        
        sh 'mvn -DskipTests clean package'
      }
    }
    stage('Test'){
      steps{
        echo'Testing..'
        sh 'mvn test'
      }
      post{
        always{
          junit'target/surefire-reports/*.xml'
        }
      }
    }
    //stage('Docker Build'){
      //steps{
        //echo'Building Docker Image....'//sh'docker build -t mauricio084/java-project .'//
      //}//
   // }
    stage('Build image'){
      steps{        
        script{
          dockerImage = docker.build dockerimagename
        }
      }
    }
    stage('Push image'){   
        steps{      
            withDockerRegistry([credentialsId: "dockerhublogin",url: ""]){
                dockerImage.push()
            }
        }
    }
    }
}