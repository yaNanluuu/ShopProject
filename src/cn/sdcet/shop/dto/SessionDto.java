package cn.sdcet.shop.dto;
/**
 * ����Ҫ���û���Ϣ��װ��SessionDto�����У�������session��ʹ��
 * 

 */
public class SessionDto  {
	/** �û�CD **/
	private String code;
	
	/** �û��� **/
	private String passwd;
	
    /** �û�Ȩ��    M������S��ҵ��F������**/
	private String auth;
	
	private String state;

	public void reset() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}




}
