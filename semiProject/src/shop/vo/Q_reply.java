package shop.vo;

import java.util.Date;

public class Q_reply {
	
	private int q_r_num  ;
	private String wr_id  ;
	private String q_r_content  ;
	private Date wr_date  ;
	private int q_b_num   ;
	
	public Q_reply() {}

	public Q_reply(int q_r_num, String wr_id, String q_r_content, Date wr_date, int q_b_num) {
		super();
		this.q_r_num = q_r_num;
		this.wr_id = wr_id;
		this.q_r_content = q_r_content;
		this.wr_date = wr_date;
		this.q_b_num = q_b_num;
	}

	public int getQ_r_num() {
		return q_r_num;
	}

	public void setQ_r_num(int q_r_num) {
		this.q_r_num = q_r_num;
	}

	public String getWr_id() {
		return wr_id;
	}

	public void setWr_id(String wr_id) {
		this.wr_id = wr_id;
	}

	public String getQ_r_content() {
		return q_r_content;
	}

	public void setQ_r_content(String q_r_content) {
		this.q_r_content = q_r_content;
	}

	public Date getWr_date() {
		return wr_date;
	}

	public void setWr_date(Date wr_date) {
		this.wr_date = wr_date;
	}

	public int getQ_b_num() {
		return q_b_num;
	}

	public void setQ_b_num(int q_b_num) {
		this.q_b_num = q_b_num;
	}
	
}
