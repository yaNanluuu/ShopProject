package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.jdbc.CustDaoJDBCImpl;
import cn.sdcet.shop.domain.Customer;




public class UpdateInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		
		String id1 = request.getParameter("id");
		int id=Integer.parseInt(id1.trim());
	    String ctName = request.getParameter("ctName");
	    String ctEmail = request.getParameter("ctEmail");
	    String ctBirthday = request.getParameter("ctBirthday");
	    String ctAddress = request.getParameter("ctAddress");
	    String ctTel=request.getParameter("ctTel");
	    String catalogId1=request.getParameter("catalogId");
		int catalogId=Integer.parseInt(catalogId1.trim());
		
		
		try {

			CustDaoJDBCImpl dao =new CustDaoJDBCImpl();
			
				Customer Customers = new Customer();
				Customers.setCtId(id);
				Customers.setCtName(ctName);
				Customers.setCtEmail(ctEmail);
				Customers.setCtTel(ctTel);
				Customers.setCtBirthday(ctBirthday);
				Customers.setCtAddress(ctAddress);
				Customers.setCatalogId(catalogId);

				dao.updateCustomerInfo(Customers);
				//dao.findCustomerByOther(Customers);
				ctTel=ctTel.substring(5,11);
				response.sendRedirect(path+"/admin/search.jsp?Tel="+ctTel);

				
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("修改客户信息失败：");
		}

	}


}
