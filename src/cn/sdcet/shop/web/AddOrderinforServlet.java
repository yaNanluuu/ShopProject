package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.jdbc.orderinforDaoJDBCImpl;
import cn.sdcet.shop.domain.Orderinfor;

public class AddOrderinforServlet extends HttpServlet {

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
		
		//ͨ����ɫ�ߴ����ȷ����Ʒ��ţ���棬Ȼ����ӵ����ݿ�
		//��ӷ�������û�п�ʼ�������ݿⷽ��Ҳ��û��д��ץ����
		
		//��ȡҪ��ӵĶ�����Ϣ
		int ctid = Integer.parseInt(request.getParameter("addctid")); //��ȡ�ͻ����
		int gNo = 0;//��Ʒ��ţ���ѯ���
		String code = request.getParameter("addcode");//��Ա����
		String orpay = request.getParameter("addorpay");//֧����ʽ
		int quantity = Integer.parseInt(request.getParameter("quantity"));//��������
		String orState = request.getParameter("addsata");//����״̬
		
		//������ѯ��Ҫ
		String gtype = request.getParameter("addgtype");//��ȡ��Ʒ���
		//String price = request.getParameter("addgprice");//�۸�
		String gcolor = request.getParameter("addgcolor");//��ɫ
		String gsize = request.getParameter("addgsize");//�ߴ�
		
		//��ѯ��棬�ж���Ҫ
		int num = 0;
		int newnum = 0;//ʣ����
		int orid = 0; //���ض������
		
		
		
		
		try {
			//��ȡ��Ʒ��źͿ��
			orderinforDaoJDBCImpl dao = new orderinforDaoJDBCImpl();
			List<Orderinfor> orderinfors = dao.findOrderinfornonum(gtype, gcolor, gsize);
			for(Orderinfor orderinfor : orderinfors){
				gNo = orderinfor.getgNo();
				num = orderinfor.getQuantity();
			}
			/*System.out.println("��Ϣ"+ctid);
			System.out.println(code);
			System.out.println(orpay);
			System.out.println(quantity);
			System.out.println(orState);
			System.out.println(gtype);
			System.out.println(gcolor);
			System.out.println(gsize);
			System.out.println("���"+gNo);
			System.out.println("���"+num);*/
			
			//�жϿ���Ƿ��㹻
			if(num >= quantity){
				//�������
				//System.out.println("�������");
				orderinforDaoJDBCImpl dao1 = new orderinforDaoJDBCImpl();
				Orderinfor orderinfor1 = new Orderinfor();
				orderinfor1.setCtId(ctid);
				orderinfor1.setgNo(gNo);
				orderinfor1.setCode(code);
				orderinfor1.setOrPay(orpay);
				orderinfor1.setQuantity(quantity);
				orderinfor1.setOrState(orState);
				
				dao1.AddOrderinfor(orderinfor1);
				
				//������Ϣ��ѯ������
				orderinforDaoJDBCImpl dao2 = new orderinforDaoJDBCImpl();
				
				List<Orderinfor> orderinfors2 = dao2.findOrderinfororid(ctid, gNo, code, orpay, quantity, orState);
				for(Orderinfor orderinfor2 : orderinfors2){
					orid = orderinfor2.getOrId();
				}
				
				
				newnum = num-quantity;
				
				request.setAttribute("orid", orid);
				request.setAttribute("num", newnum);
				
				request.getRequestDispatcher("admin/Addresultnew.jsp").forward(request, response);
				
				
				/*System.out.println("�������"+orid);
				System.out.println("ʣ������"+newnum);*/
				
				
				
			}
			else{
				//�����������ʾ��治��
				
				
				/*request.setAttribute("result", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/Addresult.jsp");
				dispatcher.forward(request, response);*/
				
				
				
				request.setAttribute("message", num);
				
				request.getRequestDispatcher("admin/Addresult.jsp").forward(request, response);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		

		
		
	}

}
