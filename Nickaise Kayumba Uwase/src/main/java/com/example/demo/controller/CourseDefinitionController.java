package com.example.demo.controller;

import com.example.demo.Service.CourseDefService;
import com.example.demo.model.CourseDefinition;
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
public class CourseDefinitionController {
    @Autowired
    private CourseDefService courseDefService;
    @GetMapping("/definitions")
    public String listCourseDef(Model model) throws RemoteException {
        List<CourseDefinition> definition = courseDefService.getCourseDef();
        model.addAttribute("definition", definition);
        return "courseDefinitionDisplay"; // Return the view for listing semesters
    }
    @GetMapping("/addDef")
    public String goToStdAdd(Model model){
        CourseDefinition courseDefinition= new CourseDefinition();
        model.addAttribute("cd", courseDefinition);
        return "courseDefinition";
    }
    @PostMapping("/saveDefinition")
    public String saveStudent(@ModelAttribute("cd") CourseDefinition courseDefinition) {
        courseDefService.addCourseDefinition(courseDefinition);
        return "redirect:/definitions";
    }
    @GetMapping("/deleteDefinition/{id}")
    public String deleteSem(@PathVariable(value = "id") UUID id){
        this.courseDefService.deleteCourse(id);
        return "redirect:/definitions";
    }
}
