FROM openjdk:11-jre-slim
ADD target/bot-sender-telegram-1.0.0.jar /opt/bot-sender-telegram-1.0.0.jar

EXPOSE 8080

ENTRYPOINT java -XX:+PrintFlagsFinal $JAVA_OPTIONS -jar /opt/bot-sender-telegram-1.0.0.jar
