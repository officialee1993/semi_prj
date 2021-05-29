package shop.vo;

import java.util.Date;

public class A_reply_vo {
	
	private int a_r_no;
	private String wr_id;
	private String a_r_content;
	private Date wr_date;
	private int a_b_num ; 
	
	public A_reply_vo() {}

	public A_reply_vo(int a_r_no, String wr_id, String a_r_content, Date wr_date, int a_b_num) {
		super();
		this.a_r_no = a_r_no;
		this.wr_id = wr_id;
		this.a_r_content = a_r_content;
		this.wr_date = wr_date;
		this.a_b_num = a_b_num;
	}

	public int getA_r_no() {
		return a_r_no;
	}

	public void setA_r_no(int a_r_no) {
		this.a_r_no = a_r_no;
	}

	public String getWr_id() {
		return wr_id;
	}

	public void setWr_id(String wr_id) {
		this.wr_id = wr_id;
	}

	public String getA_r_content() {
		return a_r_content;
	}

	public void setA_r_content(String a_r_content) {
		this.a_r_content = a_r_content;
	}

	public Date getWr_date() {
		return wr_date;
	}

	public void setWr_date(Date wr_date) {
		this.wr_date = wr_date;
	}

	public int getA_b_num() {
		return a_b_num;
	}

	public void setA_b_num(int a_b_num) {
		this.a_b_num = a_b_num;
	}
	

}
