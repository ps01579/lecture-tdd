package org.example.annotation;

import org.junit.jupiter.api.*;

public class NestedTest {

    @BeforeEach
    void setUpParent() {
        System.out.println("before each parent");
    }

    @AfterEach
    void tearDownParent() {
        System.out.println("after each parent");
    }

    @Test
    void parentTest() {
        System.out.println("parent test");
    }

    @Nested
    class NestedTests {
        @BeforeEach
        void setUpChild() {
            System.out.println("before each child");
        }

        @AfterEach
        void tearDownChild() {
            System.out.println("after each child");
        }

        @Test
        @Order(2)
        void childTest1() {
            System.out.println("child test1");
        }

        @Test
        @Order(1)
        void childTest2() {
            System.out.println("child test2");
        }
    }
}
