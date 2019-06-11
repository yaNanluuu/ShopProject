package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.caiwuzh1;
import cn.sdcet.shop.domain.caiwuzh2;





public interface caiwuzhDao {
	
	public List<caiwuzh1> selectcaiwuzh1(int year,int month );
	public List<caiwuzh2> selectcaiwuzh2(int year,int month );

}
