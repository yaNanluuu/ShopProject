package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Customer;






public interface CustomerDao {
	/**
	 * ���ݹؼ��ֽ��������ͻ�
	 */
	public List<Customer> findCustomerByOther(Customer c); 
	/**
	 * ����id���������ͻ�
	 */
	
	public Customer findbyid(String ctId);
	
	/**
	 * ��̨��ӿͻ�
	 */
	public void AddInfoDao(Customer customer);
	
	/**
	 * �жϿͻ����Ƿ��ظ�
	 */
	public boolean addcheck(String ctName);

	/**
	 * ��̨�޸Ŀͻ���Ϣ
	 */
	public void updateCustomerInfo(Customer customer);

	/*
	 * ��ҳ
	 */
	//public PageBean<Customer> getMessageList(int ctId,int page,int pageSize);
}


