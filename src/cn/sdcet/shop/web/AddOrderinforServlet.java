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
		
		//通过颜色尺寸类别确定商品编号，库存，然后添加到数据库
		//添加方法，还没有开始做，数据库方面也还没有写，抓紧的
		
		//获取要添加的订单信息
		int ctid = Integer.parseInt(request.getParameter("addctid")); //获取客户编号
		int gNo = 0;//商品编号，查询获得
		String code = request.getParameter("addcode");//店员代号
		String orpay = request.getParameter("addorpay");//支付方式
		int quantity = Integer.parseInt(request.getParameter("quantity"));//购买数量
		String orState = request.getParameter("addsata");//订单状态
		
		//其他查询需要
		String gtype = request.getParameter("addgtype");//获取商品类别
		//String price = request.getParameter("addgprice");//价格
		String gcolor = request.getParameter("addgcolor");//颜色
		String gsize = request.getParameter("addgsize");//尺寸
		
		//查询库存，判断需要
		int num = 0;
		int newnum = 0;//剩余库存
		int orid = 0; //返回订单编号
		
		
		
		
		try {
			//获取商品编号和库存
			orderinforDaoJDBCImpl dao = new orderinforDaoJDBCImpl();
			List<Orderinfor> orderinfors = dao.findOrderinfornonum(gtype, gcolor, gsize);
			for(Orderinfor orderinfor : orderinfors){
				gNo = orderinfor.getgNo();
				num = orderinfor.getQuantity();
			}
			/*System.out.println("信息"+ctid);
			System.out.println(code);
			System.out.println(orpay);
			System.out.println(quantity);
			System.out.println(orState);
			System.out.println(gtype);
			System.out.println(gcolor);
			System.out.println(gsize);
			System.out.println("编号"+gNo);
			System.out.println("库存"+num);*/
			
			//判断库存是否足够
			if(num >= quantity){
				//可以添加
				//System.out.println("可以添加");
				orderinforDaoJDBCImpl dao1 = new orderinforDaoJDBCImpl();
				Orderinfor orderinfor1 = new Orderinfor();
				orderinfor1.setCtId(ctid);
				orderinfor1.setgNo(gNo);
				orderinfor1.setCode(code);
				orderinfor1.setOrPay(orpay);
				orderinfor1.setQuantity(quantity);
				orderinfor1.setOrState(orState);
				
				dao1.AddOrderinfor(orderinfor1);
				
				//根据信息查询订单号
				orderinforDaoJDBCImpl dao2 = new orderinforDaoJDBCImpl();
				
				List<Orderinfor> orderinfors2 = dao2.findOrderinfororid(ctid, gNo, code, orpay, quantity, orState);
				for(Orderinfor orderinfor2 : orderinfors2){
					orid = orderinfor2.getOrId();
				}
				
				
				newnum = num-quantity;
				
				request.setAttribute("orid", orid);
				request.setAttribute("num", newnum);
				
				request.getRequestDispatcher("admin/Addresultnew.jsp").forward(request, response);
				
				
				/*System.out.println("订单编号"+orid);
				System.out.println("剩余库存量"+newnum);*/
				
				
				
			}
			else{
				//不可以添加提示库存不足
				
				
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
