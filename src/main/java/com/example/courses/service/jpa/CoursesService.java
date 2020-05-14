package com.example.courses.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courses.entity.Course;
import com.example.courses.repository.ICourseRepository;
import com.example.courses.service.ICoursesService;

@Service
public class CoursesService implements ICoursesService {
	
	@Autowired
	private ICourseRepository repoCursos;

	@Override
	public List<Course> searchAllCourses() {
		return repoCursos.findAll(); //implementation of method to fetch all courses from ICoursesService
	}

	@Override
	public void saveCourse(Course course) {
		repoCursos.save(course);
		
	}
	
	

	@Override
	public void deleteCourse(int code) {
		repoCursos.deleteById(code);
		
	}



	@Override
	public void editCourse(Course course, int code) {
			Optional <Course> Id= repoCursos.findById(code);
			if(Id.isPresent()) {
				course.setCode(code);
				repoCursos.save(course);
			}
	

}
}
