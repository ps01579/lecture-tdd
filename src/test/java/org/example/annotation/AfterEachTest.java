package org.example.annotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfterEachTest {
    private File file;

    @BeforeEach
    public void setUp() {
        System.out.println("perform setUp");
        file = new File("tmp.txt");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("perform tearDown");
        file.delete();
    }

    @Test
    @Tag("fast")
    public void test1() {
        System.out.println("perform test1");
    }

    @Test
    public void test2() {
        System.out.println("perform test2");
    }
}
