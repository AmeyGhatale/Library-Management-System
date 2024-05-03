package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Entity.Author;
import com.acciojob.LibraryManagementSystem.Entity.Books;
import com.acciojob.LibraryManagementSystem.Repositories.AuthorRepository;
import com.acciojob.LibraryManagementSystem.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Books book){
        book.setIsIssued(Boolean.FALSE);
        bookRepository.save(book);
        return "Book has been added";
    }

    public String pairBookWithAuthor(int bookId, int authorId){

        Optional<Books> optionalBook = bookRepository.findById(bookId);

        if(optionalBook.isEmpty()){
            // Throw new Exception
//            throw new Exception("Book is not present in DB");
        }
        Books book = optionalBook.get();

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(optionalAuthor.isEmpty()){
//            throw new Exception("Author is not present in DB");
        }
        Author author = optionalAuthor.get();
        book.setAuthor(author);

        author.setNoOfBooks(author.getNoOfBooks()+1);
        authorRepository.save(author);
        bookRepository.save(book);

        return "Book has been pair with Author";
    }






}
