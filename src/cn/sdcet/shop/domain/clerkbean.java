package cn.sdcet.shop.domain;

import java.util.Date;

public class clerkbean {
	String code;
	String cPassword;
	String cName;
	String cSex;
	String cBirthday;
	String cTel;
	String cAddress;
	String cEntrydate;
	String cState;
	int cSalary;
	String cAuthority;
	
	public clerkbean(String code, String cPassword, String cName, String cSex,
			String cBirthday, String cTel, String cAddress, String cEntrydate,
			String cState, int cSalary, String cAuthority) {
		super();
		this.code = code;
		this.cPassword = cPassword;
		this.cName = cName;
		this.cSex = cSex;
		this.cBirthday = cBirthday;
		this.cTel = cTel;
		this.cAddress = cAddress;
		this.cEntrydate = cEntrydate;
		this.cState = cState;
		this.cSalary = cSalary;
		this.cAuthority = cAuthority;
	}
	
	public clerkbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcSex() {
		return cSex;
	}
	public void setcSex(String cSex) {
		this.cSex = cSex;
	}
	public String getcBirthday() {
		return cBirthday;
	}
	public void setcBirthday(String cBirthday) {
		this.cBirthday = cBirthday;
	}
	public String getcTel() {
		return cTel;
	}
	public void setcTel(String cTel) {
		this.cTel = cTel;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getcEntrydate() {
		return cEntrydate;
	}
	public void setcEntrydate(String cEntrydate) {
		this.cEntrydate = cEntrydate;
	}
	public String getcState() {
		return cState;
	}
	public void setcState(String cState) {
		this.cState = cState;
	}
	public int getcSalary() {
		return cSalary;
	}
	public void setcSalary(int cSalary) {
		this.cSalary = cSalary;
	}
	public String getcAuthority() {
		return cAuthority;
	}
	public void setcAuthority(String cAuthority) {
		this.cAuthority = cAuthority;
	}
	
	
	
}
