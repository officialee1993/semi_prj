package shop.vo;

import java.util.Date;

public class Q_A {

	private int q_a_num ;
	private String q_a_title ;
	private String q_a_content  ;
	private Date q_a_date  ;
	
	public Q_A() {}

	public Q_A(int q_a_num, String q_a_title, String q_a_content, Date q_a_date) {
		super();
		this.q_a_num = q_a_num;
		this.q_a_title = q_a_title;
		this.q_a_content = q_a_content;
		this.q_a_date = q_a_date;
	}

	public int getQ_a_num() {
		return q_a_num;
	}

	public void setQ_a_num(int q_a_num) {
		this.q_a_num = q_a_num;
	}

	public String getQ_a_title() {
		return q_a_title;
	}

	public void setQ_a_title(String q_a_title) {
		this.q_a_title = q_a_title;
	}

	public String getQ_a_content() {
		return q_a_content;
	}

	public void setQ_a_content(String q_a_content) {
		this.q_a_content = q_a_content;
	}

	public Date getQ_a_date() {
		return q_a_date;
	}

	public void setQ_a_date(Date q_a_date) {
		this.q_a_date = q_a_date;
	}
	
}
