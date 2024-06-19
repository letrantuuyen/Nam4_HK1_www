package com.fit.service;

import java.util.List;

import com.fit.entity.TuyenXe;

public interface TuyenXeService {
	public boolean insert(TuyenXe tx);
	public boolean update(TuyenXe tx);
	public boolean delete (int id);
	public List<TuyenXe> getAll();
	public TuyenXe getTuyenXeById(int id);
}
