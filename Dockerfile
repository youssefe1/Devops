FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD /target/timesheetDEVOPS-1.3.jar Entreprise.jar
ENTRYPOINT [ "java","-jar","Entreprise.jar"]
