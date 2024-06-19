package com.service;

import java.util.List;

import com.model.OrderDetail;

public interface OrderDetailService {
	public List<OrderDetail> getAllOrderDetail();
	public OrderDetail getOrDetailById(int id);
	public OrderDetail addOrDetail(OrderDetail orderDetail);
	public List<OrderDetail> saveAllOrDetail(List<OrderDetail> orderDetails);
	public OrderDetail updateOrDetail(int id,OrderDetail orderDetail);
	public String deleteOrDetail(int id);
	public List<OrderDetail> getOrderDetailsByStatus(String status);
}
