package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Catalog;





public interface CatalogDao {
	/**
	 * 首页显示类别
	 */
	public List<Catalog> findAll(); 
	/**
	 * 根据id查找
	 */
	public Catalog findbyid(int id);
}
