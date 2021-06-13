package shop.vo;

import java.util.Date;

public class Orders_vo {
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
	private String p_name;
	private int p_count;
	private int p_price;
	private String p_size;
	private int s_count;
	private String save_img_name;

	public Orders_vo () {}
	/*재고 및 주문 사이즈 갯수 추가 생성자*/
	public Orders_vo(int o_num, String rec_name, String rec_phone, String rec_addr, int all_sum_price, String payname,
			Date o_date, String o_state, String id, int p_num, String p_name, int p_count,String p_size, int p_price, 
			String save_img_name) {
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
		this.p_name = p_name;
		this.p_count = p_count;
		this.p_price = p_price;
		this.p_size = p_size;
		this.save_img_name = save_img_name;
	}
	
	
	/*상품테이블 조인 생성자*/
	public Orders_vo(int o_num, String rec_name, String rec_phone, String rec_addr, int all_sum_price, String payname,
			Date o_date, String o_state, String id, int p_num, int b_num, String p_name, int p_count, int p_price) {
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
		this.p_name = p_name;
		this.p_count = p_count;
		this.p_price = p_price;
	}
	

	
	public String getSave_img_name() {
		return save_img_name;
	}
	public void setSave_img_name(String save_img_name) {
		this.save_img_name = save_img_name;
	}


	public String getP_size() {
		return p_size;
	}



	public void setP_size(String p_size) {
		this.p_size = p_size;
	}



	public int getS_count() {
		return s_count;
	}



	public void setS_count(int s_count) {
		this.s_count = s_count;
	}



	/*기본 테이블 생성자*/
	public Orders_vo(int o_num, String rec_name, String rec_phone, String rec_addr, int all_sum_price, String payname,
			Date o_date, String o_state, String id, int p_num, int b_num) {
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
