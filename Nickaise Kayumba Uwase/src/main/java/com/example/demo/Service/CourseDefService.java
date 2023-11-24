package com.example.demo.Service;

import com.example.demo.model.CourseDefinition;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface CourseDefService {
    public void addCourseDefinition(CourseDefinition courseDefinition);
    public List<CourseDefinition> getCourseDef() throws RemoteException;
    public CourseDefinition findCourseByName(String name); // Correct the return type here
    public void deleteCourse(UUID id); // Update method name
}

