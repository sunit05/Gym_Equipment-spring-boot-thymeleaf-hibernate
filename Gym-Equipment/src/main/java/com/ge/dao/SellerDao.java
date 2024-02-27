package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.Seller;
import com.ge.repository.SellerRepository;

@Component
public class SellerDao {
	@Autowired
	SellerRepository sellerRepository;

	public List<Seller> getAllSellers() {
		return sellerRepository.findAll();
	}

	public Seller getSellerById(int id) {
		long sid = id;
		return sellerRepository.findById(sid).get();
	}

	public Seller saveSeller(Seller seller) {
		return sellerRepository.save(seller);
	}

	public void deleteSellerById(long id) {
		sellerRepository.deleteById(id);
	}

	public void updateSeller(Seller seller) {
		long id = seller.getId();
		Seller seller2 = sellerRepository.findById(id).get();
		seller2.setName(seller.getName());
		seller2.setStatus(seller.getStatus());
		seller2.setContactNo(seller.getContactNo());
		seller2.setEmail(seller.getEmail());
		seller2.setUsername(seller.getUsername());
		seller2.setPassword(seller.getPassword());
	}

	public boolean sellerLogin(Seller seller) {
		List<Seller> sellers = getAllSellers();
		for (Seller a : sellers) {
			if (seller.getUsername().equals(a.getUsername()) && seller.getPassword().equals(a.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
