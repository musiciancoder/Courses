package com.example.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.courses.entity.Student;
import com.example.courses.repository.IStudentRepository;
//import com.example.courses.security.JWTAuthorizationFilter;

@SpringBootApplication
public class CoursesApplication implements CommandLineRunner {

	@Autowired
	private IStudentRepository repoEstudiante;

	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}

	/* Spring Security */

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					//.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests().antMatchers(HttpMethod.POST, "/user").permitAll().anyRequest().authenticated();
		}
	}

	public void run(String... args) throws Exception {
		// These are running tests only
		// searchAllOfTheStudents();
		// searchAllOfTheStudentsByPage();
	}

	private void searchAllOfTheStudents() { // Test
		List<Student> lista = repoEstudiante.findAll();
		for (Student v : lista) {
			System.out.println(
					"id: " + v.getId() + ", name: " + v.getName() + ", course code: " + v.getCourse().getCode());
			;
		}
	}

	private void searchAllOfTheStudentsByPage() { // Test
		Page<Student> page = repoEstudiante.findAll(PageRequest.of(0, 5));
		System.out.println("Total rows: " + page.getTotalElements());
		System.out.println("Total pages: " + page.getTotalPages());
		for (Student s : page) {
			System.out.println(s.getId() + " " + s.getLastname());
		}
	}

}
