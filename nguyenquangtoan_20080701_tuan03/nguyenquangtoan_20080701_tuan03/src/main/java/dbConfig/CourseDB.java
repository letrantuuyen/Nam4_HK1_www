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

public class CourseDB {
	public DataSource dataSource;

	public CourseDB(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Course> getAll() {
		List<Course> list = new ArrayList<Course>();
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Course";
			con = dataSource.getConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
//			System.out.println(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String fname = rs.getString("CourseName");
				String lname = rs.getString("StatusCourse");
				list.add(new Course(id, fname, lname));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public Course getById(int idcourse) throws SQLException {
//		Course list = new ArrayList<Course>();
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;

		String sql = "select * from Course where id= " + idcourse;
		System.out.println(sql);
		con = dataSource.getConnection();
		rs = con.createStatement().executeQuery(sql);
		if (rs.next()) {
			int id = rs.getInt("ID");
			String fname = rs.getString("CourseName");
			String lname = rs.getString("StatusCourse");
			return new Course(id, fname, lname);
		}
		return null;
	}

	public boolean updateCourse(int id, String status) throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;

		String sql = "update course set statuscourse = '" + status + "' where id = " + id;

		con = dataSource.getConnection();
		statement = con.createStatement();
		rs = statement.executeQuery(sql);

		if (rs.rowUpdated()) {
			return true;
		}
		return false;
	}

	public boolean addCourse(String name, String status) throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;

		String sql = "insert into course values('" + name + "','" + status + "')";
		System.out.println(sql);
		con = dataSource.getConnection();
		statement = con.createStatement();
		rs = statement.executeQuery(sql);

		if (rs.rowInserted()) {
			return true;
		}
		return false;
	}

	// select Coursename from Course INNER join Register on Course.ID =
	// Register.ID_Course INNER JOIN Student on Register.ID_Student = Student.ID
	// where Student.ID = 2
	public List<Course> getByIdStudent(int idstudent) throws SQLException {
		ArrayList<Course> list = new ArrayList<Course>();
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			String sql = "select Course.id,Coursename,StatusCourse from Course INNER join Register on  Course.ID = Register.ID_Course INNER JOIN Student on Register.ID_Student = Student.ID where Student.ID = "
					+ idstudent;
			System.out.println(sql);
			con = dataSource.getConnection();
			rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String fname = rs.getString("CourseName");
				String lname = rs.getString("StatusCourse");
//					return list;	
				list.add(new Course(fname, lname));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}
	
	public List<Course> getAllOn(int idStudent) {
		List<Course> list = new ArrayList<Course>();
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * from Course WHERE ID NOT IN (select Course.ID from Course INNER JOIn Register on Course.id = Register.ID_Course INNER JOIN Student on Register.ID_Student = Student.ID where Student.ID = "+idStudent+" ) AND StatusCourse = 'ON'\n"
					+ "";
			con = dataSource.getConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
//			System.out.println(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String fname = rs.getString("CourseName");
				String lname = rs.getString("StatusCourse");
				list.add(new Course(id, fname, lname));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
}
