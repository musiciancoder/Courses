package com.example.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.courses.entity.Student;
import com.example.courses.repository.IStudentRepository;

@SpringBootApplication
public class CoursesApplication implements CommandLineRunner{

	@Autowired
	private IStudentRepository repoEstudiante;
	
	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		searchAllOfTheStudents();
	}
	
	private void searchAllOfTheStudents() {
			List<Student>lista = repoEstudiante.findAll();
			for(Student v: lista) {
				System.out.println("id: " + v.getId() + ", name: " +v.getName() + ", course code: " + v.getCourse().getCode());;
			}
	}

}
