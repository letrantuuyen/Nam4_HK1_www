package TranHoangLong_20065391;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 * Servlet implementation class studentConstroller
 */
@WebServlet("/ProductControllerServlet")
public class ProductControllerServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

		private ProductDbUtil productDbUtil;
		
		@Resource(name="jdbc/DBShop")
		private DataSource dataSource;
		
		@Override
		public void init() throws ServletException {
			super.init();
			
			// create our student db util ... and pass in the conn pool / datasource
			try {
				productDbUtil = new ProductDbUtil(dataSource);
			}
			catch (Exception exc) {
				throw new ServletException(exc);
			}
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");		
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";}		
			// route to the appropriate method
			switch (theCommand) {		
			case "LIST":    listProduct(request, response);
				break;			
			case "ADD":     addProduct(request, response);
				break;			
			case "LOAD":    loadStudent(request, response);
				break;			
			case "UPDATE":	updateProduct(request, response);
				break;		
			case "DELETE":	deleteProduct(request, response);
				break;			
			default:
				listProduct(request, response);
			}				
		}
			catch (Exception exc) {
				throw new ServletException(exc);
			}
			
		}

		private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//			// read student id from form data
//			String theProductID = request.getParameter("productId");		
//			// delete student from database
//			productDbUtil.deleteProduct(theProductID);	
//			// send them back to "list students" page
//			listStudents(request, response);
		}

		private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//			// read student info from form data
//			int id = Integer.parseInt(request.getParameter("Id"));
//			String name = request.getParameter("Name");
//			String description = request.getParameter("Desciption");
//			double price = Double.parseDouble(request.getParameter("Price"));	
//			// create a new student object
//			Product theProduct = new Product(id, name,description,price);		
//			// perform update on database
//			productDbUtil.updateProduct(theProduct);		
//			// send them back to the "list students" page
//			listStudents(request, response);		
		}

		private void loadStudent(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
//			// read student id from form data
//			String theStudentId = request.getParameter("studentId");
//			// get student from database (db util)
//			Student theStudent = studentDbUtil.getStudent(theStudentId);
//			// place student in the request attribute
//			request.setAttribute("THE_STUDENT", theStudent);
//			// send to jsp page: update-student-form.jsp
//			RequestDispatcher dispatcher = 
//					request.getRequestDispatcher("/update-student-form.jsp");
//			dispatcher.forward(request, response);		
		}

		private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
//			// read student info from form data
//			String name = request.getParameter("firstName");
//			String description = request.getParameter("lastName");
//			Double price = Double.parseDouble(request.getParameter("Price"));				
//			// create a new student object
//			Product theproduct = new Product(name,description,price);		
//			// add the student to the database
//			ProductDbUtil.addProduct(theproduct);				
//			// send back to main page (the student list)
//			listStudents(request, response);
		}

		private void listProduct(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			
			// get students from db util
			List<Product> products = productDbUtil.getProduct();
			
			// add students to the request
			request.setAttribute("PRODUCT_LIST", products);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
			dispatcher.forward(request, response);
		}

}
