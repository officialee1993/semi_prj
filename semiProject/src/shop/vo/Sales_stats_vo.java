package shop.vo;

import java.util.Date;

public class Sales_stats_vo {
	
	private int Sales_stats_num;
	private int all_Sales;
	private Date o_date ;
	private int p_num ;
	private int p_count;
	
	public Sales_stats_vo() {}
	

	public Sales_stats_vo(int sales_stats_num, int all_Sales, Date o_date, int p_num, int p_count) {
		super();
		Sales_stats_num = sales_stats_num;
		this.all_Sales = all_Sales;
		this.o_date = o_date;
		this.p_num = p_num;
		this.p_count = p_count;
	}


	public int getSales_stats_num() {
		return Sales_stats_num;
	}

	public void setSales_stats_num(int sales_stats_num) {
		Sales_stats_num = sales_stats_num;
	}

	public int getAll_Sales() {
		return all_Sales;
	}

	public void setAll_Sales(int all_Sales) {
		this.all_Sales = all_Sales;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	

	
	
}
