package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Enums.CardStatus;
import com.acciojob.LibraryManagementSystem.Entity.LibraryCard;
import com.acciojob.LibraryManagementSystem.Entity.Student;
import com.acciojob.LibraryManagementSystem.Repositories.LibraryRepository;
import com.acciojob.LibraryManagementSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private StudentRepository studentRepository;


    public String generateCard(){
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardStatus(CardStatus.NEW);
        libraryCard.setNoOfBooks(0);
        Date expDate = new Date(128, 06,02);
        libraryCard.setValidity(expDate);
        libraryRepository.save(libraryCard);

        return "Card is been created with id "+libraryCard.getCardNo();
    }

    public String pairCardWithStudent(int cardId, int studentId){
        LibraryCard libraryCard = libraryRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();
        libraryCard.setStudent(student);
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryRepository.save(libraryCard);

        return "Card has been pair with Student";
    }

}
