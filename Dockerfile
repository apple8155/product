FROM openjdk:8-jdk-alpine
EXPOSE 8443 9042
ARG JAR_FILE=target/product-*.jar
ADD ${JAR_FILE} product.jar
ENTRYPOINT ["java","-jar","product.jar"]

