package org.example.annotation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeforeAfterAll {

    private static String input;
    private static Long result;

    @BeforeAll
    public static void setup() {
        System.out.println("call setup");
        input = "77";
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("call tearDown");
        input = null;
        result = null;
    }

    @Test
    public void test1() {
        System.out.println("call test1");
        result = Long.valueOf(input);
        assertEquals(77L, result);
    }

    @Test
    public void test2() {
        System.out.println("call test2");
        System.out.println(result);
    }
}
