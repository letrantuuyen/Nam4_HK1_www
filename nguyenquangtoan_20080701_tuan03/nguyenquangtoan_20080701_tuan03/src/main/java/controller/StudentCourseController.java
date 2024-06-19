package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dbConfig.CourseDB;
import dbConfig.StudentDB;
import entity.Student;

/**
 * Servlet implementation class StudentCourseController
 */
@WebServlet("/StudentCourseController")
public class StudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "WebStudentTrackerUpgrade")
	private DataSource data;
	private CourseDB courseDB;
	private StudentDB studentdb;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			studentdb = new StudentDB(data);
			courseDB = new CourseDB(data);
		} catch (Exception e) {
		}
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		if (method == null) {
			method = "LIST";
		}
		switch (method) {
		case "LIST":
			getAll(req, resp);
			break;
		case "VIEWCOURSE":
			getDSTheoKhoaHoc(req, resp);
			break;
		case "GOUPDATE":
			FormUpdate(req, resp);
			break;
		case "UPDATE":
			updateCourse(req, resp);
			break;
		case "ADDCOURSE":
			addCourse(req, resp);
			break;
		case "ADDSTUDENT":
			addStudent(req, resp);
			break;
		case "GETCOURSE":
			getCourse(req, resp);
			break;
		case "ADDSTUDENTCORSE":
			showFormUpdate(req, resp);
			break;
			
		case "REGISTER":
			reGister(req, resp);
			break;
		case "VIEWCOURE":
			getAllcourse(req, resp);
			break;
		case "VIEWCOUREWITHID":
			getDSTheoidKhoaHoc(req, resp);
			break;
		default:
			getAll(req, resp);
			break;

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	public void getAllcourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("LIST_COURSE", courseDB.getAll());
		System.out.println( courseDB.getAll());
		req.getRequestDispatcher("/listcourse_selected.jsp").forward(req, resp);
	}
	
	
	public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("LIST_STUDENT", studentdb.getAll());
		req.setAttribute("LIST_COURSER", courseDB.getAll());
		req.getRequestDispatcher("/list_main.jsp").forward(req, resp);
	}
	public void getDSTheoKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list  = studentdb.getStudentByIDCorse(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("LISTSVBYKH", list);
		req.getRequestDispatcher("/list_course.jsp").forward(req, resp);
	}
	public void getDSTheoidKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list  = studentdb.getStudentByIDCorse(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("LIST_COURSE", courseDB.getAll());
		req.setAttribute("LISTSVBYKH", list);
		req.getRequestDispatcher("/listcourse_selected.jsp").forward(req, resp);
	}
	public void FormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("course", courseDB.getById(Integer.parseInt(req.getParameter("id"))));
			System.out.println(courseDB.getById(Integer.parseInt(req.getParameter("id"))));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/update_course.jsp").forward(req, resp);
	}
	public void updateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String status = req.getParameter("STATUS");
		try {
			courseDB.updateCourse(id, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		req.setAttribute("LIST_STUDENT", studentdb.getAll());
		req.setAttribute("LIST_COURSER", courseDB.getAll());
		req.getRequestDispatcher("/list_main.jsp").forward(req, resp);
//		updateCourse
	}
	public void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("NAME");
		String status = req.getParameter("STATUS");
		try {
			courseDB.addCourse(name, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		req.setAttribute("LIST_STUDENT", studentdb.getAll());
		req.setAttribute("LIST_COURSER", courseDB.getAll());
		req.getRequestDispatcher("/list_main.jsp").forward(req, resp);
//		updateCourse
	}
	public void getCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		
		try {
			req.setAttribute("LIST", courseDB.getByIdStudent(Integer.parseInt(req.getParameter("id"))));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		req.getRequestDispatcher("/list_student.jsp").forward(req, resp);
	}
	
	public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		String fname = req.getParameter("FNAME");
		String lname = req.getParameter("LNAME");
		String email = req.getParameter("EMAIL");
		try {
			studentdb.addStudent(fname, lname, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		req.setAttribute("LIST_STUDENT", studentdb.getAll());
		req.setAttribute("LIST_COURSER", courseDB.getAll());
		req.getRequestDispatcher("/list_main.jsp").forward(req, resp);
	}
	public void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		int id = Integer.parseInt(req.getParameter("id"));
		Student student = null;
		try {
			student = studentdb.getStudentByID(id);
			System.out.println(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(courseDB.getAllOn(id));
		req.setAttribute("LIST_COURSER_ON", courseDB.getAllOn(id));
		req.setAttribute("student", student);
		req.getRequestDispatcher("/formRegister.jsp").forward(req, resp);
	}
	public void reGister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//////ID=1&CORSENAME=2
		int idSt = Integer.parseInt(req.getParameter("ID"));
		int idCOR = Integer.parseInt(req.getParameter("CORSENAME"));
		try {
			studentdb.registerCorse(idSt, idCOR);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		req.setAttribute("LIST_STUDENT", studentdb.getAll());
		req.setAttribute("LIST_COURSER", courseDB.getAll());
		req.getRequestDispatcher("/list_main.jsp").forward(req, resp);
	}
}
