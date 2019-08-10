FROM openjdk:7-jre
MAINTAINER xxx xxx@xxx.com


ENV RABBITMQ_HOS 127.0.0.1
ENV MYSQL_HOST 127.0.0.1
ENV REDIS_HOST 127.0.0.1

COPY target/leyou-common-SNAPSHOT.jar /leyou-common.jar

ENTRYPOINT ["java", "-jar", "/leyou-common.jar"]
