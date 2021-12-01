FROM openjdk:14-oraclelinux7

COPY target/calculator*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]