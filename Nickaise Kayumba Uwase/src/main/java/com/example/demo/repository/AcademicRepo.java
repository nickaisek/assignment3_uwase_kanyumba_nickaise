package com.example.demo.repository;

import com.example.demo.enums.EAcademicUnit;
import com.example.demo.model.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AcademicRepo extends JpaRepository <AcademicUnit, UUID>{
    @Query("SELECT a from AcademicUnit a where a.name =: name")
    AcademicUnit findUnitByName(@Param("name") String name);
    List<AcademicUnit> findByUnit(EAcademicUnit unit);
}
