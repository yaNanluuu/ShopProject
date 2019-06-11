package cn.sdcet.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.sdcet.shop.dao.OrderinforDao;
import cn.sdcet.shop.domain.Orderinfor;

import common.util.ConnectionPool;





public class orderinforDaoJDBCImpl implements OrderinforDao {
	/*private DataSource dataSource;
	public orderinforDaoJDBCImpl() throws NamingException {
		Context context = new InitialContext();
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:/comp/env/jdbc/ERP");	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("��������Դʧ�ܣ�" + e.getMessage());
		}
	}
	*/
	Connection conn=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
	
	//��ѯ������Ʒ
	@Override
	public List<Orderinfor> findAllOrderinfor() {
		
	
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select orId,ctId,gId,gNo,code,gType,gColor,gSize,gPrice,quantity,gSale,orPay,orState,orDate from orderinfo_view";
			System.out.println(000000);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int orId = rs.getInt("orId");
				int ctId = rs.getInt("ctId");
				String gId = rs.getString("gId");
				int gNo = rs.getInt("gNo");
				String code = rs.getString("code");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				double gPrice = rs.getDouble("gPrice");
				int quantity = rs.getInt("quantity");
				double gSale = rs.getDouble("gSale");
				double sump = gPrice*quantity*gSale;
				String orPay = rs.getString("orPay");
				String orState = rs.getString("orState");
				String orDate = rs.getString("orDate");
				
				System.out.println(5555555);
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setOrId(orId);
				orderinfor.setCtId(ctId);
				orderinfor.setgId(gId);
				orderinfor.setgNo(gNo);
				orderinfor.setCode(code);
				orderinfor.setgType(gType);
				orderinfor.setgColor(gColor);
				orderinfor.setgSize(gSize);
				orderinfor.setgPrice(gPrice);
				orderinfor.setQuantity(quantity);
				orderinfor.setgSale(gSale);
				orderinfor.setSumprice(sump);
				orderinfor.setOrPay(orPay);
				orderinfor.setOrState(orState);
				orderinfor.setOrDate(orDate);
				
				
				orderinfors.add(orderinfor);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return orderinfors;
	}


	//���ݶ�����Ų�ѯ������Ϣ
	@Override
	public List<Orderinfor> findAllOrderinforbycheck(int orid) {
		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select orId,ctId,gId,gNo,code,gType,gColor,gSize,gPrice,quantity,gSale,orPay,orState,orDate from orderinfo_view where orId like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+orid+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int orId = rs.getInt("orId");
				int ctId = rs.getInt("ctId");
				String gId = rs.getString("gId");
				int gNo = rs.getInt("gNo");
				String code = rs.getString("code");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				double gPrice = rs.getDouble("gPrice");
				int quantity = rs.getInt("quantity");
				double gSale = rs.getDouble("gSale");
				double sump = gPrice*quantity*gSale;
				String orPay = rs.getString("orPay");
				String orState = rs.getString("orState");
				String orDate = rs.getString("orDate");
				
				
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setOrId(orId);
				orderinfor.setCtId(ctId);
				orderinfor.setgId(gId);
				orderinfor.setgNo(gNo);
				orderinfor.setCode(code);
				orderinfor.setgType(gType);
				orderinfor.setgColor(gColor);
				orderinfor.setgSize(gSize);
				orderinfor.setgPrice(gPrice);
				orderinfor.setQuantity(quantity);
				orderinfor.setgSale(gSale);
				orderinfor.setSumprice(sump);
				orderinfor.setOrPay(orPay);
				orderinfor.setOrState(orState);
				orderinfor.setOrDate(orDate);
				
				
				orderinfors.add(orderinfor);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return orderinfors;
	}

	
	
