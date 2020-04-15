## Use Tomcat9 OpenJDK 11 image
FROM tomcat:9.0-jdk11-openjdk AS pres
LABEL maintainer="jaddap2@nih.gov"

### These Arguments Can be overriden during build
ARG PORT=8080

### Update all dependencies
RUN apt-get update


### Copy WAR file from local machine to container
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE $PORT
CMD ["catalina.sh","run"]
