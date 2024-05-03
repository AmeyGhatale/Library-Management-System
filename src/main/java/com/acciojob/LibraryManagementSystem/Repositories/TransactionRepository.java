package com.acciojob.LibraryManagementSystem.Repositories;

import com.acciojob.LibraryManagementSystem.Entity.Books;
import com.acciojob.LibraryManagementSystem.Entity.LibraryCard;
import com.acciojob.LibraryManagementSystem.Entity.Transactions;
import com.acciojob.LibraryManagementSystem.Enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, String> {
    Transactions findTransactionByBookAndCardAndTransactionStatus(Books book, LibraryCard card, TransactionStatus transactionStatus);

}
