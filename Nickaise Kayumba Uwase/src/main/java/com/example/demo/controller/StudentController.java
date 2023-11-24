package com.example.demo.controller;

import com.example.demo.Service.StudentService;
import com.example.demo.model.Student;
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
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student")
    public String listStudents(Model model) throws RemoteException {
        List<Student> students = studentService.getStudents();
        model.addAttribute("student", students);
        return "studentDisplay"; // Return the view for listing semesters
    }
    @GetMapping("/addStd")
    public String goToStdAdd(Model model){
        Student student= new Student();
        model.addAttribute("student", student);
        return "student";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/student";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteSem(@PathVariable(value = "id") UUID id){
        this.studentService.deleteStudent(id);
        return "redirect:/student";
    }
}
