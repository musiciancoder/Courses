package com.example.courses.service;

import java.util.List;

import com.example.courses.entity.Course;

public interface ICoursesService {
	//method for fetch all courses
	List<Course> searchAllCourses();
	void saveCourse(Course course);
	void deleteCourse(int code);

}
