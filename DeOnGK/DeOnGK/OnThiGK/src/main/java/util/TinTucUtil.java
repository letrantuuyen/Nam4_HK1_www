package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.DanhMuc;
import model.TinTuc;

public class TinTucUtil {
	private DataSource dataSource;

	public TinTucUtil(DataSource dataSource) {
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
	public List<TinTuc> getListTinTuc() throws SQLException{
		List<TinTuc> news = new ArrayList<TinTuc>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "Select *from TinTuc";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				int maTin = myRs.getInt("MaTT");
				String tieuDe = myRs.getString("TieuDe");
				String noiDungTT = myRs.getString("NoiDungTT");
				String lienKet = myRs.getString("LienKet");
				
				TinTuc tintuc = new TinTuc(maTin, tieuDe, noiDungTT, lienKet);
				news.add(tintuc);
			}
			return news;
		}finally {
			close(myConn, myStmt, myRs);
		}
	}
	/*
	public List<TinTuc> getTinTucByDM(int ma1) throws SQLException{
		List<TinTuc> news = new ArrayList<TinTuc>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "select MaTT,TieuDe,NoiDungTT,LienKet\r\n"
					+ " from TinTuc as tt\r\n"
					+ "join DanhMuc as dm\r\n"
					+ "on tt.MaDM = dm.MaDM\r\n"
					+ "where dm.MaDM = 1";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				int madm = myRs.getInt("MaDM");
				if(madm == ma1) {
				String maTin = myRs.getString("MaTT");
				String tieuDe = myRs.getString("TieuDe");
				String noiDungTT = myRs.getString("NoiDungTT");
				String lienKet = myRs.getString("LienKet");
				TinTuc tintuc = new TinTuc(tieuDe, noiDungTT, lienKet, new DanhMuc(madm));
				news.add(tintuc);
			}
			}
			return news;
		}finally {
			close(myConn, myStmt, myRs);
		}
	}
	*/
	
	public List<TinTuc> getTinTucByDM() throws SQLException {
	    List<TinTuc> news = new ArrayList<>();
	    Connection myConn = null;
	    PreparedStatement myStmt = null;
	    ResultSet myRs = null;
	    try {
	        myConn = dataSource.getConnection();
	        String sql = "SELECT tt.MaTT, tt.TieuDe, tt.NoiDungTT, tt.LienKet, dm.MaDM " +
	                     "FROM TinTuc AS tt " +
	                     "JOIN DanhMuc AS dm " +
	                     "ON tt.MaDM = dm.MaDM " +
	                     "WHERE dm.MaDM = 2";
	        myStmt = myConn.prepareStatement(sql);
	        myRs = myStmt.executeQuery();
	        while (myRs.next()) {
	            int maTin = myRs.getInt("MaTT");
	            String tieuDe = myRs.getString("TieuDe");
	            String noiDungTT = myRs.getString("NoiDungTT");
	            String lienKet = myRs.getString("LienKet");
	            int maDM = myRs.getInt("MaDM"); // Retrieve category ID
	            TinTuc tintuc = new TinTuc(maTin, tieuDe, noiDungTT, lienKet, new DanhMuc(maDM));
	            news.add(tintuc);
	        }
	        return news;
	    } finally {
	        close(myConn, myStmt, myRs);
	    }
	}

	public void addTT(TinTuc tintuc) throws SQLException {
	    Connection myCon = null;
	    PreparedStatement myStmt = null;
	    try {
	        myCon = dataSource.getConnection();
	        String sql ="INSERT INTO TinTuc(MaTT, TieuDe, NoiDungTT, LienKet, MaDM) VALUES (?, ?, ?, ?, ?)";
	        myStmt = myCon.prepareStatement(sql);
	        myStmt.setInt(1, tintuc.getMaTT());
	        myStmt.setString(2, tintuc.getTieuDe());
	        myStmt.setString(3, tintuc.getNoiDungTT());
	        myStmt.setString(4, tintuc.getLienKet());
	        
	        Integer maDMValue = null;
	        DanhMuc maDM = tintuc.getMaDM();
	        if (maDM != null) {
	            maDMValue = maDM.getMaDM();
	        }
	        myStmt.setObject(5, maDMValue); // Sử dụng setObject để tránh lỗi khi giá trị là null
	        myStmt.executeUpdate();
	    } finally {
	        close(myCon, myStmt, null);
	    }
	}

	
	public void deleteTT(int maTin) throws SQLException {
		Connection myCon = null;
		PreparedStatement stmt = null;
		try {
			
			myCon = dataSource.getConnection();
			String sql = "delete from TinTuc where MaTT = ? ";
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, maTin);
			stmt.execute();
		}finally {
			close(myCon, stmt, null);
		}
	}
}
