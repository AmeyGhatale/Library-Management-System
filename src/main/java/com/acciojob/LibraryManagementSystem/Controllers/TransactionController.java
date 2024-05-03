package com.acciojob.LibraryManagementSystem.Controllers;

import com.acciojob.LibraryManagementSystem.Entity.Transactions;
import com.acciojob.LibraryManagementSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/issueBook")
    public ResponseEntity<String> issueBook(@RequestParam("cardNo") Integer cardNo,
                                            @RequestParam("bookId") Integer bookId)
    {
        String response = "";
        try {
            response = transactionService.issueBook(cardNo, bookId);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/returnBook")
    public ResponseEntity<String> returnBook(@RequestParam("cardNo") Integer cardNo,
                                            @RequestParam("bookId") Integer bookId) throws Exception {
            String response = "";
            response = transactionService.returnBook(cardNo, bookId);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
