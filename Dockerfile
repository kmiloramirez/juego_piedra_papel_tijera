FROM openjdk:17.0.2

COPY aplicacion/build/libs/aplicacion.jar app.jar

EXPOSE 8082

ENTRYPOINT [ "java", "-jar", "app.jar" ]



