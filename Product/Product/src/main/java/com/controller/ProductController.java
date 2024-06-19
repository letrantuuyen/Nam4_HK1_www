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

import com.model.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	@GetMapping("/listProduct")
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}
	@GetMapping("/getProduct/{id}")
	public Product getProductById(@PathVariable("id") int id){
		return productService.getProductById(id);
	}
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable("id") int id,@RequestBody Product product) {
		return productService.updateProduct(id,product);
	}
	@DeleteMapping("/deleteProduct/{id}")
	public String delete(@PathVariable("id") int id){
		return productService.deleteProduct(id);
	}
}
