# Estágio 1: Build do projeto Maven
FROM maven:3.8.6-eclipse-temurin-11-alpine as builder

# Definir o diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixar as dependências do Maven
RUN mvn dependency:go-offline -B

# Copiar o código-fonte para o diretório de trabalho
COPY src ./src

# Realizar o build do projeto
RUN mvn package -DskipTests

# Estágio 2: Criar a imagem final
FROM openjdk:11.0-jdk-slim

# Definir as variáveis de ambiente
ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

# Definir o diretório de trabalho no contêiner
WORKDIR /excala/api

# Copiar o arquivo JAR gerado no estágio anterior para o diretório de trabalho no contêiner
COPY --from=builder /app/target/excaladashboard.jar /excala/api/excaladashboard.jar

# Exportar as portas utilizadas
EXPOSE 5005 8080

# Definir o comando para iniciar o projeto Spring Boot quando o contêiner for executado
CMD ["sh", "-c", "java $ADDITIONAL_OPTS -Dspring.profiles.active=$PROFILE -jar excaladashboard.jar"]
