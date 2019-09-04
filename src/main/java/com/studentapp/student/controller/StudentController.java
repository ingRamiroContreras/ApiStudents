package com.studentapp.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.student.entity.Student;
import com.studentapp.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@CrossOrigin
	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentService.getAll();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> retrieveStudent(@PathVariable long id) {
		Student student = studentService.getByID(id);

		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		Student student = studentService.getByID(id);
		if (student != null) {
			studentService.delete(student);

		}
	}

	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student savedStudent = studentService.create(student);

		return new ResponseEntity<Student>(savedStudent, HttpStatus.OK);

	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Student studentOptional = studentService.getByID(id);

		if (studentOptional == null)
			return ResponseEntity.notFound().build();

		studentService.create(student);

		return ResponseEntity.noContent().build();
	}

}
