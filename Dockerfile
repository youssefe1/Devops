FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD /target/timesheetDEVOPS-1.0.jar
ENTRYPOINT [ "java", "-jar"	 , "/app.jar"]