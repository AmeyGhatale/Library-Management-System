package com.acciojob.LibraryManagementSystem.Repositories;

import com.acciojob.LibraryManagementSystem.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
}
