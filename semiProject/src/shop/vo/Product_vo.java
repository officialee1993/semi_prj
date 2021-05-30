package shop.vo;

import java.util.Date;

public class Product_vo {

	private int p_num ;
	private String p_name ;
	private int p_count ;
	private int p_price ;
	private int p_click_num ;
	private Date p_date ;
	private String ori_img_name ;
	private String save_img_name  ;
	private String cg_name ; 
	
	public Product_vo() {}

	public Product_vo(int p_num, String p_name, int p_count, int p_price, int p_click_num, Date p_date,
			String ori_img_name, String save_img_name, String cg_name) {
		super();
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_count = p_count;
		this.p_price = p_price;
		this.p_click_num = p_click_num;
		this.p_date = p_date;
		this.ori_img_name = ori_img_name;
		this.save_img_name = save_img_name;
		this.cg_name = cg_name;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_click_num() {
		return p_click_num;
	}

	public void setP_click_num(int p_click_num) {
		this.p_click_num = p_click_num;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public String getOri_img_name() {
		return ori_img_name;
	}

	public void setOri_img_name(String ori_img_name) {
		this.ori_img_name = ori_img_name;
	}

	public String getSave_img_name() {
		return save_img_name;
	}

	public void setSave_img_name(String save_img_name) {
		this.save_img_name = save_img_name;
	}

	public String getCg_name() {
		return cg_name;
	}

	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}
	
	
	
}
