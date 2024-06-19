package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Course;
import model.Student;
import util.CourseUtil;
import util.StudentUtil;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/WebStudentTrackerUpgrade")
	private DataSource dataSource;
	private StudentUtil studentUtil;
	private CourseUtil courseUtil;
       
	
	// khởi tạo 
	public void init() throws ServletException {
		super.init();
		try {
			courseUtil = new CourseUtil(dataSource);
			studentUtil = new StudentUtil(dataSource);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void getAllList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    	request.setAttribute("StudentList", studentUtil.getListStudent());
    	request.setAttribute("CourseList", courseUtil.getAllCourse());
    	request.getRequestDispatcher("viewAllList.jsp").forward(request, response);
    	
    }

	public void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Student> students =studentUtil.getListStudent();
		// thêm student vào request
		request.setAttribute("StudentList", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewListStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	public void getAllCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Course> courses = courseUtil.getAllCourse();
		// thêm student vào request
		request.setAttribute("CourseList", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewListCourse.jsp");
		dispatcher.forward(request, response);
	}
	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// đọc thông tin của sinh viên từ dữ liệu thêm vào
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student student = new Student(firstName, lastName, email);
		
		studentUtil.addStudent(student);
		// gửi thông tin lại danh sách 
		getAllStudent(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			//If the command is missing, then default to listing students
			if (theCommand == null)
				theCommand = "GetAll";
			switch (theCommand) {
			case "ListStudent" :
				getAllStudent(request, response);
				break;
			case "AddStudent" :
				addStudent(request, response);
				break;
			case "ListCourse":
				getAllCourse(request, response);
				break;
			case "GetAll":
				getAllList(request, response);
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
                     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
