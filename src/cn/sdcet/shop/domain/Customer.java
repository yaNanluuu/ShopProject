package cn.sdcet.shop.domain;



public class Customer{
	private int ctId;
	private String ctName;
	private String ctSex;
	private String ctTel;
	private String ctEmail;
	private String ctBirthday;
	private String ctCreateDate;
	private String ctAddress;
	//private String point;
	private int catalogId;
	
	
	
	public Customer() {	
	}
	public Customer(int ctId,String ctName,String ctSex,String ctTel,String ctEmail,String ctBirthday,String ctCreateDate,
			String ctAddress,int catalogId){
		super();
		this.ctId=ctId;
		this.ctName=ctName;
		this.ctSex=ctSex;

		this.ctTel=ctTel;
		this.ctEmail=ctEmail;
		this.ctBirthday=ctBirthday;
		this.ctCreateDate=ctCreateDate;
		this.ctAddress=ctAddress;
		//this.point=point;
		this.catalogId=catalogId;
	}
	public int getCtId() {
		return ctId;
	}
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCtSex() {
		return ctSex;
	}
	public void setCtSex(String ctSex) {
		this.ctSex = ctSex;
	}
	public String getCtTel() {
		return ctTel;
	}
	public void setCtTel(String ctTel) {
		this.ctTel = ctTel;
	}
	public String getCtEmail() {
		return ctEmail;
	}
	public void setCtEmail(String ctEmail) {
		this.ctEmail = ctEmail;
	}
	public String getCtBirthday() {
		return ctBirthday;
	}
	public void setCtBirthday(String ctBirthday) {
		this.ctBirthday = ctBirthday;
	}
	public String getCtCreateDate() {
		return ctCreateDate;
	}
	public void setCtCreateDate(String ctCreateDate) {
		this.ctCreateDate = ctCreateDate;
	}
	public String getCtAddress() {
		return ctAddress;
	}
	public void setCtAddress(String ctAddress) {
		this.ctAddress = ctAddress;
	}
	/*public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	} */
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	
	
	


}
