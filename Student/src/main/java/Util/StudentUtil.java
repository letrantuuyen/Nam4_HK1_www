package Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import model.Student;

public class StudentUtil {
	

	
	public static List<Student> getStudents(){
		
		
		Student s1 = new Student("avd", "Tu Uyen", "sdfsdfs");
		List<Student> list = new ArrayList<Student>();
		
		list.add(s1);
		
		return list;
	}
	
}