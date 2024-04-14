# jUnit test 

just run maven verify (from IDE) it will generate all test cases reports (target\surefire-reports)

NOTE:
1) As it is configured with spring-boot-configuration-processor where data add through the application.properties (3 records in database)
user.data.admin=Configuration Administrator
user.data.superadmin=Administrator
user.data.alias=name

2) It includes H2 (runtime) DB where JPA integration is implemented, please check Swagger (http://localhost:8080/swagger-ui.html) for API testing 

3) Check H2 data (user table) to check data (http://localhost:8080/h2-console for jdbc:h2:mem:userdb)
