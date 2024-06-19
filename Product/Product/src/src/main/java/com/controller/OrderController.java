package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Order;
import com.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addOrder")
	public Order add(@RequestBody Order od) {
		return orderService.addOrder(od);
	}
	@GetMapping("/listOrder")
	public List<Order> getAll(){
		return orderService.getAllOrders();
	}
	@GetMapping("/getOrder/{id}")
	public Order getById(@PathVariable("id") int id){
		return orderService.getOrderById(id);
	}
	@PutMapping("/updateOrder/{id}")
	public Order update(@PathVariable("id") int id,@RequestBody Order od) {
		return orderService.updateOrder(id,od);
	}
	@DeleteMapping("/deleteOrder/{id}")
	public String delete(@PathVariable("id") int id){
		return orderService.deleteOrder(id);
	}
}
