package shop.vo;

public class P_img_vo {
private int p_i_num; 
private int p_num ; 
public P_img_vo() {}

public P_img_vo(int p_i_num, int p_num) {
	super();
	this.p_i_num = p_i_num;
	this.p_num = p_num;
}

public int getP_i_num() {
	return p_i_num;
}
public void setP_i_num(int p_i_num) {
	this.p_i_num = p_i_num;
}
public int getP_num() {
	return p_num;
}
public void setP_num(int p_num) {
	this.p_num = p_num;
}

}
