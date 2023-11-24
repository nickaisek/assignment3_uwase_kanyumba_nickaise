package com.example.demo.controller;

import com.example.demo.Service.AcademicService;
import com.example.demo.enums.EAcademicUnit;
import com.example.demo.enums.EQualification;
import com.example.demo.model.AcademicUnit;
import com.example.demo.model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class AcademicController {
        @Autowired
        private AcademicService academicService;
    @GetMapping("/academicList")
    public String listAcademicUnits(Model model) {
        List<AcademicUnit> academicUnits = academicService.findAll(); // Retrieve academic units from the database
        model.addAttribute("academicUnits", academicUnits);
        return "academicDisplay";
    }

//    @GetMapping("/academic")
//    public String listAcademics(Model model) throws RemoteException {
//        // Retrieve academic units
//        List<AcademicUnit> academicUnits = academicService.findAll();
//        model.addAttribute("academ", academicUnits);
//        // Retrieve programs for dropdowns
//        List<AcademicUnit> programs = academicService.findAll();
//        model.addAttribute("programs", programs);
//
//        return "academic";
//    }
        // Mapping to show the form for adding a Program
        @GetMapping("/addProgram")
        public String showProgramForm(Model model) {
            AcademicUnit program = new AcademicUnit();
            model.addAttribute("program", program);
            return "academic"; // This should be the name of your Thymeleaf template
        }

        // Mapping to save a Program
        @PostMapping("/saveProgram")
        public String saveProgram(@ModelAttribute("program") AcademicUnit program) {
            program.setUnit(EAcademicUnit.PROGRAMME);
            academicService.addAcademicUnit(program);
            return "redirect:/academicList";
        }

        // Mapping to show the form for adding a Faculty
        @GetMapping("/addFaculty")
        public String showFacultyForm(Model model) {
            AcademicUnit faculty = new AcademicUnit();
            model.addAttribute("faculty", faculty);
            List<AcademicUnit> programs = academicService.getAllPrograms();
            model.addAttribute("programs", programs);
            return "aaFaculty";
        }

        // Mapping to save a Faculty
        @PostMapping("/saveFaculty")
        public String saveFaculty(@ModelAttribute("faculty") AcademicUnit faculty) {
//            AcademicUnit program = academicService.getAcademicUnit(parentProgramId);
//            faculty.setParent(program);
            faculty.setUnit(EAcademicUnit.FACULTY);
            academicService.addAcademicUnit(faculty);
            return "redirect:/academicList";
        }

        // Mapping to show the form for adding a Department (similar to Faculty)
//        @GetMapping("/addDepartment")
//        public String showDepartmentForm(Model model) {
//            AcademicUnit department = new AcademicUnit();
//            model.addAttribute("department", department);
////            List<AcademicUnit> programs =academicService.getAllPrograms();
////            model.addAttribute("pro", programs);
//            List<AcademicUnit> faculties = academicService.getFaculties();
//            model.addAttribute("faculties", faculties);
//
//            return "aaDepartment";
//        }
        @GetMapping("/addDepartment")
        public String showDepartmentForm(Model model) {
            AcademicUnit faculty = new AcademicUnit();
            model.addAttribute("department", faculty);
            List<AcademicUnit> programs = academicService.getFaculties();
            model.addAttribute("programs", programs);
            return "aaDepartment";
        }
    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") AcademicUnit department) {
//            AcademicUnit program = academicService.getAcademicUnit(parentProgramId);
//            faculty.setParent(program);
        department.setUnit(EAcademicUnit.DEPARTMENT);
        academicService.addAcademicUnit(department);
        return "redirect:/academicList";
    }

//    @PostMapping("/saveDepartment")
//    public String saveDepartment(@ModelAttribute("department") AcademicUnit department) {
////        AcademicUnit program = academicService.getAcademicUnit(programId);
////        AcademicUnit faculty = academicService.getAcademicUnit(facultyId);
////        department.setParent(faculty);
//        department.setUnit(EAcademicUnit.DEPARTMENT);
//        academicService.addAcademicUnit(department);
//        return "redirect:/academicList";
//    }

    }

