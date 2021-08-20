FROM openjdk:11-jre-slim
ADD bot-sender-telegram.jar /opt/bot-sender-telegram.jar

EXPOSE 8080

ENTRYPOINT java -XX:+PrintFlagsFinal $JAVA_OPTIONS -jar /opt/bot-sender-telegram.jar
