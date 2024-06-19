package com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.OrderDetail;

public interface OrderDetailReponsitory extends JpaRepository<OrderDetail, Integer>{
	List<OrderDetail> getOrderDetailByStatus(String status);
}
