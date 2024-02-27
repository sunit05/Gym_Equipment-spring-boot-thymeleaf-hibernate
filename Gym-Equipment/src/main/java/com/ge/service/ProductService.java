package com.ge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.ProductDao;
import com.ge.dto.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void deleteProductById(long id) {
		productDao.deleteProductById(id);
	}

	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}
}
