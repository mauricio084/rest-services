# Utilizar la imagen oficial de Java 11 de OpenJDK como imagen base
FROM openjdk:11-jdk

WORKDIR /app

# Copiar el archivo JAR construido de la aplicación en el contenedor
COPY target/rest-0.0.1-SNAPSHOT.jar /app.jar

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Comando que se ejecutará cuando el contenedor se inicie
CMD ["java", "-jar", "/app.jar"]