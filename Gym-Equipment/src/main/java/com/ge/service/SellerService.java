package com.ge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.SellerDao;
import com.ge.dto.Seller;

@Service
public class SellerService {

	@Autowired
	SellerDao sellerDao;
	
	public List<Seller> getAllSellers(){
		return sellerDao.getAllSellers();
	}
	
	public Seller saveSeller(Seller seller) {
		seller.setStatus("UnAuthorized");
		return sellerDao.saveSeller(seller);
	}
	
	public Seller getSellerById(int id) {
		return sellerDao.getSellerById(id);
	}
	
	public void updateSeller(Seller seller) {
		sellerDao.updateSeller(seller);
	}

	public void deleteSellerById(long id) {
		sellerDao.deleteSellerById(id);
	}
	
	public boolean sellerLogin(Seller seller) {
		return sellerDao.sellerLogin(seller);
	}
	
}