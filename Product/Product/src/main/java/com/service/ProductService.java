package com.service;

import java.util.List;

import com.model.Product;



public interface ProductService {
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public Product addProduct(Product product);
	public List<Product> saveAllProduct(List<Product> products);
	public Product updateProduct(int id,Product product);
	public String deleteProduct(int id);
	public List<Product> getProductsByName(String search);
	
}
