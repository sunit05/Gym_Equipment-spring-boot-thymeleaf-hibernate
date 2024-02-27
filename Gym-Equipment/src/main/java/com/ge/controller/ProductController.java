package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ge.dto.Product;
import com.ge.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/showAllProducts")
	public String showAllProducts(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts());
		return "showAllProducts";
	}

	@GetMapping("/getProductById/{id}")
	public String getProductById(@PathVariable int id,Model model) {
		model.addAttribute("Product", productService.getProductById(id));
		return "showProductById";	
	}
	
	@PostMapping("/deleteProductById")
	public String deleteProductById(@PathVariable int id) {
		productService.deleteProductById(id);
		return "redirect:/deleteProductById";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		// save product to database
		productService.saveProduct(product);
		return "redirect:/";
	}
}