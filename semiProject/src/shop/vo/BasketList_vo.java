package shop.vo;

public class BasketList_vo {
	private String save_img_name;
	private String p_name;
	private int p_price;
	private int p_count;
	private String p_size;
	public BasketList_vo() {}
	
	public BasketList_vo(String save_img_name, String p_name, int p_price, int p_count, String p_size) {
		super();
		this.save_img_name = save_img_name;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_count = p_count;
		this.p_size = p_size;
	}

	public String getSave_img_name() {
		return save_img_name;
	}
	public void setSave_img_name(String save_img_name) {
		this.save_img_name = save_img_name;
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
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	public String getP_size() {
		return p_size;
	}
	public void setP_size(String p_size) {
		this.p_size = p_size;
	}


}
