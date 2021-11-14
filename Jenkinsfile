pipeline {
 environment {
    registry = "haithamkossentini/devopsemploye1"
    registryCredential = 'haithamkossentini'
    dockerImage = ''
  }
    agent any


    stages {
      
        stage("MvnCleanInstall") {
            steps {
                bat "mvn -version"
                bat "mvn clean package"
                
            }
        }
        
        stage("SonarQube") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn deploy"
            }
        }
        
        stage('PicBuild') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
  stage('PicDeploy') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    
     stage('Starting pic of mysql on container') {
      steps{
        bat "docker-compose up --detach"
      }
    }
    
    stage('Delete unused pics') {
        steps {
            bat "docker rmi $registry:$BUILD_NUMBER"
                }
            }
    }
   
    post {
        always {
             mail to: 'kossentinihaitham8@gmail.com',
             subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
             body: "${env.BUILD_URL} has result ${currentBuild.result}"
       
                    cleanWs()

                }
          }
}
