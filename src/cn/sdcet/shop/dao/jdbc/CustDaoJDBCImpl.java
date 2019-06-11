package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sdcet.shop.dao.CustomerDao;
import cn.sdcet.shop.domain.Customer;

import common.util.ConnectionPool;
import common.util.FieldCheck;







public class CustDaoJDBCImpl implements CustomerDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//主页查询客户 模糊查询
	public List<Customer> findCustomerByOther(Customer c) {

			conn = ConnectionPool.getConn();
			
			List<Customer> customerss = new ArrayList<Customer>();
			try {
				String sql="exec searchCustomer @ctName=?,@ctTel=?";
				//String sql = "select * from Customer where ctName like ? and ctTel like ? order by ctId desc" ;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+FieldCheck.convertNullToEmpty(c.getCtName())+"%");
				pstmt.setString(2,"%"+FieldCheck.convertNullToEmpty(c.getCtTel()));
				
				
				rs = pstmt.executeQuery();
				while(rs.next()){
					int id=rs.getInt(1); 
					String cn=rs.getString(2);
					String sex=rs.getString(3);
					int catalogId=rs.getInt(9);
					String ct=rs.getString(4);
					String ctEmail=rs.getString(5);
					String ctBirthday=rs.getString(6);
					String ctAddress=rs.getString(8);
					
					
					
					Customer customers = new Customer();
					customers.setCtName(cn);
					customers.setCtSex(sex);
					customers.setCtTel(ct);
					customers.setCtEmail(ctEmail);
					customers.setCtBirthday(ctBirthday);
					customers.setCtAddress(ctAddress);
					customers.setCatalogId(catalogId);				
					customers.setCtId(id);
					customerss.add(customers);
					
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
			return customerss;
		}
		
	//根据id查找信息
	public Customer findbyid(String ctId) {
		String sql="SELECT ctName,ctSex,ctTel,ctEmail,ctBirthday,ctCreatDate,ctAddress FROM Customer where ctId=?";
		System.out.println(ctId);
		Customer customer=new Customer();
		try{
			conn=ConnectionPool.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,ctId);	
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String ctName=rs.getString(1);
				String ctSex=rs.getString(2);
				String ctTel=rs.getString(3);
				String ctEmail=rs.getString(4);				
				String ctBirthday =rs.getString(5);
				String ctCreateDate =rs.getString(6);
				String ctAddress =rs.getString(7);	
				
				customer.setCtName(ctName);
				customer.setCtSex(ctSex);
				customer.setCtTel(ctTel);
				customer.setCtEmail(ctEmail);
				customer.setCtBirthday(ctBirthday);
				customer.setCtCreateDate(ctCreateDate);
				customer.setCtAddress(ctAddress);
				
			}
		} catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		return customer;
	}
	
	//添加客户信息
	public void AddInfoDao(Customer customer) {
		
		conn = ConnectionPool.getConn();

		String ctName=customer.getCtName();
		String ctSex=customer.getCtSex();
		String ctTel=customer.getCtTel();
		String ctEmail=customer.getCtEmail();
		String ctBirthday=customer.getCtBirthday();
		String ctAddress=customer.getCtAddress();
		int catalogId=customer.getCatalogId();
						
		try {
			
			String sql = "insert into Customer(ctName,ctSex,ctTel,ctEmail,ctBirthday,ctAddress,catalogId) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctName);
			pstmt.setString(2,ctSex);
			pstmt.setString(3, ctTel);
			pstmt.setString(4, ctEmail);
			pstmt.setString(5, ctBirthday);
			pstmt.setString(6, ctAddress);
			pstmt.setInt(7, catalogId);
			pstmt.executeUpdate();
					
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("增加失败：" + e.getMessage());
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

		
	}


	//检查客户名是否重复
	
	public boolean addcheck(String ctName) {
		
		conn = ConnectionPool.getConn();
		
		if(ctName==null){
			ctName="";
		}
		try {
			String sql = "select ctName from Customer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String n = rs.getString(1);
				if(ctName.equals(n)){
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

	

	//修改客户信息
	public void updateCustomerInfo(Customer customer) {
		
		int i=0;
		
		String sql = "update Customer set ctName=?,ctEmail=?,ctTel=?,ctAddress=?,catalogId=? where ctId=?";
		
						
		try {
			conn = ConnectionPool.getConn();
			int id=customer.getCtId(); 
			String ctName=customer.getCtName();
			String ctEmail=customer.getCtEmail();
			String ctTel=customer.getCtTel();
			String ctAddress=customer.getCtAddress();
			int catalogId=customer.getCatalogId();
			
			System.out.println(id);
			System.out.println(ctName);
			System.out.println(ctEmail);
			System.out.println(ctAddress);
			System.out.println(catalogId);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctName);
			pstmt.setString(2, ctEmail);
			pstmt.setString(3,ctTel);
			pstmt.setString(4, ctAddress);
			pstmt.setInt(5, catalogId);
			pstmt.setInt(6, id);
			i=pstmt.executeUpdate();
					
			
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

	}


	//分页
	/*
	public PageBean<Customer> getMessageList(int ctId,int page,int pageSize) {
		
		PageBean<Customer> pageBean=null;
		//List<Message> message=new ArrayList<Message>();
		conn = ConnectionPool.getConn();

		try {
			int total=0;
			String sql = "SELECT COUNT(ctId) FROM Customer";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				total=rs.getInt(1);
			}
			
			sql="SELECT TOP " + pageSize + " id,title,publishedtime FROM Forum WHERE cid= ? " +
					"AND id NOT IN (SELECT TOP "+ (page - 1) * pageSize + " id FROM Forum WHERE cid = ?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, catalogId);
			ps.setInt(2,catalogId);
			rs = ps.executeQuery();
			while (rs.next()) {
				//int id = rs.getInt("id");
				//String title = rs.getString("title");
				//String time = rs.getString("publishedtime");
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String time = rs.getString(3);
				
				Message m=new Message();
				m.setForumId(id);
				m.setTitle(title);
				m.setPublishedtime(time);
				//message.add(m);
				recordList.add(m);
			}
			pageBean =new PageBean<Message>(page,pageSize,total,recordList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取分类信息失败：" + e.getMessage());
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
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭PreparedStatement失败："
							+ e.getMessage());
				} finally {
					try {
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("关闭Connection失败："
								+ e.getMessage());
					}
				}
			}
		}

		return pageBean;
	}


}
*/

}
