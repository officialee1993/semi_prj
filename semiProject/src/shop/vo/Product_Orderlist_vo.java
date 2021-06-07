package shop.vo;

import java.util.Date;

public class Product_Orderlist_vo {
	private int p_num;
	private String p_name;
	private String save_img_name;
	private int o_num;
	private int all_sum_price;
	private Date o_date;
	private String o_state;
	private String id;
	private int a_b_num;
	private String a_b_content;
	
	public Product_Orderlist_vo() {}

	public Product_Orderlist_vo(int p_num, String p_name, String save_img_name, int o_num, int all_sum_price,
			Date o_date, String o_state, String id, int a_b_num, String a_b_content) {
		super();
		this.p_num = p_num;
		this.p_name = p_name;
		this.save_img_name = save_img_name;
		this.o_num = o_num;
		this.all_sum_price = all_sum_price;
		this.o_date = o_date;
		this.o_state = o_state;
		this.id = id;
		this.a_b_num = a_b_num;
		this.a_b_content = a_b_content;
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

	public String getSave_img_name() {
		return save_img_name;
	}

	public void setSave_img_name(String save_img_name) {
		this.save_img_name = save_img_name;
	}

	public int getO_num() {
		return o_num;
	}

	public void setO_num(int o_num) {
		this.o_num = o_num;
	}

	public int getAll_sum_price() {
		return all_sum_price;
	}

	public void setAll_sum_price(int all_sum_price) {
		this.all_sum_price = all_sum_price;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public String getO_state() {
		return o_state;
	}

	public void setO_state(String o_state) {
		this.o_state = o_state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getA_b_num() {
		return a_b_num;
	}

	public void setA_b_num(int a_b_num) {
		this.a_b_num = a_b_num;
	}

	public String getA_b_content() {
		return a_b_content;
	}

	public void setA_b_content(String a_b_content) {
		this.a_b_content = a_b_content;
	};
	
	



	
}
