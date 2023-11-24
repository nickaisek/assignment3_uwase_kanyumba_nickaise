package com.example.demo.repository;

import com.example.demo.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StudentRegistrationRepo extends JpaRepository<StudentRegistration, UUID> {
//    @Query("SELECT s from StudentRegistration s where s.student.regNo =: regNo and s.semester.name =: name")
//    List<StudentRegistration> findRegistrationByName (@Param("regNo") String regNo);
//
    @Query("SELECT s from StudentRegistration s where s.semester.Id =: id")
    List<StudentRegistration> findRegistrationByName (@Param("id") UUID id);

}
