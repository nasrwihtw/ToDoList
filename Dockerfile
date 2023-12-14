# Build Stage
FROM adoptopenjdk:17-jre-hotspot as build-stage

WORKDIR /app

COPY . .

RUN ./gradlew build

# Production Stage
FROM adoptopenjdk:11-jre-hotspot as production-stage

COPY --from=build-stage /app/build/libs/todolist-backend-app.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]

