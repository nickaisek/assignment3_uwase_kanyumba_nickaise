package com.example.demo.controller;

import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ListController {
    @Autowired
    private SemesterInteface semesterInteface;
    @Autowired
    private StudentRegService studentRegService;
    @Autowired
    private AcademicService academicService;
    @Autowired
    private CourseDefService courseDefService;
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

}
