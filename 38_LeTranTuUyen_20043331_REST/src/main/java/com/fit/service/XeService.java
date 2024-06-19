package com.fit.service;

import java.util.List;

import com.fit.entity.Xe;

public interface XeService {
	
	public List<Xe> getAllXe();
	public void addXe(Xe xe);
	public void delete(int idDelete);
	public Xe update(int idUpdate, Xe xe);

}
