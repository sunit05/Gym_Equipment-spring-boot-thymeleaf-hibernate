package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.ProductReview;
import com.ge.repository.ProductReviewRepository;

@Component
public class ProductReviewDao {
	
	@Autowired
	ProductReviewRepository productReviewRepository;

	public List<ProductReview> getAllProductReviews() {
		return productReviewRepository.findAll();
	}

	public ProductReview saveProductReview(ProductReview productReview) {
		return productReviewRepository.save(productReview);
	}

	public void deleteProductReviewById(long id) {
		productReviewRepository.deleteById(id);
	}

	public void updateProductReview(ProductReview productReview) {
		long id = productReview.getId();
		ProductReview productReview2 = productReviewRepository.findById(id).get();
		productReview2.setCustomer(productReview.getCustomer());
		productReview2.setProduct(productReview.getProduct());
	}

	public ProductReview getProductReviewById(long id) {
		return productReviewRepository.findById(id).get();
	}	
}
