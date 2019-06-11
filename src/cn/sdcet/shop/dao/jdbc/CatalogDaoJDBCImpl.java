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
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import cn.sdcet.shop.dao.CatalogDao;
import cn.sdcet.shop.domain.Catalog;

import common.util.ConnectionPool;






public class CatalogDaoJDBCImpl implements CatalogDao  {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	//œ‘ æ¿‡±
	public List<Catalog> findAll() {
	
		
		List<Catalog> catalogs = new ArrayList<Catalog>();
		conn = ConnectionPool.getConn();
		try {
			
			String sql = "select CatalogId,grade from Catalog";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int CatalogId = rs.getInt("CatalogId");
				String grade = rs.getString("grade");
				
				Catalog catalog = new Catalog();
				catalog.setCatalogId(CatalogId);
				catalog.setGrade(grade);
				
				catalogs.add(catalog);
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
					if (pstmt != null) {
						pstmt.close();
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
		return catalogs;
	}

	
	
public Catalog findbyid(int id) {
		
		conn = ConnectionPool.getConn();
		
		Catalog c=new Catalog();
		try {
			String sql = "select * from Catalog where catalogId =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String n = rs.getString(2);
				c.setCatalogId(id);
				c.setGrade(n);
				System.out.println(c.getCatalogId());
				System.out.println(c.getGrade());
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
					if (pstmt != null) {
						pstmt.close();
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
		return c;
	}
	
	
}
