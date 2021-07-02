FROM openjdk:11
EXPOSE 8000
ADD ./target/change-service.jar change-service
ENTRYPOINT ["java","-jar","change-service"]