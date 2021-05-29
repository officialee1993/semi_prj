package shop.vo;

public class Categroy {

	private String c_name ; 
	private String r_c_name  ; 
	
	public Categroy() {}

	public Categroy(String c_name, String r_c_name) {
		super();
		this.c_name = c_name;
		this.r_c_name = r_c_name;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getR_c_name() {
		return r_c_name;
	}

	public void setR_c_name(String r_c_name) {
		this.r_c_name = r_c_name;
	}
	
}
