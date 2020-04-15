# Spring Boot WAR file deployment using Docker
 
Spring Boot War deployment as Docker swarm service 

### How to run?
1. Clone the project on local machine and Build it using maven
    ```
    $ mvn clean package -DskipTests
    
    ```
2. Build the docker image using the **Dockerfile** or **docker-compose.yml**(preferred way) file
    ```shell script
    $ docker build .
    ```
    or **docker-compose.yml**
    ```shell script
    $ docker-compose build
    ```
3. Run the docker image using docker-compose run
    ```shell script
    $ docker run <image_name>
    ``` 

## Convert application as Docker swarm service
1. Create docker swarm service instead of step 3 in above section
    ```shell script
    $ docker service create --name <service_name>  --replicas 2  --publish published=8080,target=8080  <image_name>
    
    ```
2. List services using ls command
    ```shell script
    $ docker service ls
    
    ```



