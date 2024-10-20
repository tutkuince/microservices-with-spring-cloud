FROM eclipse-temurin:17

LABEL mentainer="incetutku@gmail.com"

WORKDIR /app

COPY target/spring-boot-docker-demo-0.0.1-SNAPSHOT.jar /app/spring-boot-docker-demo.jar

ENTRYPOINT ["java", "-jar", "spring-boot-docker-demo.jar"]