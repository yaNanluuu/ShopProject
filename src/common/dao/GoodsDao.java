package common.dao;

import java.util.List;

import common.bean.GoodsBean;

public interface GoodsDao {

	//��ȡ�����ȵ���Ʒ��Ϣ
	public List<GoodsBean> getUrgentNum();
	
	public List<GoodsBean> getAllUrgentNum();
}
