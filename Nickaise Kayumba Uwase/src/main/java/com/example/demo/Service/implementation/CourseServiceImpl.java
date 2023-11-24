package com.example.demo.Service.implementation;

import com.example.demo.Service.CourseService;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CourseServiceImpl extends RemoteException implements CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Override
    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    @Override
    public List<Course> getCourse() throws RemoteException {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> courseById(UUID id) {
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> courseByDepAndSem(UUID depId, UUID semId) {
        return null;
    }

    @Override
    public void deleteCourse(UUID id) {
        courseRepo.deleteById(id);
    }
}
