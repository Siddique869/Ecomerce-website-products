package com.siddique.e_comerse_web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.siddique.e_comerse_web.entity.OrderEntity;
import com.siddique.e_comerse_web.entity.product;
import com.siddique.e_comerse_web.service.OrderService;
import com.siddique.e_comerse_web.service.ProductService;

@Controller
public class EccomerseWebController {
	@Autowired
	ProductService productservice;
	@Autowired
	OrderService orderservice;
	
	@GetMapping("/")
	public String Homepage(Model model) {
		List<product> list = productservice.getallproducts();
		model.addAttribute("productlist", list);
		return "index";
	}
	
	@GetMapping("/LoginPage")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/Login")
	public String Login(@RequestParam String username, @RequestParam String password) {
		String page = "";
		if(username.equals("siddique") && password.equals("siddique@5/7"))
			page = "AdminPanel";
		else
			page = "LoginFailed";
		
		return page;
	}
	
	@GetMapping("/Newproduct")
	public String Newproduct() {
		return "Newproduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveproduct(@ModelAttribute product pro, Model model) {
		// Image URL is now directly set from the form via @ModelAttribute
		// No file upload processing needed
		productservice.addproduct(pro);
		model.addAttribute("product", pro);
		return "Newproductadded";
	}

	@GetMapping("/Editproduct")
	public String Editproduct(Model model) {
		List<product> list = productservice.getallproducts();
		model.addAttribute("productlist", list);
		return "Editproduct";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		List<product> list = productservice.getallproducts();
		model.addAttribute("products", list);
		return "shop";
	}
	
	@GetMapping("/editProductForm")
	public String editProductForm(@RequestParam int id, Model model) {
		product pro = productservice.getbyId(id);
		model.addAttribute("product", pro);
		return "UpdateProduct";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute product pro, Model model) {
		productservice.addproduct(pro);
		model.addAttribute("product", pro);
		return "Newproductadded";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int id) {
		productservice.delete(id);
		return "redirect:/Editproduct";
	}
	
	@GetMapping("/checkout")
	public String checkout(@RequestParam int id, Model model) {
		product pro = productservice.getbyId(id);
		model.addAttribute("product", pro);
		return "orderPage";
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@ModelAttribute OrderEntity order, Model model) {
		orderservice.saveOrder(order);
		model.addAttribute("order", order);
		return "OrderSuccess";
	}
	
	@GetMapping("/viewOrders")
	public String viewOrders(Model model) {
		List<OrderEntity> orders = orderservice.getAllOrders();
		model.addAttribute("orders", orders);
		return "viewOrders";
	}
	
	@GetMapping("/adminDashboard")
	public String adminDashboard() {
		return "AdminPanel";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
}