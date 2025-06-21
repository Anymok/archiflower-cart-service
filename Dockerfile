FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /usr/src/app

COPY . /usr/src/app

ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD
ARG PORT

RUN mvn package

FROM openjdk:17-jdk-alpine

WORKDIR /

COPY --from=builder /usr/src/app/target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
