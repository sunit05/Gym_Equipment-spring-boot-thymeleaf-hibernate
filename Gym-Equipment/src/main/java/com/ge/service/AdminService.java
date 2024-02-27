package com.ge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.AdminDao;
import com.ge.dto.Admin;

@Service
public class AdminService{

	@Autowired
	AdminDao adminDao;
	
	public List<Admin> getAllAdmins(){
		return adminDao.getAllAdmins();
	}
	
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}
	
	public boolean adminLogin(Admin admin) {
		return adminDao.adminLogin(admin);
	}
	
	public boolean authSeller(int seller_id, Admin admin) {
		return adminDao.authSeller(seller_id, admin);
	}
	
	public Admin getAdminById(long id) {
		return adminDao.getAdminById(id);
	}
}

