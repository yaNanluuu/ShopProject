package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.json.simple.JSONObject;

import cn.sdcet.shop.domain.Goods;
import cn.sdcet.shop.util.JdbcUtil;
import cn.sdcet.shop.util.PageBean;
import cn.sdcet.shop.util.PoiUtil;
import cn.sdcet.shop.util.UploadUtils;

public class GoodsServlet extends HttpServlet {
	public String state = "fail";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 统一执行doPost方法
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置文件编码
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取请求参数
		String type = request.getParameter("type");
		String strgNo = request.getParameter("gNo");
		String gId = request.getParameter("gId");
		String gType = request.getParameter("gType");
		String strPage = request.getParameter("page");
	
		String strGNos = request.getParameter("gNos");
		
		

		JdbcUtil jdbcUtil = new JdbcUtil();
		PoiUtil poiUtil = new PoiUtil();
		UploadUtils uploadUtils = new UploadUtils();
		QueryRunner queryRunner = jdbcUtil.getQueryRunner();
		// 跳转到修改页面
		if ("toFrom".equals(type)) {
			// 先判断再转类型 防止空指针
			if (strgNo != null && !"".equals(strgNo)) {
				int gNo = Integer.parseInt(strgNo);
				// 查询要更新的商品
				String sqlGNo = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage FROM Goods WHERE gNo = ?";
				Goods goods = null;
				try {
					goods = queryRunner.query(sqlGNo, new BeanHandler(Goods.class), gNo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("goods", goods);
				request.setAttribute("page", strPage);
				forword("", "admin/goods/update.jsp", request, response);
			} else {
				forword("商品编号[gNO]不能为空", "admin/goods/list.jsp", request, response);
			}
			//执行更新
		}  else if ("doUpdate".equals(type)) {
			String[] uploadFile = uploadUtils.uploadFile(request);
			if("true".equals(uploadFile[0])){
				Map<String, String> fields = uploadUtils.getFormFields();
				if(uploadUtils.getFileName()!=null){
				fields.put("gImage", uploadFile[4]);}
				update(fields,queryRunner);
				strPage = fields.get("page");
				if(strPage==null||"".equals(strPage)){
					strPage = "1";
				}
			}
			redirect("goods?type=findAll&page="+strPage, response);
			
			// 删除商品
		} else if ("doDelete".equals(type)) {
			if (strGNos != null && !"".equals(strGNos)) {
				String[] sGNos = strGNos.split(",");
				for (String No : sGNos) {
					int gNo = Integer.parseInt(No);
					String delete = "DELETE FROM Goods WHERE gNo=?";
					try {
						queryRunner.update(delete, gNo);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				redirect("goods?type=findAll", response);
			} else {
				forword("商品编号[gNO]不能为空", "admin/goods/list.jsp", request, response);
			}
			// 查询所有的商品
		} else if ("findAll".equals(type)) {
			if(strPage==null||"".equals(strPage)){
				strPage = "1";
			}
			int page = Integer.parseInt(strPage);
			String finAllByPage = "SELECT top "+page*10+" gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale, gImage FROM Goods"
					+ " where gNo not in(SELECT top "+(page - 1) * 10+" gNo FROM Goods)";
//			String findGType = "select gType from Goods group by gType";
			
			String findGType = "EXEC gType";
			
			String conutSql = "select count(*) from Goods";
			List<Goods> goodsList = new ArrayList<Goods>();
			List<String> gTypes = new ArrayList<String>();
			int count = 0;
			try {
					
					if ("gId".equals(gType)) {
						conutSql = "select count(*) from Goods where gId like '%" + gId + "%'";
						String gIdSql = "SELECT top "+page*10+" gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage FROM Goods"
								+ " where gId like '%" + gId + "%' and gNo not in(SELECT top "+(page - 1) * 10+" gNo FROM Goods where gId like '%" + gId + "%')";
						
						goodsList = queryRunner.query(gIdSql, new BeanListHandler<>(Goods.class));
					} else if(gType!=null&&!"".equals(gType)){
						conutSql = "select count(*) from Goods where GType like '"+gType+"'";
						String gtypeSql = "SELECT top "+page*10+" gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage FROM Goods"
								+ " where GType like '"+gType+"' and gNo not in(SELECT top "+(page - 1) * 10+" gNo FROM Goods WHERE GType like '"+gType+"')";
						goodsList = queryRunner.query(gtypeSql, new BeanListHandler<>(Goods.class));
					}else{
						goodsList = queryRunner.query(finAllByPage, new BeanListHandler<>(Goods.class));
					}
					count = queryRunner.query(conutSql, new ScalarHandler<Integer>());
				gTypes = queryRunner.query(findGType, new ColumnListHandler("gType"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			PageBean pageList = new PageBean(page,10,count,goodsList);
			
			request.setAttribute("gTypes", gTypes);
			request.setAttribute("gType", gType);
			request.setAttribute("gId", gId);
			request.setAttribute("pageList", pageList);
			forword("", "admin/goods/list.jsp", request, response);
		}else if("upload".equals(type)){
			String[] uploadFile = uploadUtils.uploadFile(request);
			if("true".equals(uploadFile[0])){
				Map<String, String> fields = uploadUtils.getFormFields();
				fields.put("gImage", uploadFile[4]);
				add(fields,queryRunner);
			}
			redirect("goods?type=findAll", response);
			
		}else if("import".equals(type)){
			String[] uploadFile = uploadUtils.uploadFile(request);
			if("true".equals(uploadFile[0])){
				for(String str :uploadFile){
					System.out.println(str);
				}
				List<Goods> list = poiUtil.readExcel(uploadUtils.getFinalUrl());
				//导入数据的方法
				add(list, queryRunner);
				state = "success";
			}
			redirect("goods?type=findAll", response);
			
		}else if("export".equals(type)){
			List<Goods> goodsList = new ArrayList<Goods>();
			String find = "select gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage from Goods";
			try {
				goodsList = queryRunner.query(find, new BeanListHandler<>(Goods.class));
				poiUtil.writeXlsx(goodsList, "D:/商品信息.xlsx");
				state = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			println(state,response);
		}
		else if("find".equals(type)){
			List<Goods> goodsList = new ArrayList<Goods>();
			String find = "select top 1 gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage from Goods WHERE gId like '%" + gId + "%'";
			Map<String,Object> map = null;
			try {
				map = queryRunner.query(find, new MapHandler());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JSONObject jsonObject = new JSONObject();
			if(map!=null){
				jsonObject.putAll(map);
				println(jsonObject.toJSONString(),response);
			}
			
		}
		else {
			forword("", "admin/goods/list.jsp", request, response);
		}

	}

	
	private void add(Map fields,QueryRunner queryRunner){
		String gId = (String) fields.get("gId");
		String gType = (String) fields.get("gType");
		String gColor = (String) fields.get("gColor");
		String gSize = (String) fields.get("gSize");
		String strgNum = (String) fields.get("gNum");
		String strgPrice = (String) fields.get("gPrice");
		String strgSale = (String) fields.get("gSale");
		String gImage = (String) fields.get("gImage");
		int gNum = Integer.parseInt(strgNum);
		double gPrice = Double.parseDouble(strgPrice);
		double gSale = Double.parseDouble(strgSale);
		Goods goods = new Goods();
		try {
			String sqlGNo = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage FROM Goods WHERE gId = ? AND gColor = ? AND gSize = ? AND gPrice = ?";
			goods = queryRunner.query(sqlGNo, new BeanHandler(Goods.class), gId,gColor,gSize,gPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(goods!=null){
			String update = "update Goods set gNum ="+(gNum+goods.getgNum())+" where gNo="+goods.getgNo();try {
				queryRunner.update(update);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 添加进货记录表
			String add = "insert into Supply (gId,sPrice_input,sNum,sDate) values (?,?,?,?)";
			try {
				queryRunner.update(add,goods.getgId(),goods.getgPrice()*goods.getgNum(),goods.getgNum(),new Date().toLocaleString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
		
		String insert = "INSERT INTO GOODS (gId,gType,gColor,gSize,gNum,gPrice,gSale,gImage) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
			
			try {
				queryRunner.update(insert,gId,gType,gColor,gSize,gNum,gPrice,gSale,gImage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 添加进货记录表
			String add = "insert into Supply (gId,sPrice_input,sNum,sDate) values (?,?,?,?)";
			try {
				queryRunner.update(add,gId,gPrice*gNum,gNum,new Date().toLocaleString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	private void update(Map fields,QueryRunner queryRunner){
		String strgNo = (String) fields.get("gNo");
		String gId = (String) fields.get("gId");
		String gType = (String) fields.get("gType");
		String gColor = (String) fields.get("gColor");
		String gSize = (String) fields.get("gSize");
		String strgNum = (String) fields.get("gNum");
		String strgPrice = (String) fields.get("gPrice");
		String strgSale = (String) fields.get("gSale");
		String gImage = (String) fields.get("gImage");
		int gNo = Integer.parseInt(strgNo);
		int gNum = Integer.parseInt(strgNum);
		double gPrice = Double.parseDouble(strgPrice);
		double gSale = Double.parseDouble(strgSale);
		
		// 查出要修改的商品
		String sqlGNo = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage FROM Goods WHERE gNo = ?";
		Goods goods = null;
		try {
			goods = queryRunner.query(sqlGNo, new BeanHandler(Goods.class), gNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "update Goods set gId='"+gId+"',gType='"+gType+"',gColor='"+gColor+"',gSize='"+gSize+"',gNum="+(gNum+goods.getgNum())+",gPrice='"+gPrice+"',gSale='"+gSale+"'";
		if(gImage!=null&&!"".equals(gImage)){
			sql =sql+",gImage='"+gImage+"' ";
		}
		String update = " where gNo="+gNo;
		System.out.println("["+gImage+"]");
		System.out.println(sql+update);
		
		
		
		try {
			queryRunner.update(sql+update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// 添加进货记录表
		String add = "insert into Supply (gId,sPrice_input,sNum,sDate) values (?,?,?,?)";
		try {
			queryRunner.update(add,gId,gPrice*gNum,gNum,new Date().toLocaleString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void add(List<Goods> goodsList,QueryRunner queryRunner){
		
		for (Goods goods : goodsList) {
			Goods good = null;
			String sqlGNo = "SELECT gNo,gId ,gType ,gColor ,gSize ,gNum  ,gPrice ,gSale,gImage FROM Goods WHERE gId = ? AND gColor = ? AND gSize = ? AND gPrice = ?";
			try {
				good = queryRunner.query(sqlGNo, new BeanHandler(Goods.class), goods.getgId(),goods.getgColor(),goods.getgSize(),goods.getgPrice());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(good==null){
				String insert = "INSERT INTO GOODS (gId,gType,gColor,gSize,gNum,gPrice,gSale,gImage) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
				try {
					queryRunner.update(insert,goods.getgId(),goods.getgType(),goods.getgColor(),goods.getgSize(),goods.getgNum(),goods.getgPrice(),goods.getgSale(),goods.getgImage());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				// 添加进货记录表
				String add = "insert into Supply (gId,sPrice_input,sNum,sDate) values (?,?,?,?)";
				try {
					queryRunner.update(add,goods.getgId(),goods.getgPrice()*goods.getgNum(),goods.getgNum(),new Date().toLocaleString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				String update = "update Goods set gNum ="+(good.getgNum()+goods.getgNum())+" where gNo="+good.getgNo();try {
					queryRunner.update(update);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 添加进货记录表
				String add = "insert into Supply (gId,sPrice_input,sNum,sDate) values (?,?,?,?)";
				try {
					queryRunner.update(add,goods.getgId(),goods.getgPrice()*goods.getgNum(),goods.getgNum(),new Date().toLocaleString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

	/**
	 * 执行forward操作
	 * 
	 * @param message
	 *            提示信息
	 * @param page
	 *            要跳转的页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void forword(String message, String page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", message);
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * 执行redirect操作
	 * 
	 * @param page
	 *            要跳转的页面
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void redirect(String page, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(page);
	}
	
	public void println(String state,HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(state);
        
        out.close();
	}
	

}
