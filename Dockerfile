FROM maven:3.8.2-jdk-8
WORKDIR /entreprise
EXPOSE 8082
COPY /target/timesheetDEVOPS-1.3.jar /entreprise/Entreprise.jar
RUN mvn clean install
CMD mvn spring-boot:run
ENTRYPOINT [ "java","-jar","Entreprise.jar"]
