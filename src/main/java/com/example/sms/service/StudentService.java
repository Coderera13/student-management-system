package com.example.sms.service;

import com.example.sms.entity.Student;
import com.example.sms.exception.DuplicateEmailException;
import com.example.sms.exception.ResourceNotFoundException;
import com.example.sms.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Student> findAll(String department) {
        if (department == null || department.isBlank()) {
            return repository.findAll();
        }
        return repository.findByDepartmentIgnoreCase(department.trim());
    }

    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student " + id + " not found"));
    }

    @Transactional
    public Student create(Student student) {
        if (repository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException("Email already registered");
        }
        // Prevent a client from choosing or overriding a database-generated ID.
        student.setId(null);
        return repository.save(student);
    }

    @Transactional
    public Student update(Long id, Student data) {
        Student existing = findById(id);
        repository.findByEmail(data.getEmail())
                .filter(match -> !match.getId().equals(id))
                .ifPresent(match -> {
                    throw new DuplicateEmailException("Email already registered");
                });

        existing.setName(data.getName());
        existing.setEmail(data.getEmail());
        existing.setDepartment(data.getDepartment());
        return repository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
