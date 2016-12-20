# Hutch OpenSpecimen Docker Container build file

FROM tomcat:7.0.73-jre8
MAINTAINER Glen McGhie <gmcghie@fredhutch.org>

RUN rm -r $CATALINA_HOME/webapps/docs \
    && rm -r $CATALINA_HOME/webapps/examples

#Add the war and jar files
ADD ./build/libs/openspecimen.war /usr/local/tomcat/webapps/
ADD ./lib/mysql-connector-java-5.1.40-bin.jar /usr/local/tomcat/lib/

# Add tomcat users
ADD ./config/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml

# Add DB context file
ADD ./config/context.xml /usr/local/tomcat/conf/context.xml

ADD ./scripts/*.sh /opt/hutch/
WORKDIR /opt/hutch
RUN chmod a+x *.sh
CMD ["/bin/bash", "/opt/hutch/entryPoint.sh"]
