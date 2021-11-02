pipeline {

    agent any


    stages {
      
        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package -DskipTests"
                
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn deploy -DskipTests"
            }
        }
    }
   
    post {
        always {
             mail to: 'youssefdarder@gmail.com',
             subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
             body: "${env.BUILD_URL} has result ${currentBuild.result}"
       
                    cleanWs()

                }
          }
}
