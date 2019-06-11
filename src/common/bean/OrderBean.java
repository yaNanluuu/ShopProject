package common.bean;

public class OrderBean {

		private int orId; //订单编号
		private int ctId; //客户编号
		private int gNo; //商品编号
		private String code; //店员代号
		private String orPay; //支付方式
		private String quantity; //购买数量
		private String orDate;//创建时间
		private String orState; //状态
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
		public String getOrPay() {
			return orPay;
		}
		public void setOrPay(String orPay) {
			this.orPay = orPay;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public String getOrDate() {
			return orDate;
		}
		public void setOrDate(String orDate) {
			this.orDate = orDate;
		}
		public String getOrState() {
			return orState;
		}
		public void setOrState(String orState) {
			this.orState = orState;
		}


}
