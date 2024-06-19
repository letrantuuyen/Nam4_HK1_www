package com.service;

import java.util.List;

import com.model.Category;
import com.model.Product;

public interface CategoryService {
	public Category getCategoryByTitle(String title);
	
	
	public List<Category> getAllCategories();
	public Category getCategorytById(int id);
	public Category addCategory(Category category);
//	public List<Category> saveAllProduct(List<Product> products);
	public Category updateCategory(int id,Category category);
	public String deleteProduct(int id);
}
