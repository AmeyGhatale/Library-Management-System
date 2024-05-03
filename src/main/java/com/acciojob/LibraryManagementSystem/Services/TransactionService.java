package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Entity.Books;
import com.acciojob.LibraryManagementSystem.Entity.LibraryCard;
import com.acciojob.LibraryManagementSystem.Entity.Transactions;
import com.acciojob.LibraryManagementSystem.Enums.TransactionStatus;
import com.acciojob.LibraryManagementSystem.Repositories.BookRepository;
import com.acciojob.LibraryManagementSystem.Repositories.LibraryRepository;
import com.acciojob.LibraryManagementSystem.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    private static final int MAX_NO_OF_BOOKS = 3;
    private static final int FINE_PER_DAY = 5;

    public String issueBook(int cardId, int bookId) throws Exception {
        Optional<Books> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty())
            throw new Exception("Book not found");
        Books book = optionalBook.get();

        Optional<LibraryCard> optionalCard = libraryRepository.findById(cardId);
        if(optionalCard.isEmpty())
            throw new Exception("Card not found");
        LibraryCard card = optionalCard.get();


        Transactions transactions = new Transactions();
        transactions.setBook(book);
        transactions.setTransactionStatus(TransactionStatus.PENDING);
        transactions.setCard(card);
        card.setNoOfBooks(card.getNoOfBooks()+1);

        if(book.getIsIssued()){
            transactions.setTransactionStatus(TransactionStatus.FAILURE);
            return "Book is already Issued";
        }

        if(card.getNoOfBooks() > MAX_NO_OF_BOOKS){
            transactions.setTransactionStatus(TransactionStatus.FAILURE);
            return "Card limit has been exhausted";
        }

        Long timeInMsOfCardValidity = card.getValidity().getTime();
        Long currentTimeInMs = System.currentTimeMillis();

        if(currentTimeInMs>timeInMsOfCardValidity){
            transactions.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transactions);
            return "Your card has been expired";
        }

        book.setIsIssued(true);
        transactions.setTransactionStatus(TransactionStatus.ISSUED);

        libraryRepository.save(card);
        bookRepository.save(book);
        transactionRepository.save(transactions);

        return "Transaction has been completed with TransactionId = "+transactions.getTransactionId();
    }

    public String returnBook(int cardId, int bookId) throws Exception {
        Optional<Books> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty())
            throw new Exception("Book not found");
        Books book = optionalBook.get();

        Optional<LibraryCard> optionalCard = libraryRepository.findById(cardId);
        if (optionalCard.isEmpty())
            throw new Exception("Card not found");
        LibraryCard card = optionalCard.get();

        Transactions transactions = transactionRepository.findTransactionByBookAndCardAndTransactionStatus(book, card, TransactionStatus.ISSUED);

        Long timeDiffInMs = System.currentTimeMillis() - transactions.getIssueDate().getTime();
        Long days = TimeUnit.DAYS.convert(timeDiffInMs, TimeUnit.MILLISECONDS);

        Double fineAmt = 0.0;

        if(days>15)
            fineAmt = (double) ((days-15)*FINE_PER_DAY);

        transactions.setFineAmount(fineAmt);
        transactions.setTransactionStatus(TransactionStatus.COMPLETED);
        transactions.setReturnDate(new Date());
        book.setIsIssued(Boolean.FALSE);
        card.setNoOfBooks(card.getNoOfBooks()-1);

        transactionRepository.save(transactions);
        bookRepository.save(book);
        libraryRepository.save(card);

        return "Book is returned successfully";
    }



}
