package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.Category_vo;
import shop.vo.Product_vo;
import shop_dao.Membersdao;

public class Productdao {

		public static  Productdao instnce=new Productdao();
		private Productdao() {}
		public static Productdao getinstance() {
			return instnce;
		}
		
		public ArrayList<Product_vo> pro_list(int cg_id){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> wo_pro_list = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					wo_pro_list.add(vo);
				}
				return wo_pro_list;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		
public ArrayList<Product_vo> wo_list_all(){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> wo_list_all = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=any(3,4,5)";
				pstmt = con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					wo_list_all.add(vo);
				}
				return wo_list_all;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		
		public int cg_idgetinfo(int cgb_num ,String cgs_name ) {
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			int cg_id = 0;
			try {
				con = MyDBCP.getConnection();
				String sql = "select cg_id from Category where p_id=? and cg_name=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, cgb_num);
				pstmt.setString(2, cgs_name);
				rs= pstmt.executeQuery();
				if(rs.next()) {
					cg_id = rs.getInt("cg_id");
				}
				return cg_id; 
				
			}catch(SQLException s) {
				s.getMessage();
				return -1;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		
		public Category_vo cg_namegetinfo(int cg_id) {
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			Category_vo vo = null;
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				rs= pstmt.executeQuery();
				if(rs.next()) {
					vo = new Category_vo(rs.getInt("cg_id"), rs.getString("cg_name"), rs.getInt("p_id"));
					
				}
				return vo; 
				
			}catch(SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
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
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
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
				String sql = "select * from("
						+ " select p.*,rownum rnum from("
						+ " select * from product"
						+ " order by p_date desc) p)"
						+ " where rnum<10";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
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
				
				System.out.println(vo.getP_name()+"/ "+vo.getP_count()+"/"+vo.getP_price()+"/"+vo.getP_click_num()+"/"+vo.getOri_img_name()+"/"+vo.getSave_img_name()+"/"+vo.getCg_id());
				con = MyDBCP.getConnection();
				String sql = "insert into product values(product_seq.nextval,?,?,?,?,sysdate,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getP_name());
				pstmt.setInt(2,	vo.getP_count());
				pstmt.setInt(3,	vo.getP_price());
				pstmt.setInt(4,	vo.getP_click_num());
				pstmt.setString(5,	vo.getOri_img_name());
				pstmt.setString(6,	vo.getSave_img_name());
				pstmt.setInt(7,	vo.getCg_id());
				
				int n = pstmt.executeUpdate();
				//System.out.println(n);
				return n ; 
				
			}catch(SQLException s) {
				s.getMessage();
				return -1;
			}finally {
				MyDBCP.close(con, pstmt, null);
			}
		}
}
