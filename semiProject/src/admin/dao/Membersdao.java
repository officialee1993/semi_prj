package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.Members_vo;

public class Membersdao {
	
	private static Membersdao instance = new Membersdao();
	private Membersdao() {}
	public static Membersdao getinstance() {
		return instance;
	}
	
	public int getCount(String field,String keyword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyDBCP.getConnection();
			String sql = "select count(*) from members";
			if(field!=null && !field.equals("")) {
				sql += " where " +field+ " like '%" +keyword+ "%'";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int n = rs.getInt(1);
				return n;
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<Members_vo> list(int startRow,int endRow,String field,String keyword){
		String sql=null;
		if(field==null || field.equals("")) {
			sql = "select * from("
					+ " select a.*,rownum rnum from ("
					+ " select * from members order by id desc) a)"
					+ " where rnum>=? and rnum<=?";
		}else {
			sql = "select * from ("
					+ " select o.*,rownum rnum from ("
					+ " select * from members where "+field+" like '%"+keyword+"%' order by id desc) o)"
					+ " where rnum>=? and rnum<=?";
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyDBCP.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<Members_vo> list = new ArrayList<Members_vo>();
			while(rs.next()) {
				Members_vo vo = new Members_vo(
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("address"));
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}
	
	public int del_members(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MyDBCP.getConnection();
			String sql = "delete from members where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int n = pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con, pstmt, null);
		}
	}
	
	public ArrayList<Members_vo> all_members() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Members_vo> list = new ArrayList<Members_vo>();
		try {
			con = MyDBCP.getConnection();
			String sql = "select * from members";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Members_vo vo = new Members_vo(rs.getString("id"),rs.getString("pwd"),
												rs.getString("name"),rs.getString("phone"),
												rs.getString("email"),rs.getString("address"));
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
	
	/*admin login*/
	public Members_vo adminLogin(String id,String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyDBCP.getConnection();
			String sql = "select * from members"
					+ " where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Members_vo vo=new Members_vo(
						rs.getString("id"),
						rs.getString("pwd"),
						null,
						null,
						null,
						null
						);
				return vo;
			}
			return null;
		}catch (SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			MyDBCP.close(con, pstmt, rs);
		}
	}
	
	
}
