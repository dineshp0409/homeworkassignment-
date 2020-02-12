package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Transaction;
import com.example.project.repository.TransactionRepository;

@Service
public class Project1Service {

	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}
}
