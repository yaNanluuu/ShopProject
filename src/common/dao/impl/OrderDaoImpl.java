package common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import common.dao.OrderDao;
import common.bean.OrderBean;
import common.util.ConnectionPool;

public class OrderDaoImpl implements OrderDao{

	Connection conn = ConnectionPool.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public String[] getMonthPrice() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String Year = sdf.format(new Date());
		String types[] = new String[12];
		try {
			for(int i=1;i<=12;i++){
				String sql = " select Convert(decimal(10,2),SUM(gPrice*gSale*quantity)) from Orders,Goods "+
						" where Orders.gNo=Goods.gNo and Orders.orState='有效' and year(orDate)=? and month(orDate)=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1,Year);
				ps.setInt(2,i);
				rs = ps.executeQuery();
				while (rs.next()) {
					String num = rs.getString(1);
					if(num==null){
						num="0.00";
						}
					types[i-1]=num;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return types;
	}
	@Override
	public Double getAllPrice() {
		double sum = 0;
		try {
			String sql = " select Convert(decimal(10,2),SUM(gPrice*gSale*quantity)) from Orders,Goods "+
						" where Orders.gNo=Goods.gNo and Orders.orState='有效' ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				sum = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	@Override
	public Integer getOrderNum() {
		int num = 0;
		try {
			String sql = " select count(orId) from Orders ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public Double getSupplyPrice(){
		double s_sum = 0;
		try {
			String sql = " select SUM(sPrice_input*sNum) from Supply ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				s_sum = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s_sum;
		
	}
	public Double getCancelPrice(){
		double c_sum = 0;
		try {
			String sql = " select Convert(decimal(10,2),SUM(gPrice*gSale*quantity)) from Orders,Goods "+
					" where Orders.gNo=Goods.gNo and Orders.orState='退单' ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c_sum = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c_sum;
	}
	public Integer getCancelNum(){
		int c_num = 0;
		try {
			String sql = " select SUM(quantity) from Orders where Orders.orState='退单' ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c_num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c_num;
	}

}
