package com.example.demo.Service.implementation;

import com.example.demo.Service.StudentRegService;
import com.example.demo.model.StudentRegistration;
import com.example.demo.repository.StudentRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentRegServiceImpl implements StudentRegService {
   @Autowired
   private StudentRegistrationRepo studentRegistrationRepo;
   @Override
   public void addStudentRegistration(StudentRegistration studentRegistration) {
      studentRegistrationRepo.save(studentRegistration);
   }

   @Override
   public List<StudentRegistration> getStudentRegistration() throws RemoteException {
      return studentRegistrationRepo.findAll();
   }

   @Override
   public Optional<StudentRegistration> studRegistrationById(UUID id) {
      return studentRegistrationRepo.findById(id);
   }

   @Override
   public List <StudentRegistration> findRegistrationByName(UUID id) {
      return studentRegistrationRepo.findRegistrationByName(id);
   }

   @Override
   public void deleteStudentRegistration(UUID id) {
       studentRegistrationRepo.deleteById(id);
   }

   @Override
   public List<StudentRegistration> getStudentBySemester(UUID id) {
      return null;
   }

//   @Override
//   public List<StudentRegistration> getStudentBySemester(UUID id) {
//      return studentRegistrationRepo.findById(id);
//   }

   @Override
   public List<StudentRegistration> getStudentBySemesterAndDepartment(UUID id, UUID unitId) {
      return null;
   }
}