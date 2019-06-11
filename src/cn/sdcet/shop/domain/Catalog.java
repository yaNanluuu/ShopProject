package cn.sdcet.shop.domain;


import javax.servlet.http.HttpServlet;

public class Catalog{
	private int catalogId;
	private String grade;
	public Catalog() {
	}
	public Catalog(int catalogId, String grade) {
		super();
		this.catalogId = catalogId;
		this.grade = grade;
	}
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
