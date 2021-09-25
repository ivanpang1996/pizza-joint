FROM openjdk:15-jdk
EXPOSE 8080
#COPY keystore.p12 /etc/keystore.p12
ARG JAR_FILE=build/libs/order-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]