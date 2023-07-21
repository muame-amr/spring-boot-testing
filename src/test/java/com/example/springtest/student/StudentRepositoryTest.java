package com.example.springtest.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // Given
        String email = "alig@email.com";
        Student student = new Student("Ali G", email, Gender.MALE);
        studentRepository.save(student);

        // When
        boolean expected = studentRepository.selectExistsEmail(email);

        // Then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        // Given
        String email = "simon@email.com";

        // When
        boolean expected = studentRepository.selectExistsEmail(email);

        // Then
        assertThat(expected).isFalse();
    }
}
