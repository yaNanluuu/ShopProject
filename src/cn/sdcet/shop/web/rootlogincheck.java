package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dto.SessionDto;

import cn.sdcet.shop.dao.rootDao;
import cn.sdcet.shop.dao.jdbc.rootDaoJDBCImpl;






public class rootlogincheck extends HttpServlet {

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
		String message = null;
		String name = request.getParameter("rootname");
		String password = request.getParameter("rootpsword");
		
		
		rootDao dao = new rootDaoJDBCImpl();
		SessionDto dto = dao.findUserDefault(name,password);
		String code = dto.getCode();
		String passwd = dto.getPasswd();
		String state = dto.getState();
		String auth = dto.getAuth();
		if("��Ч".equals(state)){
			request.setAttribute("message", "�ù���Ա����Ч");
			RequestDispatcher dispatcher = request.getRequestDispatcher("rootlogin.jsp");
			dispatcher.forward(request, response);
		}else{
			if(name.equals(code)&&password.equals(passwd)){
				request.getSession().setAttribute("rootname", name);
				if("�곤".equals(auth)){
					response.sendRedirect("admin/admin.jsp");
				} else if ("����Ա".equals(auth)) {
					response.sendRedirect("admin/xiaoshou.jsp");
				} else if ("����Ա".equals(auth)) {
					response.sendRedirect("admin/jinhuo.jsp");
			}
			}
			else{
				//��¼ʧ��
					request.setAttribute("message", "�û��������벻��ȷ");			
					RequestDispatcher dispatcher = request.getRequestDispatcher("rootlogin.jsp");
					dispatcher.forward(request, response);
			}
		}
	}
}
	




