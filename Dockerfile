FROM openjdk:17
EXPOSE 8080
ADD target/book-my-train.jar book-my-train.jar
ENTRYPOINT ["java", "-jar", "/book-my-train.jar"]