package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import shop.db.MyDBCP;

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
		System.out.println("주문 1단계");
		String sql="insert into orders values(ORDERS_SEQ.nextval,?,?,?,?,?,SYSDATE,?,?,?,?)";
		String sql2="insert into a_board(a_b_num,wr_id,o_num) values(A_board_SEQ.nextval,?,ORDERS_SEQ.currval)";
		String sql3="insert into a_reply(a_r_no,a_b_num) values(a_reply_seq.nextval,A_board_SEQ.currval)";
		try {
			System.out.println("주문 2단계");
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
			System.out.println("주문성공");
			return n3;
		}catch (SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con, pstmt, null);
		}
	}
}
