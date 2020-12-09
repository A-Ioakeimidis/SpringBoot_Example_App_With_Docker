# Microservices_SpringBoot_SpringCloud_Docker

# Prerequisites
Docker is installed and it is running.

See the [Docker](https://www.docker.com/) website for installation instructions.

# Build
Steps to build a Docker image:
1. Clone the repo
  ```git
  git clone https://github.com/A-Ioakimidis/Microservices_SpringBoot_SpringCloud_Docker.git
  ```
  
  
 2. Build the image
   ```docker
  docker build -t="add-tag-name" .
  ```
  
  3. Run the image's default command, which should start everything up. The -d command will run as detached. 
  The -p option forwards the container's port 8080 to port 8000 on the host. 
  ```docker
  docker run -d -p 8080:8080 "image-name"
  ```
  
  4. Once everything has started up, you should be able to access the webapp via http://localhost:8000/ on your host machine.
   ```docker
  localhost:8080
  ```
  
  You can also login to the image and have a look around:
  ```docker
  docker run -i -t "image-name" /bin/bash
  ```
  
# API endpoints
  
  **/hi**
  
  **/hi/{name}** 
  
