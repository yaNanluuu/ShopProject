package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Orderinfor;





public interface OrderinforDao {
	/**
	 * ��ѯ���ж�����Ϣ
	 */
	public List<Orderinfor> findAllOrderinfor();
	
	/**
	 * ���ݶ�����Ų�ѯ������Ϣ
	 */
	public List<Orderinfor> findAllOrderinforbycheck(int orid);
	
	/**
	 * ���ݿͻ���Ų�ѯ������Ϣ
	 */
	public List<Orderinfor> findAllOrderinforbyctidcheck(int ctid);
	
	/**
	 * ��ѯ���еĿͻ����
	 */
	public List<Orderinfor> findAllctid();
	/**
	 * ��ѯ���еĵ�Ա����
	 */
	public List<Orderinfor> findAllcode();
	
	/**
	 * ���ݶ���״̬��ѯ������Ϣ
	 */
	public List<Orderinfor> findAllOrderinforbystatcheck(String stat);
	
	/**
	 * ������Ʒ���Ų�ѯ��ѯ��Ʒ���ࡢ���ۡ��ۿ�
	 */
	public List<Orderinfor> findOrderinforbygid(String gid);
	/**
	 * ������Ʒ���Ų�ѯ��Ʒ��ɫ
	 */
	public List<Orderinfor> findcolor(String gid);
	/**
	 * ������Ʒ���Ų�ѯ��Ʒ�ߴ�
	 */
	public List<Orderinfor> findsize(String gid);
	
	
	/**
	 * �������͡���ɫ���ߴ��ѯ��Ʒ��š����
	 */
	public List<Orderinfor> findOrderinfornonum(String gtype,String color,String size);
	
	/**
	 * ��Ӷ�����Ϣ
	 */
	public void AddOrderinfor(Orderinfor orderinfor);

	/**
	 * ������Ϣ��ѯ������
	 */
	public List<Orderinfor> findOrderinfororid(int ctid,int gno,String code,String orPay,int quantity,String orstate);
	/**
	 * ���ݶ���״̬��������Ų�ѯ������Ϣ
	 */
	public List<Orderinfor> findAllOrderinforbystatorid(int storid,String oridstat);
	
	/**
	 * ���ݶ���״̬���ͻ���Ų�ѯ������Ϣ
	 */
	public List<Orderinfor> findAllOrderinforbystatctid(int stctid,String ctidstat);
	
	/**
	 * �޸Ķ���״̬
	 */
	public void updatOrderinforstat(int oridupstat,String statup);
	


	
}
