package shop_dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.Sales_stats_vo;

public class Salesdao {
	private static Salesdao instance = new Salesdao();
	private Salesdao() {};
	public static Salesdao getinstance() {
		return instance;
	}
	public ArrayList<Sales_stats_vo> sales_stats_all_selete(){
		
		ArrayList<Sales_stats_vo> list = new ArrayList<Sales_stats_vo>();
		Connection con = null; 
		Statement stmt = null; 
		ResultSet rs = null; 
		try {
			
			con = MyDBCP.getConnection();
			String sql = "select * from Sales_stats";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Sales_stats_vo sales_stats_vo = new Sales_stats_vo(rs.getInt("sales_stats_num"), rs.getInt("all_sales"), rs.getDate("o_date"), rs.getInt("p_num"), rs.getInt("p_count") );
				list.add(sales_stats_vo); 
			}
			return list;
			
		}catch (SQLException s) {
			s.getMessage();
			return null; 
		}finally {
			MyDBCP.close(con, stmt, rs);
		}
	}
	public int Sales_stats_insert(int all_Sales , int p_num,int p_count){
		Connection con = null; 
		PreparedStatement pstmt = null; 
		try {
			
			con= MyDBCP.getConnection();
			String sql ="insert into sales_stats values(Sales_stats_seq.nextval,?,sysdate,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, all_Sales);
			pstmt.setInt(2, p_count);
			pstmt.setInt(3, p_num);
			
			int n = pstmt.executeUpdate();
			
			return n ; 
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1; 
		}finally {
			
			
		}
	}
	
	public ArrayList<Sales_stats_vo> Sales_stats_kal_select (String beforekal , String afterkal ){
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		ArrayList<Sales_stats_vo> list = new ArrayList<Sales_stats_vo>();
		try {
			
			con= MyDBCP.getConnection();
			String sql ="select * from sales_stats WHERE o_date BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD-hh24-mi')";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, beforekal);
			pstmt.setString(2, afterkal);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sales_stats_vo vo = new Sales_stats_vo(rs.getInt("Sales_stats_num"), rs.getInt("all_Sales"), rs.getDate("o_date"), rs.getInt("p_num"), rs.getInt("p_count"));
				list.add(vo);
			}
			return list; 
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			return null; 
		}finally {
			MyDBCP.close(con, pstmt, rs);
			
		}
	}
	
}
