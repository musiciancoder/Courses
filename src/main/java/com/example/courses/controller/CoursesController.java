package com.example.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.entity.Course;
import com.example.courses.service.ICoursesService;

@RestController
@RequestMapping("/api")
public class CoursesController {

	
	@Autowired
	private ICoursesService serviceCourses;
	
	
	@GetMapping("/courses") //endpoint for courses
	public List<Course> searchAllCoursesC() {
		return serviceCourses.searchAllCourses();
		
		
	}
	
	
	
}
