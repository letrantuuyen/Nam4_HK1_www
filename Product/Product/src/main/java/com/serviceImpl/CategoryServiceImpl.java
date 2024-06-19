package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.model.Product;
import com.reponsitory.CategoryReponsitory;
import com.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryReponsitory categoryReponsitory;
	@Override
	public Category getCategoryByTitle(String title) {
		// TODO Auto-generated method stub
		return categoryReponsitory.getCategoryByTitle(title);
	}
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryReponsitory.findAll();
	}
	@Override
	public Category getCategorytById(int id) {
		// TODO Auto-generated method stub
		return categoryReponsitory.findById(id).orElse(null);
	}
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryReponsitory.save(null);
	}
	@Override
	public Category updateCategory(int id, Category category) {
		Category category2 = categoryReponsitory.findById(id).orElse(null);
		if(category2!= null) {
			category2.setTitle(category.getTitle());
			category2.setStatus(category.getStatus());
			category2.setCreatedAt(category.getCreatedAt());
			category2.setProducts(category.getProducts());
			return categoryReponsitory.save(category2);
		}
		return null;
	}
	@Override
	public String deleteProduct(int id) {
		categoryReponsitory.deleteById(id);
		return "success";
	}

}
