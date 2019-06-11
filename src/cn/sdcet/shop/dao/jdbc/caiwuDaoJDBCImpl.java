package cn.sdcet.shop.dao.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



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

import cn.sdcet.shop.dao.caiwuDao;
import cn.sdcet.shop.domain.caiwu;
import cn.sdcet.shop.domain.jinhuo;

import common.util.ConnectionPool;



public class caiwuDaoJDBCImpl implements caiwuDao {
	//private DataSource dataSource;
	/*	public caiwuDaoJDBCImpl() throws NamingException {
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

	//Õ®π˝ƒÍ‘¬≤È—Ø
	@Override
	public caiwu selectcaiwu(String id,int year,int month) {
		// TODO Auto-generated method stub
		
		caiwu cai=new caiwu();
		try {
			conn=ConnectionPool.getConn();
			String sql = "exec pro_mon @a=?,@b=?,@c= ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2,year);
			stmt.setInt(3,month);
			
			
			rs = stmt.executeQuery();
		
		
			//code ,cName,cSalary,leaveDay, sump ,orDate
			
			while(rs.next()){
			String code=rs.getString("code");
		    String cname=rs.getString("cName");
		    int csalary=rs.getInt("cSalary");
			int leaveday=rs.getInt("leaveDay");
			double sump=rs.getDouble("sump");
			System.out.println(code);
			double mon=rs.getDouble("mon");
			 
			cai.setCode(code);
			cai.setCname(cname);
			cai.setCsalary(csalary);
			cai.setLeaveday(leaveday);
			cai.setSump(sump);
			cai.setMon(mon);
			
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
		return cai;


	}
	@Override
	public caiwu selectcaiwu1(String id,int year,int month) {
		// TODO Auto-generated method stub
		String sql = "exec pro_mon1 @a=?,@b=?,@c= ? ";
		caiwu cai=new caiwu();
		try {
			conn=ConnectionPool.getConn();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2,year);
			stmt.setInt(3,month);
			
			
			rs = stmt.executeQuery();
			
			//code ,cName,cSalary,leaveDay, sump ,orDate
			System.out.println(id);
			while(rs.next()){
			String code=rs.getString("code");
		    String cname=rs.getString("cName");
		   // String cauthority=rs.getString("cAuthority");
		    int csalary=rs.getInt("cSalary");
			int leaveday=rs.getInt("leaveDay");
			//double sump=rs.getDouble("sump");
		    //Date ordate=rs.getDate("orDate");
			System.out.println(id);
			double mon=rs.getDouble("mon");
			 
			cai.setCode(code);
			cai.setCname(cname);
			cai.setCsalary(csalary);
			cai.setLeaveday(leaveday);
			//cai.setSump(sump);
			//cai.setOrdate(ordate);
			cai.setMon(mon);
			//cai.setCauthority(cauthority);
			
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
		return cai;


	}
	
	
	@Override
	public caiwu selectcaiwu2(String id,int year,int month) {
		// TODO Auto-generated method stub
		String sql = "exec pro_mon2 @a=?,@b=?,@c= ? ";
		caiwu cai=new caiwu();
		try {
			conn=ConnectionPool.getConn();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2,year);
			stmt.setInt(3,month);
			
			
			rs = stmt.executeQuery();
			
			//code ,cName,cSalary,leaveDay, sump ,orDate
			System.out.println(id);
			while(rs.next()){
			String code=rs.getString("code");
		    String cname=rs.getString("cName");
		   // String cauthority=rs.getString("cAuthority");
		    int csalary=rs.getInt("cSalary");
			//int leaveday=rs.getInt("leaveDay");
			double sump=rs.getDouble("sump");
		    //Date ordate=rs.getDate("orDate");
			System.out.println(id);
			double mon=rs.getDouble("mon");
			 
			cai.setCode(code);
			cai.setCname(cname);
			cai.setCsalary(csalary);
			//cai.setLeaveday(leaveday);
			cai.setSump(sump);
			//cai.setOrdate(ordate);
			cai.setMon(mon);
			
			
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
		return cai;


	}
	
	
	
	@Override
	public List<jinhuo> selectjinhuo(int year, int month) {
		// TODO Auto-generated method stub
		
		List<jinhuo> jinhuos=new ArrayList<jinhuo>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select Clerk.code , cName , cSalary ,SUM(leaveDay) s from Clerk,Leave where Clerk.code=Leave.code and cAuthority='Ω¯ªı‘±'and cState='”––ß' and year(leaveDate)=? and month(leaveDate)=? Group by  Clerk.code , cName , cSalary ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,year);
			stmt.setInt(2,month);
			
			
			rs = stmt.executeQuery();
			
			//code ,cName,cSalary,leaveDay, sump ,orDate
			
			while(rs.next()){
			String code =rs.getString("code");
			String cname=rs.getString("cName");
			double cSalary=rs.getDouble("cSalary");
			int leaveDay=rs.getInt("s");
			
		
			
			 
			jinhuo jin = new jinhuo();
			jin.setCode(code);
			jin.setcName(cname);
			jin.setcSalary(cSalary);
			jin.setLeaveDay(leaveDay);
			
			jinhuos.add(jin);
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
		return jinhuos;

	}



	

}
