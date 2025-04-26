package com.example.yasix.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.transaction.Transactional;

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

    public void addNewStudent(student student) {
		studentRepository.findStudentByEmail(student.getEmail())
				.ifPresent(s -> {
					throw new IllegalStateException("email taken");
				});
		studentRepository.save(student);

    }

	public void deleteStudent(Long studentID) {
		studentRepository.findById(studentID).orElseThrow(() -> new IllegalStateException(
				"student with id " + studentID + " does not exist"));
		studentRepository.deleteById(studentID);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email, LocalDate dob) {
		student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
				"student with id " + studentId + " does not exist"));
		if (name != null && name.length() > 0 && !name.equals(student.getName())) {
			student.setName(name);
		}
		if (email != null && email.length() > 0 && !email.equals(student.getEmail())) {
			studentRepository.findStudentByEmail(email).ifPresent(s -> {
				throw new IllegalStateException("email taken");
			});
			student.setEmail(email);
		}
		if (dob != null && !dob.equals(student.getDob())) {
			student.setDob(dob);
		}
	}

    
}
