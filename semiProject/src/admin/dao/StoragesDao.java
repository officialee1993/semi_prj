package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import shop.db.MyDBCP;
import shop.vo.Basket_product_storage_vo;

public class StoragesDao {
	
	

	public static StoragesDao instance = new StoragesDao();
	private StoragesDao() {} ;
	public static StoragesDao getinstance() {
		
		return instance;
	};

	
public int Storages_p_num_count(int p_num) {
	
	Connection con = null; 
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	try {
		con = MyDBCP.getConnection();
		String sql = "select nvl(count(*),0) from storages where p_num = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, p_num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			int count = rs.getInt(1);
			return count;
			
		}
		return -1;
		
	}catch (SQLException s) {
		
		System.out.println(s.getMessage());
		
		return -1;
	}
}

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
public Basket_product_storage_vo Basket_product_storage_vo(int b_num){
	
	Connection con =null; 
	PreparedStatement pstmt = null; 
	ResultSet rs =null; 
	
	try {
		
		con =MyDBCP.getConnection();
		String sql ="select p.p_num,b.p_count,b.p_size from product p ,basket b where b.p_num=p.p_num and b.b_num =?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, b_num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			Basket_product_storage_vo vo = new Basket_product_storage_vo(rs.getInt("p_num"),rs.getInt("p_count"), rs.getString("p_size"));
			return vo;
		}
			return null;
	}catch (SQLException s) {
		s.getMessage();
		return null;
	}finally {
		MyDBCP.close(con, pstmt, rs);
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
