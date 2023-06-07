# Internship by Cato

This is the repository that contains the backend service needed to run the **Internship by Cato** app.
It uses the following tech stack

<img  src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/121px-Java_programming_language_logo.svg.png"  width="50" height="100">  <img  src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/120px-Postgresql_elephant.svg.png"  width="100"  height="100">

To develop it is recommended that you download [IntelliJ IDEA](https://www.jetbrains.com/idea/download)

## Docker

You can also run the project with docker containers. This repository contains two Dockerfiles, one for the backend and another one for the database.

|Service|Location|
|-------|--------|
|Backend|/|
|Database|/db/|

You need to have the database up and ready for the backend, navigate to the folder containing the database Dockerfile and run the following:
```console
> docker build -t ucb/internship-db:1.0.0 .
> docker run -p 5432:5432 -d ucb/internship-db:1.0.0
```
Once done with this, you can build the backend container, you need to pick one of last two, the former have all the environment variables needed to run the app ready to fill:
```console
> docker build -t ucb/internship-backend:1.0.0 .
> docker run --env DB_HOST=192.168.0.3 -p 8080:8080 ucb/internship-backend:1.0.0
> docker run --env-file ./env ucb/internship-backend:1.0.0