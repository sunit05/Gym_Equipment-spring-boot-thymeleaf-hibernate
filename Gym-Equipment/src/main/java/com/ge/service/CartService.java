package com.ge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.CartDao;
import com.ge.dto.Cart;

@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	public List<Cart> getAllCarts(){
		return cartDao.getAllCarts();
	}
	
	public Cart saveCart(Cart cart) {
		return cartDao.saveCart(cart);
	}
	
	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}

	public void deleteCartById(long id) {
		cartDao.deleteCartById(id);
	}

	public Cart getCartById(long id) {
		return cartDao.getCartById(id);
	}
	
}
