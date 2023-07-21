package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringTestApplicationTests {

    Calculator underTest = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    void itShouldAddTwoNumbers() {
        // Given
        int numOne = 20;
        int numTwo = 10;

        // When
        int result = underTest.add(numOne, numTwo);

        // Then
        int expected = 30;
        assertThat(result).isEqualTo(expected);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}
