package com.se.service;

import java.util.List;

import com.se.entity.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	public void addStudent(Student student);
	public void deleteStudent(int theId);
	public boolean updateStudent(Student studentUpdate);
	public Student getStudentById(int theId);



}
