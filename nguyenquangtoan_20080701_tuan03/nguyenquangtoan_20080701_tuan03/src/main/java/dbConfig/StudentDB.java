package dbConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.Course;
import entity.Student;

public class StudentDB {
	private DataSource dataSource;

	public StudentDB(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Student> getAll() {
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
				String lname = rs.getString("lastName");
				String email = rs.getString("email");
				list.add(new Student(id, fname, lname, email));
			}
		} catch (Exception e) {

			// TODO: handle exception
		}

		return list;
	}

	public List<Student> getStudentByIDCorse(int idcorse) {
		List<Student> list = new ArrayList<>();
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select Student.ID,FirstName,lastname,email from Student inner JOIN Register on Student.ID= Register.ID_Student INNER join Course on Course.ID = Register.ID_Course WHERE Register.ID_Course = "
					+ idcorse;
			con = dataSource.getConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("lastName");
				String email = rs.getString("email");
				list.add(new Student(id, fname, lname, email));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}

	public boolean addStudent(String fname, String lname, String email) throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;

		String sql = "insert into student values('" + fname + "','" + lname + "','" + email + "')";
		System.out.println(sql);
		con = dataSource.getConnection();
		statement = con.createStatement();
		rs = statement.executeQuery(sql);

		if (rs.rowInserted()) {
			return true;
		}
		return false;
	}

	public boolean updatetudent(int id, String fname, String lname, String email) throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;

		String sql = "update student set FirstName = '" + fname + "' , LastName = '" + lname + "', Email = '" + email
				+ "' WHERE id = " + id;
		System.out.println(sql);
		con = dataSource.getConnection();
		statement = con.createStatement();
		rs = statement.executeQuery(sql);

		if (rs.rowUpdated()) {
			return true;
		}
		return false;
	}

	public Student getStudentByID(int id) throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		Student s = null;
		String sql = "select * from student where id = " + id;

		con = dataSource.getConnection();
		statement = con.createStatement();
		rs = statement.executeQuery(sql);
		System.out.println(sql);

		
		if (rs.next()) {
			int ids = rs.getInt("ID");
			String fname = rs.getString("FirstName");
			String lname = rs.getString("lastName");
			String email = rs.getString("email");
			s = new Student(ids, fname, lname, email);
		}

		return s;
	}
	public boolean registerCorse(int idstudent ,int idCorse) throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		
		String sql = "insert into register values ("+idCorse+","+idstudent+")";
		System.out.println(sql);
		con = dataSource.getConnection();
		statement = con.createStatement();
		rs = statement.executeQuery(sql);
		
		if (rs.rowInserted()) {
			return true;
		}
		return false;
		
	}
	
}
