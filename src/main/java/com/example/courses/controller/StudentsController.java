package com.example.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.entity.Student;
import com.example.courses.service.IStudentsService;

@RestController
@RequestMapping("/api")
public class StudentsController {

	@Autowired
	private IStudentsService serviceStudents;

	@GetMapping("/students") // endpoint for fetching all students
	public List<Student> searchAllstudentsC() {

		return serviceStudents.searchAllStudents();
	}

	@PostMapping("/students") // endpoint for saving a Student
	public Student saveStudentC(@RequestBody Student student) {
		serviceStudents.saveStudent(student);
		return student;
	}

	@PutMapping("/students/{id}") // endpoint for editing a Student
	public String modifyStudentC(@PathVariable("id") Integer id, @RequestBody Student student) {
		serviceStudents.editStudent(student, id);
		return "Register has been edited successfully";

	}

	@DeleteMapping("/students/{id}") // endpoint for deleting a Student
	public String deleteC(@PathVariable("id") int id) {
		serviceStudents.deleteStudent(id);
		return "Register has been deleted successfully";

	}

}
