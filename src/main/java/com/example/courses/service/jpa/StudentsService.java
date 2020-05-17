package com.example.courses.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courses.entity.Student;
import com.example.courses.repository.IStudentRepository;
import com.example.courses.service.IStudentsService;

@Service
public class StudentsService implements IStudentsService {

	@Autowired
	private IStudentRepository repoEstudiantes;

	
	@Override
	public List<Student> searchAllStudents() {
		return repoEstudiantes.findAll();

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
