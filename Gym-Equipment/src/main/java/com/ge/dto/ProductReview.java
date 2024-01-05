package com.ge.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ProductReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String review;

	@OneToOne
	public Customer customer;
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