//    @Autowired
//    private AcademicService academicService;
//    @GetMapping("/academic")
//    public String listAcademics(Model model) throws RemoteException {
//        List<AcademicUnit> academicUnits = academicService.findAll();
//        model.addAttribute("academ", academicUnits);
////        return "academicDisplay"; // Return the view for listing semesters
//        return "academic";
//    }
//    @GetMapping("/addAcad")
//    public String goToSemAdd(Model model){
//        AcademicUnit academicUnit = new AcademicUnit();
//        model.addAttribute("ac", academicUnit);
//        return "academic";
//    }
//    @PostMapping("/saveAcademic")
//    public String saveAcademic(@ModelAttribute("ac") AcademicUnit academicUnit) {
//        academicService.addAcademicUnit(academicUnit);
//        return "redirect:/addAcad";
//    }
//////    @GetMapping("/updateSemester/{id}") // Updated path
//////    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
//////        Semester semesters = semesterInteface.findSemesterById(id);
//////        model.addAttribute("semesters", semesters);
//////        return "Semester";
//////    }
////
//    @GetMapping("/deleteAcademic/{id}")
//    public String deleteAcademic(@PathVariable(value = "id") UUID id){
//        this.academicService.deleteUnit(id);
//        return "redirect:/academic";
//    }
//    @GetMapping("/showNewProgrammeForm")
//    public String showNewAcademicUnitForm(Model model) {
//        AcademicUnit academicUnit = new AcademicUnit();
//        int min = 10000; // Smallest 5-digit number
//        int max = 99999; // Largest 5-digit number'
//        UUID programId = UUID.randomUUID();
//        Random random = new Random();
//        int randomCode = random.nextInt(max - min + 1) + min;
//        model.addAttribute("randomCode", randomCode);
//        model.addAttribute("programId", programId);
//        model.addAttribute("academicUnit", academicUnit);
//
//        System.out.println(programId);
//
//        return "new_programme";
//
//    }
//    @GetMapping("/showNewFacultyForm")
//    public String showNewFacultyForm(Model model) {
//        AcademicUnit employee = new AcademicUnit();
//        int min = 10000; // Smallest 5-digit number
//        int max = 99999; // Largest 5-digit number
//
//        EAcademicUnit name = EAcademicUnit.PROGRAMME;
//
//        List<AcademicUnit> listOfPrograms = academicService.findUnitByName(name);
//
//        Random random = new Random();
//        int randomCode = random.nextInt(max - min + 1) + min;
//        model.addAttribute("randomCode", randomCode);
//
//        model.addAttribute("listOfPrograms",listOfPrograms);
//
//        model.addAttribute("faculty", employee);
//        return "new_faculty";
//
//    }
//    @GetMapping("/showNewDepartmentForm")
//    public String showNewDepartmentForm(Model model) {
//        AcademicUnit employee = new AcademicUnit();
//        int min = 10000; // Smallest 5-digit number
//        int max = 99999; // Largest 5-digit number
//
//        EAcademicUnit name = EAcademicUnit.FACULTY;
//
//        List<AcademicUnit> listOfPrograms = academicService.findUnitByName(name);
//
//        Random random = new Random();
//        int randomCode = random.nextInt(max - min + 1) + min;
//        model.addAttribute("randomCode", randomCode);
//
//        model.addAttribute("listOfPrograms",listOfPrograms);
//
//        model.addAttribute("department", employee);
//        return "new_department";
//
//    }
//    @PostMapping("/saveAcademic")
//    public String saveAcademic(@ModelAttribute("ac") AcademicUnit academicUnit) {
//        academicService.addAcademicUnit(academicUnit);
//        return "redirect:/academic";
//    }