	//���ݿͻ���Ų�ѯ������Ϣ
	@Override
	public List<Orderinfor> findAllOrderinforbyctidcheck(int ctid) {
		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select orId,ctId,gId,gNo,code,gType,gColor,gSize,gPrice,quantity,gSale,orPay,orState,orDate from orderinfo_view where ctId like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+ctid+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int orId = rs.getInt("orId");
				int ctId = rs.getInt("ctId");
				String gId = rs.getString("gId");
				int gNo = rs.getInt("gNo");
				String code = rs.getString("code");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				double gPrice = rs.getDouble("gPrice");
				int quantity = rs.getInt("quantity");
				double gSale = rs.getDouble("gSale");
				double sump = gPrice*quantity*gSale;
				String orPay = rs.getString("orPay");
				String orState = rs.getString("orState");
				String orDate = rs.getString("orDate");
				
				
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setOrId(orId);
				orderinfor.setCtId(ctId);
				orderinfor.setgId(gId);
				orderinfor.setgNo(gNo);
				orderinfor.setCode(code);
				orderinfor.setgType(gType);
				orderinfor.setgColor(gColor);
				orderinfor.setgSize(gSize);
				orderinfor.setgPrice(gPrice);
				orderinfor.setQuantity(quantity);
				orderinfor.setgSale(gSale);
				orderinfor.setSumprice(sump);
				orderinfor.setOrPay(orPay);
				orderinfor.setOrState(orState);
				orderinfor.setOrDate(orDate);
				
				
				orderinfors.add(orderinfor);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return orderinfors;
	}
	

