package shop_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.CommentsVo;
import shop.vo.Q_board_vo;


public class QuestionDao {
	private static QuestionDao instance= new QuestionDao();
	private QuestionDao() {};
	public static QuestionDao getinstance() {
		return instance;
	}
	/*문의상세 페이지 비밀번호 전달받아서 폼 엘리먼트 노출*/
	public int questionDetail_pwd(int qnum,String pwd) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql="select * from("
				+ " select q.q_b_num q_num,q.q_b__pwd pwd from product p"
				+ " join Q_board q"
				+ " on p.p_num=q.p_num"
				+ " join q_a a"
				+ " on q.q_b_num=a.q_a_num)"
				+ " where q_num=? and pwd=?";
		try {
			con=MyDBCP.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("dao:1");
				return 1;
			}
			return -1;
		}catch (SQLException s) {
			s.getMessage();
			return -1;
		}finally {
			MyDBCP.close(con,pstmt,rs);
		}
	}
	
	
	/*문의사항 번호 받아서 데이터 받기*/
	public CommentsVo questionDetail(int qnum) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql="select * from("
				+ " select q.q_b_num q_num,q.id id,q.q_b_category category,q.q_b_title q_title,q.q_b_content q_content,q.wr_date q_date,a.q_a_title a_title,a.q_a_content a_content,a.q_a_date a_date from product p"
				+ " join Q_board q"
				+ " on p.p_num=q.p_num"
				+ " join q_a a"
				+ " on q.q_b_num=a.q_a_num)"
				+ " where q_num=?";
		try {
			con=MyDBCP.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			rs=pstmt.executeQuery();
			rs.next();
			CommentsVo vo=new CommentsVo(
						rs.getInt("q_num"),
						rs.getString("id"),
						rs.getString("category"),
						rs.getString("q_title"),
						rs.getString("q_content"),
						rs.getDate("q_date"),
						rs.getString("a_title"),
						rs.getString("a_content"),
						rs.getDate("a_date")
					);
			return vo;
		}catch (SQLException s) {
			s.getMessage();
			return null;
		}finally {
			MyDBCP.close(con,pstmt,rs);
		}
	}
	//전체 문의사항 갯수 얻어오기
	public int getCount(int p_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			String sql="select NVL(count(q.q_b_num),0) from q_board q"
					+ " join product p "
					+ " on q.p_num=p.p_num"
					+ " where p.p_num=?";//새글이 등록되기 전에는 max(num)이 null이기 때문에 0으로 치환한다는 NVL 
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, p_num);
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
	
	/*문의사항 리스트 불러오기(상품상세페이지)*/
	public ArrayList<CommentsVo> questionList(int p_num,int startRow,int endRow) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql="select * from ("
				+ " select qlist.*, rownum rnum from("
				+ " select q.q_b_num q_num,q.id id,q.q_b_category category,q.q_b_title q_title,q.q_b_content q_content,q.wr_date q_date,a.q_a_title a_title,a.q_a_content a_content,a.q_a_date a_date from product p"
				+ " join Q_board q"
				+ " on p.p_num=q.p_num"
				+ " join q_a a"
				+ " on q.q_b_num=a.q_a_num"
				+ " where p.p_num=? order by q_date desc) qlist)"
				+ " where rnum>=? and rnum<=?";
		try {
			con=MyDBCP.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, p_num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs=pstmt.executeQuery();
			ArrayList<CommentsVo> list=new ArrayList<CommentsVo>();
			while(rs.next()) {
				CommentsVo vo=new CommentsVo(
						rs.getInt("q_num"),
						rs.getString("id"),
						rs.getString("category"),
						rs.getString("q_title"),
						rs.getString("q_content"),
						rs.getDate("q_date"),
						rs.getString("a_title"),
						rs.getString("a_content"),
						rs.getDate("a_date")
						);
				list.add(vo);
			}
			return list;
		}catch (SQLException s) {
			s.getMessage();
			return null;
		}finally {
			MyDBCP.close(con,pstmt,rs);
		}
	}
	
	/*문의사항 등록*/
	public int questionInsert(Q_board_vo vo) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		Statement stmt=null;

		String sql1="insert into Q_board(q_b_num,id,q_b_category,q_b_title,q_b_content,q_b__pwd,wr_date,p_num) values(q_board_seq.nextval,?,?,?,?,?,sysdate,?)";
		String sql2="insert into q_a(q_a_num) values(q_board_seq.currval)";
		try {
			System.out.println("start");
			con=MyDBCP.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getQ_b_category());
			pstmt.setString(3, vo.getQ_b_title());
			pstmt.setString(4, vo.getQ_b_content());
			pstmt.setString(5, vo.getQ_b__pwd());
			pstmt.setInt(6, vo.getP_num());
			int qboard=pstmt.executeUpdate();
			
			System.out.println("qboard="+qboard);
			
			stmt=con.createStatement();
			int n=stmt.executeUpdate(sql2);
			con.commit();
			
			return n;
			
		}catch (SQLException s) {
			s.getMessage();
			try {
				con.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			return -1;
		}finally {
			MyDBCP.close(stmt);
			MyDBCP.close(pstmt);
			MyDBCP.close(con);
		}
	}
	
}