package com.service;

import java.util.List;

import com.model.Order;



public interface OrderService {
	public List<Order> getAllOrders();
	public Order getOrderById(int id);
	public Order addOrder(Order order);
	public List<Order> saveAllOrders(List<Order> orders);
	public Order updateOrder(int id,Order order);
	public String deleteOrder(int id);
}
