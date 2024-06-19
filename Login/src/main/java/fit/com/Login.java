package fit.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		//1. setContentType
			response.setContentType("text/html");
		//2. get data form
			String us = request.getParameter("username");
			String pass = request.getParameter("password");
			
		//kiem tra dung sai
			// dung thi chuyen trang welcom
			//sai thi dang nhap lai
			if(valite(us,pass))
			{
				RequestDispatcher rs = request.getRequestDispatcher("/Welcom");
				rs.forward(request, response);
			}else {
				RequestDispatcher rs = request.getRequestDispatcher("/index");
				rs.forward(request, response);
			}
	}

	
	private boolean valite(String user, String pass) {
		
		if(user.equals("abc") && pass.equals("12345"))
		return true;
		return false;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
