package com.ipayment;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void init() {
        System.out.println("executing before all");
    }

    @BeforeEach
    void prepare() {
        System.out.println("executing before each");
    }

    @Test
    void t1() {
        System.out.println("test t1");
    }

    @Test
    void t2() {
        System.out.println("test 2");
    }

    @AfterEach
    void cleanUp() {
        System.out.println("executing after each");
    }

    @AfterAll
    static void close() {
        System.out.println("executing after all");
    }
}
