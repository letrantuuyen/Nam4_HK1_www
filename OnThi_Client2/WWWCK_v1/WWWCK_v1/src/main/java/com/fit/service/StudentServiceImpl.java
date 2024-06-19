package com.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.dao.StudentDAO;
import com.fit.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public boolean insert(Student s) {
		return studentDAO.insert(s);
	}

	@Override
	public boolean update(Student s) {
		return studentDAO.update(s);
	}

	@Override
	public boolean delete(int id) {
		return studentDAO.delete(id);
	}

	@Override
	public List<Student> getAll() {
		return studentDAO.getAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

}
