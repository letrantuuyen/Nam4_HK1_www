package com.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "orderDetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private String status;
	@Column(name = "created_at")
	private Date createdAt;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderDetail(int id, int quantity, String status, Date createdAt, Order order, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.status = status;
		this.createdAt = createdAt;
		this.order = order;
		this.product = product;
	}
	public OrderDetail(int quantity, String status, Date createdAt, Order order, Product product) {
		super();
		this.quantity = quantity;
		this.status = status;
		this.createdAt = createdAt;
		this.order = order;
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", quantity=" + quantity + ", status=" + status + ", createdAt=" + createdAt
				+ ", order=" + order + ", product=" + product + "]";
	}
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
}
