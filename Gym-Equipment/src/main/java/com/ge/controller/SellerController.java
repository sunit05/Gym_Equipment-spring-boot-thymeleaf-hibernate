package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ge.dto.Seller;
import com.ge.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;

//	@GetMapping("/")
//	public String viewHomePage(Model model) {
//		return "home";
//	}

	@GetMapping("/showAllSellers")
	public String showAllSellers(Model model) {
		model.addAttribute("listSellers", sellerService.getAllSellers());
		return "showAllSellers";
	}

	@GetMapping("/showNewSellerForm")
	public String showNewSellerForm(Model model) {
		// create model attribute to bind form data
		Seller seller = new Seller();
		model.addAttribute("seller", seller);
		return "new_seller";
	}

	@PostMapping("/saveSeller")
	public String saveSeller(@ModelAttribute("seller") Seller seller) {
		// save seller to database
		sellerService.saveSeller(seller);
		return "redirect:/";
	}

	@GetMapping("/showNewSellerLoginForm")
	public String showNewSellerLoginForm(Model model) {
		// create model attribute to bind form data
		Seller seller = new Seller();
		model.addAttribute("seller", seller);
		return "login_seller";
	}

	@PostMapping("/loginSeller")
	public String loginSeller(@ModelAttribute("seller") Seller seller) {
		// save seller to database

		if (sellerService.sellerLogin(seller)) {
			return "redirect:/";
		} else {
			return "redirect:/login_seller";
		}
	}
}