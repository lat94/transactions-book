FROM openjdk:11-jre-slim
VOLUME /tmp
ADD build/libs/transactions-book-0.0.1-SNAPSHOT.jar transactions-api.jar
COPY src/main/resources/transactions.json ./src/main/resources/transactions.json
ENTRYPOINT ["java", "-jar", "/transactions-api.jar"]