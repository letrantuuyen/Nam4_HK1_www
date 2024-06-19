package com.fit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.Check;

@Entity
@Table(name="tuyenxe")
@Check(constraints = "diemKhoihanh <> diemDen")
public class TuyenXe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="maTuyenXe")
	private int id;
	
	@NotEmpty(message = "khong duoc rong")
	@Column(name="tenTuyenXe")
	private String tenTuyenXe;
	
	@Positive (message = "khoang cach phai lon hon 0")
	@Column(name="khoangCach")
	private double khoangCach;
	
	@NotEmpty(message = "khong duoc rong")
	@Column(name="diemKhoiHanh")
	private String diemKhoiHanh;

	@NotEmpty(message = "khong duoc rong")
	@Column(name="diemDen")
	private String diemDen;

	public TuyenXe(int id, @NotEmpty(message = "khong duoc rong") String tenTuyenXe,
			@Positive(message = "khoang cach phai lon hon 0") double khoangCach,
			@NotEmpty(message = "khong duoc rong") String diemKhoiHanh,
			@NotEmpty(message = "khong duoc rong") String diemDen) {
		super();
		this.id = id;
		this.tenTuyenXe = tenTuyenXe;
		this.khoangCach = khoangCach;
		this.diemKhoiHanh = diemKhoiHanh;
		this.diemDen = diemDen;
	}

	public TuyenXe() {
		super();
	}

	public TuyenXe(int id) {
		super();
		this.id = id;
	}

	public TuyenXe(@NotEmpty(message = "khong duoc rong") String tenTuyenXe,
			@Positive(message = "khoang cach phai lon hon 0") double khoangCach,
			@NotEmpty(message = "khong duoc rong") String diemKhoiHanh,
			@NotEmpty(message = "khong duoc rong") String diemDen) {
		super();
		this.tenTuyenXe = tenTuyenXe;
		this.khoangCach = khoangCach;
		this.diemKhoiHanh = diemKhoiHanh;
		this.diemDen = diemDen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTuyenXe() {
		return tenTuyenXe;
	}

	public void setTenTuyenXe(String tenTuyenXe) {
		this.tenTuyenXe = tenTuyenXe;
	}

	public double getKhoangCach() {
		return khoangCach;
	}

	public void setKhoangCach(double khoangCach) {
		this.khoangCach = khoangCach;
	}

	public String getDiemKhoiHanh() {
		return diemKhoiHanh;
	}

	public void setDiemKhoiHanh(String diemKhoiHanh) {
		this.diemKhoiHanh = diemKhoiHanh;
	}

	public String getDiemDen() {
		return diemDen;
	}

	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}

	@Override
	public String toString() {
		return "TuyenXe [id=" + id + ", tenTuyenXe=" + tenTuyenXe + ", khoangCach=" + khoangCach + ", diemKhoiHanh="
				+ diemKhoiHanh + ", diemDen=" + diemDen + "]";
	}
	
	
}
