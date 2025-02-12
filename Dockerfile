FROM openjdk:17-jdk-slim

MAINTAINER onlinegrocery

COPY target/POSDataservice-0.0.1-SNAPSHOT.jar POSDataservice.0.0.1-SNAPSHOT.jar

RUN chmod 755 /POSDataservice.0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java","-jar", "/POSDataservice.0.0.1-SNAPSHOT.jar" ]
