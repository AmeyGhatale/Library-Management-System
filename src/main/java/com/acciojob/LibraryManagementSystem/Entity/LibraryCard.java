package com.acciojob.LibraryManagementSystem.Entity;


import com.acciojob.LibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "CardInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    private CardStatus cardStatus;

    private int noOfBooks;

    private Date validity;

    @JoinColumn
    @OneToOne
    private Student student;
}
