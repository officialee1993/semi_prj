package shop.vo;

import java.sql.Date;

public class CommentsVo {
	private int q_num;
	private String id;
	private String category;
	private String q_title;
	private String q_content;
	private Date q_date;
	private String a_title;
	private String a_content;
	private Date a_date;
	
	public CommentsVo(){}

	public CommentsVo(int q_num,String id, String category, String q_title, String q_content, Date q_date, String a_title,
			String a_content, Date a_date) {
		this.q_num = q_num;
		this.id = id;
		this.category = category;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.a_title = a_title;
		this.a_content = a_content;
		this.a_date = a_date;
	}


	
	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public Date getQ_date() {
		return q_date;
	}

	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public String getA_content() {
		return a_content;
	}

	public void setA_content(String a_content) {
		this.a_content = a_content;
	}

	public Date getA_date() {
		return a_date;
	}

	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	
	
	
}
