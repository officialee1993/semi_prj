package shop.vo;

public class Storages_vo {

	private int s_num;
	private int s_count ;
	private String p_size ;
	private int o_num ;
	private int p_num ;
	
	public Storages_vo() {}

	public Storages_vo(int s_num, int s_count, String p_size, int o_num, int p_num) {
		super();
		this.s_num = s_num;
		this.s_count = s_count;
		this.p_size = p_size;
		this.o_num = o_num;
		this.p_num = p_num;
	}

	public int getS_num() {
		return s_num;
	}

	public void setS_num(int s_num) {
		this.s_num = s_num;
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

	public int getO_num() {
		return o_num;
	}

	public void setO_num(int o_num) {
		this.o_num = o_num;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	
}
