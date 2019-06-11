package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.Orderinfor;





public interface OrderinforDao {
	/**
	 * 查询所有订单信息
	 */
	public List<Orderinfor> findAllOrderinfor();
	
	/**
	 * 根据订单编号查询订单信息
	 */
	public List<Orderinfor> findAllOrderinforbycheck(int orid);
	
	/**
	 * 根据客户编号查询订单信息
	 */
	public List<Orderinfor> findAllOrderinforbyctidcheck(int ctid);
	
	/**
	 * 查询所有的客户编号
	 */
	public List<Orderinfor> findAllctid();
	/**
	 * 查询所有的店员代号
	 */
	public List<Orderinfor> findAllcode();
	
	/**
	 * 根据订单状态查询订单信息
	 */
	public List<Orderinfor> findAllOrderinforbystatcheck(String stat);
	
	/**
	 * 根据商品代号查询查询商品种类、单价、折扣
	 */
	public List<Orderinfor> findOrderinforbygid(String gid);
	/**
	 * 根据商品代号查询商品颜色
	 */
	public List<Orderinfor> findcolor(String gid);
	/**
	 * 根据商品代号查询商品尺寸
	 */
	public List<Orderinfor> findsize(String gid);
	
	
	/**
	 * 根据类型、颜色、尺寸查询商品编号、库存
	 */
	public List<Orderinfor> findOrderinfornonum(String gtype,String color,String size);
	
	/**
	 * 添加订单信息
	 */
	public void AddOrderinfor(Orderinfor orderinfor);

	/**
	 * 根据信息查询订单号
	 */
	public List<Orderinfor> findOrderinfororid(int ctid,int gno,String code,String orPay,int quantity,String orstate);
	/**
	 * 根据订单状态、订单编号查询订单信息
	 */
	public List<Orderinfor> findAllOrderinforbystatorid(int storid,String oridstat);
	
	/**
	 * 根据订单状态、客户编号查询订单信息
	 */
	public List<Orderinfor> findAllOrderinforbystatctid(int stctid,String ctidstat);
	
	/**
	 * 修改订单状态
	 */
	public void updatOrderinforstat(int oridupstat,String statup);
	


	
}
