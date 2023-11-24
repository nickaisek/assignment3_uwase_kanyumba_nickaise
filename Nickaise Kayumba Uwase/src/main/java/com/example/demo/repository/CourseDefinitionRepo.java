package com.example.demo.repository;

import com.example.demo.model.CourseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CourseDefinitionRepo extends JpaRepository<CourseDefinition, UUID> {
    @Query("SELECT cd from CourseDefinition cd where cd.name =: name")
    CourseDefinition findCourseByName(@Param("name") String name);
}
