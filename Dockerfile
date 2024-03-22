FROM gradle:latest
COPY . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build
RUN cp aplicacion/build/libs/aplicacion.jar /home/gradle/project/app.jar
WORKDIR /home/gradle/project
EXPOSE 8082
ENTRYPOINT [ "java", "-jar", "app.jar" ]

