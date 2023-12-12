FROM amazoncorretto:17

MAINTAINER matheus

ENV email email-0.0.1-SNAPSHOT

WORKDIR /app

COPY ./target/${email}.jar /app/${email}.jar

CMD java -jar ${email}.jar docker-compose-run.sh

EXPOSE 8081