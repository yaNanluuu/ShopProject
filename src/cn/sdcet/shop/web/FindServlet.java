package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.OrderinforDao;
import cn.sdcet.shop.dao.jdbc.orderinforDaoJDBCImpl;
import cn.sdcet.shop.domain.Orderinfor;





public class FindServlet extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");
		
		//��ȡ��һ��������
		String checkstat = request.getParameter("checkstat");
		//System.out.println(checkstat);
		
		//��ȡ�ڶ���������
		String checkstat2 = request.getParameter("checkstat2");
		//System.out.println(checkstat2);
		
		
		
		
		if(checkstat.equals("��ʾȫ��")==true){
			System.out.println("ȫ����ʾ");
			if(checkstat2.equals("��ʾȫ��")==true){
				response.sendRedirect("admin/orderinfor.jsp");
			}
			else if(checkstat2.equals("�������")==true){
				//��ȡ�ı�������
				String orids = request.getParameter("textin");
				int orid = Integer.parseInt(orids);
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbycheck(orid);
						
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
			else if(checkstat2.equals("�ͻ����")==true){
				//��ȡ�ı�������
				String ctids = request.getParameter("textin");
				int ctid = Integer.parseInt(ctids);
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbyctidcheck(ctid);
					
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		else if(checkstat.equals("��Ч����")==true){
			System.out.println("��Ч");
			String stat = "��Ч";
			if(checkstat2.equals("��ʾȫ��")==true){
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbystatcheck(stat);
					
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			else if(checkstat2.equals("�������")==true){
				//��ȡ�ı�������
				String orids = request.getParameter("textin");
				int orid = Integer.parseInt(orids);
				
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbystatorid(orid, stat);
					
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			else if(checkstat2.equals("�ͻ����")==true){
				//��ȡ�ı�������
				String ctids = request.getParameter("textin");
				int ctid = Integer.parseInt(ctids);
				
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbystatctid(ctid, stat);
					
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) { 
					// TODO: handle exception
				}
			}
		}
		else if(checkstat.equals("�˻�����")==true){
			System.out.println("��Ч");
			String stat = "�˵�";
			if(checkstat2.equals("��ʾȫ��")==true){
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbystatcheck(stat);
					
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			else if(checkstat2.equals("�������")==true){
				String orids = request.getParameter("textin");
				int orid = Integer.parseInt(orids);
				
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbystatorid(orid, stat);
					
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			else if(checkstat2.equals("�ͻ����")==true){
				String ctids = request.getParameter("textin");
				int ctid = Integer.parseInt(ctids);
				
				try {
					OrderinforDao dao = new orderinforDaoJDBCImpl();
					List<Orderinfor> orderinfors = dao.findAllOrderinforbystatctid(ctid, stat);
					
					request.setAttribute("result", orderinfors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
					dispatcher.forward(request, response);
				} catch (Exception e) { 
					// TODO: handle exception
				}
			}
			
		}
		
		
		
		/*
		try {
			OrderinforDao dao = new orderinforDaoJDBCImpl();
			List<Orderinfor> orderinfors = dao.findAllOrderinforbycheck(orid);
			request.setAttribute("result", orderinfors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Findorderinfor.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		
		
		
		
		
	}

}
