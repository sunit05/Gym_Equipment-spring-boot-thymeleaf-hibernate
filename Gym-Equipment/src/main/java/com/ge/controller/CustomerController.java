package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ge.dto.Customer;
import com.ge.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

//	@GetMapping("/showAllCustomers")
//	public String viewHomePage(Model model) {
//		model.addAttribute("listCustomers", customerService.getAllCustomers());
//		return "";
//	}

	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		// create model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// save customer to database
		customerService.saveCustomer(customer);
		return "redirect:/";
	}
	
	@PostMapping("/deleteCustomer")
	public void deleteCustomerById(@ModelAttribute("id") int id) {
		customerService.deleteCustomerById(id);
	}
	
	@PostMapping("/updateCustomer")
	public void updateCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.updateCustomer(customer);
	}
	
	@PostMapping("/loginCustomer")
	public String loginCustomer(@ModelAttribute("customer") Customer customer) {

		if (customerService.customerLogin(customer)) {
			return "redirect:/";
		}
		else {
			return "redirect:/login_customer";
		}
	}
	
}
