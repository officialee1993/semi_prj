package shop.vo;

public class Category_vo {

	private int cg_id ; 
	private String cg_name  ; 
	private int p_id;
	public Category_vo() {}
	
	public Category_vo(int cg_id, String cg_name, int p_id) {
		super();
		this.cg_id = cg_id;
		this.cg_name = cg_name;
		this.p_id = p_id;
	}

	public int getCg_id() {
		return cg_id;
	}
	public void setCg_id(int cg_id) {
		this.cg_id = cg_id;
	}
	public String getCg_name() {
		return cg_name;
	}
	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	
	
}
