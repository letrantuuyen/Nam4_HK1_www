package com.sv.iuh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.iuh.entity.LopHoc;

@Repository
public class LopHocDaoImpl implements LopHocDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<LopHoc> getALl() {
		Session session= sessionFactory.getCurrentSession();
		Query<LopHoc> theQuery=session.createQuery("from LopHoc", LopHoc.class);
		List<LopHoc> list=theQuery.getResultList();
		
		return list;
	}

	@Override
	public LopHoc getById(int maLopHoc) {
		Session session= sessionFactory.getCurrentSession();
		Query<LopHoc> theQuery=session.createQuery("from LopHoc where maLopHoc = :maLopHoc", LopHoc.class);
		theQuery.setParameter("maLopHoc",maLopHoc);
		LopHoc lopHoc= theQuery.getSingleResult();
		return lopHoc;
	}

	@Override
	public void save(LopHoc lopHoc) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(lopHoc);
		
	}

	@Override
	public void delete(int maLopHoc) {
		Session session= sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("delete LopHoc where maLopHoc = :maLopHoc");
		theQuery.setParameter("maLopHoc",maLopHoc);
		theQuery.executeUpdate();
		
	}

}
