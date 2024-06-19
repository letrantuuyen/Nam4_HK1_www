package com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Order;
@Repository
public interface OrderReponsitory extends JpaRepository<Order, Integer>{

}
