# Build Stage
FROM gradle:jdk17-jammy as build-stage

WORKDIR /app

COPY . .

RUN ./gradlew build

# Package Stage
FROM eclipse-temurin:17-jdk-jammy

COPY --from=build-stage /app/build/libs/todolist-backend-app.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]




