package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sdcet.shop.dao.clerkservice;
import cn.sdcet.shop.domain.clerkbean;

import common.util.ConnectionPool;
import common.util.FieldCheck;





public class clerkserviceimpi implements clerkservice {
	Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
	@Override
	public List<clerkbean> findall() {
		// TODO Auto-generated method stub
		
		List<clerkbean> cls = new ArrayList<clerkbean>();

		String sql="SELECT * FROM clerk";
		try{
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);

			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String code=rs.getString(1);
				String cname=rs.getString(3);
				String cTel=rs.getString(6);
				String cAuthority=rs.getString(11);
				
				String cState =rs.getString(9);
				String cSa =rs.getString(10).trim();
				int csalary=Integer.parseInt(cSa);
				System.out.println(cSa);
				
				clerkbean cl=new clerkbean();
				
				cl.setCode(code);
				cl.setcAuthority(cAuthority);
				cl.setcState(cState);
				cl.setcTel(cTel);
				cl.setcName(cname);
				cl.setcSalary(csalary);
				cls.add(cl);
			
			}
		} catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		return cls;
	}


	@Override
	public void insertnew(clerkbean c) {
		// TODO Auto-generated method stub
		int i=0;
		//2.创建sql
		String sql="insert into Clerk(code,cPassword,cName,cSex,"
				+"cBirthday,cTel,cAddress,cState,cSalary,cAuthority) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try {
			//3.给占位符赋值
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,c.getCode());	
			pstmt.setString(2,c.getcPassword());
			pstmt.setString(3,c.getcName());
			pstmt.setString(4,c.getcSex());
			pstmt.setString(5,c.getcBirthday());
			pstmt.setString(6,c.getcTel());			
			pstmt.setString(7,c.getcAddress());
			pstmt.setString(8,c.getcState());
			pstmt.setInt(9,c.getcSalary());			
			pstmt.setString(10,c.getcAuthority());
			//System.out.println("id是："+customer.getCUSTOMER_CD());
			//4.发送执行sql
			 i= pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}

	}

	

	@Override
	public void update(clerkbean c) {
		// TODO Auto-generated method stub
		int i;
		String sql="update clerk set cpassword=?,cname=?,ctel=?,caddress=?,cstate=?,cSalary=?,cAuthority=? where code=?";
		try{
			
			
			conn=ConnectionPool.getConn();
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, c.getcPassword());
			pstmt.setString(2, c.getcName());
			pstmt.setString(3, c.getcTel());
			pstmt.setString(4, c.getcAddress());
			pstmt.setString(5, c.getcState());
			pstmt.setInt(6, c.getcSalary());
			pstmt.setString(7, c.getcAuthority());
			
			pstmt.setString(8, c.getCode());
			
			i=pstmt.executeUpdate();
				
				
	} catch(Exception ex){
				ex.printStackTrace();
			}finally{
				ConnectionPool.close(pstmt, rs, conn);
			}
			
	}

	
	
	@Override
	public clerkbean findbyid(String id) {
		String sql="SELECT * FROM clerk where code=?";
		clerkbean cl=new clerkbean();
		try{
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);	
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String cPassword=rs.getString(2);
				String cname=rs.getString(3);
				String cTel=rs.getString(6);
				String cAuthority=rs.getString(11);
				
				String cState =rs.getString(9);
				String cAddress =rs.getString(7);
				String cSalary =rs.getString(10).trim();
				int s=Integer.parseInt(cSalary);
				
				
				
				cl.setcPassword(cPassword);
				cl.setcAuthority(cAuthority);
				cl.setcState(cState);
				cl.setcTel(cTel);
				cl.setcName(cname);
				cl.setcAddress(cAddress);
				cl.setcSalary(s);
				
			}
		} catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		return cl;
	}


	@Override
	public List<clerkbean> findby(clerkbean c) {
		List<clerkbean> cls = new ArrayList<clerkbean>();
	//	FieldCheck f=new FieldCheck();
		String sql="SELECT * FROM clerk where "+
					"code like ? and cname like ? and "+
					"cState like ? and cAuthority like ? ";
		try{
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%" +FieldCheck.convertNullToEmpty(c.getCode())+ "%");
			pstmt.setString(2,"%" +FieldCheck.convertNullToEmpty(c.getcName())+ "%");			
			pstmt.setString(3,"%" +FieldCheck.convertNullToEmpty(c.getcState())+ "%");				
			pstmt.setString(4,"%" +FieldCheck.convertNullToEmpty(c.getcAuthority())+ "%");
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String code=rs.getString(1);
				String cname=rs.getString(3);
				String cTel=rs.getString(6);
				String cAuthority=rs.getString(11);
				
				String cState =rs.getString(9);
				String cSa =rs.getString(10).trim();
				int csalary=Integer.parseInt(cSa);
				
				
				
				
				clerkbean cl=new clerkbean();
				
				cl.setCode(code);
				cl.setcAuthority(cAuthority);
				cl.setcState(cState);
				cl.setcTel(cTel);
				cl.setcName(cname);
				cl.setcSalary(csalary);
				cls.add(cl);
			
			}
		} catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		return cls;
	}
	@Override
	public boolean addcheck(String id) {
		
		conn = ConnectionPool.getConn();
		
		if(id==null){
			id="";
		}
		try {
			String sql = "SELECT * FROM clerk";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String n = rs.getString(1);
				if(id.equals(n)){
					return false;
				}
			}
			}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败：" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭ResultSet失败：" + e.getMessage());
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭PreparedStatement失败："
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("关闭Connection失败："
								+ e.getMessage());
					}
				}
			}
		}
		return true;
	}

	}


