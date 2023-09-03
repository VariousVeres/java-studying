FROM openjdk

WORKDIR /src/main/java

COPY . /app

CMD ["java DemoClass"]