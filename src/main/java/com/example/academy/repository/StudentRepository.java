package com.example.academy.repository;

import com.example.academy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByRegistration(long id);

}
