package com.se.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.se.entity.Student;

@Repository
public class StudentImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Student> theQuery = session.createQuery("from Student",Student.class);
		List<Student> students = theQuery.getResultList();
		return students;
	}
	@Override
	@Transactional
	public void addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}
	@Override
	@Transactional
	public void deleteStudent(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete Student where id =:studentId");
		theQuery.setParameter("studentId", theId);
		theQuery.executeUpdate();
		
	}
	@Override
	@Transactional
	public boolean updateStudent(Student studentUpdate) {
		Session session = sessionFactory.getCurrentSession();
		session.update(studentUpdate);
		return true;
	}

	@Override
	@Transactional
	public Student getStudentById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.createQuery("from Student where id =" + theId, Student.class).uniqueResult();
        return student;
    }

}
