package com.example.demo.Service;

import com.example.demo.model.StudentCourse;

import java.util.List;
import java.util.UUID;

public interface StudentCourseService {
    public void addStudentCourse(StudentCourse studentCourse);
    public List<StudentCourse> studentCourseList();
    public void deleteStudentCourse(UUID id);
    public List<StudentCourse> getRegisteredStudents();
    public List<StudentCourse> studentBySemAndCourse(UUID crId, UUID smId);
    public List<StudentCourse> courseByStudentId(UUID id);
}
