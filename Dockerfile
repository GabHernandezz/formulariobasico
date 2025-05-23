FROM openjdk:17
COPY "./target/quizGabriela-1.jar" "app.jar"
EXPOSE 8888
ENTRYPOINT [ "java", "-jar", "app.jar"]