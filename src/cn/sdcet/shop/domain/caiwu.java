package cn.sdcet.shop.domain;

import java.sql.Date;

public class caiwu {
	
	private String code;
	private String cname;
	private int csalary;
	private int leaveday;
	private double sump;
	private double mon;
	private Date ordate;
	//private double gongzi;
	public caiwu(){};
	
	public caiwu(String code, String cname, int csalary, int leaveday,
			double sump,double mon, Date ordate) {
		super();
		this.code = code;
		this.cname = cname;
		this.csalary = csalary;
		this.leaveday = leaveday;
		this.sump = sump;
		this.ordate = ordate;
		this.mon=mon;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCsalary() {
		return csalary;
	}

	public void setCsalary(int csalary) {
		this.csalary = csalary;
	}

	public int getLeaveday() {
		return leaveday;
	}

	public void setLeaveday(int leaveday) {
		this.leaveday = leaveday;
	}

	public double getSump() {
		return sump;
	}

	public void setSump(double sump) {
		this.sump = sump;
	}

	public double getMon() {
		return mon;
	}

	public void setMon(double mon) {
		this.mon = mon;
	}
	public Date getOrdate() {
		return ordate;
	}

	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	
}
