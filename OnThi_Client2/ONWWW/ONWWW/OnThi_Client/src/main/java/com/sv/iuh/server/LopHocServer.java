package com.sv.iuh.server;

import java.util.List;

import com.sv.iuh.entity.LopHoc;

public interface LopHocServer {
	public List<LopHoc> getALl();
	public LopHoc getById(int maLopHoc);
	public void save(LopHoc lopHoc);
	public void delete(int maLopHoc);
}
