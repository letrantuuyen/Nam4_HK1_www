package com.fit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	// Vũ Tiến Đức
	@NotEmpty(message = "khong duoc rong")
	@Pattern(regexp = "^[A-Z][a-zà-ỹ]+( [A-Z][a-zà-ỹ]+)+$", message = "phai viet hoa chu cai dau, khong dung so")
	private String name;
	@NotEmpty(message = "khong duoc rong")
	private String address;
	@NotEmpty(message = "khong duoc rong")
	@Pattern(regexp = "^0[0-9]{9}", message = "sdt chi dung so")
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Student(int id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public Student(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public Student(int id) {
		super();
		this.id = id;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
