package com.example.demo.Service.implementation;

import com.example.demo.Service.TeacherService;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepo;
import com.example.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherServiceImpl extends RemoteException implements TeacherService {
 @Autowired
 private TeacherRepo teacherRepo;
 @Override
 public void addTeacher(Teacher teacher) {
  teacherRepo.save(teacher);
 }

 @Override
 public List<Teacher> getTeacher() throws RemoteException {
  return teacherRepo.findAll();
 }

 @Override
 public void deleteTeacher(UUID id) {
  teacherRepo.deleteById(id);
 }

 @Override
 public Teacher findTeacherByName(String name) {
  return teacherRepo.findTeacherByName(name);
 }
}
