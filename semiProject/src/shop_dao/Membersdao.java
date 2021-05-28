package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.db.MyDBCP;

public class Membersdao {

	private static Membersdao instance= new Membersdao();
	private Membersdao() {};
	public static Membersdao getinstance() {
		return instance;
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
			
		}
	}
}
