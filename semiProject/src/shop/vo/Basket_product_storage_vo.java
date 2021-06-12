package shop.vo;

public class Basket_product_storage_vo {
	
	private int p_num;
	private int P_count;
	private String p_size;
	
	public Basket_product_storage_vo() {}

	public Basket_product_storage_vo(int p_num, int p_count, String p_size) {
		super();
		this.p_num = p_num;
		P_count = p_count;
		this.p_size = p_size;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getP_count() {
		return P_count;
	}

	public void setP_count(int p_count) {
		P_count = p_count;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}
	
	
}
