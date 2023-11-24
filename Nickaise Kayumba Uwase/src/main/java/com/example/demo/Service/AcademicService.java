package com.example.demo.Service;

import com.example.demo.enums.EAcademicUnit;
import com.example.demo.model.AcademicUnit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AcademicService {
    public void addAcademicUnit(AcademicUnit academicUnit);

    public List<AcademicUnit> findAll();
    public AcademicUnit findUnitByName(String name);
//    public AcademicUnit findUnitByUnit(EQualification unit);

    public void deleteUnit(UUID id);

    public Optional<AcademicUnit> findUnitById(UUID id);
    public List<AcademicUnit> getAllPrograms();
    public List<AcademicUnit> getFaculties();
    public AcademicUnit getAcademicUnit(UUID id);




}
