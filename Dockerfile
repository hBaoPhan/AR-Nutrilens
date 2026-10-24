# Stage 1: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Configure Vietnam Timezone (UTC+7) and non-root system user for security
RUN apk add --no-cache tzdata && \
    cp /usr/share/zoneinfo/Asia/Ho_Chi_Minh /etc/localtime && \
    echo "Asia/Ho_Chi_Minh" > /etc/timezone && \
    addgroup -S nutrilens && adduser -S nutrilens -G nutrilens

# Copy the pre-built jar from target/
COPY target/nutrilens-backend-1.0.0.jar app.jar

USER nutrilens

EXPOSE 8080

ENTRYPOINT ["java", "-Duser.timezone=Asia/Ho_Chi_Minh", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
