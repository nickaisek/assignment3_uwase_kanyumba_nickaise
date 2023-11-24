package com.example.demo.controller;

import com.example.demo.Service.AcademicService;
import com.example.demo.Service.SemesterInteface;
import com.example.demo.Service.StudentRegService;
import com.example.demo.Service.StudentService;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class StudentRegController {
    @Autowired
    private StudentRegService studentRegService;
    @Autowired
    private SemesterInteface semesterInteface;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AcademicService academicService;

    @GetMapping("/registration")
    public String listRegistration(Model model) throws RemoteException {
        List<StudentRegistration> studentRegistrations = studentRegService.getStudentRegistration();
        model.addAttribute("regs", studentRegistrations);
        return "studentRegDisplay"; // Return the view for listing semesters
    }

    @GetMapping("/addReg")
    public String goToCourseAdd(Model model) throws RemoteException {
        StudentRegistration studentRegistration = new StudentRegistration();
        model.addAttribute("reg", studentRegistration);
        List<Semester> semesters = semesterInteface.getSemesters();
        List<AcademicUnit> academicUnits = academicService.findAll();
        List<Student> students = studentService.getStudents();
        model.addAttribute("semesters", semesters);
        model.addAttribute("students", students);
//        model.addAttribute("units", academicUnits);
        return "studentReg";
    }

    @PostMapping("/saveReg")
    public String saveRegistration(@ModelAttribute("reg") StudentRegistration studentRegistration) {
        studentRegService.addStudentRegistration(studentRegistration);
        return "redirect:/registration";
    }

//    @GetMapping("/updateSemester/{id}") // Updated path
//    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
//        Semester semesters = semesterInteface.findSemesterById(id);
//        model.addAttribute("semesters", semesters);
//        return "Semester";
//    }

    @GetMapping("/deleteReg/{id}")
    public String deleteReg(@PathVariable(value = "id") UUID id) {
        this.studentRegService.deleteStudentRegistration(id);
        return "redirect:/registration";
    }

        @GetMapping("/listStudents")
        public String listStudentsBySemester(@RequestParam("semester") UUID semesterId, Model model) {
            // Retrieve the list of students for the selected semester
            List<StudentRegistration> studentRegistrations = studentRegService.getStudentBySemester(semesterId);
//            List<Semester> se>mesters = semesterInteface.getSemesters();
            model.addAttribute("students", studentRegistrations);
            return "listStudentBySem";
        }
    }
