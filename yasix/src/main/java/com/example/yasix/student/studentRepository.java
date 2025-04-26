package com.example.yasix.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
    // This interface will automatically provide CRUD operations for the student entity.

    //@Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<student> findStudentByEmail(String email);

}
