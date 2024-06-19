package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Order;
import com.reponsitory.OrderReponsitory;
import com.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderReponsitory orderReponsitory;
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderReponsitory.findAll();
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderReponsitory.findById(id).orElse(null);
	}

	@Override
	public Order addOrder(Order order) {
		if(order != null) {
			orderReponsitory.save(order);
		}
		return null;
	}

	@Override
	public List<Order> saveAllOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(int id, Order order) {
		Order od = orderReponsitory.findById(id).orElse(null);
		if(od != null) {
			od.setPhone(order.getPhone());
			od.setAddress(order.getAddress());
			od.setTotal(order.getTotal());
			od.setStatus(order.getStatus());
			od.setCreatedAt(order.getCreatedAt());
			return orderReponsitory.save(od);
		}
		return null;
	}

	@Override
	public String deleteOrder(int id) {
		orderReponsitory.deleteById(id);
		return "success";
	}
	
}
