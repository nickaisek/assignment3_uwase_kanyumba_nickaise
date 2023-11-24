package com.example.demo.repository;

import com.example.demo.model.Course;
import com.example.demo.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SemesterRepo extends JpaRepository<Semester, UUID> {
    @Query("SELECT s FROM Semester s WHERE s.name = :name")
    Semester findByName(@Param("name") String name);
}
