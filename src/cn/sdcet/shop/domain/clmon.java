package cn.sdcet.shop.domain;

public class clmon {
	String code;
	String ldate;
	int lday;
	double mon;
	public clmon(String code, String ldate, int lday, double mon) {
		super();
		this.code = code;
		this.ldate = ldate;
		this.lday = lday;
		this.mon = mon;
	}
	public clmon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLdate() {
		return ldate;
	}
	public void setLdate(String ldate) {
		this.ldate = ldate;
	}
	public int getLday() {
		return lday;
	}
	public void setLday(int lday) {
		this.lday = lday;
	}
	public double getMon() {
		return mon;
	}
	public void setMon(double mon) {
		this.mon = mon;
	}
	
	
}
