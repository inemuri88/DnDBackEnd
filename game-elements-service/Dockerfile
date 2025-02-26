FROM openjdk:21-slim

WORKDIR /app

COPY target/game-elements-service-0.0.1-SNAPSHOT.jar game-elements-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

CMD ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]
