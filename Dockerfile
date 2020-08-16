FROM openjdk:8u191-jre-alpine3.9


#COMPILED FILES
WORKDIR C:/AutoInfra/target

#ADDING COMPILE JARS,LIBS
ADD target/AutoInfra-docker.jar         AutoInfra-docker.jar
ADD target/AutoInfra-docker-tests.jar   AutoInfra-docker-tests.jar
ADD target/libs                         libs

#ADDING TestNG.XMLS

ADD Suites/DuckDuckGo.xml               DuckDuckGo.xml
ADD Suites/MercuryTours.xml             MercuryTours.xml

#ADD HEALTH CHECK SCRIPT
#ADD healthcheck.sh                      healthcheck.sh

##JAR RUN COMMAND
ENTRYPOINT java -cp AutoInfra-docker.jar:AutoInfra-docker-tests.jar:libs/* -DGRID_TYPE=$GRID_TYPE -DBROWSER=$BROWSER -DHOST_HUB=$HOST_HUB org.testng.TestNG DuckDuckGo.xml
#UNABLE TO ADD -DMODULE=$MODULE