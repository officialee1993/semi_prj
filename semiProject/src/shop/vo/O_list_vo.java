package shop.vo;

public class O_list_vo {
private String o_count;
private int o_num; 
private int s_num; 
public O_list_vo() {}

public O_list_vo(String o_count, int o_num, int s_num) {
	super();
	this.o_count = o_count;
	this.o_num = o_num;
	this.s_num = s_num;
}

public String getO_count() {
	return o_count;
}
public void setO_count(String o_count) {
	this.o_count = o_count;
}
public int getO_num() {
	return o_num;
}
public void setO_num(int o_num) {
	this.o_num = o_num;
}
public int getS_num() {
	return s_num;
}
public void setS_num(int s_num) {
	this.s_num = s_num;
}

}
