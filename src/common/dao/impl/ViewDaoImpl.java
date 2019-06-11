package common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.bean.OrderBean;
import common.bean.ViewBean;
import common.dao.ViewDao;
import common.util.ConnectionPool;

public class ViewDaoImpl implements ViewDao {

	Connection conn = ConnectionPool.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<ViewBean> getTopGoods(){
		List<ViewBean> lists = new ArrayList<ViewBean>();
		try {
			String sql = " select top 5 * from Goods_Orders_View where orState='ÓÐÐ§' order by num desc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int gNo = rs.getInt(1);
				String gId = rs.getString(2);
				String gColor = rs.getString(3);
				String gType = rs.getString(4);
				String gPrice = rs.getString(5);
				int num = rs.getInt(6);
				String orState = rs.getString(7);
				ViewBean list = new ViewBean();
				list.setgNo(gNo);
				list.setgId(gId);
				list.setgColor(gColor);
				list.setgType(gType);
				list.setgPrice(gPrice);
				list.setNum(num);
				list.setOrState(orState);
				lists.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

}
