package com.example.demo.repository;

import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface TeacherRepo extends JpaRepository<Teacher, UUID> {
    @Query("SELECT t from Teacher t where t.names =:names")
    Teacher findTeacherByName (@Param("names") String names);
}
