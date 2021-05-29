package shop.vo;

public class Sales_stats_vo {

	private int all_Sales;
	private String p_price ;
	private String o_date ;
	private int p_count ;
	
	public Sales_stats_vo() {}

	public Sales_stats_vo(int all_Sales, String p_price, String o_date, int p_count) {
		super();
		this.all_Sales = all_Sales;
		this.p_price = p_price;
		this.o_date = o_date;
		this.p_count = p_count;
	}

	public int getAll_Sales() {
		return all_Sales;
	}

	public void setAll_Sales(int all_Sales) {
		this.all_Sales = all_Sales;
	}

	public String getP_price() {
		return p_price;
	}

	public void setP_price(String p_price) {
		this.p_price = p_price;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	
}
