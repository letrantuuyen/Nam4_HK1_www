package com.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.dao.TuyenXeDAO;
import com.fit.entity.TuyenXe;
@Service
public class TuyenXeServiceImpl implements TuyenXeService{
	@Autowired
	private TuyenXeDAO tuyenXeDAO;
	
	@Override
	public boolean insert(TuyenXe tx) {
		// TODO Auto-generated method stub
		return tuyenXeDAO.insert(tx);
	}

	@Override
	public boolean update(TuyenXe tx) {
		// TODO Auto-generated method stub
		return tuyenXeDAO.update(tx);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return tuyenXeDAO.delete(id);
	}

	@Override
	public List<TuyenXe> getAll() {
		// TODO Auto-generated method stub
		return tuyenXeDAO.getAll();
	}

	@Override
	public TuyenXe getTuyenXeById(int id) {
		// TODO Auto-generated method stub
		return tuyenXeDAO.getTuyenXeById(id);
	}

}
