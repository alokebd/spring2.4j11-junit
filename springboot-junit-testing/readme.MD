# jUnit test 

just run maven verify (from IDE) it will generate all test cases reports (target\surefire-reports)

NOTE:
1) As it is configured with spring-boot-configuration-processor where data add through the application.properties (3 records in database)
user.data.admin=Configuration Administrator
user.data.superadmin=Administrator
user.data.alias=name

2) It includes H2 (runtime) DB where JPA integration is implemented, please check Swagger (http://localhost:8080/swagger-ui.html) for API testing 

3) Check H2 data (user table) to check data (http://localhost:8080/h2-console for jdbc:h2:mem:userdb)



# jcoco that shows the code coverage according to test cases (check the pom file).

## Build
mvn clean install
## Run
mvn spring-boot:run
## Working
1. Build the Project
2. Move to Jacoco folder and open ```target/site/jacoco/index.html```
3. ```index.html``` will list the coverage for the complete Project

**Coverage Indicators**
- Red    : Not Covered
- Yellow : Partially Covered
- Green  : Completely Covered

