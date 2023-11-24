package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepo extends JpaRepository<Course, UUID> {
}
