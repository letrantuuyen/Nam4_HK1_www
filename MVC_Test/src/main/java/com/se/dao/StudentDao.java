package com.se.dao;

import java.util.List;

import com.se.entity.Student;

public interface StudentDao {
	public List<Student> getAllStudent();
	public void addStudent(Student student);
	public void deleteStudent(int theId);
	public boolean updateStudent(Student studentUpdate);

	public Student getStudentById(int theId);

}
