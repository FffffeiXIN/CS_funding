# Usage:
# 1. Build the image: `docker build -t cs304:v1 --rm .`
# 2. Start a new container: `docker run --rm --name cs304 -p 8000:8080 cs304:v1`
# 3. Now the backend is running on port 8000.

FROM openjdk:8

COPY target/CS_funding-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]