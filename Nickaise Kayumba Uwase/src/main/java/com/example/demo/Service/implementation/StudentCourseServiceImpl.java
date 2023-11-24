package com.example.demo.Service.implementation;

import com.example.demo.Service.StudentCourseService;
import com.example.demo.model.StudentCourse;
import com.example.demo.repository.StudentCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseRepo studentCourseRepo;
    @Override
    public void addStudentCourse(StudentCourse studentCourse) {
        studentCourseRepo.save(studentCourse);
    }

    @Override
    public List<StudentCourse> studentCourseList() {
        return studentCourseRepo.findAll();
    }

    @Override
    public void deleteStudentCourse(UUID id) {
        studentCourseRepo.deleteById(id);
    }

    @Override
    public List<StudentCourse> getRegisteredStudents() {
        return studentCourseRepo.findAll();
    }

    @Override
    public List<StudentCourse> studentBySemAndCourse(UUID crId, UUID smId) {
        return null;
    }

    @Override
    public List<StudentCourse> courseByStudentId(UUID id) {
        return null;
    }
}
