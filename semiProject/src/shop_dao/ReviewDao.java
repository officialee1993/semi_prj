package shop_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.A_board_vo;


public class ReviewDao {
	
	private static ReviewDao instance=new ReviewDao();
	private ReviewDao() {};
	public static ReviewDao getinstance() {
		return instance;
	}

	
	/*댓글 가져오기*/
	public ArrayList<A_board_vo> replyList(int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from("
				+ " select * from("
				+ " select r.* from a_board a"
				+ " join a_reply r"
				+ " on a.a_b_num=r.a_b_num)"
				+ " where a_b_num=?)"
				+ " order by wr_date desc";
		try {
			con=MyDBCP.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			ArrayList<A_board_vo> list=new ArrayList<A_board_vo>();
			while(rs.next()) {
				A_board_vo vo=new A_board_vo(
						rs.getInt("a_r_no"),
						rs.getString("wr_id"),
						rs.getString("a_r_content"),
						rs.getDate("wr_date"),
						rs.getInt("a_b_num")
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
	
	
	/*댓글 입력하기*/
	public int replyInsert(String id,String content,int num) {
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			con=MyDBCP.getConnection();
			String sql="insert into a_reply values(a_reply_seq.nextval,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con,pstmt,null);
		}
	}
	
	/*상품페이지 후기불러오기*/
	public ArrayList<A_board_vo> goodsReviewList(int p_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			System.out.println("test1");
			con=MyDBCP.getConnection();
			String sql="select * from("
					+ " select * from a_board a"
					+ " join orders o"
					+ " on a.o_num=o.o_num"
					+ " where o.p_num=?)"
					+ " order by wr_date desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, p_num);
			rs=pstmt.executeQuery();
			System.out.println("test2");
			ArrayList<A_board_vo> list=new ArrayList<A_board_vo>();
			while(rs.next()) {
				System.out.println("test3");
				String content=rs.getString("a_b_content");
				String id=rs.getString("wr_id");
				int a_b_num=rs.getInt("a_b_num");
				Date wr_date=rs.getDate("wr_date");
				A_board_vo vo=new A_board_vo(content,id,a_b_num,wr_date);
				
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
	
	/*마이페이지 리뷰상세보기*/
	public ArrayList<A_board_vo> myReviewDetail(int a_b_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			String sql="select b.a_b_num b_a_num,b.a_b_title btitle,b.a_b_content bcontent,b.wr_id bid,b.wr_date bdate,b.o_num b_onum,"
					+ " r.a_r_no rnum,r.wr_id rid,r.a_r_content rcontent,r.wr_date rdate,r.a_b_num r_a_num"
					+ " from a_board b"
					+ " join a_reply r"
					+ " on b.a_b_num=r.a_b_num"
					+ " where r.a_b_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, a_b_num);
			rs=pstmt.executeQuery();
			ArrayList<A_board_vo> list=new ArrayList<A_board_vo>();
			while(rs.next()) {
				A_board_vo vo=new A_board_vo(
						rs.getInt("b_a_num"),
						rs.getString("btitle"),
						rs.getString("bcontent"),
						rs.getString("bid"),
						rs.getDate("bdate"),
						rs.getInt("b_onum"),
						rs.getInt("rnum"),
						rs.getString("rid"),
						rs.getString("rcontent"),
						rs.getDate("rdate"),
						rs.getInt("r_a_num")
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
	
	/*마이페이지 리뷰리스트 불러오기*/
	public ArrayList<A_board_vo> myReviewList(String id){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			String sql="select * from a_board where wr_id=? order by wr_date desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			ArrayList<A_board_vo> list=new ArrayList<A_board_vo>();
			while(rs.next()) {
				A_board_vo vo=new A_board_vo(
						rs.getInt("a_b_num"),
						rs.getString("a_b_title"),
						rs.getString("a_b_content"),
						rs.getString("wr_id"),
						rs.getDate("wr_date"),
						rs.getInt("o_num")
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
	
	/*리뷰작성*/
	public int reviewInsert(String title,String content,int o_num) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		try {
			con = MyDBCP.getConnection();
			String sql="update a_board set a_b_title=?,a_b_content=?,wr_date=sysdate where o_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, o_num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(con,pstmt,null);
		}
		
	}
	
}
