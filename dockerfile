#start with base image containing runtime
FROM openjdk:17-jdk-slim
MAINTAINER rishisharan
COPY target/POSDataservice-0.0.1-SNAPSHOT.jar POSDataservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "POSDataservice-0.0.1-SNAPSHOT.jar" ]