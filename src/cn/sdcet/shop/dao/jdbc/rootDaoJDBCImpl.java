package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.rootDao;
import cn.sdcet.shop.dto.SessionDto;

import common.util.ConnectionPool;




public class rootDaoJDBCImpl implements rootDao {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	@Override
	/*
	public boolean rootlogincheck(String name, String psword) {
		// TODO Auto-generated method stub
		
		if(name==null){
			name="";
		}else if(psword==null){
			psword="";
		}
		try {
			conn=ConnectionPool.getConn();
			
			String sql=" SELECT code,cPassword,cState FROM clerk where code=? and cPassword=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, psword);
			rs = stmt.executeQuery();
			while(rs.next()){
				String code = rs.getString(1);
				String passwd = rs.getString(2);
				String state = rs.getString(3);
				if(name.equals(code)&&psword.equals(passwd)&&"”––ß".equals(state)){
					return true;
				}
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
		return false;
	}
*/
	
	public SessionDto findUserDefault(String c_code,String password) {
		SessionDto dto = new SessionDto();
		try {
			conn=ConnectionPool.getConn();
			
			String sql=" SELECT code,cPassword,cState,cAuthority FROM clerk where code=? and cPassword=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c_code);
			stmt.setString(2,password);
			rs = stmt.executeQuery();
			while(rs.next()){
				dto.setCode(rs.getString(1));
				dto.setPasswd(rs.getString(2));
				dto.setState(rs.getString(3));
				dto.setAuth(rs.getString(4));
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
		return dto;
	}

}

