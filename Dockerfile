FROM openjdk:17.0.2



COPY application/build/libs/*.jar app.jar

ENTRYPOINT [ "/bin/bash", "-c", "source <(cat /vault/secrets/*) && java -javaagent:/opt/javaagent.jar $JAVA_OPTS -jar /app.jar" ]