	//������Ʒ���Ų�ѯ��Ʒ��𡢵��ۡ��ۿۡ�
	@Override
	public List<Orderinfor> findOrderinforbygid(String gid) {
		//��ѯ��𡢵��ۡ��ۿ�
		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();

		try {
			conn=ConnectionPool.getConn();
			//��ѯ��𡢵��ۡ��ۿ�
			String sql = "select distinct gType,gPrice,gSale from Goods where gId like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+gid+"%");
			rs = stmt.executeQuery();
			while(rs.next()){
				String gType = rs.getString("gType");
				double gPrice = rs.getDouble("gPrice");
				
				double gSale = rs.getDouble("gSale");
				
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setgType(gType);
				orderinfor.setgPrice(gPrice);
				
				orderinfor.setgSale(gSale);
				
				
				orderinfors.add(orderinfor);
			}
			
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return orderinfors;
	}
	
	
	//������Ʒ���Ų�ѯ��Ʒ��ɫ
	@Override
	public List<Orderinfor> findcolor(String gid) {
	
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			//��ѯ��ɫ
			conn=ConnectionPool.getConn();
			String sqlcolor ="select distinct gColor from Goods where gId like ?";
			stmt = conn.prepareStatement(sqlcolor);
			stmt.setString(1, "%"+gid+"%");
			rs = stmt.executeQuery();
			while(rs.next()){
				String gColor = rs.getString("gColor");
				Orderinfor orderinfor1 = new Orderinfor();
				
				orderinfor1.setgColor(gColor);
				
				orderinfors.add(orderinfor1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return orderinfors;
	}


	//������Ʒ���Ų�ѯ��Ʒ�ߴ�
	@Override
	public List<Orderinfor> findsize(String gid) {
		//��ѯ�ߴ�
				Connection connsize = null;
				PreparedStatement stmtsize = null;
				ResultSet rssize = null;
				
				List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
				
				try {
					//��ѯ�ߴ�
					connsize=ConnectionPool.getConn();
					String sqlsize = "select distinct gSize from Goods where gId like ?";
					stmtsize = connsize.prepareStatement(sqlsize);
					stmtsize.setString(1,"%"+gid+"%");
					rssize = stmtsize.executeQuery();
					while(rssize.next()){
						String gSize = rssize.getString("gSize");
						Orderinfor orderinfor2 = new Orderinfor();
						orderinfor2.setgSize(gSize);
						
						orderinfors.add(orderinfor2);
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return orderinfors;
	}
	
	
	//���ݶ���״̬��ѯ������Ϣ
		@Override
		public List<Orderinfor> findAllOrderinforbystatcheck(String stat) {
			
			List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
			try {
				conn=ConnectionPool.getConn();
				String sql = "select orId,ctId,gId,gNo,code,gType,gColor,gSize,gPrice,quantity,gSale,orPay,orState,orDate from orderinfo_view where orState like ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+stat+"%");
				rs = stmt.executeQuery();
				
				while(rs.next()){
					int orId = rs.getInt("orId");
					int ctId = rs.getInt("ctId");
					String gId = rs.getString("gId");
					int gNo = rs.getInt("gNo");
					String code = rs.getString("code");
					String gType = rs.getString("gType");
					String gColor = rs.getString("gColor");
					String gSize = rs.getString("gSize");
					double gPrice = rs.getDouble("gPrice");
					int quantity = rs.getInt("quantity");
					double gSale = rs.getDouble("gSale");
					double sump = gPrice*quantity*gSale;
					String orPay = rs.getString("orPay");
					String orState = rs.getString("orState");
					String orDate = rs.getString("orDate");
					
					
					
					Orderinfor orderinfor = new Orderinfor();
					orderinfor.setOrId(orId);
					orderinfor.setCtId(ctId);
					orderinfor.setgId(gId);
					orderinfor.setgNo(gNo);
					orderinfor.setCode(code);
					orderinfor.setgType(gType);
					orderinfor.setgColor(gColor);
					orderinfor.setgSize(gSize);
					orderinfor.setgPrice(gPrice);
					orderinfor.setQuantity(quantity);
					orderinfor.setgSale(gSale);
					orderinfor.setSumprice(sump);
					orderinfor.setOrPay(orPay);
					orderinfor.setOrState(orState);
					orderinfor.setOrDate(orDate);
					
					
					orderinfors.add(orderinfor);
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			return orderinfors;
		}
	
	//���ݶ���״̬��������Ų�ѯ������Ϣ
	@Override
	public List<Orderinfor> findAllOrderinforbystatorid(int storid,
			String oridstat) {

		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select orId,ctId,gId,gNo,code,gType,gColor,gSize,gPrice,quantity,gSale,orPay,orState,orDate from orderinfo_view where orId like ? and orState like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+storid+"%");
			stmt.setString(2, "%"+oridstat+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int orId = rs.getInt("orId");
				int ctId = rs.getInt("ctId");
				String gId = rs.getString("gId");
				int gNo = rs.getInt("gNo");
				String code = rs.getString("code");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				double gPrice = rs.getDouble("gPrice");
				int quantity = rs.getInt("quantity");
				double gSale = rs.getDouble("gSale");
				double sump = gPrice*quantity*gSale;
				String orPay = rs.getString("orPay");
				String orState = rs.getString("orState");
				String orDate = rs.getString("orDate");
				
				
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setOrId(orId);
				orderinfor.setCtId(ctId);
				orderinfor.setgId(gId);
				orderinfor.setgNo(gNo);
				orderinfor.setCode(code);
				orderinfor.setgType(gType);
				orderinfor.setgColor(gColor);
				orderinfor.setgSize(gSize);
				orderinfor.setgPrice(gPrice);
				orderinfor.setQuantity(quantity);
				orderinfor.setgSale(gSale);
				orderinfor.setSumprice(sump);
				orderinfor.setOrPay(orPay);
				orderinfor.setOrState(orState);
				orderinfor.setOrDate(orDate);
				
				
				orderinfors.add(orderinfor);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return orderinfors;
	
	}
	
	
	//���ݶ���״̬���ͻ���Ų�ѯ������Ϣ
	@Override
	public List<Orderinfor> findAllOrderinforbystatctid(int stctid,
			String ctidstat) {

	
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select orId,ctId,gId,gNo,code,gType,gColor,gSize,gPrice,quantity,gSale,orPay,orState,orDate from orderinfo_view where ctId like ? and orState like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+stctid+"%");
			stmt.setString(2, "%"+ctidstat+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int orId = rs.getInt("orId");
				int ctId = rs.getInt("ctId");
				String gId = rs.getString("gId");
				int gNo = rs.getInt("gNo");
				String code = rs.getString("code");
				String gType = rs.getString("gType");
				String gColor = rs.getString("gColor");
				String gSize = rs.getString("gSize");
				double gPrice = rs.getDouble("gPrice");
				int quantity = rs.getInt("quantity");
				double gSale = rs.getDouble("gSale");
				double sump = gPrice*quantity*gSale;
				String orPay = rs.getString("orPay");
				String orState = rs.getString("orState");
				String orDate = rs.getString("orDate");
				
				
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setOrId(orId);
				orderinfor.setCtId(ctId);
				orderinfor.setgId(gId);
				orderinfor.setgNo(gNo);
				orderinfor.setCode(code);
				orderinfor.setgType(gType);
				orderinfor.setgColor(gColor);
				orderinfor.setgSize(gSize);
				orderinfor.setgPrice(gPrice);
				orderinfor.setQuantity(quantity);
				orderinfor.setgSale(gSale);
				orderinfor.setSumprice(sump);
				orderinfor.setOrPay(orPay);
				orderinfor.setOrState(orState);
				orderinfor.setOrDate(orDate);
				
				
				orderinfors.add(orderinfor);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return orderinfors;
	
	}


	//���ݶ���id�޸Ķ���״̬
	@Override
	public void updatOrderinforstat(int oridupstat, String statup) {
		
		
		try {
			conn=ConnectionPool.getConn();
			String sql = "update Orders set orState=? where orId=?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, statup);
			stmt.setInt(2,oridupstat);
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�޸�ʧ�ܣ�" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�ResultSetʧ�ܣ�" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("�ر�PreparedStatementʧ�ܣ�"
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("�ر�Connectionʧ�ܣ�"
								+ e.getMessage());
					}
				}
			}
		}
		
		
		
		
		
	}

	
	//��ѯ���еĿͻ����
	@Override
	public List<Orderinfor> findAllctid() {
		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select ctId from Customer order by ctId asc";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int ctId = rs.getInt("ctId");
				
				
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setCtId(ctId);
				
				
				orderinfors.add(orderinfor);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return orderinfors;
	}
	
	
	//��ѯ���еĵ�Ա����

	@Override
	public List<Orderinfor> findAllcode() {
		
		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select code from Clerk";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				String code = rs.getString("code");
				
				
				
				Orderinfor orderinfor = new Orderinfor();
				orderinfor.setCode(code);
				
				
				orderinfors.add(orderinfor);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return orderinfors;
	}



	
	
	//�������͡���ɫ���ߴ��ѯ��Ʒ��š����
	
	@Override
	public List<Orderinfor> findOrderinfornonum(String gtype, String color,
			String size) {
		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		try {
			conn=ConnectionPool.getConn();
			String sql = "select gNo,gNum from Goods where gType = ? and gColor=? and gSize=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, gtype);
			stmt.setString(2, color);
			stmt.setString(3, size);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				int gNo = rs.getInt("gNo");
				int gNum = rs.getInt("gNum");
				
				Orderinfor orderinfor = new Orderinfor();
				
				orderinfor.setgNo(gNo);
				orderinfor.setQuantity(gNum);
				
				orderinfors.add(orderinfor);
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return orderinfors;
	}
	
	//��Ӷ�����Ϣ



	@Override
	public void AddOrderinfor(Orderinfor orderinfor) {
		
		
		int ctid = orderinfor.getCtId();
		int gno = orderinfor.getgNo();
		String code = orderinfor.getCode();
		String orpay = orderinfor.getOrPay();
		int quantity = orderinfor.getQuantity();
		String orstata = orderinfor.getOrState();
		
		try {
			conn=ConnectionPool.getConn();
			String sql = "insert into Orders(ctId,gNo,code,orPay,quantity,orState) values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ctid);
			stmt.setInt(2, gno);
			stmt.setString(3, code);
			stmt.setString(4, orpay);
			stmt.setInt(5, quantity);
			stmt.setString(6, orstata);
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ�ܣ�" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�ResultSetʧ�ܣ�" + e.getMessage());
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("�ر�PreparedStatementʧ�ܣ�"
							+ e.getMessage());
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("�ر�Connectionʧ�ܣ�"
								+ e.getMessage());
					}
				}
			}
		}
		
		
		
	}



	
	//���������Ϣ��ѯ�������
	@Override
	public List<Orderinfor> findOrderinfororid(int ctid, int gno, String code,
			String orPay, int quantity, String orstate) {
		
		
		List<Orderinfor> orderinfors = new ArrayList<Orderinfor>();
		
		try {
			conn=ConnectionPool.getConn();
			String sql = "select orId from Orders where ctId=? and gNo=? and code=? and orPay=? and quantity=? and orState=?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ctid);
			stmt.setInt(2, gno);
			stmt.setString(3, code);
			stmt.setString(4, orPay);
			stmt.setInt(5, quantity);
			stmt.setString(6, orstate);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int orid = rs.getInt("orId");
				
				Orderinfor orderinfor = new Orderinfor();
				
				orderinfor.setOrId(orid);
				orderinfors.add(orderinfor);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return orderinfors;
	}



	





	







	
}
