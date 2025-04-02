FROM eclipse-temurin:21
LABEL maintainer="lucasgfeldmann@gmail.com"
WORKDIR /app
COPY target/Ponto-0.0.1-SNAPSHOT.jar /app/ponto.jar
ENV DATABASE_URL=jdbc:postgresql://127.0.0.1:5432/ponto
ENTRYPOINT ["java", "-jar", "ponto.jar"]