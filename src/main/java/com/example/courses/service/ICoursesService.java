package com.example.courses.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.courses.entity.Course;


public interface ICoursesService {
	
	List<Course> searchAllCourses();
	void saveCourse(Course course);
	void deleteCourse(int code);
	void editCourse(Course course, int code);
	Page <Course> searchAllOfTheCoursesByPage();
	Course searchCourseById(int id);
}
