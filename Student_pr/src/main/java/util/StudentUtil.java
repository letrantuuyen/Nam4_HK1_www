package util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import model.Student;

public class StudentUtil {

	public static List<Student> getStudent() {
		ArrayList<Student> students = new ArrayList<>();
		
		Student s = new Student(1, "Le", "Uyen", "tuuyen@gmail.com");
		Student s1 = new Student(2, "Nguyen", "Mai", "xuanmai@gmail.com");
		Student s2= new Student(3, "Tran", "Long", "baolong@gmail.com");
		Student s3 = new Student(4, "Le", "Tranh", "ngantranh@gmail.com");
		Student s4 = new Student(5, "Le", "O", "lio@gmail.com");
		
		students.add(s);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		return students;
	}
	
	

}
