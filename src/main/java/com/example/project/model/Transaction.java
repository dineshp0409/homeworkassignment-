package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Transaction{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String customerId;
	private Double total;
	private String description;

	@JsonInclude  
	@Transient   
	protected Long points;
	
	public Transaction() {
		super();
	}
	public Transaction(Long id, String customerId, Double total, String description) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.total = total;
		this.description = description;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
	public Long getPoints() {
		this.points = 0l;
		
		if (this.total > 50 && this.total <= 100) {
			this.points += (this.total.intValue() - 50) * 1;
			
		} 
		
		if (this.total > 100) {
			this.points += 50;  //1 point for every dollar spent over $50
			this.points += (this.total.intValue() - 100) * 2;  //2 points for every dollar spent over $100
		}
		
		return this.points;
	}
	
	@Override
	public String toString() {
		return String.format("Transaction [id=%s, customer=%s, total=%s, description=%s, saveDate=%s]", 
				id, customerId,
				total, description);
	}
	
}
