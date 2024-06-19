package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.entity.Customer;
import com.se.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	@GetMapping("/list")
	public String getListCustomer(Model theModel) {
		List<Customer> customers = customerService.getAllCustomer();
		theModel.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	private String getCustomer(Model themodel) {
		
		Customer customer = new Customer();
		themodel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@RequestMapping("/saveCustomer")
	private String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/";
		
	}
	@GetMapping("/delete")
	private String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.delete(id);
		return "redirect:/";
	}


}
