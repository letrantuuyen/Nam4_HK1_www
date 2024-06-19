package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Util.ProductUtil;
import model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductUtil productUtil;
	@Resource(name = "jdbc/DBShop" )
	private DataSource dataSource;
	
	public void init() throws  ServletException{
		super.init();
		try {
			productUtil = new ProductUtil(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);		}
	}
	
   
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");		
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";}		
			// route to the appropriate method
			switch (theCommand) {		
			case "LIST":  
				listProduct(request, response);
				break;			
			case "ADD":    
				addProduct(request, response);
			default:
				listProduct(request, response);
			}				
		}
			catch (Exception exc) {
				throw new ServletException(exc);
			}
			
		}
	
	private void  listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Product> products = new ArrayList<>();
		// add students to the request
		request.setAttribute("Product_list", products);
							
					// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product.jsp");
		dispatcher.forward(request, response);
	}
	protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("productName");
		String des = request.getParameter("productDes");
		Long p = Long.parseLong(request.getParameter("productPrice"));
		Double price = Double.valueOf(p);
		Product productnew = new Product(name, des, price);
		productUtil.addProduct(productnew);
		listProduct(request, response);
	}

	protected void LoadProduct(HttpServletRequest request, HttpServletResponse respose) throws Exception {
		String theproductID = request.getParameter("productId");
		Product theproduct = productUtil.getProductID(theproductID);
		request.setAttribute("PRODUCT", theproduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddtoCart.jsp");
		dispatcher.forward(request, respose);

	}
	protected void buyProduct (HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
