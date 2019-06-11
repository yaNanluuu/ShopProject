package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.jdbc.CustDaoJDBCImpl;
import cn.sdcet.shop.domain.Customer;



public class CustomerAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		String message1 = null;
		String message2 = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String path = request.getContextPath();
		PrintWriter out = response.getWriter();

		String ctName = request.getParameter("ctName");
		String ctSex=request.getParameter("ctSex");
		String ctTel=request.getParameter("ctTel");
		if(ctName==""){
			request.setAttribute("message1", "请输入姓名");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addInfo.jsp");
			dispatcher.forward(request, response);
		}else if(ctTel==""){
			request.setAttribute("message2", "请输入联系电话");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addInfo.jsp");
			dispatcher.forward(request, response);
		}else{
			request.setAttribute("message", "保存成功！");
			String ctEmail=request.getParameter("ctEmail");
			String ctBirthday=request.getParameter("ctBirthday");
			String ctAddress=request.getParameter("ctAddress");
			//String point=request.getParameter("point");
			String catalogId1=request.getParameter("catalogId");
			int catalogId=Integer.parseInt(catalogId1.trim());
			String ctTel1=ctTel.substring(5,11);
			try {
				
				//CatalogDao dao =new CatalogDaoJDBCImpl();
				CustDaoJDBCImpl dao =new CustDaoJDBCImpl();
				Customer Customers = new Customer();
				Customers.setCtName(ctName);
				Customers.setCtSex(ctSex);
				Customers.setCtTel(ctTel);
				Customers.setCtEmail(ctEmail);
				Customers.setCtBirthday(ctBirthday);
				Customers.setCtAddress(ctAddress);
				//Customers.setPoint(point);
				Customers.setCatalogId(catalogId);
			
				dao.AddInfoDao(Customers);
				response.sendRedirect(path+"/admin/search.jsp?tel="+ctTel1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("失败："+ e.getMessage());
		}
		}

	}
	

}
