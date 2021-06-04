package shop.vo;

public class Cgname_Pid_select_vo {

	private String cg_name;
	private int p_id; 
	public Cgname_Pid_select_vo() {}
	
	public Cgname_Pid_select_vo(String cg_name, int p_id) {
		super();
		this.cg_name = cg_name;
		this.p_id = p_id;
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
