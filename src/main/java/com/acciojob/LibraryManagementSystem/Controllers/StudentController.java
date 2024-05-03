package com.acciojob.LibraryManagementSystem.Controllers;

import com.acciojob.LibraryManagementSystem.Entity.Student;
import com.acciojob.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student)
    {
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
