package dbConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.Student;

public class Dbconfig {
	private DataSource dataSource;

	public Dbconfig(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	public List<Student> getAll(){
		List<Student> list = new ArrayList<>();
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student";
			con = dataSource.getConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String email = rs.getString("Email");
				list.add(new Student(id,fname, lname, email));		
			}
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		return list;
	}
	public boolean insertStudent(Student student) {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sql = "insert into Student values ("+student.getId()+","+student.getFirstName()+","+student.getLastName()+","+student.getEmail()+")";
			con = dataSource.getConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println(sql);
			if (rs.rowInserted()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	
	}
}
