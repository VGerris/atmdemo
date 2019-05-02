# README #

This README describes how to get this Atm application up and running

### What is this repository for? ###

* A simple demo Atm application with support for withdrawel and deposit
* Version - WIP
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Clone this repo
* Import as a Maven project in any IDE is easiest 
* Dependencies : Maven, Java 8 - Maven will pull dependencies like Spring boot
* Database configuration : included H2 database
* How to run tests : As Spring Boot run class : com.example.simpleatm.BootSimpleAtmApplication
* Run instructions : run the package task under Maven - this will build a jar file in the target directory. Run jar like : java -jar target/atmdemo-0.0.1-SNAPSHOT.jar or directly from the IDE  

### Contribution guidelines ###

* Writing tests - the current test just loads the Spring context - this verifies proper Hibernate configuration - needs unit tests added
* Code review - this is a demo to explore Spring Boot REST, JPA, Angular. Implementation is far from ideal or complete :) 
* Other guidelines - check the many great tutorials at spring.io and https://docs.angularjs.org/guide/introduction

### Who do I talk to? ###

* StackOverflow is a good source of information. This code base is not supported in any way :)
