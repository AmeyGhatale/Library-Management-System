package com.acciojob.LibraryManagementSystem.Controllers;

import com.acciojob.LibraryManagementSystem.Entity.Books;
import com.acciojob.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Books book)
    {
        String response = bookService.addBook(book);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/pairBookWithAuthor")
    public ResponseEntity<String> pairBookWithAuthor(@RequestParam("bookId") Integer bookId,
                                                     @RequestParam("authorId") Integer authorId)
    {
        String response="";
        try {
             response = bookService.pairBookWithAuthor(bookId, authorId);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
