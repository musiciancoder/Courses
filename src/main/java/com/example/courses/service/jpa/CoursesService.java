package com.example.courses.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.courses.entity.Course;
import com.example.courses.entity.Student;
import com.example.courses.repository.ICourseRepository;
import com.example.courses.service.ICoursesService;



@Service
public class CoursesService implements ICoursesService {
	
	@Autowired
	private ICourseRepository repoCursos;

	@Override
	public List<Course> searchAllCourses() {
		return repoCursos.findAll(); 
	}
	
	
	@Override
	public Page<Course> searchAllOfTheCoursesByPage() {
		Page<Course>page = repoCursos.findAll(PageRequest.of(0,2,Sort.by("name")));
		System.out.println("Total rows: " + page.getTotalElements());
		System.out.println("Total pages: " + page.getTotalPages());
		for (Course s : page) {
			System.out.println(s.getCode() + " " + s.getName());
		}
		return page;
	}





	@Override
	public Course searchCourseById(int id) {
		Optional<Course> optional  = repoCursos.findById(id);
		if (optional.isPresent()) {
			return	optional.get();
				
			}
		return null;
		
	}
	

	@Override
	public void saveCourse(Course course) {
		repoCursos.save(course);
		
	}
	


	@Override
	public Course searchById(int code) {
		Optional<Course> optional = repoCursos.findById(code);
		if (optional.isPresent())
			return optional.get();
		return null;
		
	}

	

	@Override
	public Course deleteCourse(int code) {
		Optional <Course> Id= repoCursos.findById(code);
		if(Id.isPresent()) {
			Course curso = Id.get();
			repoCursos.deleteById(code);
			return curso;
		}
		return null;
	}




	@Override
	public Course editCourse(Course course, int code) {
			Optional <Course> Id= repoCursos.findById(code);
			if(Id.isPresent()) {
				course.setCode(code);
				repoCursos.save(course);
				Course curso = Id.get();
				return curso;
			}
			return null;
	

}







}
