package com.example.yasix.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
    // This interface will automatically provide CRUD operations for the student entity.


}
