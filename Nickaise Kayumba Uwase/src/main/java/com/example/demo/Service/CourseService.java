package com.example.demo.Service;

import com.example.demo.model.Course;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {
    public void addCourse(Course course);
    public List<Course> getCourse() throws RemoteException;
    public Optional<Course> courseById(UUID id);
    public List<Course> courseByDepAndSem(UUID depId, UUID semId);
    public void deleteCourse(UUID id);

}
