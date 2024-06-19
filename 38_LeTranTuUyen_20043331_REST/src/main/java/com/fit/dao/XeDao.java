package com.fit.dao;

import java.util.List;

import com.fit.entity.Xe;

public interface XeDao {
	public List<Xe> getAllXe();
	public void addXe(Xe xe);
	public void delete(int idDelete);
	public Xe update(int idUpdate, Xe xe);
	
	

}
