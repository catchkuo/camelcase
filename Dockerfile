FROM centos:7.3.1611

VOLUME ["/opt/ticket"]

ARG JarName=ticket-Camel-1.0.0

COPY target/$JarName.jar /opt/ticket/$JarName.jar

RUN yum install -y java-1.8.0-openjdk

ENV RunJarName=$JarName

WORKDIR /opt/ticket

CMD java -jar /opt/ticket/$RunJarName.jar --spring.config.location=application.properties

