FROM ghcr.io/graalvm/jdk:ol7-java17
MAINTAINER khnam <synstin@gmail.com>

EXPOSE 8080

VOLUME /tmp
RUN mkdir -p /app
COPY ./build/libs/onemm_spring-0.0.1-SNAPSHOT.jar /app/onemm_spring-0.0.1-SNAPSHOT.jar
ADD ./startup.sh /usr/local/bin/startup.sh
RUN chmod u+x /usr/local/bin/startup.sh
WORKDIR /app

CMD /usr/local/bin/startup.sh