package com.example.demo.repository;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface StudentRepo extends JpaRepository<Student, UUID> {
    @Query("SELECT s from Student s where s.fullname =: fullname")
    Student findStudentByName (@Param("fullname") String fullname);

    @Query("SELECT s from Student s where s.regNo =: regNo")
    Student findStudentByRegNo (@Param("regNo") String regNo);

}
