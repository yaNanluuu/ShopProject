package cn.sdcet.shop.domain;

public class Orderinfor {
	private int orId; // 订单编号
	private int ctId; // 客户编号
	private String gId; // 商品代号
	private int gNo; // 商品编号
	private String code; // 店员代号
	private String gType; // 商品类别
	private String gColor; // 商品颜色
	private String gSize; // 商品尺寸
	private double gPrice; // 单价
	private int quantity; // 数量
	private double gSale; // 折扣
	private double sumprice;// 总价
	private String orPay; // 支付方式
	private String orState; // 订单状态
	private String orDate; // 创建时间
	public Orderinfor(){
		
	}
	public Orderinfor(int orId, int ctId, String gId, int gNo, String code,
			String gType, String gColor, String gSize, double gPrice,
			int quantity, double gSale, double sumprice, String orPay,
			String orState, String orDate) {
		super();
		this.orId = orId;
		this.ctId = ctId;
		this.gId = gId;
		this.gNo = gNo;
		this.code = code;
		this.gType = gType;
		this.gColor = gColor;
		this.gSize = gSize;
		this.gPrice = gPrice;
		this.quantity = quantity;
		this.gSale = gSale;
		this.sumprice = sumprice;
		this.orPay = orPay;
		this.orState = orState;
		this.orDate = orDate;
	}
	public int getOrId() {
		return orId;
	}
	public void setOrId(int orId) {
		this.orId = orId;
	}
	public int getCtId() {
		return ctId;
	}
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getgType() {
		return gType;
	}
	public void setgType(String gType) {
		this.gType = gType;
	}
	public String getgColor() {
		return gColor;
	}
	public void setgColor(String gColor) {
		this.gColor = gColor;
	}
	public String getgSize() {
		return gSize;
	}
	public void setgSize(String gSize) {
		this.gSize = gSize;
	}
	public double getgPrice() {
		return gPrice;
	}
	public void setgPrice(double gPrice) {
		this.gPrice = gPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getgSale() {
		return gSale;
	}
	public void setgSale(double gSale) {
		this.gSale = gSale;
	}
	public double getSumprice() {
		return sumprice;
	}
	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}
	public String getOrPay() {
		return orPay;
	}
	public void setOrPay(String orPay) {
		this.orPay = orPay;
	}
	public String getOrState() {
		return orState;
	}
	public void setOrState(String orState) {
		this.orState = orState;
	}
	public String getOrDate() {
		return orDate;
	}
	public void setOrDate(String orDate) {
		this.orDate = orDate;
	}
	
	
	
}
