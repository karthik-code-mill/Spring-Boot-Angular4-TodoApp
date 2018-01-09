# Spring-Boot-Angular4-TodoApp

# Angular4 Spring Boot Todo App Excercise



## To just run the app 

** WAY 1 : 

    Make sure you have Java 1.7 or greater

    Make sure JAVA_HOME & path variables are set for Java

    Download the jar using download link in https://github.com/karthik-code-mill/Spring-Boot-Angular4-TodoApp/blob/master/todo-app-backend/target/todo-app-0.1.jar

    Double click the downloaded jar file to run.

    If any issues open terminal(cmd in windows) and run the command java -jar todo-app-0.1.jar after navigating to the download path

**PS NOTE:**

** Make sure the java process & Mongo DB instance is allowed to start without any firewall blockage**

** Access the application using url --> http://localhost:8080/ **

**WAY 2: Alternatively if insterested in checking code also, clone the whole project

    run the runapp.bat file to start

    Access the application using url --> http://localhost:8080/ **

## To Build the source code
**Make sure you have Maven and Java 1.7 or greater**
**Make sure you also have NPM 3.1, Node 6.9.5 and angular-cli globally installed**
```bash
# clone our repo
# --depth 1 removes all but one .git commit history
git clone --depth 1 https://github.com/karthik-code-mill/Spring-Boot-Angular4-TodoApp.git

# change directory to the repo's frontend folder
cd Spring-Boot-Angular4-TodoApp/todo-app-ui

# install the frontend dependencies with npm
# npm install @angular/cli -g
npm install

# Build the frontend app
npm install copyfiles -g
npm run build

# change directory to the repo's backend folder
cd ../todo-app-backend

# install the server dependencies with mvn
mvn package

# start the backend server
mvn spring-boot:run


# the spring-boot server will be running on port 8080
# the app will be running on port 8080
http://localhost:8080/
