package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Catalog;





public interface CatalogDao {
	/**
	 * ��ҳ��ʾ���
	 */
	public List<Catalog> findAll(); 
	/**
	 * ����id����
	 */
	public Catalog findbyid(int id);
}
