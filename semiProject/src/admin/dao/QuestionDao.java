package admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shop.db.MyDBCP;
import shop.vo.Q_board_vo;

public class QuestionDao {

	public static QuestionDao instance=new QuestionDao();
	private QuestionDao() {}
	public static QuestionDao getinstance() {
		return instance;
	}

	public int getCount(String fieldCategory,String fieldState) {
		String sql="";
		
		if(fieldCategory==null||fieldCategory.equals("")||fieldCategory.equals("undefined")) {
			fieldCategory=null;
		}
		if(fieldState==null||fieldState.equals("")||fieldState.equals("undefined")) {
			fieldState=null;
		}
		
		if(fieldCategory!=null && fieldState==null) {
			sql="select NVL(count(q_b_num),0) from q_board where q_b_category='"+fieldCategory+"'";
		}else if(fieldState!=null && fieldCategory==null ) {
			sql="select NVL(count(q_b_num),0) from q_board where q_b_state='"+fieldState+"'";
		}else if(fieldCategory!=null && fieldState!=null ) {
			sql="select NVL(count(q_b_num),0) from q_board where q_b_category='"+fieldCategory+"' and q_b_state='"+fieldState+"'";
		}else if(fieldCategory==null && fieldState==null) {
			sql="select NVL(count(q_b_num),0) from q_board";
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
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
	

	/*문의사항 답변*/
	public int adminAnswer(int qnum,String answer) {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;

		try {
			con=MyDBCP.getConnection();
			con.setAutoCommit(false);
			String sql1="update q_a set q_a_content=?, q_a_date=sysdate where q_a_num=?";
			String sql2="update q_board set q_b_state='답변완료' where q_b_num=?";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, answer);
			pstmt1.setInt(2, qnum);
			pstmt1.executeUpdate();
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, qnum);
			int n=pstmt2.executeUpdate();
			con.commit();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			MyDBCP.close(pstmt2);
			MyDBCP.close(pstmt1);
			MyDBCP.close(con);
		}
	}
	
	/*문의사항 상세보기*/
	public ArrayList<Q_board_vo> adminQDetail(int qnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			String sql="select * from q_board q"
					+ " join product p"
					+ " on q.p_num=p.p_num"
					+ " join q_a a"
					+ " on q.q_b_num=a.q_a_num"
					+ " join storages s"
					+ " on q.p_num=s.p_num"
					+ " where q_b_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			rs=pstmt.executeQuery();
			ArrayList<Q_board_vo> list=new ArrayList<Q_board_vo>();
			while(rs.next()) {
				Q_board_vo vo=new Q_board_vo(
						rs.getInt("q_b_num"),
						rs.getString("id"),
						rs.getString("q_b_category"),
						rs.getString("q_b_title"),
						rs.getString("q_b_content"),
						rs.getString("q_b__pwd"),
						rs.getDate("wr_date"),
						rs.getString("q_b_state"),
						rs.getInt("p_num"),
						rs.getString("p_name"),
						rs.getInt("p_count"),
						rs.getInt("p_price"),
						rs.getString("ori_img_name"),
						rs.getString("save_img_name"),
						rs.getInt("cg_id"),
						rs.getString("q_a_content"),
						rs.getDate("q_a_date"),
						rs.getInt("s_count"),
						rs.getString("p_size")
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
	
	/*문의사항 조회*/
	public ArrayList<Q_board_vo> adminQList(String fieldCategory,String fieldState,int startRow,int endRow) {

		if(fieldCategory==null||fieldCategory.equals("")||fieldCategory.equals("undefined")) {
			fieldCategory=null;
		}
		if(fieldState==null||fieldState.equals("")||fieldState.equals("undefined")) {
			fieldState=null;
		}
		String sql="";
		if(fieldCategory!=null && fieldState==null) {
			sql="select * from ("
					+ " select q.*,rownum rnum from("
					+ " select * from q_board where q_b_category='"+fieldCategory+"' order by wr_date desc) q)"
					+ " where rnum>="+startRow+" and rnum<="+endRow;
		}else if(fieldState!=null && fieldCategory==null ) {
			sql="select * from ("
					+ " select q.*,rownum rnum from("
					+ " select * from q_board where q_b_state='"+fieldState+"' order by wr_date desc) q)"
					+ " where rnum>="+startRow+" and rnum<="+endRow;
		}else if(fieldCategory!=null && fieldState!=null ) {
			sql="select * from ("
					+ " select q.*,rownum rnum from("
					+ " select * from q_board where q_b_state='"+fieldState+"' and q_b_category='"+fieldCategory+"' order by wr_date desc) q)"
					+ " where rnum>="+startRow+" and rnum<="+endRow;
		}else if(fieldCategory==null && fieldState==null) {
			sql="select * from("
					+ " select q.*,rownum rnum from("
					+ " select * from q_board order by wr_date desc) q)"
					+ " where rnum>="+startRow+" and rnum<="+endRow;
		}
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=MyDBCP.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			ArrayList<Q_board_vo> list=new ArrayList<Q_board_vo>();
			while(rs.next()) {
				int qnum=rs.getInt("q_b_num");
				String id=rs.getString("id");
				String category=rs.getString("q_b_category");
				String q_b_title=rs.getString("q_b_title");
				String q_b_content=rs.getString("q_b_content");
				String pwd=rs.getString("q_b__pwd");
				Date wr_date=rs.getDate("wr_date");
				String state=rs.getString("q_b_state");
				int pnum=rs.getInt("p_num");
				Q_board_vo vo=new Q_board_vo(qnum,id,category,q_b_title,q_b_content,pwd,wr_date,state,pnum);
				list.add(vo);
				}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			MyDBCP.close(con,stmt,rs);
		}
		
	}
	
}
