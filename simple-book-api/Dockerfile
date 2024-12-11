FROM openjdk:21-jdk-slim

# Diretório de trabalho no contêiner
WORKDIR /app

# Copia os arquivos necessários do Quarkus
COPY target/quarkus-app /app/

# Porta exposta pela aplicação
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "/app/quarkus-run.jar"]
