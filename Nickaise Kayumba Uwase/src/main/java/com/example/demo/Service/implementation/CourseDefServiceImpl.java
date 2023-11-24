package com.example.demo.Service.implementation;

import com.example.demo.Service.CourseDefService;
import com.example.demo.model.CourseDefinition;
import com.example.demo.repository.CourseDefinitionRepo;
import com.example.demo.model.CourseDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

@Service
public class CourseDefServiceImpl extends RemoteException implements CourseDefService {
    @Autowired
    private CourseDefinitionRepo courseDefinitionRepo;
    @Override
    public void addCourseDefinition(CourseDefinition courseDefinition) {
        courseDefinitionRepo.save(courseDefinition);
    }

    @Override
    public List<CourseDefinition> getCourseDef() throws RemoteException {
        return courseDefinitionRepo.findAll();
    }

    @Override
    public CourseDefinition findCourseByName(String name) {
        return courseDefinitionRepo.findCourseByName(name);
    }

    @Override
    public void deleteCourse(UUID id) {
       courseDefinitionRepo.deleteById(id);
    }

}
