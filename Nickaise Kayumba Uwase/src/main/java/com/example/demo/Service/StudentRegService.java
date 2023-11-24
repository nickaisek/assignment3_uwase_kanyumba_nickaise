package com.example.demo.Service;

import com.example.demo.model.StudentRegistration;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRegService {

    public void addStudentRegistration(StudentRegistration studentRegistration);
    public List<StudentRegistration> getStudentRegistration() throws RemoteException;
    public Optional<StudentRegistration> studRegistrationById(UUID id);
    public List <StudentRegistration> findRegistrationByName(UUID id);
    public void deleteStudentRegistration(UUID id);
    public List<StudentRegistration> getStudentBySemester(UUID id);
    public List<StudentRegistration> getStudentBySemesterAndDepartment(UUID id, UUID unitId);

    }
