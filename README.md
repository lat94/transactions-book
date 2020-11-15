# transactions-book

## Intro
First, you need to set up the JSON file named `transactions.json` and place it at `src/main/resources` so the file can be read

### Running the api
With everything installed and set up, there's a lot of ways to run this API:

### Run with your IDE
The easiest way would be to run it inside an IDE which supports Spring Boot Applications, like IntelliJ.

### Run with [GRADLE](https://gradle.org/)
Running with `gradle`, using the JAR file

run `./gradlew build` to generate the necessary files

and then run `java -jar build/libs/transactions-book-0.0.1-SNAPSHOT.jar`
  


## Additional scripts
### Run with [DOCKER](https://www.docker.com/)
Based in the Dockerfile inside the project:

run `docker build -t transactions-book .`

then, run `sudo docker run -p3015:3015 transactions-book` to build the container using the image you created in the previous step. This command will also map your local port 3015 to the container port 3015
