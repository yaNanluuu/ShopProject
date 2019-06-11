package cn.sdcet.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.enterprise.context.spi.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdcet.shop.dao.jdbc.clerkserviceimpi;
import cn.sdcet.shop.domain.clerkbean;



public class clerkservlet extends HttpServlet {

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

		clerkserviceimpi c=new clerkserviceimpi();
		request.setCharacterEncoding("utf-8");
		String url=request.getContextPath()+"/admin/yg-jbxx-se.jsp";
		response.setContentType("text/html;charset=utf-8");
		String action =request.getParameter("action");
		PrintWriter out = response.getWriter();
		/*out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");*/
		
		if("insert".equals(action))
		{
			
			String code=request.getParameter("code");
			String cPassword=request.getParameter("cpassword");
			String cName=request.getParameter("cname");
			String cSex=request.getParameter("csex");
			if("1".equals(cSex))
				cSex="男";
			else
				cSex="女";
			String cBirthday=request.getParameter("cbirth");
			String cTel=request.getParameter("ctel");
			String cAddress=request.getParameter("address");
			
			String cState=request.getParameter("cstate");
			if("1".equals(cState))
				cState="有效";
			else
				cState="无效";
			String salary=request.getParameter("csalary");
			
			
			int cSalary=Integer.parseInt(salary );
			
			String cAuthority=request.getParameter("authority");
			if("1".equals(cAuthority))
				cAuthority="进货员";
			else
				cAuthority="销售员";
			
			clerkbean cb=new clerkbean(code,cPassword,cName ,cSex ,cBirthday, 
					cTel ,cAddress ,"",cState, cSalary, cAuthority);
			
			boolean ct= c.addcheck(code);
			if(ct==true){
			c.insertnew(cb);
			response.sendRedirect(url+"?id="+code);
			}
			else{
				out.print(" <h1><a href="+request.getContextPath()+"'/yg-jbxx-se.jsp'>编号重复！！！<br>点击此处返回</a></h1>");
			}
		}
		if("update".equals(action)){
			String code=request.getParameter("id");
			String cPassword=request.getParameter("cpassword");
			String cName=request.getParameter("cname");
			String cTel=request.getParameter("ctel");
			String cAddress=request.getParameter("address");
			String cAuthority=request.getParameter("authority");
			if("1".equals(cAuthority))
				cAuthority="进货员";
			else
				cAuthority="销售员";
			String cState=request.getParameter("cstate");
			if("1".equals(cState))
				cState="有效";
			else
				cState="无效";
			String salary=request.getParameter("csalary");
			int cSalary=Integer.parseInt(salary );
			clerkbean cb=new clerkbean(code,cPassword,cName ,"","", 
					cTel ,cAddress ,"",cState, cSalary, cAuthority);
			c.update(cb);
			
			
			
			response.sendRedirect(url+"?id="+code);
		}
		

		out.flush();
		out.close();
	}

}
