package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.sql.Statement;


import shop.db.MyDBCP;
import shop.vo.BasketList_vo;
import shop.vo.Orders_vo;
import shop.vo.Product_Orderlist_vo;

public class OrderDao {
	
	
	private static OrderDao instance = new OrderDao();
	public static OrderDao getinstance() {
		return instance; 
	}
	
	public int goodorder_insert(String rec_name, String rec_phone, String rec_addr,int ALL_SUM_PRICE, String payname, String O_STATE,String id,int p_num,int b_num_max) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		PreparedStatement pstmt2 = null; 
		Statement stmt2 = null; 

	
		String sql="insert into orders values(ORDERS_SEQ.nextval,?,?,?,?,?,SYSDATE,?,?,?,?)";
		String sql2="insert into a_board(a_b_num,wr_id,o_num) values(A_board_SEQ.nextval,?,ORDERS_SEQ.currval)";
		String sql3="insert into a_reply(a_r_no,a_b_num) values(a_reply_seq.nextval,A_board_SEQ.currval)";
		try {

			
			con = MyDBCP.getConnection();
			con.setAutoCommit(false);
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
			pstmt.executeUpdate();
			
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setString(1, id);
			pstmt2.executeUpdate();

			stmt2=con.createStatement();
			int n3=stmt2.executeUpdate(sql3);

			
			con.commit();
			return n3;
			
		}catch (SQLException s) {
			s.printStackTrace();
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

public ArrayList<Product_Orderlist_vo> ordervo_list_info (String id){
	
	Connection con = null; 
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	Product_Orderlist_vo product_orderlist_vo = null;
	ArrayList<Product_Orderlist_vo> list = new ArrayList<Product_Orderlist_vo>();
	try {
	
		con = MyDBCP.getConnection();
		
		String sql = "select * from orders o, product p , category c , basket b where o.p_num = p.p_num and p.cg_id =  c.cg_id and o.b_num = b.b_num and b.id =?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs= pstmt.executeQuery();
		
		while(rs.next()) {
			
			product_orderlist_vo = new Product_Orderlist_vo(rs.getInt("O_NUM"), rs.getString("REC_NAME"), rs.getString("REC_PHONE"), rs.getString("REC_ADDR"),
							rs.getInt("ALL_SUM_PRICE"), rs.getString("PAYNAME"), rs.getDate("O_DATE"), rs.getString("O_STATE"), rs.getString("ID")
								, rs.getInt("P_NUM"), rs.getInt("B_NUM"), rs.getString("save_img_name"),rs.getString("cg_name") );
			
			list.add(product_orderlist_vo);
		}
		return list;
	}catch(SQLException s) {
		System.out.println(s.getMessage());
		return null; 
	}finally {
		MyDBCP.close(con, pstmt, rs);
	}
}

}
