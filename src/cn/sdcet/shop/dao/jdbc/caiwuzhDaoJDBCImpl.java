package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.caiwuzhDao;
import cn.sdcet.shop.domain.caiwuzh1;
import cn.sdcet.shop.domain.caiwuzh2;

import common.util.ConnectionPool;





public class caiwuzhDaoJDBCImpl implements caiwuzhDao {
	private DataSource dataSource;
/*	public caiwuzhDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:/comp/env/jdbc/ERP");	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("≤È’“ ˝æ›‘¥ ß∞‹£∫" + e.getMessage());
		}
	}*/
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	@Override
	public List<caiwuzh1> selectcaiwuzh1(int year, int month) {
		// TODO Auto-generated method stub
		
		List<caiwuzh1> caizh1s=new ArrayList<caiwuzh1>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select SUM(sPrice_input*sNum) price ,SUM(sNum) num  from Supply where year(sDate)=? and month(sDate)=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,year);
			stmt.setInt(2,month);
			
			
			rs = stmt.executeQuery();
			
			//code ,cName,cSalary,leaveDay, sump ,orDate
			
			while(rs.next()){
			double price=rs.getDouble("price");
		    int num=rs.getInt("num");
		   
		
			
			 
			caiwuzh1 caizh1=new caiwuzh1();
			caizh1.setPrice(price);
			caizh1.setNum(num);
			
			caizh1s.add(caizh1);
			}
		
			}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹£∫" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("πÿ±’ResultSet ß∞‹£∫" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("πÿ±’PreparedStatement ß∞‹£∫"
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("πÿ±’Connection ß∞‹£∫"
								+ e.getMessage());
					}
				}
			}
		}
		return caizh1s;
	}

	@Override
	public List<caiwuzh2> selectcaiwuzh2(int year, int month) {
		// TODO Auto-generated method stub
		
		List<caiwuzh2> caizh2s=new ArrayList<caiwuzh2>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select SUM(d) d,SUM(m) m,SUM(s) s from caiwuzh_View_12 where year(orDate)=? and month(orDate)=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,year);
			stmt.setInt(2,month);
			
			
			rs = stmt.executeQuery();
			
			
			
			while(rs.next()){
			int dingdan=rs.getInt("d");
			int maichu=rs.getInt("m");
			double shouru=rs.getDouble("s");
		
			
			 
			caiwuzh2 caizh2=new caiwuzh2();
			caizh2.setDingdan(dingdan);
			caizh2.setMaichu( maichu);
			caizh2.setShouru(shouru);
			caizh2s.add(caizh2);
			}
		
			}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹£∫" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("πÿ±’ResultSet ß∞‹£∫" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("πÿ±’PreparedStatement ß∞‹£∫"
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("πÿ±’Connection ß∞‹£∫"
								+ e.getMessage());
					}
				}
			}
		}
		return caizh2s;
	}

}
