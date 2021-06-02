package shop.vo;

import java.sql.Date;

public class Q_board_vo {
	private int q_b_num;
	private String id;
	private String q_b_category;
	private String q_b_title;
	private String q_b_content;
	private String q_b__pwd;
	private Date wr_date;
	private String q_b_state;
	private int p_num;
	
	public Q_board_vo() {}
	
	public Q_board_vo(int q_b_num, String id, String q_b_category, String q_b_title, String q_b_content,
			String q_b__pwd, Date wr_date, String q_b_state, int p_num) {
		super();
		this.q_b_num = q_b_num;
		this.id = id;
		this.q_b_category = q_b_category;
		this.q_b_title = q_b_title;
		this.q_b_content = q_b_content;
		this.q_b__pwd = q_b__pwd;
		this.wr_date = wr_date;
		this.q_b_state = q_b_state;
		this.p_num = p_num;
	}

	public String getQ_b_state() {
		return q_b_state;
	}

	public void setQ_b_state(String q_b_state) {
		this.q_b_state = q_b_state;
	}

	public int getQ_b_num() {
		return q_b_num;
	}

	public void setQ_b_num(int q_b_num) {
		this.q_b_num = q_b_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQ_b_category() {
		return q_b_category;
	}

	public void setQ_b_category(String q_b_category) {
		this.q_b_category = q_b_category;
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

	public String getQ_b__pwd() {
		return q_b__pwd;
	}

	public void setQ_b__pwd(String q_b__pwd) {
		this.q_b__pwd = q_b__pwd;
	}

	public Date getWr_date() {
		return wr_date;
	}

	public void setWr_date(Date wr_date) {
		this.wr_date = wr_date;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	
	
	
}
