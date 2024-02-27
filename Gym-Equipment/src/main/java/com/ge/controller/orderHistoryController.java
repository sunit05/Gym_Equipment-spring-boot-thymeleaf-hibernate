package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ge.dao.OrderHistoryDao;
import com.ge.dto.OrderHistory;

public class orderHistoryController {

	@Autowired
	private OrderHistoryDao orderHistoryDao;

	@PostMapping("/newOrder")
	public String newOrder(@RequestBody OrderHistory orderHistory) {
		orderHistoryDao.saveOrderHistory(orderHistory);
		return "redirect:/getCartById/{id}";
	}

	@GetMapping("/order/{id}")
	public String getOrderById(@RequestParam long id) {
		orderHistoryDao.getOrderHistoryById(id);
		return "orderById";
	}
	
	
}
