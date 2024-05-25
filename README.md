# AD Management API Server

2023 겨울방학 국민대학교 PBL 교육 프로젝트 최종 산출물 中 Backend API Server

## Description

2023년 겨울방학 중 2주간 진행된 국민대학교 PBL 교육 프로젝트(w. Codestates)에서 구현하는 최종 산출물의 일부입니다.
AD Management Platform의 Backend 부분이 되는 API Server를 구현한 Repository입니다.
* [API Document](https://www.notion.so/b5cbae3b2d7c4db2af74add5ad36f161?v=0b1e0c8696a4442eb7fb4aa161375e5c)
* [교육 내용 정리 문서](https://www.notion.so/sinam7/2023-PBL-w-Codestates-f800d835d05845a28286b54487bee8fb)

## Getting Started

### Dependencies

* Gradle 8.5
* Java 17을 실행 가능한 JRE
* MySQL

### Installing

1. GitHub에서 git clone
```
$ git clone https://github.com/KMU-PBL-team4/backend.git
```

2. 프로젝트 빌드
   * Gradle
      * Windows
      ```
      $ gradle clean build
      ```
      * Linux/MacOS
      ```
      $ ./gradlew clean build
      ```
   * Jar
     * Windows
      ```
      $ gradle clean bootJar
      ```
      * Linux/MacOS
      ```
      $ ./gradlew clean bootJar
      ```
3. 실행
   * Gradle로 실행
     ```
     $ gradle bootRun
     ```
   * Linux/MacOS
     ```
     $ java -jar KMU-PBL-3-0.0.1-SNAPSHOT.jar
     ```

## Help
   * Release에 있는 jar 파일은 `gradle bootJar`로 만들어진 파일입니다.
   * Spring Boot 실행 시 Communication Link Failure 예외가 발생하면, 아래 방식으로 실행해보시기 바랍니다.
      ```
      $ java -jar KMU-PBL-3-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:mysql://localhost:3306/mysqldb?serverTimezone=UTC&characterEncoding=UTF-8 --spring.active.profile=test
      ```

## Author
   * 정성원 [@sinam7](https://github.com/sinam7)

### Related-CoAuthors
###### @See Also: [Frontend Repository - React](https://github.com/KMU-PBL-team4/front)
   * 김동연 [@0yeonnnn0](https://github.com/0yeonnnn0) - 동 프로젝트 Frontend
   * 최지헌 [@jihoney41](https://github.com/jihoney41) - 동 프로젝트 Frontend

## Acknowledgments
* [readme-template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)
* []
