package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Course;

public class CourseUtil {
	
	private DataSource dataSource;

	public CourseUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public void close(Connection myConn, Statement stmt, ResultSet myRs) {
		try {
		if(myConn !=null)
			myConn.close();
		if(stmt != null)
			stmt.close();
		if(myRs != null)
			myRs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Course> getAllCourse() throws SQLException{
		List<Course> courses = new ArrayList<Course>();
		Connection myConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			myConnection = dataSource.getConnection();
			String sql = "select *from Course";
			statement = myConnection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				int id = resultSet.getInt("ID");
				String name = resultSet.getString("CourseName");
				String status = resultSet.getString("StatusCourse");
				
				Course course = new Course(id, name, status);
				courses.add(course);
			}
			return courses;
		}finally {
			close(myConnection, statement, resultSet);
		}
		
	}

}
