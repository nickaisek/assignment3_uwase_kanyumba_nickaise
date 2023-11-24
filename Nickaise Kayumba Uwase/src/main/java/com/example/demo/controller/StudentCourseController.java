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
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private StudentRegService studentRegService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/stdCourses")
    public String listStdCourse(Model model) throws RemoteException {
        List<StudentCourse> studentCourses = studentCourseService.studentCourseList();
        model.addAttribute("stdCr", studentCourses);
        return "studentCourseDisplay"; // Return the view for listing semesters
    }

    @GetMapping("/addStdCourse")
    public String goToCourseAdd(Model model) throws RemoteException {
        StudentCourse studentCourse = new StudentCourse();
        model.addAttribute("stdCourse", studentCourse);
        List<StudentRegistration> studentRegistrations = studentRegService.getStudentRegistration();
        List<Course> courses = courseService.getCourse();
        model.addAttribute("stdRg", studentRegistrations);
        model.addAttribute("cour", courses);
//        model.addAttribute("unit", academicUnits);
        return "StudentCourse";
    }

    @PostMapping("/saveStdCourse")
    public String saveRegistration(@ModelAttribute("stdCourse") StudentCourse studentCourse) {
        studentCourseService.addStudentCourse(studentCourse);
        return "redirect:/stdCourses";
    }

//    @GetMapping("/updateSemester/{id}") // Updated path
//    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
//        Semester semesters = semesterInteface.findSemesterById(id);
//        model.addAttribute("semesters", semesters);
//        return "Semester";
//    }

    @GetMapping("/deleteStdCourse/{id}")
    public String deleteReg(@PathVariable(value = "id") UUID id) {
        this.studentCourseService.deleteStudentCourse(id);
        return "redirect:/stdCourses";
    }

}
