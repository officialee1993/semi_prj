package shop.vo;

import java.util.Date;

public class A_board_vo {

	private int a_b_num;
	private String a_b_name;
	private String a_b_title;
	private String a_b_content;
	private String wr_id;
	private Date wr_date;
	private int o_num; 
	private int p_num;
	
	public A_board_vo() {}
	
	public A_board_vo(int a_b_num, String a_b_name, String a_b_title, String a_b_content, String wr_id, Date wr_date,
			int o_num, int p_num) {
		super();
		this.a_b_num = a_b_num;
		this.a_b_name = a_b_name;
		this.a_b_title = a_b_title;
		this.a_b_content = a_b_content;
		this.wr_id = wr_id;
		this.wr_date = wr_date;
		this.o_num = o_num;
		this.p_num = p_num;
	}

	public int getA_b_num() {
		return a_b_num;
	}
	public void setA_b_num(int a_b_num) {
		this.a_b_num = a_b_num;
	}
	public String getA_b_name() {
		return a_b_name;
	}
	public void setA_b_name(String a_b_name) {
		this.a_b_name = a_b_name;
	}
	public String getA_b_title() {
		return a_b_title;
	}
	public void setA_b_title(String a_b_title) {
		this.a_b_title = a_b_title;
	}
	public String getA_b_content() {
		return a_b_content;
	}
	public void setA_b_content(String a_b_content) {
		this.a_b_content = a_b_content;
	}
	public String getWr_id() {
		return wr_id;
	}
	public void setWr_id(String wr_id) {
		this.wr_id = wr_id;
	}
	public Date getWr_date() {
		return wr_date;
	}
	public void setWr_date(Date wr_date) {
		this.wr_date = wr_date;
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	} 
	
}
