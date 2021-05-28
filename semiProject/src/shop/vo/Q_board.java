package shop.vo;

import java.util.Date;

public class Q_board {

	private int q_b_num ;
	private String q_b_name ;
	private String q_b_title ;
	private String q_b_content ;
	private String q_b_pwd  ;
	private Date wr_date ;
	private String id   ;
	private int p_num  ;
	
	public Q_board() {}

	public Q_board(int q_b_num, String q_b_name, String q_b_title, String q_b_content, String q_b_pwd, Date wr_date,
			String id, int p_num) {
		super();
		this.q_b_num = q_b_num;
		this.q_b_name = q_b_name;
		this.q_b_title = q_b_title;
		this.q_b_content = q_b_content;
		this.q_b_pwd = q_b_pwd;
		this.wr_date = wr_date;
		this.id = id;
		this.p_num = p_num;
	}

	public int getQ_b_num() {
		return q_b_num;
	}

	public void setQ_b_num(int q_b_num) {
		this.q_b_num = q_b_num;
	}

	public String getQ_b_name() {
		return q_b_name;
	}

	public void setQ_b_name(String q_b_name) {
		this.q_b_name = q_b_name;
	}

	public String getQ_b_title() {
		return q_b_title;
	}

	public void setQ_b_title(String q_b_title) {
		this.q_b_title = q_b_title;
	}

	public String getQ_b_content() {
		return q_b_content;
	}

	public void setQ_b_content(String q_b_content) {
		this.q_b_content = q_b_content;
	}

	public String getQ_b_pwd() {
		return q_b_pwd;
	}

	public void setQ_b_pwd(String q_b_pwd) {
		this.q_b_pwd = q_b_pwd;
	}

	public Date getWr_date() {
		return wr_date;
	}

	public void setWr_date(Date wr_date) {
		this.wr_date = wr_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	
}
