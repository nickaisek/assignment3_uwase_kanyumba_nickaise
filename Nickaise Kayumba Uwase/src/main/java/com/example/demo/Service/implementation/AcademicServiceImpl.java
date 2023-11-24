package com.example.demo.Service.implementation;

import com.example.demo.Service.AcademicService;
import com.example.demo.enums.EAcademicUnit;
import com.example.demo.enums.EQualification;
import com.example.demo.repository.AcademicRepo;
import com.example.demo.model.AcademicUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AcademicServiceImpl  extends RemoteException implements AcademicService {
    @Autowired
    private AcademicRepo academicRepo;
    @Override
    public void addAcademicUnit(AcademicUnit academicUnit) {
        academicRepo.save(academicUnit);
    }

    @Override
    public List<AcademicUnit> findAll() {
        return academicRepo.findAll();
    }

    @Override
    public AcademicUnit findUnitByName(String name) {
        return academicRepo.findUnitByName(name);
    }

//    @Override
//    public AcademicUnit findUnitByUnit(EAcademicUnit unit) {
//        return academicRepo.findUnitByUnit(unit);
//    }

    @Override
    public void deleteUnit(UUID id) {
        academicRepo.deleteById(id);
    }

    @Override
    public Optional<AcademicUnit> findUnitById(UUID id) {
        return academicRepo.findById(id);
    }

    @Override
    public List<AcademicUnit> getAllPrograms() {
//        {
//            return academicUnitRepository.findByUnit(EAcademicUnit.PROGRAMME);
//        }
        return academicRepo.findByUnit(EAcademicUnit.PROGRAMME);
    }

    @Override
    public List<AcademicUnit> getFaculties() {
        return academicRepo.findByUnit(EAcademicUnit.FACULTY);
    }

    @Override
    public AcademicUnit getAcademicUnit(UUID id) {
        // Use the repository to find the academic unit by its ID
        Optional<AcademicUnit> academicUnit = academicRepo.findById(id);
        if (academicUnit.isPresent()) {
            return academicUnit.get();
        } else {
            return null;
        }
    }
}