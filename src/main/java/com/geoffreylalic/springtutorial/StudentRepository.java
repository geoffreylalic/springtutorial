package com.geoffreylalic.springtutorial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Long countStudentsByEmail(String email);
    List<Student> findAllByFirstNameContaining(String p);
}
