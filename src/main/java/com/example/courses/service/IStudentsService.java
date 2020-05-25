package com.example.courses.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.courses.entity.Student;



public interface IStudentsService {
	List<Student> searchAllStudents();
	void saveStudent(Student student);
	Student deleteStudent(int id);
	
    Page <Student> searchAllOfTheStudentsByPage();
    Student searchStudentById(int id);
	Student editStudent(Student student, int code);
	
}
