package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.Product;
import com.ge.repository.ProductRepository;

@Component
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProductById(long id) {
		productRepository.deleteById(id);
	}

	public void updateProduct(Product product) {
		long id = product.getId();
		Product product2 = productRepository.findById(id).get();
		product2.setProduct_categories(product.getProduct_categories());
		product2.setProduct_description(product.getProduct_description());
		product2.setProduct_mrp(product.getProduct_mrp());
		product2.setProduct_name(product.getProduct_name());
		product2.setProduct_offerPrice(product.getProduct_offerPrice());
		product2.setProduct_quantity(product.getProduct_quantity());
		product2.setProduct_rating(product.getProduct_rating());
		product2.setSeller(product.getSeller());
	}

	public Product getProductById(long id) {
		return productRepository.findById(id).get();
	}	
}
