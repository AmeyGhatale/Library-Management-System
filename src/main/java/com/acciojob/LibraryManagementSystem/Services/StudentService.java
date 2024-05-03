package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Entity.Student;
import com.acciojob.LibraryManagementSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Student has been added";
    }
}
