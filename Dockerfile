FROM openjdk:17.0.2-jdk-slim

MAINTAINER onlinegrocery

COPY target/posdataservice-0.0.1-SNAPSHOT.jar posdataservice-0.0.1-SNAPSHOT.jar

#RUN chmod 755 /posdataservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java","-jar", "/posdataservice-0.0.1-SNAPSHOT.jar" ]
