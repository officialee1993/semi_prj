package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.db.MyDBCP;

public class StoragesDao {
	
	

	public static StoragesDao instance = new StoragesDao();
	private StoragesDao() {} ;
	public static StoragesDao getinstance() {
		
		return instance;
	};
	
public int Storages_getcount(int p_num ,String p_size) {
	
	Connection con = null; 
	 PreparedStatement pstmt = null; 
	 ResultSet rs = null; 
	 try {
		 con = MyDBCP.getConnection();
		 String sql = "select s_count from Storages  where  p_num=? and p_size=?";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, p_num);
		 pstmt.setString(2, p_size);
		 
		 rs = pstmt.executeQuery();
		 if(rs.next()) {
			 int getcount = rs.getInt("s_count");
			 return getcount ; 
		 }
		return -1;
	 }catch (SQLException s) {
		 s.getMessage();
		 return -1;
	}finally {
		MyDBCP.close(con, pstmt, null);
	}
}
	
public int Storages_update_add(int p_count, int p_num ,String p_size) {
	 
	 Connection con = null; 
	 PreparedStatement pstmt = null; 
	 
	 try {
		 con = MyDBCP.getConnection();
		 String sql = "update Storages set s_count = ? where  p_num=? and p_size=?";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, p_count);
		 pstmt.setInt(2, p_num);
		 pstmt.setString(3, p_size);
		 
		 int n = pstmt.executeUpdate();
		 
		 return n ; 
	 }catch (SQLException s) {
		 s.getMessage();
		 return -1;
	}finally {
		MyDBCP.close(con, pstmt, null);
	}
}

 public int Storages_update(int p_count, int p_num ,String p_size) {
	 
	 Connection con = null; 
	 PreparedStatement pstmt = null; 
	 
	 try {
		 con = MyDBCP.getConnection();
		 String sql = "update Storages set s_count = s_count-? where  p_num=? and p_size=?";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, p_count);
		 pstmt.setInt(2, p_num);
		 pstmt.setString(3, p_size);
		 
		 int n = pstmt.executeUpdate();
		 
		 return n ; 
	 }catch (SQLException s) {
		 s.getMessage();
		 return -1;
	}finally {
		MyDBCP.close(con, pstmt, null);
	}
 }
}
