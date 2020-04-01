Doma  with Spring Boot
========================================

This sample shows how easy to integrate [Doma][doma] with  [Spring Boot][spring-boot] .

Java 8 is needed to run this sample.

Clone
--------

```sh
git clone https://github.com/arachan/domaboot.git
```

Run
--------

```sh
cd domaspringboot
```

```sh
./gradlew bootRun
```

Access
--------

### Select

```
http://localhost:8080/
```

JSON Response:

```json
[{"id":1,"name":"お得意先さん"}]
```

### Update

```
http://localhost:8080/update?name=Kyoto
```

JSON Response:

```json
[{"id":1,"name":"Kyoto"}]
```

Edit
--------

Use Eclipse 4.4 or above.

Generate all Eclipse files with Gradle.

```sh
./gradlew eclipse
```

### Step

1. right clike on build.gradle
2. Refresh Gradle Project
3. ./gradlew eclipse
4. right click on project > Refresh
5. right click on project > Run As > Spring Boot Apps

License
-------

Apache License, Version 2.0

[doma]: https://github.com/domaframework/doma
[spring-boot]: https://github.com/spring-projects/spring-boot

