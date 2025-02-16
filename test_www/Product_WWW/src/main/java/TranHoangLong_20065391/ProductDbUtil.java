package TranHoangLong_20065391;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class ProductDbUtil {

	private DataSource dataSource;

	public ProductDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
public List<Product> getProduct() throws Exception {		
	List<Product> products = new ArrayList<>();		
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;		
	try {
		// get a connection
		myConn = dataSource.getConnection();			
		// create sql statement
		String sql = "select * from Product order by name";			
		myStmt = myConn.createStatement();			
		// execute query
		myRs = myStmt.executeQuery(sql);			
		// process result set
		while (myRs.next()) {				
			// retrieve data from result set row
			int id = myRs.getInt("id");
			String name = myRs.getString("name");
			String description = myRs.getString("discription");
			Double price = myRs.getDouble("price");				
			// create new student object
			Product tempproduct = new Product(id, name, description, price);				
			// add it to the list of students
			products.add(tempproduct);}			
		return products;}
	  finally {
		// close JDBC objects
		close(myConn, myStmt, myRs);}		
}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
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

	public void addProduct(Product theProduct) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;		
		try {
			// get db connection
			myConn = dataSource.getConnection();			
			// create sql for insert
			String sql = "insert into Product "
					   + "(name, description, price) "
					   + "values (?, ?, ?)";			
			myStmt = myConn.prepareStatement(sql);			
			// set the param values for the student
			myStmt.setString(1, theProduct.getName());
			myStmt.setString(2, theProduct.getDescription());
			myStmt.setDouble(3, theProduct.getPrice());			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Product getProduct(String theProductID) throws Exception {
		Product theProduct = null;	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int productId;		
		try {
			// convert student id to int
			productId = Integer.parseInt(theProductID);			
			// get connection to database
			myConn = dataSource.getConnection();			
			// create sql to get selected student
			String sql = "select * from Product where id=?";			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);			
			// set params
			myStmt.setInt(1, productId);			
			// execute statement
			myRs = myStmt.executeQuery();			
			// retrieve data from result set row
			if (myRs.next()) {
				String name = myRs.getString("name");
				String description = myRs.getString("description");
				Double price = myRs.getDouble("price");				
				// use the studentId during construction
				theProduct = new Product(productId, name, description, price);
			}
			else {
				throw new Exception("Could not find Product id: " + productId);	}							
			return theProduct;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);}
	}

	public void updateStudent(Product theProduct) throws Exception {		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			// get db connection
			myConn = dataSource.getConnection();			
			// create SQL update statement
			String sql = "update Product "
						+ "name=?, description=?, price=? "
						+ "where id=?";			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);			
			// set params
			myStmt.setString(1, theProduct.getName());
			myStmt.setString(2, theProduct.getDescription());
			myStmt.setDouble(3, theProduct.getPrice());
			myStmt.setInt(4, theProduct.getId());			
			// execute SQL statement
			myStmt.execute();}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);}
	}

	public void deleteProduct(String theProductID) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;		
		try {
			// convert student id to int
			int productId = Integer.parseInt(theProductID);			
			// get connection to database
			myConn = dataSource.getConnection();			
			// create sql to delete student
			String sql = "delete from Product where id=?";			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);			
			// set params
			myStmt.setInt(1, productId);			
			// execute sql statement
			myStmt.execute();}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);}	
	} 

}
