# Info
The application was built with:

  - [Kotlin](https://github.com/JetBrains/kotlin) as programming language
  - [testcontainers](https://github.com/testcontainers/testcontainers-java) Java library that supports JUnit tests, providing lightweight, throwaway instances of common databases that can run in a Docker container
# to Read 
- [Как собрать образ Oracle DB для Testcontainers](https://habr.com/ru/post/480106/)
- [Docker. Создание контейнера с базой данных Oracle](https://nicholasgribanov.name/docker-sozdanie-kontejnera-s-bazoj-dannyx-oracle/)
- [Hibernate with Kotlin - powered by Spring Boot](https://kotlinexpertise.com/hibernate-with-kotlin-spring-boot/)
- [Spring Boot, Hibernate и Kotlin для новичков шаг за шагом](https://habr.com/ru/company/domclick/blog/505860/)

./gradlew clean build && java -jar build/libs/hiber-0.0.1-SNAPSHOT.jar