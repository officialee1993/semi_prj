package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.BasketList_vo;
import shop.vo.Basket_vo;

public class Basketdao {
	
	
	private static Basketdao instance= new Basketdao();
	public static Basketdao getinstance() {
		return instance; 
	}
	private Basketdao () {}

	

	public ArrayList<BasketList_vo> basketlist(String id){
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
	
		
		try {
			ArrayList< BasketList_vo> basketlist = new ArrayList<BasketList_vo>();
			con = MyDBCP.getConnection();
			
			String sql = "select p.save_img_name,b.p_size,p.p_name,p.p_price,b.p_count from Product p,Basket b where id=? and p.p_num = b.p_num";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				
			BasketList_vo basketlistvo = new BasketList_vo(rs.getString("save_img_name"), rs.getString("p_name"), rs.getInt("p_price"), rs.getInt("p_count"),rs.getString("p_size"));
				
			basketlist.add(basketlistvo);
				
			}
			return basketlist;
			
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null; 
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}
	public int insert(int p_count,int p_num , String id,String p_size ) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		try {
			
			con = MyDBCP.getConnection();
			String sql = "insert into Basket values(basket_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,p_count);
			pstmt.setInt(2, p_num);
			pstmt.setString(3, id);
			pstmt.setString(4, p_size);
		
			int n = pstmt.executeUpdate();
			
			return n; 
			
			
		}catch(SQLException s) {
			s.getMessage();
			return -1; 
		}finally {
			MyDBCP.close(con, pstmt, null);
		}
	}
}
