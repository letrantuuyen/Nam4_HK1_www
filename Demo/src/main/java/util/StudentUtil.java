package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Course;
import model.Student;

public class StudentUtil {
	
	private DataSource dataSource;

	public StudentUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	//viết hàm close 
	private void close(Connection myConnect, Statement stmt, ResultSet myRs) {
		try {
			if(myConnect != null)
			myConnect.close();
		if(stmt != null)
			stmt.close();
		if(myRs != null)
			myRs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// hàm lấy danh sách sinh viên từ sql
	public List<Student> getListStudent() throws SQLException{
		List<Student> students = new ArrayList<Student>();
		Connection myConnect = null;
		Statement stmt = null;
		ResultSet Rs = null;
		try {
			myConnect = dataSource.getConnection();
			String sql = "Select *from Student";
			stmt = myConnect.createStatement();
			Rs = stmt.executeQuery(sql);
			
			while(Rs.next()) {
				int id = Rs.getInt("ID");
				String firstName = Rs.getString("FirstName");
				String lastName = Rs.getString("LastName");
				String email =Rs.getString("Email");
				Student s = new Student(id, firstName, lastName, email);
				
				students.add(s);
			}
			return students;
		}finally {
			close(myConnect, stmt, Rs);
		}
		
		
	}
	// thêm sinh viên 
	public void addStudent(Student stu) throws SQLException {
		Connection myConnect = null;
		PreparedStatement myPreSta = null;
		try {
			myConnect = dataSource.getConnection();
			String sql = "insert into Student(FirstName, LastName, Email) values (?,?,?)";
			myPreSta = myConnect.prepareStatement(sql);
			myPreSta.setString(1, stu.getFirstName());
			myPreSta.setString(2, stu.getLastName());
			myPreSta.setString(3, stu.getEmail());
			myPreSta.execute();
			
		}finally {
			close(myConnect, myPreSta, null);
		}
	}
	
	//lấy danh sách course từ sql 
	public List<Course> getListCourse() throws SQLException{
		List<Course> courses = new ArrayList<Course>();
		Connection myConnect = null;
		Statement stmt = null;
		ResultSet Rs = null;
		try {
			myConnect = dataSource.getConnection();
			String sql = "Select *from Course";
			stmt = myConnect.createStatement();
			Rs = stmt.executeQuery(sql);
			
			while(Rs.next()) {
				int id = Rs.getInt("ID");
				String courseName = Rs.getString("CourseName");
				String statusName = Rs.getString("StatusName");
				String email =Rs.getString("Email");
				
				Course course = new Course(id, courseName, statusName);
			}
			return courses;
		}finally {
			close(myConnect, stmt, Rs);
		}
		
		
	}
	
	

}
