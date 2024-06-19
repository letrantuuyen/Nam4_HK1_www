package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.DanhMuc;

public class DanhMucUtil {
	private DataSource dataSource;

	public DanhMucUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		try {
			if(myConn != null)
				myConn.close();
			if(myStmt !=null)
				myStmt.close();
			if(myRs != null)
				myRs.close();
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public List<DanhMuc> getListDanhMuc() throws SQLException{
		List<DanhMuc> dms = new ArrayList<DanhMuc>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "Select *from DanhMuc";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				int maDM = myRs.getInt("MaDM");
				String tenDM = myRs.getString("TenDanhMuc");
				String nguoiQL = myRs.getString("NguoiQuanLi");
				String ghiChu = myRs.getString("GhiChu");
				
				DanhMuc danhmuc = new DanhMuc(maDM, tenDM, nguoiQL, ghiChu);
				dms.add(danhmuc);	
				}
			return dms;
		}finally {
			close(myConn, myStmt, myRs);
		}
	}
}