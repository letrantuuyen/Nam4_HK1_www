package com.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String phone;
	private String address;
	private double total;
	private String status;
	@Column(name = "created_at")
	private Date createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
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
	public Order(String phone, String address, double total) {
		super();
	
		this.phone = phone;
		this.address = address;
		this.total = total;

	}
	
	public Order(String phone, String address, double total, String status, Date createdAt) {
		super();
		this.phone = phone;
		this.address = address;
		this.total = total;
		this.status = status;
		this.createdAt = createdAt;
	}
	public Order(int id, String phone, String address, double total, String status, Date createdAt) {
		super();
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.total = total;
		this.status = status;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", phone=" + phone + ", address=" + address + ", total=" + total + ", status="
				+ status + ", createdAt=" + createdAt + "]";
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
}