package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.Product_vo;
import shop_dao.Membersdao;

public class Productdao {

		public static  Productdao instnce=new Productdao();
		private Productdao() {}
		public static Productdao getinstance() {
			return instnce;
		}
		public Product_vo getinfo(int p_num) {
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			Product_vo vo = null;
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where p_num=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, p_num);
				rs= pstmt.executeQuery();
				if(rs.next()) {
					vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getString("cg_name"));
					
				}
				return vo; 
				
			}catch(SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> list(){
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> list = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getString("cg_name"));
					list.add(vo);
				}
				return list;
			}catch (SQLException s) {
				s.getMessage();
				return null;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public int insert(Product_vo vo ) {
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			try {
				
				//System.out.println(vo.getP_name()+"/ "+vo.getP_count()+"/"+vo.getP_price()+"/"+vo.getP_click_num()+"/"+vo.getOri_img_name()+"/"+vo.getSave_img_name()+"/"+vo.getCg_name());
				con = MyDBCP.getConnection();
				String sql = "insert into product values(product_seq.nextval,?,?,?,?,sysdate,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getP_name());
				pstmt.setInt(2,	vo.getP_count());
				pstmt.setInt(3,	vo.getP_price());
				pstmt.setInt(4,	vo.getP_click_num());
				pstmt.setString(5,	vo.getOri_img_name());
				pstmt.setString(6,	vo.getSave_img_name());
				pstmt.setString(7,	vo.getCg_name());
				
				int n = pstmt.executeUpdate();
				
				return n ; 
				
			}catch(SQLException s) {
				s.getMessage();
				return -1;
			}finally {
				MyDBCP.close(con, pstmt, null);
			}
		}
}
