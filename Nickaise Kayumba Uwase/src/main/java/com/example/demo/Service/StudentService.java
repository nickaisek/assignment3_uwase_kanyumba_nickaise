package com.example.demo.Service;

import com.example.demo.model.Semester;
import com.example.demo.model.Student;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    public void addStudent(Student student);
    public List<Student> getStudents() throws RemoteException;
    public void deleteStudent(UUID id);
    public Student findStudentByName(String fullname);
    public Student findStudentByRegNo(String regNo);
    // In your service interface (StudentService.java)

}
