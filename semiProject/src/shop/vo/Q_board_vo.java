package shop.vo;

import java.sql.Date;

public class Q_board_vo {
	private int q_b_num;
	private String id;
	private String q_b_category;
	private String q_b_title;
	private String q_b_content;
	private String q_b__pwd;
	private Date wr_date;
	private String q_b_state;
	private int p_num;
	private String p_name;
	private int p_count;
	private int p_price;
	private String ori_img_name;
	private String save_img_name;
	private int cg_id;
	private String q_a_content;
	private Date q_a_date;
	private int q_a_num;
	private int s_count;
	private String p_size;



	public Q_board_vo() {}
	
	
	
	/*회원마이페이지 상세보기용 오버로딩*/
	public Q_board_vo(int q_b_num, String id, String q_b_category, String q_b_title, String q_b_content,
			String q_b__pwd, Date wr_date, String q_b_state, int p_num,int q_a_num, String q_a_content, Date q_a_date,String p_name,int p_price,String save_img_name) {
		this.q_b_num = q_b_num;
		this.id = id;
		this.q_b_category = q_b_category;
		this.q_b_title = q_b_title;
		this.q_b_content = q_b_content;
		this.q_b__pwd = q_b__pwd;
		this.wr_date = wr_date;
		this.q_b_state = q_b_state;
		this.p_num = p_num;
		this.q_a_num = q_a_num;
		this.q_a_content = q_a_content;
		this.q_a_date = q_a_date;
		this.p_name=p_name;
		this.p_price=p_price;
		this.save_img_name=save_img_name;
	}




	public Q_board_vo(int q_b_num, String id, String q_b_category, String q_b_title, String q_b_content,
			String q_b__pwd, Date wr_date, String q_b_state, int p_num) {
		this.q_b_num = q_b_num;
		this.id = id;
		this.q_b_category = q_b_category;
		this.q_b_title = q_b_title;
		this.q_b_content = q_b_content;
		this.q_b__pwd = q_b__pwd;
		this.wr_date = wr_date;
		this.q_b_state = q_b_state;
		this.p_num = p_num;
	}
	
	
	/*회원 문의사항 상세보기용 오버로딩*/
	public Q_board_vo(int q_b_num, String id, String q_b_category, String q_b_title, String q_b_content,
			String q_b__pwd, Date wr_date, String q_b_state, int p_num, String p_name, int p_count, int p_price,
			String ori_img_name, String save_img_name, int cg_id,String q_a_content,Date q_a_date,int s_count,String p_size) {
		this.q_b_num = q_b_num;
		this.id = id;
		this.q_b_category = q_b_category;
		this.q_b_title = q_b_title;
		this.q_b_content = q_b_content;
		this.q_b__pwd = q_b__pwd;
		this.wr_date = wr_date;
		this.q_b_state = q_b_state;
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_count = p_count;
		this.p_price = p_price;
		this.ori_img_name = ori_img_name;
		this.save_img_name = save_img_name;
		this.cg_id = cg_id;
		this.q_a_content = q_a_content;
		this.q_a_date = q_a_date;
		this.s_count = s_count;
		this.p_size = p_size;
	}
	

	
	
	public int getS_count() {
		return s_count;
	}



	public void setS_count(int s_count) {
		this.s_count = s_count;
	}



	public String getP_size() {
		return p_size;
	}



	public void setP_size(String p_size) {
		this.p_size = p_size;
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
	
	
	public String getQ_b_state() {
		return q_b_state;
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

	public int getCg_id() {
		return cg_id;
	}

	public void setCg_id(int cg_id) {
		this.cg_id = cg_id;
	}

	public void setQ_b_state(String q_b_state) {
		this.q_b_state = q_b_state;
	}

	public int getQ_b_num() {
		return q_b_num;
	}

	public void setQ_b_num(int q_b_num) {
		this.q_b_num = q_b_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQ_b_category() {
		return q_b_category;
	}

	public void setQ_b_category(String q_b_category) {
		this.q_b_category = q_b_category;
	}

	public String getQ_b_title() {
		return q_b_title;
	}

	public void setQ_b_title(String q_b_title) {
		this.q_b_title = q_b_title;
	}

	public String getQ_b_content() {
		return q_b_content;
	}

	public void setQ_b_content(String q_b_content) {
		this.q_b_content = q_b_content;
	}

	public String getQ_b__pwd() {
		return q_b__pwd;
	}

	public void setQ_b__pwd(String q_b__pwd) {
		this.q_b__pwd = q_b__pwd;
	}

	public Date getWr_date() {
		return wr_date;
	}

	public void setWr_date(Date wr_date) {
		this.wr_date = wr_date;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	
	
	
}
