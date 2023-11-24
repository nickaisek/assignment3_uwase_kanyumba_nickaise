package com.example.demo.Service.implementation;

import com.example.demo.Service.SemesterInteface;
import com.example.demo.model.Semester;
import com.example.demo.repository.SemesterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SemesterServiceImpl implements SemesterInteface {
    // create an instance of class(dao)
    @Autowired
    private SemesterRepo semesterRepo;
    @Override
    public void addSemester(Semester semester) {
        semesterRepo.save(semester);
    }

    @Override
    public List<Semester> getSemesters() throws RemoteException {
        return semesterRepo.findAll();
    }

    @Override
    public Semester findSemesterById(UUID id) {
        Optional<Semester> optional = semesterRepo.findById(id);

        if (optional.isPresent()) {
            return optional.get(); // Return the found client
        } else {
            throw new RuntimeException("Client not found for id :: " + id);
        }
    }

    @Override
    public void deleteSemester(UUID id) {
         semesterRepo.deleteById(id);
    }

    @Override
    public Semester findSemesterByName(String name) {
        //right query in repository to findByName
        return semesterRepo.findByName(name);
    }
}
