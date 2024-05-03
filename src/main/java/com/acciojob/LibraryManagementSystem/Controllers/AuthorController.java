package com.acciojob.LibraryManagementSystem.Controllers;

import com.acciojob.LibraryManagementSystem.Entity.Author;
import com.acciojob.LibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody Author author)
    {
        String response = authorService.addAuthor(author);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
