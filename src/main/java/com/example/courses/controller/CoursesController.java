package com.example.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.entity.Course;
import com.example.courses.entity.Student;
import com.example.courses.service.ICoursesService;

@RestController
@RequestMapping("/rest") // do not forget to add "rest" to each URL as part of all endpoints. Example: to execute method searchAllCoursesC() one must write down: http://localhost:8080/rest/courses/all 
public class CoursesController {

	
	@Autowired
	private ICoursesService serviceCourses;
	
	
	@GetMapping("/courses") // endpoint for fetching all courses paginate
	public Page<Course> searchAllCoursesByPageC() {
		return serviceCourses.searchAllOfTheCoursesByPage();
		
	}
	
	
	@GetMapping("/courses/all") //endpoint for fetching all courses
	public List<Course> searchAllCoursesC() {
		return serviceCourses.searchAllCourses();
	}
	
	
	
	@GetMapping("/courses/{id}")  // endpoint for fetching a course by id
	public ResponseEntity<Course> searchCourseByIdC(@PathVariable("id") Integer id) { 
	    Course course = serviceCourses.searchCourseById(id);
	    if (course != null) {
	        return new ResponseEntity<Course>(course, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND); //Status 404
	}
	
	
	
	@PostMapping("/courses") //endpoint for saving a course
	public Course saveCourseC(@RequestBody Course course) {
		serviceCourses.saveCourse(course);
		return course;
		
	}
	
	
	@PutMapping("/courses/{id}") //endpoint for editing a course
	public String modifyC(@PathVariable ("id") int code, @RequestBody Course course) {
		
		serviceCourses.editCourse(course, code);
		return "Register has been edited successfully";
		
	}
	
	@DeleteMapping("/courses/{id}") //endpoint for deleting a course
	public String deleteC(@PathVariable ("id") int code) {
		serviceCourses.deleteCourse(code);
		return "Register has been deleted successfully";
		
	}
	
	
}
