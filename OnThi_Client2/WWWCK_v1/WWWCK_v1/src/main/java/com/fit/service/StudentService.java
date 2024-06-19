package com.fit.service;

import java.util.List;

import com.fit.entity.Student;

public interface StudentService {
	public boolean insert(Student s);
	public boolean update (Student s);
	public boolean delete (int id);
	public List<Student> getAll();
	public Student getStudentById (int id);
}
