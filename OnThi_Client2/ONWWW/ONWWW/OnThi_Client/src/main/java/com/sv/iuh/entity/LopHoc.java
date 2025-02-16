package com.sv.iuh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LopHoc {
	private int maLopHoc;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String tenLopHoc;
	private String tenNha;
	private String buoiHoc;
	public int getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(int maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public String getTenLopHoc() {
		return tenLopHoc;
	}
	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}
	public String getTenNha() {
		return tenNha;
	}
	public void setTenNha(String tenNha) {
		this.tenNha = tenNha;
	}
	public String getBuoiHoc() {
		return buoiHoc;
	}
	public void setBuoiHoc(String buoiHoc) {
		this.buoiHoc = buoiHoc;
	}
	public LopHoc(int maLopHoc, String tenLopHoc, String tenNha, String buoiHoc) {
		super();
		this.maLopHoc = maLopHoc;
		this.tenLopHoc = tenLopHoc;
		this.tenNha = tenNha;
		this.buoiHoc = buoiHoc;
	}
	public LopHoc() {
		super();
	}
	
	

}
