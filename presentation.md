---
marp: true
html: true
theme: default
footer: "![w:100px opacity:.5](images/endava-logo.png) | Internship"
class:
  - invert
style: |
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap');
  * {
    font-family: 'Roboto', sans-serif;
  }
  footer {
    text-align: right;
    width: 95%;
  }
---

# Unit Testing 
###### Adrian Pulbere | adrian.md
###### October 2020

---

# Purpose

> Unit Testing is a software testing method by which individual units of source code — sets of one or more computer program modules together with associated control data, usage procedures, and operating procedures — are tested to determine whether they are fit for use.

* early error detection 
* prevent regressions
* automation
* product documentation

---

# Terminology

* __Coverage__ is a metric expressed as a percentage of a project being tested by its test
* __Integration Test__ verifies that a set of components or the whole system works as expected
* __Corner cases__  refers to inputs at the edge of the range of acceptable values

---

# Test Life Cycle

* Setup
  * `@BeforeAll`
  * `@BeforeEach`
* Test
  * `@Test`
* Cleanup
  * `@AfterEach`
  * `@AfterAll`

---

# Test Structure

* Arrange
* Act
* Assert

---

# Assertions

###### Is an expression which encapsulates some testable logic specified about a target under test

JUnit Assertion
```java
assertTrue(lastName.startsWith("D"));
assertTrue(lastName.endsWith("e"));
assertAll(
  () -> assertTrue(lastName.startsWith("D")),
  () -> assertTrue(lastName.endsWith("e"))
);
```
3rd party (AssertJ)
```java
assertThat(a).isEqualTo(b);

assertThat(someIntList).contains(3).doesNotContain(4);
```

---

# Test properties

* Readable (AAA)
* Fast
* Independent and Isolated
* Repeatable / Deterministic
* Correct (test one thing only, do what their name suggests)

---

# Mocks, Interactions and Spies

###### Mocking is creating objects that simulate the behavior of real objects

* __Fake__ objects actually have working implementations, but usually take some shortcut which makes them not suitable for production

* __Stubs__ provide predefined answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test

* __Mocks__ are objects pre-programmed with expectations which form a specification of the calls they are expected to receive

* __Spies__ are partial mocks in the sens that they replace the real behavior of an object only when told so

---

# Additional Info
| | |
| - | - |
| Example | https://github.com/apulbere/unit-testing-dava-internship |
| JUnit 5 User Guide | https://junit.org/junit5/docs/current/user-guide |
| Mockito JavaDoc | https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html |
| Practical Test Pyramid | https://martinfowler.com/articles/practical-test-pyramid.html |