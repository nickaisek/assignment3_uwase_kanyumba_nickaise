package com.example.demo.Service.implementation;

import com.example.demo.Service.StudentService;
import com.example.demo.model.Semester;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.model.Semester;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentRepo studentRepo;
  @Override
  public void addStudent(Student student) {
    studentRepo.save(student);
  }

  @Override
  public List<Student> getStudents() throws RemoteException {
    return studentRepo.findAll();
  }

  @Override
  public void deleteStudent(UUID id) {
    studentRepo.deleteById(id);
  }

  @Override
  public Student findStudentByName(String fullname) {
    return studentRepo.findStudentByName(fullname);
  }

  @Override
  public Student findStudentByRegNo(String regNo) {
    return studentRepo.findStudentByRegNo(regNo);
  }

}
