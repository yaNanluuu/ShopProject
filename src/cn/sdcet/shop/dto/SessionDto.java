package cn.sdcet.shop.dto;
/**
 * 将需要的用户信息封装到SessionDto对象中，保存在session中使用
 * 

 */
public class SessionDto  {
	/** 用户CD **/
	private String code;
	
	/** 用户名 **/
	private String passwd;
	
    /** 用户权限    M：管理；S：业务；F：财务**/
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
