FROM openjdk:8-jdk-alpine
EXPOSE 8088
ADD /target/timesheetDEVOPS-1.3.jar app.jar
ENTRYPOINT [ "java", "-jar"	 , "/app.jar"]
