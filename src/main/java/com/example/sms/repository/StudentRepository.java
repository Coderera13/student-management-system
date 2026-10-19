package com.example.sms.repository;

import com.example.sms.entity.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    Optional<Student> findByEmail(String email);

    List<Student> findByDepartmentIgnoreCase(String department);
}
