package com.ge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.ProductReviewDao;
import com.ge.dto.ProductReview;

@Service
public class ProductReviewService {


	@Autowired
	ProductReviewDao productReviewDao;
	
	public List<ProductReview> getAllProductReviews(){
		return productReviewDao.getAllProductReviews();
	}
	
	public ProductReview saveProductReview(ProductReview productReview) {
		return productReviewDao.saveProductReview(productReview);
	}
	
	public void updateProductReview(ProductReview productReview) {
		productReviewDao.updateProductReview(productReview);
	}

	public void deleteProductReviewById(long id) {
		productReviewDao.deleteProductReviewById(id);
	}

	public ProductReview getProductReviewById(long id) {
		return productReviewDao.getProductReviewById(id);
	}
	
}
