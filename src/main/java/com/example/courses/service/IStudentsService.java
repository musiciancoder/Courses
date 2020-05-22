package com.example.courses.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.courses.entity.Student;



public interface IStudentsService {
	List<Student> searchAllStudents();
	void saveStudent(Student student);
	void deleteStudent(int id);
	void editStudent(Student student, Integer id);
    Page <Student> searchAllOfTheStudentsByPage();
    Student searchStudentById(int id);
	
}
