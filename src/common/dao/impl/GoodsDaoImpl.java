package common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.bean.GoodsBean;
import common.dao.GoodsDao;
import common.util.ConnectionPool;

public class GoodsDaoImpl implements GoodsDao {

	Connection conn = ConnectionPool.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<GoodsBean> getUrgentNum() {
		List<GoodsBean> lists = new ArrayList<GoodsBean>();
		try {
			String sql = " select top 5 * from Goods where gNum<3 order by gNum asc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int gNo = rs.getInt(1);
				String gId = rs.getString(2);
				String gType = rs.getString(3);
				String gColor = rs.getString(4);
				String gSize = rs.getString(5);
				int gNum = rs.getInt(6);
				String gPrice = rs.getString(7);
				String gSale = rs.getString(7);
				GoodsBean list = new GoodsBean();
				list.setgNo(gNo);
				list.setgId(gId);
				list.setgType(gType);
				list.setgColor(gColor);
				list.setgSize(gSize);
				list.setgNum(gNum);
				list.setgPrice(gPrice);
				list.setgSale(gSale);
				lists.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<GoodsBean> getAllUrgentNum() {
		List<GoodsBean> lists = new ArrayList<GoodsBean>();
		try {
			String sql = " select * from Goods where gNum<3 order by gNum asc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int gNo = rs.getInt(1);
				String gId = rs.getString(2);
				String gType = rs.getString(3);
				String gColor = rs.getString(4);
				String gSize = rs.getString(5);
				int gNum = rs.getInt(6);
				String gPrice = rs.getString(7);
				String gSale = rs.getString(7);
				GoodsBean list = new GoodsBean();
				list.setgNo(gNo);
				list.setgId(gId);
				list.setgType(gType);
				list.setgColor(gColor);
				list.setgSize(gSize);
				list.setgNum(gNum);
				list.setgPrice(gPrice);
				list.setgSale(gSale);
				lists.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}


}
