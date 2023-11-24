package com.example.demo.Service;

import com.example.demo.model.Semester;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SemesterInteface {
    public void addSemester(Semester semester);
    public List<Semester> getSemesters() throws RemoteException;
    public Semester findSemesterById(UUID id);
    public void deleteSemester(UUID id);
    public Semester findSemesterByName(String name);
}
