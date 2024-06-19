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

import com.model.OrderDetail;
import com.model.Product;
import com.service.OrderDetailService;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
	@Autowired OrderDetailService service;
	
	@PostMapping("/addOrDetail")
	public OrderDetail add(@RequestBody OrderDetail od) {
		return service.addOrDetail(od);
	}
	@GetMapping("/listOrDetail")
	public List<OrderDetail> getAll(){
		return service.getAllOrderDetail();
	}
	@GetMapping("/getOrDetail/{id}")
	public OrderDetail getById(@PathVariable("id") int id){
		return service.getOrDetailById(id);
	}
	@PutMapping("/updateOrDetail/{id}")
	public OrderDetail update(@PathVariable("id") int id,@RequestBody OrderDetail od) {
		return service.updateOrDetail(id,od);
	}
	@DeleteMapping("/deleteOrDetail/{id}")
	public String delete(@PathVariable("id") int id){
		return service.deleteOrDetail(id);
	}
}
