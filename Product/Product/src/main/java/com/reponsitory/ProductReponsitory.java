package com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Product;
@Repository
public interface ProductReponsitory extends JpaRepository<Product, Integer>{
	@Query(value="SELECT * FROM products p where p.title like %?1%",nativeQuery = true)
    List<Product> getProductsByName(String search) ;
}
