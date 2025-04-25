package com.example.yasix.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class studentService {

	private final studentRepository studentRepository;
    
	@Autowired
	public studentService(studentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
    
	public List<student> getStudent() {
		return studentRepository.findAll();
	}

    
}
