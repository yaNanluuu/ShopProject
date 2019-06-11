package cn.sdcet.shop.dao;

import cn.sdcet.shop.dto.SessionDto;

public interface rootDao {
	//public boolean rootlogincheck(String rootname , String rootpsword);
	
	   public SessionDto findUserDefault(String c_code,String password);
	
}
