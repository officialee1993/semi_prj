package shop.vo;

import java.util.Date;

public class Orders {
	private int o_num ;
	private String rec_name ;
	private String rec_phone ;
	private String rec_addr ;
	private int all_sum_price ; 
	private String payname ;
	private Date o_date ;
	private String o_state  ;
	private String id  ;
	private int p_num ;
	private int b_num  ;
	
	public Orders () {}

	public Orders(int o_num, String rec_name, String rec_phone, String rec_addr, int all_sum_price, String payname,
			Date o_date, String o_state, String id, int p_num, int b_num) {
		super();
		this.o_num = o_num;
		this.rec_name = rec_name;
		this.rec_phone = rec_phone;
		this.rec_addr = rec_addr;
		this.all_sum_price = all_sum_price;
		this.payname = payname;
		this.o_date = o_date;
		this.o_state = o_state;
		this.id = id;
		this.p_num = p_num;
		this.b_num = b_num;
	}

	public int getO_num() {
		return o_num;
	}

	public void setO_num(int o_num) {
		this.o_num = o_num;
	}

	public String getRec_name() {
		return rec_name;
	}

	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}

	public String getRec_phone() {
		return rec_phone;
	}

	public void setRec_phone(String rec_phone) {
		this.rec_phone = rec_phone;
	}

	public String getRec_addr() {
		return rec_addr;
	}

	public void setRec_addr(String rec_addr) {
		this.rec_addr = rec_addr;
	}

	public int getAll_sum_price() {
		return all_sum_price;
	}

	public void setAll_sum_price(int all_sum_price) {
		this.all_sum_price = all_sum_price;
	}

	public String getPayname() {
		return payname;
	}

	public void setPayname(String payname) {
		this.payname = payname;
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

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	
}
