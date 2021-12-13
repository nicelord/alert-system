
##Requirements
- Java 11 (**important!**)
- Maven

## Note 

- This is an IntellijIdea Maven project, to avoid any missing configurations please import this project to IntellijIDEA as Maven Project
- To run in development : ```mvn clean compile exec:java -Dexec.mainClass=org.example.App```
- Run test : ```mvn test```
- Build with dependencies: ```mvn clean install```
- Compiled output will be in : `target\alert-system-1.0-SNAPSHOT-jar-with-dependencies.jar` and ready to ship

## Run the app
- ```java -jar target\alert-system-1.0-SNAPSHOT-jar-with-dependencies.jar <LOG_FILE>```

## Solution decisions:
This project implementing hexagonal architecture and follow DDD practice, the purpose is to make this project extensible and easy to maintain.

The project currently bundled together in a single maven project, later when new requirements coming, some packages can be easily separated as an independent module or even an independent project 
since each layer (in this case packages) have a very small coupling with the other, such as the adapters and domain. Thus,  we achieve modularity by implementing this pattern.

## Assumptions
With the given limited context, assumptions have been made :
 
- This will read logs file based on user input argument.
- If no input argument provided, sample log file will be used which is bundled in the jar.
- No database used, sample user data provided at runtime in AppConfig.class.
- No external file configuration used, sample configurations are bundled in AppConfig.class