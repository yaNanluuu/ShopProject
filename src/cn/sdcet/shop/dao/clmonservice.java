package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.clmon;





public interface clmonservice {
	public void insert(String id,int day);
	public List<clmon> findallbyid(String id);
	public clmon findmon(String id,int mm,int yy);
}
