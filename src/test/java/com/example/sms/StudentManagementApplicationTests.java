package com.example.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.sms.entity.Student;
import com.example.sms.exception.DuplicateEmailException;
import com.example.sms.exception.ResourceNotFoundException;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class StudentManagementApplicationTests {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void clearStudents() {
        studentRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        assertNotNull(studentService);
    }

    @Test
    void createsAndReadsStudent() {
        Student created = studentService.create(
                new Student("Divya Menon", "divya.menon@example.com", "CSE"));

        assertNotNull(created.getId());
        assertEquals("Divya Menon", studentService.findById(created.getId()).getName());
    }

    @Test
    void rejectsDuplicateEmail() {
        studentService.create(new Student("First Student", "same@example.com", "CSE"));

        assertThrows(DuplicateEmailException.class, () -> studentService.create(
                new Student("Second Student", "same@example.com", "ECE")));
    }

    @Test
    void filtersDepartmentsWithoutCaseSensitivity() {
        studentService.create(new Student("CSE Student", "cse@example.com", "CSE"));
        studentService.create(new Student("ECE Student", "ece@example.com", "ECE"));

        List<Student> result = studentService.findAll("cse");

        assertEquals(1, result.size());
        assertEquals("CSE Student", result.get(0).getName());
    }

    @Test
    void updatesAndDeletesStudent() {
        Student created = studentService.create(
                new Student("Old Name", "old@example.com", "CSE"));
        Student updated = studentService.update(created.getId(),
                new Student("New Name", "new@example.com", "IT"));

        assertEquals("New Name", updated.getName());
        assertEquals("new@example.com", updated.getEmail());
        assertEquals("IT", updated.getDepartment());

        studentService.delete(created.getId());
        assertThrows(ResourceNotFoundException.class,
                () -> studentService.findById(created.getId()));
    }
}
