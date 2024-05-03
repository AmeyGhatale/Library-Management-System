package com.acciojob.LibraryManagementSystem.Repositories;

import com.acciojob.LibraryManagementSystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryCard, Integer> {
}
