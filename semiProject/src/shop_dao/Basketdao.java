package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.DBConversion;
import shop.db.MyDBCP;
import shop.vo.BasketList_vo;
import shop.vo.Basket_sum_price_vo;


public class Basketdao {
	
	
	private static Basketdao instance= new Basketdao();
	public static Basketdao getinstance() {
		return instance; 
	}
	private Basketdao () {}
	
public ArrayList<Basket_sum_price_vo> basket_sum_price(String id) {
		
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		ArrayList<Basket_sum_price_vo> list = new ArrayList<Basket_sum_price_vo>();
		try {
			con = MyDBCP.getConnection();
			String sql = "SELECT p_num,b_num ,C*P all_sum_price, c\r\n"
					+ "FROM(\r\n"
					+ "SELECT p_num, b_num,p_count C , P_PRICE P FROM (\r\n"
					+ "select p.p_price ,b.p_count ,b.b_num, b.p_num from Product p,Basket b where b.id=? and p.p_num = b.p_num\r\n"
					+ "minus\r\n"
					+ "select p.p_price ,b.p_count ,o.b_num, b.p_num from Product p,orders o ,Basket b where o.id=? and p.p_num = o.p_num and o.b_num=b.b_num\r\n"
					+ "))";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				Basket_sum_price_vo basket_sum_price_vo = new Basket_sum_price_vo(rs.getInt("b_num"), rs.getInt("all_sum_price"),rs.getInt("p_num"),rs.getInt("c"));
				list.add(basket_sum_price_vo);
			}
			return list;
		}catch (SQLException s) {
			System.out.println(s.getMessage());
			return null;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}

	public int basket_all_sum_price(String id) {
		
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		int all_sum_price =0;
		try {
			con = MyDBCP.getConnection();
			String sql = "SELECT SUM(C*P) all_sum_price \r\n"
					+ "FROM(\r\n"
					+ "SELECT p_count C , P_PRICE P FROM (\r\n"
					+ "select p.p_price  ,b.p_count ,b.b_num from Product p,Basket b where b.id='one' and p.p_num = b.p_num\r\n"
					+ "minus\r\n"
					+ "select p.p_price ,b.p_count ,o.b_num from Product p,orders o ,Basket b where o.id=? and p.p_num = o.p_num and o.b_num=b.b_num\r\n"
					+ "))";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				all_sum_price = rs.getInt("all_sum_price");
			}
			return all_sum_price;
		}catch (SQLException s) {
			s.getMessage();
			return -1;
		}finally {
			
		}
	}
	
	public int basket_b_num_max() {
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs= null;
		
		try {
			con = MyDBCP.getConnection();
			String sql = "select NVL(max(b_num),0)bnum from basket";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int bnum = rs.getInt("bnum");
			
			return bnum ; 
		}catch(SQLException s) {
			s.getMessage();
			return -1 ; 
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}
	
	public int basketdelete(int b_num) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		
		
		try {
			con = MyDBCP.getConnection();
			String sql = "delete from basket where b_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			int n = pstmt.executeUpdate();
			return n ; 
			
		}catch (SQLException s) {
			System.out.println(s.getMessage());
			return -1; 
		}finally {
			MyDBCP.close(con, pstmt, null);
		}
	}
	
	public ArrayList<BasketList_vo> notorder_basketlist(String id){ 
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
	
		
		try {
			ArrayList< BasketList_vo> basketlist = new ArrayList<BasketList_vo>();
			con = MyDBCP.getConnection();
			
			String sql = "select p.save_img_name,b.p_size,p.p_name,p.p_price,b.p_count,b.b_num from Product p,Basket b where b.id=? and p.p_num = b.p_num";
			// 회원에 따른 모든 방바구니 (주문 통한 장바구니도 포함 ) 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				
			BasketList_vo basketlistvo = new BasketList_vo(rs.getString("save_img_name"), rs.getString("p_name"),
						rs.getInt("p_price"), rs.getInt("p_count"),rs.getString("p_size"),rs.getInt("b_num"));
				
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

	public ArrayList<BasketList_vo> basketlist(String id){ //구매 한번 후 장바구니 list 가능 // 이거 쳐야 한다. 
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
	
		
		try {
			ArrayList< BasketList_vo> basketlist = new ArrayList<BasketList_vo>();
			con = MyDBCP.getConnection();
			
			String sql = "select p.save_img_name,b.p_size,p.p_name,p.p_price,b.p_count,b.b_num from Product p,Basket b where b.id=? and p.p_num = b.p_num\r\n"
					+ "minus\r\n"
					+ "select p.save_img_name,b.p_size,p.p_name,p.p_price,b.p_count,o.b_num from Product p,orders o ,Basket b where o.id=? and p.p_num = o.p_num and o.b_num=b.b_num\r\n"
					;
			// 장바구이네서 주문한 장바구니 제외하고 뽑아 노는 sql 구현 하기 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				
			BasketList_vo basketlistvo = new BasketList_vo(rs.getString("save_img_name"), rs.getString("p_name"),
						rs.getInt("p_price"), rs.getInt("p_count"),rs.getString("p_size"),rs.getInt("b_num"));
				
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
