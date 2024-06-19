package com.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

public class SanPham {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maSanPham;
	@Column(name = "TENSANPHAM")
	@NonNull
	private String tenSanPham;
	@Column(name = "DONGIA")
	
	private double donGia;
	

}
