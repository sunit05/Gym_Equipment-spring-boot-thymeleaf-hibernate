package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ge.dto.Cart;
import com.ge.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/showAllCarts")
	public String showAllCarts(Model model) {
		model.addAttribute("listCarts", cartService.getAllCarts());
		return "showAllCarts";
	}

	@GetMapping("/getCartById/{id}")
	public String getCartById(@PathVariable int id,Model model) {
		model.addAttribute("Cart", cartService.getCartById(id));
		return "showCartById";	
	}
	
	@PostMapping("/deleteCartById")
	public String deleteCartById(@PathVariable int id) {
		cartService.deleteCartById(id);
		return "redirect:/deleteCartById";
	}

	@PostMapping("/addTOCart")
	public String addToCart(@ModelAttribute("cart") Cart cart) {
		// save cart to database
		cartService.saveCart(cart);
		return "redirect:/getCartById/{id}";
	}

}
