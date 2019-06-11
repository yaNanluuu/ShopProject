package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cn.sdcet.shop.dao.clmonservice;
import cn.sdcet.shop.domain.clmon;

import common.util.ConnectionPool;




public class clmonserviceimpi implements clmonservice {
	Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
	@Override
	public void insert(String id,int day) {
		// TODO Auto-generated method stub
		String sql="insert into Leave(code,leaveDay) values(?,?)";
		try {
			//3.给占位符赋值
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);	
			pstmt.setInt(2,day);	
	
			
			//System.out.println("id是："+customer.getCUSTOMER_CD());
			//4.发送执行sql
			  pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
	}

	@Override
	public List<clmon> findallbyid(String id) {
		// TODO Auto-generated method stub
		List<clmon> cls=new ArrayList<clmon>(); 
			
			
		String sql="SELECT * FROM Leave where code=?";
		try{
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String code=rs.getString(1);
				String ldate=rs.getString(2);
				String lday=rs.getString(3);
				int ld=Integer.parseInt(lday);
				
				
				
				
				clmon cl=new clmon();
				
				cl.setCode(code);
				cl.setLdate(ldate);
				cl.setLday(ld);
				
				cls.add(cl);
			
			}
		} catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		return cls;
	}
	public int getPrice(String id,int mm,int yy) {
		int sum = 0;
		String sql = " select count(*) from Orders where  Orders.orState='有效' and Orders.code=? and MONTH(orDate)=? and year(orDate)=?";
		try {
			conn=ConnectionPool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,mm);
			pstmt.setInt(3,yy);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	public clmon getPrice2(String id,int mm,int yy) {
		clmon cl=new clmon();
		String sql = " exec pro_mon1 @a=?,@b=?,@c= ";
		try {
			conn=ConnectionPool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,yy);
			pstmt.setInt(3,mm);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				double money=rs.getDouble(2);
				cl.setMon(money);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;
	}
	
	public int getLdy(String id,int mm,int yy) {
		int sum = 0;
		try {
			String sql = "SELECT count(*) FROM Leave where code=? and MONTH(leaveDate)=? and year(leaveDate)=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,mm);
			pstmt.setInt(3,yy);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	public clmon getLdy1(String id,int mm,int yy) {
		clmon cl=new clmon();
		try {
			String sql = "exec pro_mon1 @a=?,@b=?,@c= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,yy);
			pstmt.setInt(3,mm);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				double money=rs.getDouble(2);
				cl.setMon(money);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;
	}
	@Override
	public clmon findmon(String id, int mm,int yy) {
		
		String sql="exec pro_mon @a=?,@b=?,@c= ?";
		clmon cl=new clmon();
		try{
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,yy);
			pstmt.setInt(3,mm);
			
			rs=pstmt.executeQuery();
			//System.out.println(id);
			System.out.println(mm);
			while(rs.next()){
				double money=rs.getDouble(2);
				cl.setMon(money);
				
				
			}
		} catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		return cl;
	}
	}



