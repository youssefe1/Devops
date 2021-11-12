pipeline {

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
