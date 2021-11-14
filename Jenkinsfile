pipeline {
       
       environment
{
registry = "maneltabessi/timesheet"
registryCredential= 'dockerHub'
dockerImage = ''
}



agent any
stages{
       stage('Checkout GIT'){
       steps{
             echo 'Pulling...';
             git branch: 'main',
             url : 'https://github.com/youssefe1/Devops.git';
             }
         }
         
         stage("Test,Build"){
          steps{
          bat """mvn clean package -Dmaven.test.skip=true"""
          }
          }
          
          stage("Sonar"){
          steps{
          bat """mvn sonar:sonar"""
          }
          }
          
          stage("Nexus"){
          steps{
          bat """mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheetDEVOPS -Dversion=1.4 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo  -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheetDEVOPS-1.4.jar"""
          }
          }
           
       stage('Building our image') {
          steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
          }
          stage('Deploy our image') {
          steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
          }
          stage('Cleaning up') {
          steps { bat "docker rmi $registry:$BUILD_NUMBER" }
          }
          }
          
          }
       
       post {
    always {
       mail to: 'meissabnali@gmail.com',
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
   
       }    
        }
      
      
       }
