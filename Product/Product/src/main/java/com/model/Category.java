package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "categories") 
public class Category {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "status")
	private String status;

	@Column(name = "created_at")
	private String createdAt;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "category")
	private List<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(int id, String title, String status, String createdAt, List<Product> products) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.createdAt = createdAt;
		this.products = products;
	}

	public Category(String title, String status, String createdAt, List<Product> products) {
		super();
		this.title = title;
		this.status = status;
		this.createdAt = createdAt;
		this.products = products;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
}
