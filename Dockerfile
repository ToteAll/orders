FROM alpine/java:21

COPY ./build/libs/orders-0.0.1-SNAPSHOT.jar application.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/application.jar"]