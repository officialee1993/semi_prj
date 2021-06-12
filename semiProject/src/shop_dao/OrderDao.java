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

	/*mypage order list count*/
	public int getCountMyOrder(String id,String startDate,String endDate) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		if(startDate==null || startDate.equals("")) {
			sql="select NVL(count(o_num),0) from orders"
					+ " where id=?";
		}else{
			sql="select NVL(count(o_num),0) from orders"
					+ " where id=? and o_date between to_date("+startDate+",'yyyy/mm/dd') and to_date("+endDate+",'yyyy/mm/dd')+0.99999";
		}
		try {
			con=MyDBCP.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rs.next();
			int q_b_num=rs.getInt(1); //첫번째 행 얻어옴
			return q_b_num;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con,pstmt,rs);
		}
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
			
			if(n3>0) 
			System.out.println("주문성공");
			
			
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

	public ArrayList<Product_Orderlist_vo> mypage_orderList(String id,int startRow,int endRow,String startDate,String endDate){
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql="";
		if(startDate==null || startDate.equals("")) {
			sql="select * from("
					+ " select orderlist.*,rownum rnum from("
					+ " select o.p_num,p.p_name,p.save_img_name,o.o_num,o.all_sum_price,o.o_date,o.o_state,o.id,a.a_b_num,a.a_b_content from product p"
					+ " join orders o"
					+ " on p.p_num=o.p_num"
					+ " join a_board a"
					+ " on o.o_num=a.o_num"
					+ " where o.id=?"
					+ " order by o.o_date desc) orderlist)"
					+ " where rnum>=? and rnum<=?";
		}else {
			sql="select * from("
					+ " select orderlist.*,rownum rnum from("
					+ " select o.p_num,p.p_name,p.save_img_name,o.o_num,o.all_sum_price,o.o_date,o.o_state,o.id,a.a_b_num,a.a_b_content from product p"
					+ " join orders o"
					+ " on p.p_num=o.p_num"
					+ " join a_board a"
					+ " on o.o_num=a.o_num"
					+ " where o.id=? and o_date between to_date("+startDate+",'yyyy/mm/dd') and to_date("+endDate+",'yyyy/mm/dd')+0.99999"
					+ " order by o.o_date desc) orderlist)"
					+ " where rnum>=? and rnum<=?";
		}
		
		try {
			con = MyDBCP.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs=pstmt.executeQuery();
			ArrayList<Product_Orderlist_vo> list=new ArrayList<Product_Orderlist_vo>();
			while(rs.next()) {
				Product_Orderlist_vo vo=new Product_Orderlist_vo(
						rs.getInt("p_num"),
						rs.getString("p_name"),
						rs.getString("save_img_name"),
						rs.getInt("o_num"),
						rs.getInt("all_sum_price"),
						rs.getDate("o_date"),
						rs.getString("o_state"),
						rs.getString("id"),
						rs.getInt("a_b_num"),
						rs.getString("a_b_content")
						);
				list.add(vo);
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

























