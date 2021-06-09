package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.Category_vo;
import shop.vo.Product_category_vo;
import shop.vo.Product_vo;
import shop_dao.Membersdao;

public class Productdao {

		public static  Productdao instnce=new Productdao();
		private Productdao() {}
		public static Productdao getinstance() {
			return instnce;
		}
		
		public ArrayList<Product_vo> admin_sex_product_list(String p_id){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList<Product_vo> admin_sex_product_list = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from category c , product p where p.cg_id=c.cg_id and p_id =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					admin_sex_product_list.add(vo);
				}
				return admin_sex_product_list;
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return null; 
			}
			
		}
		public ArrayList<Product_vo> admin_all_product_select (String p_name){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> admin_all_product_select = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product p  where  p.p_name like '%'||?||'%' ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_name);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					admin_all_product_select.add(vo);
				}
				return admin_all_product_select;
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return null; 
			}
			
		}
		public ArrayList<Product_vo> admin_product_select (String cg_name , String p_name){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> admin_product_select = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product p ,category c where p.cg_id = c.cg_id and c.cg_name=? and p.p_name like '%'||?||'%' ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cg_name);
				pstmt.setString(2, p_name);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					admin_product_select.add(vo);
				}
				return admin_product_select;
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return null; 
			}
			
		}
		
		public ArrayList<Product_vo> pro_order_new_date(int cg_id){
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> pro_order_new_date = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=? order by p_date desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					pro_order_new_date.add(vo);
				}
				return pro_order_new_date;
			}catch (SQLException s) {
				s.getMessage();
				return null;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> pro_order_low_price(int cg_id){
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> pro_order_low_price = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=? order by p_price asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					pro_order_low_price.add(vo);
				}
				return pro_order_low_price;
			}catch (SQLException s) {
				s.getMessage();
				return null;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> pro_order_high_price(int cg_id){
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> pro_order_high_price = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=? order by p_price desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					pro_order_high_price.add(vo);
				}
				return pro_order_high_price;
			}catch (SQLException s) {
				s.getMessage();
				return null;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> order_new_date(){
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> order_new_date = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product order by p_date desc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					order_new_date.add(vo);
				}
				return order_new_date;
			}catch (SQLException s) {
				s.getMessage();
				return null;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> order_low_price(){
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> order_low_price = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product order by p_price asc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					order_low_price.add(vo);
				}
				return order_low_price;
			}catch (SQLException s) {
				s.getMessage();
				return null;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> order_high_price(){
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> order_high_price = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product order by p_price desc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
													rs.getInt("p_click_num"), rs.getDate("p_date"),
													rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					order_high_price.add(vo);
				}
				return order_high_price;
			}catch (SQLException s) {
				s.getMessage();
				return null;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}

		
		public int product_delete(int p_num) {
			
			Connection con =null; 
			PreparedStatement pstmt = null; 
			try {
				con = MyDBCP.getConnection();
				String sql = "delete from product where p_num =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_num);
				int n = pstmt.executeUpdate();
				
				return n ; 
				
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return -1; 
			}finally {
				MyDBCP.close(con, pstmt, null);
			}
		}
		
		
		public int product_not_img_update(int p_num , String p_name, int p_price, int p_count, int cg_id) {
			Connection con = null; 
			PreparedStatement pstmt = null; 
			 
			try {
				con = MyDBCP.getConnection();
				String sql = "update product set p_name= ? ,p_price=? ,p_count=? , cg_id=? where p_num =?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, p_name);
				pstmt.setInt(2, p_price);
				pstmt.setInt(3, p_count);
				pstmt.setInt(4, cg_id);
				pstmt.setInt(5, p_num);
				
				int n = pstmt.executeUpdate();
				return n;
			}catch(SQLException s) {
				
				System.out.println(s.getMessage());
				return -1;
			}
		}
		public int productupdate(int p_num , String p_name, int p_price, int p_count,String save_img_name, int cg_id) {
			Connection con = null; 
			PreparedStatement pstmt = null; 
			 
			try {
				con = MyDBCP.getConnection();
				String sql = "update product set p_name= ? ,p_price=? ,p_count=? ,save_img_name=? , cg_id=? where p_num =?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, p_name);
				pstmt.setInt(2, p_price);
				pstmt.setInt(3, p_count);
				pstmt.setString(4, save_img_name);
				pstmt.setInt(5, cg_id);
				pstmt.setInt(6, p_num);
				
				int n = pstmt.executeUpdate();
				return n;
			}catch(SQLException s) {
				
				System.out.println(s.getMessage());
				return -1;
			}
		}
		public ArrayList<Product_category_vo> pro_cate_list(){
			
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			Product_category_vo vo =null;
			ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
			try {
				
				con = MyDBCP.getConnection();
				String sql = "select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.save_img_name,c.cg_name from product p , category c where p.cg_id=c.cg_id";
				pstmt =con .prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					vo = new Product_category_vo(rs.getInt("p_num") ,rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),rs.getInt("p_click_num"),
								rs.getDate("p_date"), rs.getString("save_img_name"), rs.getString("cg_name"));
					list.add(vo);
									
				}
				return list; 
			}catch(SQLException s) {
				s.getMessage();
				return null; 
			}
			
		}
		

		public ArrayList<Product_vo> pro_list(int cg_id){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> pro_list = new ArrayList<Product_vo>();
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
					pro_list.add(vo);
				}
				return pro_list;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> new_pro_list(int cg_id,int cg_id1){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> new_pro_list = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=? or cg_id=? order by p_date desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				pstmt.setInt(2, cg_id1);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					new_pro_list.add(vo);
				}
				return new_pro_list;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> low_pro_list(int cg_id,int cg_id1){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> low_pro_list = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=? or cg_id=? order by p_count asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				pstmt.setInt(2, cg_id1);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					low_pro_list.add(vo);
				}
				return low_pro_list;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> high_pro_list(int cg_id,int cg_id1){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> high_pro_list = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product where cg_id=? or cg_id=? order by p_count desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cg_id);
				pstmt.setInt(2, cg_id1);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					high_pro_list.add(vo);
				}
				return high_pro_list;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> list_all(int p_id){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> list_all = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select p.* from product p,category c where p.cg_id=c.cg_id and p_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					list_all.add(vo);
				}
				return list_all;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> new_list_all(int p_id){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> new_list_all = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select p.* from product p,category c where p.cg_id=c.cg_id and p_id=? order by p_date desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					new_list_all.add(vo);
				}
				return new_list_all;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> low_list_all(int p_id){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> low_list_all = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select p.* from product p,category c where p.cg_id=c.cg_id and p_id=? order by p_price asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					low_list_all.add(vo);
				}
				return low_list_all;
				
			}catch (SQLException s) {
				s.getMessage();
				return null;
				
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		public ArrayList<Product_vo> high_list_all(int p_id){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			ArrayList<Product_vo> high_list_all = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select p.* from product p,category c where p.cg_id=c.cg_id and p_id=? order by p_price desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					high_list_all.add(vo);
				}
				return high_list_all;
				
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
