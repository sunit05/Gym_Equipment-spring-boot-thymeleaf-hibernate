package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ge.dto.OrderHistory;
import com.ge.repository.OrderHistoryRepository;

public class OrderHistoryDao {
	
	@Autowired
	OrderHistoryRepository orderHistoryRepository;

	public OrderHistory saveOrderHistory(OrderHistory orderHistory) {
		return orderHistoryRepository.save(orderHistory);
	}

	public List<OrderHistory> getAllOrderHistorys() {
		return orderHistoryRepository.findAll();
	}

	public OrderHistory getOrderHistoryById(long id) {
		return orderHistoryRepository.findById(id).get();
	}
}
