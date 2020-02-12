package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Transaction;
import com.example.project.service.Project1Service;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Project1Controller {	
	
	@Autowired
	private Project1Service project1Service;

	@GetMapping("/transactions")
	public List<Transaction> findAllTransactions() {
		return project1Service.getAllTransactions();
	}
	
}
