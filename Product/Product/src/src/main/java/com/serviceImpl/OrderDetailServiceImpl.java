package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.OrderDetail;
import com.reponsitory.OrderDetailReponsitory;
import com.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	private OrderDetailReponsitory orderDetailReponsitory;
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		// TODO Auto-generated method stub
		return orderDetailReponsitory.findAll();
	}

	@Override
	public OrderDetail getOrDetailById(int id) {
		// TODO Auto-generated method stub
		return orderDetailReponsitory.findById(id).orElse(null);
	}

	@Override
	public OrderDetail addOrDetail(OrderDetail orderDetail) {
		if(orderDetail != null) {
			return orderDetailReponsitory.save(orderDetail);
		}
		return null;
	}

	@Override
	public List<OrderDetail> saveAllOrDetail(List<OrderDetail> orderDetails) {
		
		return null;
	}

	@Override
	public OrderDetail updateOrDetail(int id, OrderDetail od) {
		OrderDetail od2 = orderDetailReponsitory.findById(id).orElse(null);
		if(od2!= null) {
			od2.setQuantity(od.getQuantity());
			od2.setStatus(od.getStatus());
			od2.setCreatedAt(od.getCreatedAt());
			od2.setOrder(od.getOrder());
			od2.setProduct(od.getProduct());
			return orderDetailReponsitory.save(od2);
			
		}
		return null;
	}

	@Override
	public String deleteOrDetail(int id) {
		orderDetailReponsitory.deleteById(id);
		return "success";
	}

	@Override
	public List<OrderDetail> getOrderDetailsByStatus(String status) {
		return orderDetailReponsitory.getOrderDetailByStatus(status);
	}

}
