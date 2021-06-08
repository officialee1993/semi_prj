package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.remote.JMXConnectionNotification;

import shop.db.MyDBCP;
import shop.vo.Members_vo;

public class Membersdao {

	private static Membersdao instance= new Membersdao();
	private Membersdao() {};
	public static Membersdao getinstance() {
		return instance;
	}
	
	public String find_pwd(String id , String email) {
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs= null;
		String pwd =null;
		try {
			con = MyDBCP.getConnection();
			String sql = "select * from members where id=? and email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				pwd = rs.getString("pwd");
			}
			return pwd ; 
		}catch (SQLException s) {
			s.getMessage();
			return null;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
		
	}
	public String find_id(String name , String email) {
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs= null;
		String id =null;
		try {
			con = MyDBCP.getConnection();
			String sql = "select * from members where name=? and email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
			}
			return id ; 
		}catch (SQLException s) {
			s.getMessage();
			return null;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
		
	}
	public int insert(String id , String pwd , String name , String phone , String email, String address ) {
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		try {
			con = MyDBCP.getConnection();
			String sql = "insert into members values(?,?,?,?,?,?)";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setString(6, address);
			
			int n = pstmt.executeUpdate();
			
			return n ; 
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1; 
		}finally {
			MyDBCP.close(con, pstmt, null);
		}
	}
	public boolean isMember(String id , String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs= null; 
		try {
		
			con = MyDBCP.getConnection();
			String sql="select * from members where id=? and pwd=?";
			System.out.println("memberdao");
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2,pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException s) {
			s.getMessage();
			return false;
			
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}
}
