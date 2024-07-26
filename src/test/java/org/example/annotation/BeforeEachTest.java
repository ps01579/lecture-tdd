package org.example.annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeforeEachTest {
    private int value;

    @BeforeEach
    public void setUp() {
        System.out.println("perform setUp");
        value = 5;
    }

    @Test
    public void test() {
        System.out.println("perform test");
        value += 2;
        assertEquals(7, value);
    }



}
