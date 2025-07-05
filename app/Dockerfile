ARG MVN_VERSION=3.9.10
ARG JDK_VERSION=21

FROM maven:${MVN_VERSION}-eclipse-temurin-${JDK_VERSION} as BUILD
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


FROM gcr.io/distroless/java21-debian12
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]