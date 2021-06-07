package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.DBConversion;
import shop.db.MyDBCP;
import shop.vo.Cgname_Pid_select_vo;

public class Categorydao {
	
	private static Categorydao instance = new Categorydao();
	private Categorydao () {};
	public static Categorydao getinstance () {
		return instance; 
	}
	
	public int cg_id_select(String cg_name , int p_id) {
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		int cg_id = 0;
		try {
				con = MyDBCP.getConnection();
				String sql = "select cg_id from category where cg_name=? and p_id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, cg_name);
				pstmt.setInt(2, p_id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					cg_id= rs.getInt("cg_id");	
				}
				
				return cg_id;
		}catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
		
	}
	
	public Cgname_Pid_select_vo cgname_pid_select(int cg_id) {
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		Cgname_Pid_select_vo vo = null;
		try {
				con = MyDBCP.getConnection();
				String sql = "select cg_name, p_id from category where cg_id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					
					vo = new Cgname_Pid_select_vo(rs.getString("cg_name"), rs.getInt("p_id"));
					
				}
				
				return vo;
		}catch (SQLException s) {
			System.out.println(s.getMessage());
			return null;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
		
	}
	
}
