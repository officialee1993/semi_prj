package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.A_board_vo;
import shop.vo.Orders_vo;

public class OrderDao {

	public static OrderDao instance=new OrderDao();
	private OrderDao() {}
	public static OrderDao getinstance() {
		return instance;
	}
	
	public Orders_vo orderDetail(int o_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			String sql="select o.o_num,o.rec_name,o.rec_phone,o.rec_addr,o.all_sum_price,o.payname,o.o_date,o.o_state,o.id,b.b_num,p.p_num,p.p_name,b.p_count,b.p_size,p.p_price,p.save_img_name from orders o"
					+ " join product p"
					+ " on o.p_num=p.p_num"
					+ " join basket b"
					+ " on o.o_num=b.b_num"
					+ " where o.o_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, o_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Orders_vo vo=new Orders_vo(
						rs.getInt("o_num"),
						rs.getString("rec_name"),
						rs.getString("rec_phone"),
						rs.getString("rec_addr"),
						rs.getInt("all_sum_price"),
						rs.getString("payname"),
						rs.getDate("o_date"),
						rs.getString("o_state"),
						rs.getString("id"),
						rs.getInt("p_num"),
						rs.getString("p_name"),
						rs.getInt("p_count"),
						rs.getString("p_size"),
						rs.getInt("p_price"),
						rs.getString("save_img_name")
						);
				return vo;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			MyDBCP.close(con,pstmt,rs);
		}
	}
	
	public int getCount(String field,String keyword,String startDate,String endDate) {
		if(keyword==null || keyword.equals("")) {
			field=null;
			keyword=null;
		}
		if(field==null || field.equals("")) {
			field=null;
			keyword=null;
		}
		if(startDate==null || startDate.equals("")) {
			startDate=null;
			endDate=null;
		}
		if(endDate==null || endDate.equals("")) {
			startDate=null;
			endDate=null;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			String sql="select NVL(count(o_num),0) from orders";
			if(startDate!=null && endDate!=null && field==null && keyword==null) {
				sql += " where o_date between to_date("+startDate+",'yyyy/mm/dd') and to_date("+endDate+",'yyyy/mm/dd')+0.99999";
			}else if(field!=null && keyword!=null && startDate==null && endDate==null) {
				sql += " where " + field + " like '%"+ keyword +"%'";
			}else if(field!=null && keyword!=null && startDate!=null && endDate!=null) {
				sql += " where " + field + " like '%"+ keyword +"%' and o_date between to_date("+startDate+",'yyyy/mm/dd') and to_date("+endDate+",'yyyy/mm/dd')+0.99999";
			}
			System.out.println("getcount:"+sql);
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int n=rs.getInt(1);
				System.out.println(n);
				return n;
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con,pstmt,rs);
		}
	}
	
	public int adminOrderStateUpdate(int o_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=MyDBCP.getConnection();
			String sql="update orders set o_state='배송완료' where o_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, o_num);
			return pstmt.executeUpdate();		
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con,pstmt,null);
		}
	}
	
	public ArrayList<Orders_vo> adminOrder(int startRow,int endRow,String field,String keyword,String startDate,String endDate){
		String sql="";
		if(keyword==null || keyword.equals("")) {
			field=null;
			keyword=null;
		}
		if(field==null || field.equals("")) {
			field=null;
			keyword=null;
		}
		if(startDate==null || startDate.equals("")) {
			startDate=null;
			endDate=null;
		}
		if(endDate==null || endDate.equals("")) {
			startDate=null;
			endDate=null;
		}
		
		if(startDate!=null && endDate!=null && field==null && keyword==null) {
			sql="select * from("
					+ " select a.*,rownum rnum from ("
					+ " select * from orders "
					+ " where o_date between to_date("+startDate+",'yyyy/mm/dd') and to_date("+endDate+",'yyyy/mm/dd')+0.99999"
					+ " order by o_date desc"
					+ " ) a)"
					+ " where rnum>=? and rnum<=?";
		}else if(field!=null && keyword!=null && startDate==null && endDate==null) {
			sql="select * from ("
					+ " select o.*,rownum rnum from ("
					+ " select * from orders where "+field+" like '%"+keyword+"%' order by o_date desc) o)"
					+ " where rnum>=? and rnum<=?";
		}else if(field!=null && keyword!=null && startDate!=null && endDate!=null) {
			sql="select * from ("
					+ " select o.*,rownum rnum from ("
					+ " select * from orders "
					+ " where "+field+" like '%"+keyword+"%' "
					+ " and o_date between to_date("+startDate+",'yyyy/mm/dd') and to_date("+endDate+",'yyyy/mm/dd')+0.99999"
					+ " order by o_date desc) o)"
					+ " where rnum>=? and rnum<=?";
		}else if(field==null && keyword==null && startDate==null && endDate==null) {
			sql="select * from("
					+ " select a.*,rownum rnum from ("
					+ " select * from orders order by o_date desc) a)"
					+ " where rnum>=? and rnum<=?";
		}
		System.out.println("list:"+sql);
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Orders_vo> list=new ArrayList<Orders_vo>();
			while(rs.next()) {
				Orders_vo vo=new Orders_vo(
						rs.getInt("o_num"),
						rs.getString("rec_name"),
						rs.getString("rec_phone"),
						rs.getString("rec_addr"),
						rs.getInt("all_sum_price"),
						rs.getString("payname"),
						rs.getDate("o_date"),
						rs.getString("o_state"),
						rs.getString("id"),
						rs.getInt("p_num"),
						rs.getInt("b_num")
						);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			MyDBCP.close(con,pstmt,rs);
		}
	}
}
