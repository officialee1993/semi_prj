package shop.vo;

public class Basket_sum_price_vo {

	private int b_num;
	private int all_sum_price;
	private int p_num; 
	public Basket_sum_price_vo () {}
	
	public Basket_sum_price_vo(int b_num, int all_sum_price, int p_num) {
		super();
		this.b_num = b_num;
		this.all_sum_price = all_sum_price;
		this.p_num = p_num;
	}

	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public int getAll_sum_price() {
		return all_sum_price;
	}
	public void setAll_sum_price(int all_sum_price) {
		this.all_sum_price = all_sum_price;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	
}
