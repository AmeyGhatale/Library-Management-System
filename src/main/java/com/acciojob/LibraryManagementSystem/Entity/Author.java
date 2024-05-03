package com.acciojob.LibraryManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "author_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(nullable = false)
    private String name;

    private int age;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int noOfBooks;

    @Column(unique = true)
    private String email;

    private double rating;
}
