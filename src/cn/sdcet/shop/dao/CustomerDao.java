package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Customer;






public interface CustomerDao {
	/**
	 * 根据关键字进行搜索客户
	 */
	public List<Customer> findCustomerByOther(Customer c); 
	/**
	 * 根据id进行搜索客户
	 */
	
	public Customer findbyid(String ctId);
	
	/**
	 * 后台添加客户
	 */
	public void AddInfoDao(Customer customer);
	
	/**
	 * 判断客户名是否重复
	 */
	public boolean addcheck(String ctName);

	/**
	 * 后台修改客户信息
	 */
	public void updateCustomerInfo(Customer customer);

	/*
	 * 分页
	 */
	//public PageBean<Customer> getMessageList(int ctId,int page,int pageSize);
}


