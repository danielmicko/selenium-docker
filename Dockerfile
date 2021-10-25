#FROM openjdk:8u191-jre-alpine
#FROM openjdk
FROM alpine
#pridan curl pro pingovani statusu a parsing json response
RUN apk add curl jq 
ADD openjdk

#Creating workspace
WORKDIR /usr/share/dockerfiles

#ADD .jar under the target file from host into this image
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs 						libs

#in case of any other dependency like .csv / .json / .xls
#ADD that as well
#ADD suites
ADD bookflight-module.xml 				bookflight-module.xml
ADD search-module.xml 					search-module.xml

# ADD health check script
# RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh
ADD healthcheck.sh                      healthcheck.sh

#alpine je linux image, pouzivame : misto ; a kdyz vipisujeme jar files a nemusime to davat do uvozovek
#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
#variables, ktere predavame...pri pousteni kontaineru musime zadat vsechny
#BROWSER
#HUB_HOST
#MODULE

#pridan novy entrypoint
ENTRYPOINT sh healthcheck.sh