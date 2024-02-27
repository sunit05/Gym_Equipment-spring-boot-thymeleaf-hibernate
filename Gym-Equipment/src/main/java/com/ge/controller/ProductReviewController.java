package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ge.dto.ProductReview;
import com.ge.service.ProductReviewService;

@Controller
public class ProductReviewController {

	@Autowired
	private ProductReviewService productReviewService;

	@GetMapping("/showAllProductReviews")
	public String showAllProductReviews(Model model) {
		model.addAttribute("listProductReviews", productReviewService.getAllProductReviews());
		return "showAllProductReviews";
	}

	@GetMapping("/getProductReviewById/{id}")
	public String getProductReviewById(@PathVariable int id,Model model) {
		model.addAttribute("ProductReview", productReviewService.getProductReviewById(id));
		return "showProductReviewById";	
	}
	
	@PostMapping("/deleteProductReviewById")
	public String deleteProductReviewById(@PathVariable int id) {
		productReviewService.deleteProductReviewById(id);
		return "redirect:/deleteProductReviewById";
	}

	@PostMapping("/saveProductReview")
	public String saveProductReview(@ModelAttribute("productReview") ProductReview productReview) {
		// save productReview to database
		productReviewService.saveProductReview(productReview);
		return "redirect:/";
	}
}