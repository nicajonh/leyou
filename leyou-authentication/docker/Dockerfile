FROM openjdk:7-jre
MAINTAINER xxx xxx@xxx.com


ENV RABBITMQ_HOS 127.0.0.1
ENV MYSQL_HOST 127.0.0.1
ENV REDIS_HOST 127.0.0.1

COPY target/leyou-authentication-SNAPSHOT.jar /leyou-authentication.jar

ENTRYPOINT ["java", "-jar", "/leyou-authentication.jar"]
