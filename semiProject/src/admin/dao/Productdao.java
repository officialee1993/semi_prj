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
import shop.vo.pro_cate_storage_list_vo;
import shop.vo.product_add_p_size_vo;
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
				String sql = "select * from category c , product p, Storages s where p.cg_id=c.cg_id and s.p_num=p.p_num and  p_id =?";
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
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
			
		}
		
		public ArrayList<product_add_p_size_vo> admin_sex_pro_size_list(String p_id,int startRow,int endRow ){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList<product_add_p_size_vo> admin_sex_product_list = new ArrayList<product_add_p_size_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from(\r\n"
						+ "select admin_sex_pro_size_list.*,rownum rnum from \r\n"
						+ "(select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.ori_img_name,p.save_img_name,p.cg_id,s.p_size,s.s_count \r\n"
						+ "from category c , product p, Storages s \r\n"
						+ "where p.cg_id=c.cg_id and s.p_num=p.p_num and  p_id =? order by p.p_num desc) admin_sex_pro_size_list) where rnum>=? and rnum<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_id);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					product_add_p_size_vo vo = new product_add_p_size_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"),rs.getString("p_size"),rs.getInt("s_count"));
					admin_sex_product_list.add(vo);
				}
				return admin_sex_product_list;
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return null; 
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
			
		}
		public int admin_sex_pro_size_list_getCount(String p_id) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=MyDBCP.getConnection();
				String sql="select NVL(count(*),0) from (  \r\n"
						+ "select * from category c , product p, Storages s where p.cg_id=c.cg_id and s.p_num=p.p_num and  p_id =?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, p_id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					int n=rs.getInt(1);
					return n;
				}
				return -1;
			}catch(SQLException se) {
				se.printStackTrace();
				return -1;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
	}
		
		public ArrayList<product_add_p_size_vo> admin_all_product_select (String p_name,int startRow,int endRow){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< product_add_p_size_vo> admin_all_product_select = new ArrayList<product_add_p_size_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from\r\n"
						+ "(select admin_all_product_select.*,rownum rnum from\r\n"
						+ "(select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.ori_img_name,p.save_img_name,p.cg_id,s.p_size,s.s_count  \r\n"
						+ "from product p , Storages s  \r\n"
						+ "where  s.p_num=p.p_num and p.p_name like '%'||?||'%' order by p.p_num desc)admin_all_product_select) where rnum>=? and rnum<=? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_name);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					product_add_p_size_vo vo = new product_add_p_size_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"),rs.getString("p_size"),rs.getInt("s_count"));
					admin_all_product_select.add(vo);
				}
				return admin_all_product_select;
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return null; 
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
			
		}
		public int admin_all_product_select_getCount(String p_name) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=MyDBCP.getConnection();
				String sql="select NVL(count(*),0) from (  \r\n"
						+ "select * from product p , Storages s  where  s.p_num=p.p_num and p.p_name like '%'||?||'%')";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, p_name);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					int n=rs.getInt(1);
					return n;
				}
				return -1;
			}catch(SQLException se) {
				se.printStackTrace();
				return -1;
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
	}
		public ArrayList<Product_vo> list_product (String p_name){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< Product_vo> list_product = new ArrayList<Product_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from product p  where  p.p_name like '%'||?||'%' order by p_date desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_name);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					Product_vo vo = new Product_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"));
					list_product.add(vo);
				}
				return list_product;
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return null; 
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
		}
		
		public ArrayList<product_add_p_size_vo> admin_product_select (String cg_name , String p_name,int startRow,int endRow){
			
			Connection con = null;
			PreparedStatement pstmt = null; 
			ResultSet rs= null; 
			ArrayList< product_add_p_size_vo> admin_product_select = new ArrayList<product_add_p_size_vo>();
			try {
				con = MyDBCP.getConnection();
				String sql = "select * from\r\n"
						+ "(select admin_all_product_select.*,rownum rnum from\r\n"
						+ "(select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.ori_img_name,p.save_img_name,p.cg_id,s.p_size,s.s_count  \r\n"
						+ "from product p ,category c , Storages s where s.p_num=p.p_num and p.cg_id = c.cg_id and c.cg_name=? and p.p_name like '%'||?||'%' order by p.p_num desc)admin_all_product_select) "
						+ "where rnum>=? and rnum<=?  ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cg_name);
				pstmt.setString(2, p_name);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					product_add_p_size_vo vo = new product_add_p_size_vo(rs.getInt("p_num"),rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),
							rs.getInt("p_click_num"), rs.getDate("p_date"),
							rs.getString("ori_img_name"), rs.getString("save_img_name"), rs.getInt("cg_id"),rs.getString("p_size"),rs.getInt("s_count"));
					admin_product_select.add(vo);
				}
				return admin_product_select;
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return null; 
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
			
		}
		public int admin_product_select_getCount(String ct_gory,String search) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=MyDBCP.getConnection();
				String sql="select nvl(count(*),0)from(\r\n"
						+ "select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.ori_img_name,p.save_img_name,p.cg_id,s.p_size,s.s_count   \r\n"
						+ "from product p ,category c , Storages s \r\n"
						+ "where s.p_num=p.p_num and p.cg_id = c.cg_id and c.cg_name=? and p.p_name like '%'||?||'%' order by p.p_num desc)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ct_gory);
				pstmt.setString(2, search);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					int n=rs.getInt(1);
					return n;
				}
				return -1;
			}catch(SQLException se) {
				se.printStackTrace();
				return -1;
			}finally {
				MyDBCP.close(con, pstmt, rs);
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

		
		public int product_storages_delete(int p_num, String p_size) {
			
			Connection con =null; 
			PreparedStatement pstmt = null; 
			try {
				con = MyDBCP.getConnection();
				String sql = "delete from storages where p_num =? and p_size=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_num);
				pstmt.setString(2, p_size);
				int n = pstmt.executeUpdate();
				
				return n ; 
				
			}catch (SQLException s) {
				System.out.println(s.getMessage());
				return -1; 
			}finally {
				MyDBCP.close(con, pstmt, null);
			}
		}
		
		public int product_delete(int p_num) {
			
			Connection con =null; 
			PreparedStatement pstmt = null; 
			try {
				con = MyDBCP.getConnection();
				String sql = "delete from product where p_num =? ";
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
			}finally {
				MyDBCP.close(con, pstmt, null);
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
			}finally {
				MyDBCP.close(con, pstmt, null);
			}
		}
		
		public int pro_cate_list_getCount() {
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			try{
				con = MyDBCP.getConnection();
				String sql = "select NVL(count(*),0) from\r\n"
						+ "(select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.save_img_name,c.cg_name,s.s_count,s.p_size\r\n"
						+ "from product p , category c, storages s where p.cg_id=c.cg_id and s.p_num = p.p_num)";
				pstmt = con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					int n = rs.getInt(1);
					return n ; 
				}
				return -1; 
				
			}catch(SQLException s) {
				s.getMessage();
				return -1; 
			}finally {
				MyDBCP.close(con, pstmt, rs);
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
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
			
		}
		public ArrayList<Product_category_vo> pro_cate_list(int startRow, int endRow){
			
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			Product_category_vo vo =null;
			ArrayList<Product_category_vo> list = new ArrayList<Product_category_vo>();
			try {
				
				con = MyDBCP.getConnection();
				String sql = "select * from (select pro_cate_list.*, rownum rnum from (select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.save_img_name,c.cg_name "
						+ "from product p , category c where p.cg_id=c.cg_id order by p_num desc)pro_cate_list)where rnum>=? and rnum<=?";
				pstmt =con .prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
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
			}finally {
				MyDBCP.close(con, pstmt, rs);
			}
			
		}
		public ArrayList<pro_cate_storage_list_vo> pro_cate_storage_list(int startRow, int endRow){
			
			Connection con = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			pro_cate_storage_list_vo vo =null;
			ArrayList<pro_cate_storage_list_vo> list = new ArrayList<pro_cate_storage_list_vo>();
			try {
				
				con = MyDBCP.getConnection();
				String sql = "select * from (select pro_cate_list.*, rownum rnum from \r\n"
						+ "(select p.p_num,p.p_name,p.p_count,p.p_price,p.p_click_num,p.p_date,p.save_img_name,c.cg_name,s.s_count,s.p_size\r\n"
						+ "from product p , category c, storages s where p.cg_id=c.cg_id and s.p_num = p.p_num order by p_num desc)pro_cate_list)where rnum>=? and rnum<=?";
				pstmt =con .prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					vo = new pro_cate_storage_list_vo(rs.getInt("p_num") ,rs.getString("p_name"), rs.getInt("p_count"), rs.getInt("p_price"),rs.getInt("p_click_num"),
								rs.getDate("p_date"), rs.getString("save_img_name"), rs.getString("cg_name"),rs.getInt("s_count"),rs.getString("p_size"));
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
			PreparedStatement pstmt1= null; 
			PreparedStatement pstmt2= null; 
			PreparedStatement pstmt3= null; 
			try {
				
				System.out.println(vo.getP_name()+"/ "+vo.getP_count()+"/"+vo.getP_price()+"/"+vo.getP_click_num()+"/"+vo.getOri_img_name()+"/"+vo.getSave_img_name()+"/"+vo.getCg_id());
				con = MyDBCP.getConnection();
				String sql = "insert into product values(product_seq.nextval,?,?,?,?,sysdate,?,?,?)";
				String sql1 = "insert into storages(s_num,s_count,p_size,p_num) values(storages_seq.nextval,?,'M',product_seq.currval)";
				String sql2 = "insert into storages(s_num,s_count,p_size,p_num) values(storages_seq.nextval,?,'L',product_seq.currval)";
				String sql3 = "insert into storages(s_num,s_count,p_size,p_num) values(storages_seq.nextval,?,'XL',product_seq.currval)";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, vo.getP_name());
				pstmt.setInt(2,	vo.getP_count());
				pstmt.setInt(3,	vo.getP_price());
				pstmt.setInt(4,	vo.getP_click_num());
				pstmt.setString(5,	vo.getOri_img_name());
				pstmt.setString(6,	vo.getSave_img_name());
				pstmt.setInt(7,	vo.getCg_id());
				pstmt.executeUpdate();
				
				pstmt1 = con.prepareStatement(sql1);
				pstmt1.setInt(1, vo.getP_count());
				pstmt1.executeUpdate();
				
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, vo.getP_count());
				pstmt2.executeUpdate();
				
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setInt(1, vo.getP_count());
				int n = pstmt3.executeUpdate();
				
				return n ; 
				
			}catch(SQLException s) {
				System.out.println(s.getMessage());
				return -1;
			}finally {
				MyDBCP.close(con, pstmt3, null);
				
			}
		}
}
