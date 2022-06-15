## Brief

### Preparation

Instructors' prior knowledge:
- Unit test in a DI Pattern framework requires the test to spin up a relevant test context before objects are able to injected via the `@Autowired` annotation.
- In this lesson, we will go through two types of unit test: `MockMvc` to test against the `@RestController` and simply `JUnit` to test against business logics in the `@Service` layer.

### Lesson Overview

Unit testings are commonly used for TDD approach. Unit Test aims to test the smallest unit of code in the application with its dependencies mocked. In this lesson, we will look at how we can test against the `@RestController` and simply `@Service` (child of `@Component` annotation).

---

## Self-studies check-in

**Q1: Are unit test and TDD both the same thing?**

A - Yes

B - No


**Q2: Which is NOT the benefit of writing unit tests?**

A - It prevent regression (breaking old feature while creating new feature).

B - It improves code quality by forcing developers to write loosely coupled testable code.

C - It makes the project size smaller.

D - It greatly reduces bugs.


**Q3: Which of the follow is NOT the way to write unit tests?**

A - Multiple tests are written against a single App code.

B - The amount of test code must always be written lesser than the App code.

C - You should always mock dependencies of the App Code.

D - Each test must always run independently.

> Test Code are codes you write to test against Application Code.
> Application Code (App Code) are the logics you write to develop a software.

---
## Part 1 - Scoping Unit Tests

The [Given-When-Then](https://en.wikipedia.org/wiki/Given-When-Then) approach is a good guide for us to scope test cases.

- GIVEN: The pre-conditions to the test.
- WHEN: Executing the test.
- THEN: The outcome 

### Short Exercise (Individual)

What are the test cases you might cover for a function like this?

```java
public boolean isExist(int productId){
    Optional<Product> product = prodRepo.findById(productId);

    return product.isPresent() ? true : false; // Shortform if-else statement
}
```
Shortform if-else statement [reference](https://www.w3schools.com/java/java_conditions_shorthand.asp).


|Given|When|Then|
|-----|----|----|
|Product ID exist|isExist() is called|return true|
|Learners input ...|||


---

## Part 2 - Maven Dependency Required

### Spring Simple Architecture Brief
A typical backend architecture for Spring Web looks like this:

<img src="./assets/images/spring-simple-architecture.drawio.png" />

- The `@RestController` classes are responsible for handling the Requests and Responses of the HTTP Endpoint.
- The `@Service` classes contain business logics. They are not mandatory but recommended when business logics get complicated. 
- The `@Repository` interfaces that implements `JpaRepository` are responsible for handling data access.

A simple endpoint that check if a product exist basically do not need a `@Service` class.

A payment process that linked to inventory update and shipping request would use the `@Service` classes.

### Testing Approach

There are two approaches of testing we will be exploring in the next 1 hour. The first approach is the use of MockMvc and the other is JUnit, both references are listed in learners' self study materials under "Helpful Links".

The MockMvc approach is typically used for testing the `@RestController` layer by mock firing HTTP Requests. The database `Repository` layer shall be mocked to eliminate the need for real data.

The JUnit approach is typically used for testing the `@Service` layer. `@Service` is a child of `@Component`, used for containing complex business logics. In such a case, the use of JUnit will be testing against the business logics. 

### The pom.xml file

Spring Boot comes with tester starter dependency. But we have to exclude JUnit 4 because we are using JUnit 5. Add the `<exclusions>` to the current `spring-boot-starter-test` dependency. If the entire dependency is not present, add the entire block of code below.

The MockMvc library is included in the `spring-boot-starter-test` so you do not have to add this explicitly.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
    
    <!-- exclude junit 4 -->
    <exclusions>
        <exclusion>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

Since spring boot v2.4.0 onwards, JUnit 5 is automatically included in the `spring-boot-starter-test`. You should be using spring boot version >2.6.0 in this program.

---

## Part 3 - MockMVC Test

Insert Instructions

---

## Part 4 - JUnit Test

Insert Instructions