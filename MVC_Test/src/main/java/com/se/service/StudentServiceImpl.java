package com.se.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.StudentDao;
import com.se.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}
	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
		
	}
	@Override
	public void deleteStudent(int theId) {
		studentDao.deleteStudent(theId);
		
	}
	@Override
	public boolean updateStudent(Student studentUpdate) {
		// TODO Auto-generated method stub
		 return studentDao.updateStudent(studentUpdate);
		 
	}
	@Override
	public Student getStudentById(int theId) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(theId);
	}

}
