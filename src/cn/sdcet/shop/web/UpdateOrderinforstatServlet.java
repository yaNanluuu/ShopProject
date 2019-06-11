package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.OrderinforDao;
import cn.sdcet.shop.dao.jdbc.orderinforDaoJDBCImpl;




public class UpdateOrderinforstatServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取要修改的订单id
		String uporids = request.getParameter("uporid");
		int uporid = Integer.parseInt(uporids);
		
		//获取订单的状态
		String upstat = request.getParameter("upstat");
		
		System.out.println(uporid);
		System.out.println(upstat);
		
		try {
			OrderinforDao dao = new orderinforDaoJDBCImpl();
			dao.updatOrderinforstat(uporid, upstat);
			
		}finally{
			response.sendRedirect("admin/orderinfor.jsp");
		}
		
		
		
	}

}
