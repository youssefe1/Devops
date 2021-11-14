FROM openjdk:8-jdk-alpine
EXPOSE 8090
ADD /target/timesheetDEVOPS-1.2.jar app.jar
ENTRYPOINT [ "java", "-jar"	 , "/app.jar"]
