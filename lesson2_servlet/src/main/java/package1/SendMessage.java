package package1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/message.html")
public class SendMessage extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// chuyen trang
		
		
		///servlet -> JSP 
		String mess = "Xin chao";
		req.setAttribute("ten", mess);
		req.getRequestDispatcher("message.jsp").forward(req, resp);
	}
}
