package com.example.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.entity.Course;
import com.example.courses.service.ICoursesService;

@RestController
@RequestMapping("/api")
public class CoursesController {

	
	@Autowired
	private ICoursesService serviceCourses;
	
	
	@GetMapping("/courses") //endpoint for fetching all courses
	public List<Course> searchAllCoursesC() {
		return serviceCourses.searchAllCourses();
	}
	
	
	@PostMapping("/courses") //endpoint for saving a course
	public Course saveCourseC(@RequestBody Course course) {
		serviceCourses.saveCourse(course);
		return course;
		
	}
	
	@PutMapping("/courses") //endpoint for editing a course
	public Course modify(@RequestBody Course course) {
		serviceCourses.saveCourse(course);
		return course;
		
	}
	
	
}
