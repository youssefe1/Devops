FROM openjdk:8-jdk-alpine
EXPOSE 8088
ADD /target/Timesheet_DevOps-1.2.jar app.jar
ENTRYPOINT [ "java", "-jar"	 , "/app.jar"]
