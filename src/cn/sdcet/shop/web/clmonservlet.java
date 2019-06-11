package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.jdbc.clmonserviceimpi;




public class clmonservlet extends HttpServlet {

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
		clmonserviceimpi cli=new clmonserviceimpi();
		request.setCharacterEncoding("utf-8");
		//String url=request.getContextPath()+"/yg-jsgl-mon.jsp";
		response.setContentType("text/html;charset=utf-8");
		String action =request.getParameter("action");
		if("insert".equals(action))
		{
			
			String id =request.getParameter("id");
			String url=request.getContextPath()+"/admin/yg-jsgl-mon.jsp?id="+id;
			String day =request.getParameter("lday");
			int lday=Integer.parseInt(day);
			cli.insert(id,lday );
			response.sendRedirect(url);
	}

	}
}
