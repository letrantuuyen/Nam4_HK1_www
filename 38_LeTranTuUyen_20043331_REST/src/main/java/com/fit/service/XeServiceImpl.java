package com.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.dao.XeDao;
import com.fit.entity.Xe;


@Service
public class XeServiceImpl implements XeService {
	
	@Autowired
	private XeDao xeDao;
	

	@Override
	public List<Xe> getAllXe() {
		// TODO Auto-generated method stub
		return xeDao.getAllXe();
	}

	@Override
	public void addXe(Xe xe) {
		xeDao.addXe(xe);
		
	}

	@Override
	public void delete(int idDelete) {
		// TODO Auto-generated method stub
		xeDao.delete(idDelete);
		
	}

	@Override
	public Xe update(int idUpdate, Xe xe) {
		// TODO Auto-generated method stub
		return xeDao.update(idUpdate, xe);
	}
	
	

}
