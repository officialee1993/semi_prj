package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.BasketList_vo;
import shop.vo.Orders_vo;

public class OrderDao {
	
	
	private static OrderDao instance = new OrderDao();
	public static OrderDao getinstance() {
		return instance; 
	}
	
	public int goodorder_insert(String rec_name, String rec_phone, String rec_addr,int ALL_SUM_PRICE, String payname, String O_STATE,String id,int p_num,int b_num_max) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		
		try {
			con = MyDBCP.getConnection();
			String sql="insert into orders values(ORDERS_SEQ.nextval,?,?,?,?,?,SYSDATE,?,?,?,?)";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,rec_name );
			pstmt.setString(2,rec_phone );
			pstmt.setString(3,rec_addr );
			pstmt.setInt(4, ALL_SUM_PRICE);
			pstmt.setString(5,payname );
			pstmt.setString(6,O_STATE );
			pstmt.setString(7,id );
			pstmt.setInt(8, p_num);
			pstmt.setInt(9, b_num_max);
			int n = pstmt.executeUpdate();
			
			return n ;
		}catch (SQLException s) {
			s.getMessage();
			return -1;
		}finally {
			MyDBCP.close(con, pstmt, null);
		}
	}
	
public Orders_vo ordervoinfo (){
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		Orders_vo ordervo = null;
		
		try {
		
			con = MyDBCP.getConnection();
			
			String sql = "select * from orders";
			
			pstmt = con.prepareStatement(sql);
		
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				
			ordervo = new Orders_vo(rs.getInt("O_NUM"), rs.getString("REC_NAME"), rs.getString("REC_PHONE"), rs.getString("REC_ADDR"),
								rs.getInt("ALL_SUM_PRICE"), rs.getString("PAYNAME"), rs.getDate("O_DATE"), rs.getString("O_STATE"), rs.getString("ID")
									, rs.getInt("P_NUM"), rs.getInt("B_NUM"));
			
			}
			return ordervo;
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null; 
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}

}
