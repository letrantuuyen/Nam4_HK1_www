package com.model;

import java.sql.Date;

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
public class CartDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private String status;
	@Column(name = "created_at")
	private Date createdAt;
	
	

	private int product_id, order_id;



	public CartDetail() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CartDetail(int quantity, String status, Date createdAt, int product_id, int order_id) {
		super();
		this.quantity = quantity;
		this.status = status;
		this.createdAt = createdAt;
		this.product_id = product_id;
		this.order_id = order_id;
	}



	@Override
	public String toString() {
		return "CartDetail [id=" + id + ", quantity=" + quantity + ", status=" + status + ", createdAt=" + createdAt
				+ ", product_id=" + product_id + ", order_id=" + order_id + "]";
	}
	
	
}
