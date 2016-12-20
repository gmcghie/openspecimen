#!/bin/bash
echo "Getting OpenSpecimen Defaults..."

. set-default-vars.sh

file=/opt/hutch/initialized.done
if [ ! -f $file ] ; then
  echo "Preparing OpenSpecimen Configs..."

cat << EOF > $file
Initialization file.  Delete to re-initialize.
EOF

  if [ "true"="${USE_SSL}" ] ; then
    cp -v /sessions/catalina.sh /usr/local/tomcat/bin/
    sed -i "s#§§keystorepath#${TOMCAT_KEYSTORE_PATH}#g" /usr/local/tomcat/bin/catalina.sh
    sed -i "s#§§keystorepassword#${TOMCAT_KEYSTORE_PASSWORD}#g" /usr/local/tomcat/bin/catalina.sh
    sed -i "s#§§truststorepath#${TOMCAT_TRUSTSTORE_PATH}#g" /usr/local/tomcat/bin/catalina.sh
    sed -i "s#§§truststorepassword#${TOMCAT_TRUSTSTORE_PASSWORD}#g" /usr/local/tomcat/bin/catalina.sh

    cp -v /sessions/server.xml /usr/local/tomcat/conf/
    sed -i "s#§§certpath#${TOMCAT_CERT_PATH}#" /usr/local/tomcat/conf/server.xml
    sed -i "s#§§keypath#${TOMCAT_CERT_KEY_PATH}#" /usr/local/tomcat/conf/server.xml
    sed -i "s#§§certchainpath#${TOMCAT_CERT_CHAIN_PATH}#" /usr/local/tomcat/conf/server.xml

    slString='?verifyServerCertificate=true\&amp;useSSL=true\&amp;requireSSL=true'
  else
    sslString=''
  fi

  sed -i "s#§§username#${MYSQL_USER}#g" /usr/local/tomcat/conf/context.xml
  sed -i "s#§§password#${MYSQL_PASSWORD}#g" /usr/local/tomcat/conf/context.xml
  sed -i "s#§§useddatabasedriver#${DATABASE_DRIVER}#g" /usr/local/tomcat/conf/context.xml
  sed -i "s#§§useddatabasetype#${DATABASE_TYPE}#g" /usr/local/tomcat/conf/context.xml
  sed -i "s#§§host#${DATABASE_HOST}#g" /usr/local/tomcat/conf/context.xml
  sed -i "s#§§port#${DATABASE_PORT}#g" /usr/local/tomcat/conf/context.xml
  sed -i "s#§§database#${MYSQL_DATABASE}#g" /usr/local/tomcat/conf/context.xml
  sed -i "s#§§sslpostfix#$sslString#" /usr/local/tomcat/conf/context.xml
  
  sed -i "s#§§username#${TOMCAT_MANAGER_USER}#g" /usr/local/tomcat/conf/tomcat-users.xml
  sed -i "s#§§password#${TOMCAT_MANAGER_PASSWORD}#g" /usr/local/tomcat/conf/tomcat-users.xml
  
  echo "Done with Configs..."
else
  echo "No Config changes needed..."
fi

/usr/local/tomcat/bin/catalina.sh run
