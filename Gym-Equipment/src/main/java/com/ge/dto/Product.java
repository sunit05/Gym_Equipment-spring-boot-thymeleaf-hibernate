package com.ge.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String product_name;
	private double product_mrp;
	private double product_offerPrice;
	private String product_description;
	private String product_categories;
	private int product_quantity;
	private float product_rating;

	@ManyToOne
	public Seller seller;
	
	@OneToMany
	public List<ProductReview> productReviews;
	
	public int getId() {
		return id;
	}
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_mrp() {
		return product_mrp;
	}

	public void setProduct_mrp(double product_mrp) {
		this.product_mrp = product_mrp;
	}

	public double getProduct_offerPrice() {
		return product_offerPrice;
	}

	public void setProduct_offerPrice(double product_offerPrice) {
		this.product_offerPrice = product_offerPrice;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getProduct_categories() {
		return product_categories;
	}

	public void setProduct_categories(String product_categories) {
		this.product_categories = product_categories;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public float getProduct_rating() {
		return product_rating;
	}

	public void setProduct_rating(float product_rating) {
		this.product_rating = product_rating;
	}

}
