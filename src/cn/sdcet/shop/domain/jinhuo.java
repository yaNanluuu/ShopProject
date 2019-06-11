package cn.sdcet.shop.domain;

public class jinhuo {
	private String code;
	private String cName  ;
	private double  cSalary; 
	private int leaveDay;
	public jinhuo(){};
	public jinhuo(String code, String cName, double cSalary, int leaveDay) {
		super();
		this.code = code;
		this.cName = cName;
		this.cSalary = cSalary;
		this.leaveDay = leaveDay;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public double getcSalary() {
		return cSalary;
	}
	public void setcSalary(double cSalary) {
		this.cSalary = cSalary;
	}
	public int getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}

}
