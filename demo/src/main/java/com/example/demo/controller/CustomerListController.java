package com.example.demo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
//@ImportResource("/webapp/WEB-INF/web.xml")
public class CustomerListController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/customer",method = GET)
	public String showAllCustomers(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers",customers);
		System.out.println("showAll起動");
		return "/list";
	}

	@RequestMapping(value = "/",method = GET)
	public String home() {
		System.out.println("home起動");
		return "forward:/customer";
	}

	@RequestMapping(value = "/customer/{customerId}",method = GET)
	public String showCustomerDetail(@PathVariable int customerId,Model model)
											throws Exception{
		Customer customer = customerService.findById(customerId);
		model.addAttribute("customer", customer);
		return "customer/detail";

	}//web.xmlが効いていない？orパスが間違っている？or検索場所がおかしい？
		//→listが見つからない
}
