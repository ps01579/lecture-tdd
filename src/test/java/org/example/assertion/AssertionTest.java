package org.example.assertion;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    @Test
    @Tag("fast")
    void myTestMethod() {
        String exptected = "Hello, World";
        String actual = "Hello, World";

        assertEquals(exptected, actual);
    }
}
