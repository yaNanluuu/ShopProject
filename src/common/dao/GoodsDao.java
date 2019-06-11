package common.dao;

import java.util.List;

import common.bean.GoodsBean;

public interface GoodsDao {

	//获取库存紧迫的商品信息
	public List<GoodsBean> getUrgentNum();
	
	public List<GoodsBean> getAllUrgentNum();
}
