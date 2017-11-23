FROM docker.io/java:8-jdk-alpine

MAINTAINER Zak Hassan zak.hassan1010@gmail.com


RUN mkdir -p /app
WORKDIR /app
ADD ./target/jiminy-html-server-0.0.1-SNAPSHOT.jar /app

EXPOSE 8181 

ENTRYPOINT ["java","-jar", "jiminy-html-server-0.0.1-SNAPSHOT.jar", "--server.port=8181"]
