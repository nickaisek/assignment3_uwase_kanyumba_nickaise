package com.example.demo.controller;

import com.example.demo.Service.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    CourseDefService courseDefService;
    @Autowired
    SemesterInteface semesterInteface;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AcademicService academicService;

    @GetMapping("/courses")
    public String listCourses(Model model) throws RemoteException {
        List<Course> course = courseService.getCourse();
        model.addAttribute("courses", course);
        return "courseDisplay"; // Return the view for listing semesters
    }
    @GetMapping("/addCourse")
    public String goToCourseAdd(Model model) throws RemoteException {
        Course course= new Course();
        model.addAttribute("crs", course);
        List<CourseDefinition> courseDefinitions = courseDefService.getCourseDef();
        List<Semester> semesters = semesterInteface.getSemesters();
        List<Teacher> teachers = teacherService.getTeacher();
        List<AcademicUnit> academicUnits = academicService.findAll();
        model.addAttribute("definitions", courseDefinitions);
        model.addAttribute("semesters", semesters);
        model.addAttribute("t", teachers);
        model.addAttribute("unit", academicUnits);
        return "Course";
    }
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("crs") Course course) {
        courseService.addCourse(course);
        return "redirect:/courses";
    }

//    @GetMapping("/updateSemester/{id}") // Updated path
//    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
//        Semester semesters = semesterInteface.findSemesterById(id);
//        model.addAttribute("semesters", semesters);
//        return "Semester";
//    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") UUID id){
        this.courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
