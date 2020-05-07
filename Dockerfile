FROM openjdk:11-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/secao25.jar
WORKDIR /app
ENTRYPOINT java -jar secao25.jar