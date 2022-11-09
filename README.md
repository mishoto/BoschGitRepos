# BoschGitRepos

## 🧐 About <a name = "about"></a>

This project is about fetching BoschIO public repos and adding some filtering by name || description or programming language.
On first start application fetches the repos and writes them to a file. There are two get endpoints:
one with resources from gitHub and one with resources from a file.

### Framework

Spring Boot

### Dependencies

- spring-boot-starter-web
- com.google.code.gson

### Prerequisites

On windows you have to install Docker desktop if you want to start application as a container.

- [Docker Desktop](https://docs.docker.com/desktop/install/windows-install/)

### Installing

Download and build the project.

- [BoschGitRepos](https://github.com/mishoto/BoschGitRepos)

In the project's folder build docker image, but before that you have to start docker daemon via docker desktop:

```
docker build -t <your image name> .
```

Check if image exist

```
docker images
```

Run the app container from this image

```
docker run -p 8095:8090 <your image name> 
```

Tomcat is running on port 8090 and the container port is 8095





