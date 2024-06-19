package model;

public class Course {
	private int id;
	private String courseName;
	private String statusCourse;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String courseName, String statusCourse) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.statusCourse = statusCourse;
	}

	public Course(String courseName, String statusCourse) {
		super();
		this.courseName = courseName;
		this.statusCourse = statusCourse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStatusCourse() {
		return statusCourse;
	}

	public void setStatusCourse(String statusCourse) {
		this.statusCourse = statusCourse;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", statusCourse=" + statusCourse + "]";
	}
	
	

}
