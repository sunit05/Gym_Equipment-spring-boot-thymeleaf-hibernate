package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ge.dto.Admin;
import com.ge.dto.Seller;
import com.ge.repository.SellerRepository;
import com.ge.service.AdminService;
import com.ge.service.ProductService;
import com.ge.service.SellerService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private SellerService sellerService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "home";
	}

	@GetMapping("/showAllAdmins")
	public String showAllAdmins(Model model) {
		model.addAttribute("listAdmins", adminService.getAllAdmins());
		return "showAllAdmins";
	}

	@GetMapping("/showNewAdminForm")
	public String showNewAdminForm(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "new_admin";
	}

	@PostMapping("/saveAdmin")
	public String saveAdmin(@ModelAttribute("admin") Admin admin) {
		adminService.saveAdmin(admin);
		return "redirect:/";
	}

	@GetMapping("/showNewAdminLoginForm")
	public String showNewAdminLoginForm(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "login_admin";
	}

	@PostMapping("/loginAdmin")
	public String loginAdmin(@ModelAttribute("admin") Admin admin) {
		if (adminService.adminLogin(admin)) {
			return "redirect:/";
		} else {
			return "redirect:/login_admin";
		}
	}

//	@GetMapping("/showAllProducts")
//	public String showAllProducts(Model model) {
//		model.addAttribute("listProducts", productService.getAllProducts());
//		return "showAllProducts";
//	}

	@PutMapping("/authSeller")
	public String authSeller(@RequestParam int ad_id, @RequestParam int sl_id) {
		Seller sl = sellerService.getSellerById(sl_id);
		Admin ad = adminService.getAdminById(ad_id);
		sl.setAdmin(ad);
		sl.setStatus("Authorized");
//		sellerService.updateSeller(sl);
		sellerRepository.save(sl);
//		return "success";
//		return "/showAllSellers";
		return "/home";
	}

}