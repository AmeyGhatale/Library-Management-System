package com.acciojob.LibraryManagementSystem.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "studentInfo")
@Getter
@Setter
@NoArgsConstructor // Default Constructor
@AllArgsConstructor // All Arguments Constructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    @Column(nullable = false)
    private String name;

    private String branch;

    private double cgpa;

    @Column(unique = true)
    private String emailId;

}
