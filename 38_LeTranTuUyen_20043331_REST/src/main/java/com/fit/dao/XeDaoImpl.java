package com.fit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fit.entity.Xe;


@Repository
public class XeDaoImpl implements XeDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Xe> getAllXe() {
		Session session = sessionFactory.getCurrentSession();
		Query<Xe> theQuery = session.createQuery("from Xe",Xe.class);
		List<Xe> students = theQuery.getResultList();
		return students;
	}

	@Override
	@Transactional
	public void addXe(Xe xe) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(xe);
		
	}

	@Override
	@Transactional
	public void delete(int idDelete) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete Xe where id =:maXe");
		theQuery.setParameter("studentId", idDelete);
		theQuery.executeUpdate();
		
		
	}

	@Override
	@Transactional
	public Xe update(int idUpdate, Xe xeUpdate) {
		Session currentSession = sessionFactory.getCurrentSession();

        // Lấy sinh viên từ cơ sở dữ liệu
        Xe existingXe = currentSession.get(Xe.class, idUpdate);
        // Cập nhật thông tin của sinh viên
        existingXe.setTenXe(xeUpdate.getTenXe());
        existingXe.setKhoangCach(xeUpdate.getKhoangCach());
        existingXe.setDiemKhoiHanh(xeUpdate.getDiemKhoiHanh());
        existingXe.setDiemDen(xeUpdate.getDiemDen());
        // Lưu lại vào cơ sở dữ liệu
        currentSession.saveOrUpdate(existingXe);

        return existingXe;
	}

}
