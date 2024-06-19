package com.fit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TuyenXe")
public class Xe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="MaXe")
	private int maXe;
	@NotNull(message = "Khong duoc rong")
	@Column(name ="DiemKhoiHanh")
	private String diemKhoiHanh;
	@NotNull(message= "Khong duoc rong")
	@Column(name ="TenXe")
	private String tenXe;
	@NotNull(message = "Khong duoc rong")
	@Column(name ="DiemDen")
	private String diemDen;
	@Size(min = 0)
	private double khoangCach;
	
	public Xe() {
		// TODO Auto-generated constructor stub
	}

	public Xe(String diemKhoiHanh, String tenXe, String diemDen, double khoangCach) {
		super();
		this.diemKhoiHanh = diemKhoiHanh;
		this.tenXe = tenXe;
		this.diemDen = diemDen;
		this.khoangCach = khoangCach;
	}

	public Xe(int maXe, String diemKhoiHanh, String tenXe, String diemDen, double khoangCach) {
		super();
		this.maXe = maXe;
		this.diemKhoiHanh = diemKhoiHanh;
		this.tenXe = tenXe;
		this.diemDen = diemDen;
		this.khoangCach = khoangCach;
	}

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public String getDiemKhoiHanh() {
		return diemKhoiHanh;
	}

	public void setDiemKhoiHanh(String diemKhoiHanh) {
		this.diemKhoiHanh = diemKhoiHanh;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getDiemDen() {
		return diemDen;
	}

	public void setDiemDen(String diemDen) {
		if(diemDen.isEmpty() && diemDen.equals(diemKhoiHanh)) {
			System.out.println("aaaa");
		}else {
		this.diemDen = diemDen;
			}
	}
		

	public double getKhoangCach() {
		return khoangCach;
	}

	public void setKhoangCach(double khoangCach) {
		this.khoangCach = khoangCach;
	}

	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", diemKhoiHanh=" + diemKhoiHanh + ", tenXe=" + tenXe + ", diemDen=" + diemDen
				+ ", khoangCach=" + khoangCach + "]";
	}
	
	
}
