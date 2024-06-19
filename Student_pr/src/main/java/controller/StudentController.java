package controller;

import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentController {
		
	List<Student> listStu = new ArrayList<>();
	
	public void addStu(Student student) {
		listStu.add(student);
	}
	
	public boolean deleteStu(Student student) {
		listStu.remove(student);
		return true;
	}
	

}
