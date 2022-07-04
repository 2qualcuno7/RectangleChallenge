# RectangleChallenge
Nuvalence Rectangle Challenge

## Description

This project implements a REST API in order to find if a pair of rectangles intersects, 
are contained in one another or are adjacent, as described in its attached documentation. 
Its methods and internal implementation are suitable to evaluate these three aspects for any pair of polygons, 
although endpoints were only provided for rectangles. 

It is important to note that although there are several Java classes that already implemented parts of this solution,
it was decided not to use them as they have limitations for certain use cases and the nature of this project as a
coding challenge would be better respected creating a solution from scratch.

## Swagger
Endpoint documentation can be seen in http://localhost:8080/swagger-ui.html, after executing locally.

## Requirements

This project was tested and works properly with the following:

- [Open JDK 17.0.2](https://mail.openjdk.org/pipermail/jdk-updates-dev/2022-January/011709.html)
- [Maven 3.8.4](https://maven.apache.org)


## Local Execution

This application can be executed locally in the IDE of your preference, as long as it supports Java. 

Alternatively, the following command can be run on terminal:

```shell
mvn spring-boot:run
```
