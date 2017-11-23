#!/bin/sh
VERSION="1.0.0-SNAPSHOT"
MAINTAINERS="Zak Hassan"
COMPONENT="movie-recommender-service"

#cleaning up the image folder:
mvn clean install

# docker run   -p 8081:8081  docker.io/zmhassan/$COMPONENT
docker   build  --rm -t  $COMPONENT  .

docker tag   $COMPONENT  docker.io/zmhassan/$COMPONENT
docker push  docker.io/zmhassan/$COMPONENT
