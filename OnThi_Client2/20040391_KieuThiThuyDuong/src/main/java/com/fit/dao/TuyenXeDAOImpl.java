package com.fit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fit.entity.TuyenXe;

@Repository
public class TuyenXeDAOImpl implements TuyenXeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean insert(TuyenXe tx) {
		Session session = sessionFactory.getCurrentSession();
		session.save(tx);
		return true;
	}

	@Override
	@Transactional
	public boolean update(TuyenXe tx) {
		Session session = sessionFactory.getCurrentSession();
		session.update(tx);
		return true;
	}

	@Override
	@Transactional

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(new TuyenXe(id));
		;
		return true;
	}

	@Override
	@Transactional

	public List<TuyenXe> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<TuyenXe> tuyenXes = session.createQuery("from TuyenXe", TuyenXe.class).list();
		return tuyenXes;
	}

	@Override
	@Transactional

	public TuyenXe getTuyenXeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		TuyenXe tuyenXe = session.createQuery("from TuyenXe where id = " + id, TuyenXe.class).uniqueResult();
		return tuyenXe;
	}

}
