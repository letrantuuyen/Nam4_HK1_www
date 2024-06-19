package com.fit.ServletMVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fit.entity.Product;
import com.fit.entity.ShoppingItem;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {
    "/products", "/viewProductDetails",
    "/addToCart", "/viewCart"})
public class ShoppingCartServlet extends HttpServlet {

    private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<>();
    private NumberFormat currencyFormat = NumberFormat
            .getCurrencyInstance(Locale.US);
    private String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=DBShop";
    private String username = "sa";
    private String password = "ducvu0969";
    private Connection connection = null;
	private Statement statement;

    @Override
    public void init() throws ServletException {
        
    }
    
    private void connect () throws SQLException, ClassNotFoundException {
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	connection = DriverManager.getConnection(jdbcUrl, username, password);
    	statement = connection.createStatement();
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        String uri = request.getRequestURI();
        if (uri.endsWith("/products")) {
            try {
				sendProductList(response);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (uri.endsWith("/viewProductDetails")) {
            try {
				sendProductDetails(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (uri.endsWith("viewCart")) {
            showCart(request, response);// 
        }
    }
    
    private void sendProductList(HttpServletResponse response)
            throws IOException, SQLException, ClassNotFoundException {
    	connect();
    	String sqlQuery = "SELECT * FROM Product";
    	response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			writer.println("<!DOCTYPE html>"
	                + "<html><head><title>Products</title>"
	                + "</head><body><h2>Products</h2>");
	        writer.println("<ul>");
	        while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                writer.println("<li>" + name + "("
	                    + currencyFormat.format(price)
	                    + ") (" + "<a href='viewProductDetails?id="
	                    + id + "'>Details</a>)");
            }
	        writer.println("</ul>");
	        writer.println("<a href='viewCart'>View Cart</a>");
	        writer.println("</body></html>");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        // add to cart
        int productId = 0;
        int quantity = 0;
        try {
			connect();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
            productId = Integer.parseInt(
                    request.getParameter("id"));
            quantity = Integer.parseInt(request
                    .getParameter("quantity"));
        } catch (NumberFormatException e) {
        }
        Product product = null;
        try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Product where id = " + productId);
			while (resultSet.next()) {
				 int id = resultSet.getInt("id");
	             String name = resultSet.getString("name");
	             String description = resultSet.getString("description");
	             BigDecimal price = resultSet.getBigDecimal("price");
	             product = new Product(id, name, description, price);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (product != null && quantity >= 0) {
            ShoppingItem shoppingItem = new ShoppingItem(product,
                    quantity);
            HttpSession session = request.getSession();
            List<ShoppingItem> cart = (List<ShoppingItem>) session
                    .getAttribute(CART_ATTRIBUTE);
            if (cart == null) {
                cart = new ArrayList<ShoppingItem>();
                session.setAttribute(CART_ATTRIBUTE, cart);
            }
            cart.add(shoppingItem);
        }
        try {
			sendProductList(response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private Product getProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    private void sendProductDetails(HttpServletRequest request,
            HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int productId = 0;
        try {
            productId = Integer.parseInt(
                    request.getParameter("id"));
        } catch (NumberFormatException e) {
        }
       connect();
       String sqlQuery = "SELECT * FROM Product where id = " + productId;
       ResultSet rs = statement.executeQuery(sqlQuery);
       Product product = null;
       while (rs.next()) {
    	   product = new Product(rs.getInt("id"),rs.getString("name"), rs.getString("description"),rs.getBigDecimal("price"));
       }
       if (product != null) {
            writer.println("<html><head>"
                    + "<title>Product Details</title></head>"
                    + "<body><h2>Product Details</h2>"
                    + "<form method='post' action='addToCart'>");
            writer.println("<input type='hidden' name='id' "
                    + "value='" + productId + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td>"
                    + product.getName() + "</td></tr>");
            writer.println("<tr><td>Description:</td><td>"
                    + product.getDescription() + "</td></tr>");
            writer.println("<tr>" + "<tr>"
                    + "<td><input name='quantity'/></td>"
                    + "<td><input type='submit' value='Buy'/>"
                    + "</td>"
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='products'>Product List</a>"
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body>");
        } else {
            writer.println("No product found");
        }
    }

    private void showCart(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>"
                + "<html><head><title>Shopping Cart</title>"
                + "<style>table, td {border:1px solid green;}</style>"
                + "</head>");
        writer.println("<body><a href='products'>" + "Product List</a>");
        HttpSession session = request.getSession();
        List<ShoppingItem> cart = (List<ShoppingItem>) session
                .getAttribute(CART_ATTRIBUTE);
        System.out.println(session.getAttribute(CART_ATTRIBUTE)); 
        if (cart != null) {
            writer.println("<table>");
            writer.println("<tr><td style='width:150px'>Quantity"
                    + "</td>"
                    + "<td style='width:150px'>Product</td>"
                    + "<td style='width:150px'>Price</td>"
                    + "<td>Amount</td></tr>");
            BigDecimal total = BigDecimal.ZERO;
            for (ShoppingItem shoppingItem : cart) {
                Product product = shoppingItem.getProduct();
                int quantity = shoppingItem.getQuantity();
                if (quantity != 0) {
                    BigDecimal price = product.getPrice();
                    writer.println("<tr>");
                    writer.println("<td>" + quantity + "</td>");
                    writer.println("<td>" + product.getName()
                            + "</td>");
                    writer.println("<td>"
                            + currencyFormat.format(price)
                            + "</td>");
                    BigDecimal subtotal = price.multiply(
                            BigDecimal.valueOf(quantity));

                    writer.println("<td>"
                            + currencyFormat.format(subtotal)
                            + "</td>");
                    total = total.add(subtotal);
                    writer.println("</tr>");
                }
            }
            writer.println("<tr><td colspan='4' "
                    + "style='text-align:right'>"
                    + "Total:"
                    + currencyFormat.format(total)
                    + "</td></tr>");
            writer.println("</table>");
        }
        writer.println("</table></body></html>");
    }
}
