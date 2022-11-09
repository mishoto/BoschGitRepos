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

Download project from repo.

- [BoschGitRepos](https://github.com/mishoto/BoschGitRepos)

In the project's folder build docker image:

```
docker build -t <your image name> .
```

Check if image exist

```
docker images
```

Run the app container from this image

```
docker run -d -p 8090:8095 --name <your container name> 
```

Tomcat is running on port 8090 and the container port is upon your preference if is not conflicting OS running ports





