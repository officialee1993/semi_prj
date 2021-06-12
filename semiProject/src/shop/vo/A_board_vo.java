package shop.vo;

import java.util.Date;

public class A_board_vo {

	private int a_b_num;
	private String a_b_title;
	private String a_b_content;
	private String wr_id;
	private Date wr_date;
	private int o_num; 
	private int a_r_no;
	private String re_wr_id;
	private String a_r_content;
	private Date re_wr_date;
	private int re_a_b_num;
	private int repcnt;
	private int p_num;
	private String p_name;
	private int p_price;
	private String save_img_name;

	public A_board_vo() {}

	public A_board_vo(int p_num, String p_name, int p_price, String save_img_name) {

		this.p_num = p_num;
		this.p_name = p_name;
		this.p_price = p_price;
		this.save_img_name = save_img_name;
	}

	/*댓글리스트 가져오기*/
	public A_board_vo(int a_r_no, String re_wr_id, String a_r_content, Date re_wr_date, int re_a_b_num) {
		super();
		this.a_r_no = a_r_no;
		this.re_wr_id = re_wr_id;
		this.a_r_content = a_r_content;
		this.re_wr_date = re_wr_date;
		this.re_a_b_num = re_a_b_num;
	}
	
	/*상품상세페이지 후기 내용 및 아이디 불러오는 생성자*/
	public A_board_vo(String a_b_content, String wr_id,int a_b_num,Date wr_date) {
		this.a_b_content = a_b_content;
		this.wr_id = wr_id;
		this.a_b_num = a_b_num;
		this.wr_date = wr_date;
	}

	
	/*글조회 생성자*/
	public A_board_vo(int a_b_num, String a_b_title, String a_b_content, String wr_id, Date wr_date, int o_num,int repcnt) {
		this.a_b_num = a_b_num;
		this.a_b_title = a_b_title;
		this.a_b_content = a_b_content;
		this.wr_id = wr_id;
		this.wr_date = wr_date;
		this.o_num = o_num;
		this.repcnt=repcnt;
	}
	public A_board_vo(int a_b_num, String a_b_title, String a_b_content, String wr_id, Date wr_date, int o_num,
			int a_r_no, String re_wr_id, String a_r_content, Date re_wr_date, int re_a_b_num) {
		super();
		this.a_b_num = a_b_num;
		this.a_b_title = a_b_title;
		this.a_b_content = a_b_content;
		this.wr_id = wr_id;
		this.wr_date = wr_date;
		this.o_num = o_num;
		this.a_r_no = a_r_no;
		this.re_wr_id = re_wr_id;
		this.a_r_content = a_r_content;
		this.re_wr_date = re_wr_date;
		this.re_a_b_num = re_a_b_num;
	}

	

	public A_board_vo(int a_b_num,String a_b_title, String a_b_content,int p_num,String p_name,int p_price,String save_img_name) {
		this.a_b_num = a_b_num;
		this.a_b_title = a_b_title;
		this.a_b_content = a_b_content;
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_price = p_price;
		this.save_img_name = save_img_name;
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

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getSave_img_name() {
		return save_img_name;
	}

	public void setSave_img_name(String save_img_name) {
		this.save_img_name = save_img_name;
	}

	public int getRepcnt() {
		return repcnt;
	}

	public void setRepcnt(int repcnt) {
		this.repcnt = repcnt;
	}
	
	
	public int getA_r_no() {
		return a_r_no;
	}


	public void setA_r_no(int a_r_no) {
		this.a_r_no = a_r_no;
	}


	public String getRe_wr_id() {
		return re_wr_id;
	}


	public void setRe_wr_id(String re_wr_id) {
		this.re_wr_id = re_wr_id;
	}


	public String getA_r_content() {
		return a_r_content;
	}


	public void setA_r_content(String a_r_content) {
		this.a_r_content = a_r_content;
	}


	public Date getRe_wr_date() {
		return re_wr_date;
	}


	public void setRe_wr_date(Date re_wr_date) {
		this.re_wr_date = re_wr_date;
	}


	public int getRe_a_b_num() {
		return re_a_b_num;
	}


	public void setRe_a_b_num(int re_a_b_num) {
		this.re_a_b_num = re_a_b_num;
	}


	public int getA_b_num() {
		return a_b_num;
	}

	public void setA_b_num(int a_b_num) {
		this.a_b_num = a_b_num;
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
	
	
	
}
