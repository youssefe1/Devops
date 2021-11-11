pipeline {
 environment {
    registry = "youssefe1/timesheet"
    registryCredential = 'dockerhub_id'
    dockerImage = ''
  }
    agent any


    stages {
      
        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package"
                
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn deploy"
            }
        }
        
        stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
  stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    
     stage('Run images/mysql-phpmyadmin on a container') {
      steps{
        bat "docker-compose up --detach"
      }
    }
    
    stage('Delete the unused images') {
        steps {
            bat "docker rmi $registry:$BUILD_NUMBER"
                }
            }
    }
   
    post {
        always {
             mail to: 'youssefdarderi@gmail.com',
             subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
             body: "${env.BUILD_URL} has result ${currentBuild.result}"
       
                    cleanWs()

                }
          }
}
