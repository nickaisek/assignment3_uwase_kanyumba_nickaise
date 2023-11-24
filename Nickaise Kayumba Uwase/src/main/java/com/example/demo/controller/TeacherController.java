package com.example.demo.controller;

import com.example.demo.Service.TeacherService;
import com.example.demo.model.Semester;
import com.example.demo.model.Teacher;
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
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/teachers")
    public String listTeachers(Model model) throws RemoteException {
        List<Teacher> teachers = teacherService.getTeacher();
        model.addAttribute("tea", teachers);
        return "teacherDisplay"; // Return the view for listing semesters
    }
    @GetMapping("/addTea")
    public String goToTeaAdd(Model model){
        Teacher teacher= new Teacher();
        model.addAttribute("teac", teacher);
        return "Teacher";
    }
    @PostMapping("/addedT")
    public String saveTeacher(@ModelAttribute("teac") Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/deleteTeacher/{id}")
    public String deleteSem(@PathVariable(value = "id") UUID id){
        this.teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }
}
