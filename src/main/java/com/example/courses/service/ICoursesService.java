package com.example.courses.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.courses.entity.Course;



public interface ICoursesService {
	
	List<Course> searchAllCourses();
	void saveCourse(Course course);
	Course searchById(int code);
	Course deleteCourse(int code);

	Course editCourse(Course course, int code);
	Page <Course> searchAllOfTheCoursesByPage();
	Course searchCourseById(int id);

}
