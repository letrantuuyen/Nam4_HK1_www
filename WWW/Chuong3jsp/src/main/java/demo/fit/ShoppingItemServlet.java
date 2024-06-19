package demo.fit;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ShoppingItemServlet
 */
@WebServlet("/ShoppingItemServlet")
public class ShoppingItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String cart_atb = "cart";
	
	private List<ShoppingItem> cart = new ArrayList<ShoppingItem>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void showCart(HttpServletRequest request, HttpServletResponse reponse) {
		reponse.setContentType("text/html");
		HttpSession sesion = request.getSession();
		List<ShoppingItem> cart = new ArrayList<ShoppingItem>();
		sesion.getAttribute(cart_atb);
		
		
	}

}
