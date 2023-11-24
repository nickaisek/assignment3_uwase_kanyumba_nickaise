package com.example.demo.controller;

import com.example.demo.Service.SemesterInteface;
import com.example.demo.Service.implementation.SemesterServiceImpl;
import com.example.demo.model.Semester;
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
public class SemesterController {
    @Autowired
    private SemesterInteface semesterInteface;

    @GetMapping("/sems")
    public String listSemesters(Model model) throws RemoteException {
        List<Semester> semesters = semesterInteface.getSemesters();
        model.addAttribute("ss", semesters);
        return "semesterDisplay"; // Return the view for listing semesters
    }
    @GetMapping("/addSem")
    public String goToSemAdd(Model model){
        Semester semester= new Semester();
        model.addAttribute("sem", semester);
        return "Semester";
    }
    @PostMapping("/added")
    public String saveSemester(@ModelAttribute("sem") Semester semester) {
        semesterInteface.addSemester(semester);
        return "redirect:/sems";
    }
//    @GetMapping("/updateSemester/{id}") // Updated path
//    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
//        Semester semesters = semesterInteface.findSemesterById(id);
//        model.addAttribute("semesters", semesters);
//        return "Semester";
//    }

    @GetMapping("/deleteSemester/{id}")
    public String deleteSem(@PathVariable(value = "id") UUID id){
        this.semesterInteface.deleteSemester(id);
        return "redirect:/sems";
    }
}
