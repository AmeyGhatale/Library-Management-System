package com.acciojob.LibraryManagementSystem.Controllers;

import com.acciojob.LibraryManagementSystem.Services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libraryCard")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;


    @PostMapping("/generateCard")
    public ResponseEntity<String> addCard(){
        String response = libraryService.generateCard();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/pairCardWithStudent")
    public ResponseEntity<String> pairCardWithStudent(@RequestParam("cardNo") Integer cardId,
                                                      @RequestParam("rollNo") Integer studentId)
    {
        String response = libraryService.pairCardWithStudent(cardId, studentId);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }





}
