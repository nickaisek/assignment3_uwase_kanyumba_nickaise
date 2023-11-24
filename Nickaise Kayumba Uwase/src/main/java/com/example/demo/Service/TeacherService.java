package com.example.demo.Service;

import com.example.demo.model.Teacher;

import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface TeacherService {
    public void addTeacher(Teacher teacher);
    public List<Teacher> getTeacher() throws RemoteException;
    public void deleteTeacher(UUID id);
    public Teacher findTeacherByName(String name);
}
