package Util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Product;

public class ProductUtil {
	
	private DataSource dataSource;
	
	public ProductUtil() {
		// TODO Auto-generated constructor stub
	}

	public ProductUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<Product> getListProduct() throws SQLException{
		
		List<Product> products = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
		
			String sql = "Select *from Product";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String discription = myRs.getString("discription");
				double price = myRs.getDouble("price");
				Product p = new Product(id, name, discription, price);
				products.add(p);
			}
			return products;
		}finally {
			close(myConn,myStmt,myRs);
		}
		
	}
	public void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close(); }			
			if (myStmt != null) {
				myStmt.close();	}			
			if (myConn != null) {
				myConn.close();   
				// doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public void addProduct(Product product) throws Exception {
		Connection myConn = null;
		PreparedStatement myStm = null;
		try {
			// 1. get Connection
			myConn = dataSource.getConnection();
			// 2. Create Statement
			String sql = "insert into Product " + "(Name,Description, Price) " + "values (?,?,?)";
			myStm = myConn.prepareStatement(sql);
			myStm.setString(1, product.getName());
			myStm.setString(2, product.getDescription());
			myStm.setDouble(3, product.getPrice());
			myStm.execute();

		} finally {
			// TODO: handle finally clause
			close(myConn, myStm, null);
		}

	}
	public  Product getProductID(String proID) throws Exception {
		Connection myCon=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		Product theproduct=null;
		int id=Integer.parseInt(proID);
		try {
			myCon=dataSource.getConnection();
			String sql="select * from Product where Id=?";
			myStmt=myCon.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			myRs=myStmt.executeQuery();
			if(myRs.next()){
				String name=myRs.getString("Name");
				String des=myRs.getNString("Description");
				Double price=myRs.getDouble("price");
				theproduct = new Product(name, des,price );
				
				
			}else {
				throw new Exception("Could not find id "+ proID);
			}
			return theproduct;			
		
		} finally {
			close(myCon, myStmt, myRs);
		} 
		
	}
	
	
	
	

}
