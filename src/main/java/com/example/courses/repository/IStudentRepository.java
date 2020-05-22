package com.example.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courses.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
