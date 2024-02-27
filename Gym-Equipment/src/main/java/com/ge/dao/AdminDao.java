package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.Admin;
import com.ge.dto.Seller;
import com.ge.repository.GymRepository;

@Component
public class AdminDao {

	@Autowired
	GymRepository gymRepository;
	@Autowired
	SellerDao sellerDao;

	public List<Admin> getAllAdmins() {
		return gymRepository.findAll();
	}

	public Admin saveAdmin(Admin admin) {
		return gymRepository.save(admin);
	}

	public boolean adminLogin(Admin admin) {
		List<Admin> admins = getAllAdmins();
		for (Admin a : admins) {
			if (admin.getUsername().equals(a.getUsername()) && admin.getPassword().equals(a.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public Admin getAdminById(long id) {
		return gymRepository.findById(id).get();
	}

	public boolean authSeller(int seller_id, Admin admin) {
		Seller s = sellerDao.getSellerById(seller_id);
		if (s != null) {
			s.setStatus("Authorized");
			return true;
		}
		return false;
	}
}
