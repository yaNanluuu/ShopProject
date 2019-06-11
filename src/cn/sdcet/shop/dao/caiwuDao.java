package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.caiwu;
import cn.sdcet.shop.domain.jinhuo;




public interface caiwuDao {

	public caiwu selectcaiwu(String id,int year,int month );
	public caiwu selectcaiwu1(String id,int year,int month );
	public caiwu selectcaiwu2(String id,int year,int month );
	public List<jinhuo> selectjinhuo(int year,int month );
}
