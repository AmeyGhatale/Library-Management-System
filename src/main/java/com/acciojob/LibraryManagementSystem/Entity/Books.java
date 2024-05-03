package com.acciojob.LibraryManagementSystem.Entity;

import com.acciojob.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(nullable = false)
    private String title;

    private Genre genre;

    private Integer noOfPages;

    private Integer price;

    private Boolean isIssued;

    @JoinColumn
    @ManyToOne
    private Author author;
}
