# Build stage
FROM maven:3.9.4-eclipse-temurin-17 as builder
WORKDIR /app
COPY backend/pom.xml .
COPY backend/src ./src
RUN mvn -f pom.xml -DskipTests package

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/ecommerce-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
