package org.example.annotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTestTest {

    static class Employee {
        private String name;
        private String empNo;
        private int age;
        public Employee(String name, String empNo, int age) {
            this.name = name;
            this.empNo = empNo;
            this.age = age;
        }
    }

    public boolean isPalindrome(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "level", "test"})
    void isPalindromeTest(String input) {
        assertTrue(isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, true, false})
    void testBooleanTest(boolean input) {
        assertTrue(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 9})
    void testIntTest(int input) {
        assertTrue(input%2 == 0);
    }

    @ParameterizedTest
    @MethodSource("provideEmployees")
    void testEmployee(Employee input) {
        assertTrue(input.age > 30);

    }

    public static Stream<Arguments> provideEmployees() {
        return Stream.of(
                Arguments.of(new Employee("John", "111111", 30)),
                Arguments.of(new Employee("Jane", "111112", 25)),
                Arguments.of(new Employee("Alex", "111113", 31)),
                Arguments.of(new Employee("Mary", "111114", 40))
                );
    }

    @ParameterizedTest
    @CsvSource({
            "racecar,true",
            "radar,true",
            "level,true",
            "test,false"
    })
    void isPalindromeTest(String input, boolean expected) {
        assertEquals(expected, isPalindrome(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/fruit_price.csv", numLinesToSkip = 1)
    void isFruitTest(String fruit, int price) {
        assertTrue(price > 5000);
    }

}
