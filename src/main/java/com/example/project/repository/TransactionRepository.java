package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
