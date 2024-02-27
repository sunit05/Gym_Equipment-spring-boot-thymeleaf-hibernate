package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.Cart;
import com.ge.repository.CartRepository;

@Component
public class CartDao {
	
	@Autowired
	CartRepository cartRepository;

	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public void deleteCartById(long id) {
		cartRepository.deleteById(id);
	}

	public void updateCart(Cart cart) {
		long id = cart.getId();
		Cart cart2 = cartRepository.findById(id).get();
		cart2.setCustomer(cart.getCustomer());
		cart2.setProducts(cart.getProducts());
	}

	public Cart getCartById(long id) {
		return cartRepository.findById(id).get();
	}		
}

