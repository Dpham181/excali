FROM adoptopenjdk/openjdk8
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY /target/*.jar calitour.jar
CMD ["java","-jar","dpham181/calitour.jar"]