package com.example.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courses.entity.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
