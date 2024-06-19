package com.fit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fit.entity.Student;

@Repository
public class StudentDAOimlp implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean insert(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
		return true;
	}

	@Override
	@Transactional
	public boolean update(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.update(s);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(new Student(id));
		return true;
	}

	@Override
	@Transactional
	public List<Student> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Student> students = session.createQuery("from Student", Student.class).list();
		return students;
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.createQuery("from Student where id = " + id, Student.class).uniqueResult();
		return student;
	}

}
