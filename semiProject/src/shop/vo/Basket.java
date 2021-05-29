package shop.vo;



public class Basket {
	private int b_num; 
	private int p_count ; 
	private int p_num ; 
	private String id ;
	public Basket() {}
	
	public Basket(int b_num, int p_count, int p_num, String id) {
		super();
		this.b_num = b_num;
		this.p_count = p_count;
		this.p_num = p_num;
		this.id = id;
	}

	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
