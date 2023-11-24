package com.example.demo.repository;

import com.example.demo.model.StudentCourse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, UUID> {
}
