FROM openjdk:11
ADD target/bosch-io-repos.jar bosch-io-repos.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "bosch-io-repos.jar"]