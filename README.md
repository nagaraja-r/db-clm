## db CLM  APIs
dbCLM is an Angular 10 / Java micro services application using spring batch/boot that has dynamic GUI forms for one by one form completion and also the need for displaying lots of data in a tabular format with bulk actions and uses AG Grid for. We also use swagger to expose and document our APIs. There is focus on TDD and BDD so unit tests and automation are key. The other key aspect is performance of the application v’s 4000/5000 users and now over low bandwidth/latency links in people’s homes.

## Running db CLM locally
db CLM is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/nagaraja-r/db-clm.git
git checkout develop
cd db-clm
./mvnw package
java -jar target/dbclm-0.0.1-SNAPSHOT.jar
```

You can then access db-clm here: http://localhost:8080/
And find the APIs exposed here : http://localhost:8080/swagger-ui.html

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## Database configuration

In its default configuration, db-clm uses an in-memory database (H2) which
gets populated at startup with data.
You can access the h2 console : http://localhost:8080/h2

## Working with db CLM in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 11 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE(Eclipse or IntelliJ IDEA)
    * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
      not there, just follow the install process here: https://www.eclipse.org/m2e/
    * [Spring Tools Suite](https://spring.io/tools) (STS)
    * IntelliJ IDEA
    * [VS Code](https://code.visualstudio.com)

## Looking for something in particular?

|Spring Boot Configuration | Class or Java property files  |
|--------------------------|---|
|The Main Class | [DbClmApplication](https://github.com/nagaraja-r/db-clm/blob/develop/src/main/java/com/db/task/dbclm/DbClmApplication.java) |
|Properties Files | [application.properties](https://github.com/nagaraja-r/db-clm/tree/develop/src/main/resources) |
