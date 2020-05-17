package com.example.courses.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.courses.entity.Student;
import com.example.courses.repository.IStudentRepository;
import com.example.courses.service.IStudentsService;

@Service
public class StudentsService implements IStudentsService {

	@Autowired
	private IStudentRepository repoEstudiantes;

	
	@Override
	public Page<Student> searchAllOfTheStudentsByPage() {
		Page<Student>page = repoEstudiantes.findAll(PageRequest.of(0,5,Sort.by("lastname")));
		System.out.println("Total rows: " + page.getTotalElements());
		System.out.println("Total pages: " + page.getTotalPages());
		for (Student s : page) {
			System.out.println(s.getId() + " " + s.getLastname());
		}
		return page;
	}
	
	
	@Override
	public List<Student> searchAllStudents() {
		return repoEstudiantes.findAll();

	}
	
	
	@Override
	public Student searchStudentById(int id) {
		Optional<Student> optional  = repoEstudiantes.findById(id);
		if (optional.isPresent()) {
			return	optional.get();
				
			}
		return null;
		
	}
	
	@Override
	public void saveStudent(Student student) {
		repoEstudiantes.save(student);

	}

	@Override
	public void deleteStudent(int id) {
		repoEstudiantes.deleteById(id);

	}

	@Override
	public void editStudent(Student student, Integer id) {
		Optional<Student> Id = repoEstudiantes.findById(id);
		if (Id.isPresent()) {
			student.setId(id);
			repoEstudiantes.save(student);
		}

	}






}









