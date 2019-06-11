package common.dao;


import java.util.ArrayList;
import java.util.List;
import common.bean.OrderBean;

public interface OrderDao {

	/**
	 * @param args
	 */
	public String[] getMonthPrice();
	
	public Double getAllPrice();
	
	public Integer getOrderNum();
	
	public Double getSupplyPrice();
	
	public Double getCancelPrice();
	
	public Integer getCancelNum();

}
