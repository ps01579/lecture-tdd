package org.example.assertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Greeting Test")
public class GreetingTest {

    @Test
    @DisplayName("Testing Greet method")
    void testGreeting() {
        Greeting greeting = new Greeting();
        String name = "Jenny";
        String result = greeting.greet(name);

        assertEquals("Hello, Jenny", result);

    }

    @Test
    void testEquality() {
        int value1 = 10;
        int value2 = 10;

        String string1 = "hello";
        String string2 = "hello";

        Object obj1 = new Object();
        Object obj2 = new Object();

        assertEquals(value1, value2);
        assertNotEquals(value1, value2+1);

        assertEquals(string1, string2);
        assertNotEquals(string1, string2 + "a");
        assertSame(string1, string2);

        assertNotSame(obj1, obj2);
    }

    @Test
    void testBoolen() {
        boolean cond1 = true;
        boolean cond2 = false;

        assertTrue(cond1);
        assertFalse(cond2);
    }

    @Test
    void testException() {
        assertThrows(ArithmeticException.class,
                () -> {
                    int value = 1 / 0;
                });
        assertDoesNotThrow(
                () -> {
                    int value = 1 / 1;
                }
        );
    }

    @Test
    void testNull() {
        Object obj1 = null;
        Object obj2 = new Object();

        assertNull(obj1);
        assertNotNull(obj2);
    }

    @Test
    void testAssertIterableEquals() {
        List<String> expected = List.of("John", "Jane", "Marry");
        List<String> actual = List.of("John", "Jane", "Marry");

        assertIterableEquals(expected, actual);
    }

    @Test
    void testAssertLineMatchRegExp() {
        List<String> expected = List.of("luv", "[2-7]", "code");
        List<String> actual = List.of("luv", "5", "code");

        assertLinesMatch(expected, actual, "should match actual lines");
    }

    @Test
    void testAssertLineMatchRegExp2() {
        List<String> expected = List.of("luv", "my", ">>4>>", "code");
        List<String> actual = List.of("luv", "my", "one", "two", "three", "four", "code");

        assertLinesMatch(expected, actual, "should match actual lines");
    }

    @Test
    void testAssertAll() {
        String firstName = "John";
        String lastName = "Doe";
        int age = 30;

        assertAll("Person",
                () -> assertEquals(firstName, "John"),
                () -> assertEquals(lastName, "Doe"),
                () -> assertEquals(age, 30)
        );
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(1),
                () -> {
                    Thread.sleep(900);
                });
    }

    @Test
    void testOnlyRunsOnLinux() {
        assumeTrue(System.getProperty("os.name").toLowerCase().contains("windows"));

        String string1 = "hello";
        String string2 = "hello";

        assertEquals(string1, string2);
    }

    @Test
    void testDeltaEquals() {
        double expected = 13.0;
        double actual = 15.0;
        double delta = 2.0;

        assertEquals(expected, actual, delta);
    }
}

