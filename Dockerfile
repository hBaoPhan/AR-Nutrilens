# Stage 1: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Add a non-root system user for security
RUN addgroup -S nutrilens && adduser -S nutrilens -G nutrilens

# Copy the pre-built jar from target/
COPY target/nutrilens-backend-1.0.0.jar app.jar

USER nutrilens

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
