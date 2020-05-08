FROM openjdk:11-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/apistore.jar
WORKDIR /app
ENTRYPOINT java -jar apistore.jar