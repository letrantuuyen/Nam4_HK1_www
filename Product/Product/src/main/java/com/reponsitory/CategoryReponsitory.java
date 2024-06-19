package com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.Category;
@Repository
public interface CategoryReponsitory extends JpaRepository<Category, Integer> {
	
	Category getCategoryByTitle(String title);
}
