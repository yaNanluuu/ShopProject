
<%@page import="cn.sdcet.shop.dao.*"%>

<%@page import="cn.sdcet.shop.dao.jdbc.*"%>

<%@page import="cn.sdcet.shop.domain.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	int month1=0,year1=0;
String action=request.getParameter("action");
if(action!=null){
 year1=Integer.parseInt(request.getParameter("ye")); 
 month1=Integer.parseInt(request.getParameter("mo"));
 
 
 
 }
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta charset="utf-8">
<title>财经-出款单</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
<script src="js/jquery.min.js"></script>
<!-- 动态菜单JS -->
<script type="text/javascript" src="js/menu.js"></script>
</head>

<body>
	<jsp:useBean id="daoa" class="cn.sdcet.shop.dao.jdbc.caiwuDaoJDBCImpl"
		scope="session"></jsp:useBean>

	<div class="con-header">
		<div class="header-rg">
			<div class="ident"></div>
			<div class="ident"></div>
		</div>
	</div>
	<form method="post" action="<%=basePath%>admin/caiwu.jsp?action=5">
		<%-- //action="<%=request.getContextPath() %>/caiwuchaxun" --%>
		<div class="yg-gl">
			<div class="layoutgr ckd">

				<ul> 
					<li><label class="ck">年</label> <input type="text" id="ye"
						name="ye" value="2019" class="buedit"> 
						月 <input type="text" id="mo" name="mo" value="1" class="buedit"></li>

					<li>
						<button type="submit">查询</button>
					</li>

				</ul>
			</div>
	</form>
	
	<div class="yg-tab">
		<div class="grid">
			<div class="layoutitem" style="width:100%;border:none;">
						<%
					if(action!=null) {	
							
							 List<clerkbean> cls=new ArrayList<clerkbean>();
							 clerkservice clsi=new clerkserviceimpi();
							 clmonserviceimpi cli=new clmonserviceimpi();
							 cls=clsi.findall();         	
							for(clerkbean cl : cls){
								if(!("店长".equals(cl.getcAuthority()))&&"有效".equals(cl.getcState())){
									int t1=0;
            	 	 				int t2=0;
            	 					t1=cli.getPrice(cl.getCode(),  month1,year1);
            	 					//System.out.println(cl.getCode());
	            					t2=cli.getLdy(cl.getCode(),  month1,year1);
	            					
	            					caiwu cai=new  caiwu();
	            					
									//System.out.println(t1);
									//System.out.println(t2);
	            					if(t1==0&&t2==0){
            		   					 cai.setMon(cl.getcSalary());
            		   					 cai.setCode(cl.getCode());
            		   					 cai.setCname(cl.getcName());
            		   					 cai.setCsalary(cl.getcSalary());
            		   					 }
            	  					else if(t1==0){
            		  					 cai=daoa.selectcaiwu1(cl.getCode(),   year1,month1);
            	  						cai.setSump(0);	
            	  					}
            	  					else if(t2==0){
            		 					  cai=daoa.selectcaiwu2(cl.getCode(),  year1,month1);
            	  					}  
            	  					else {
            		 					  cai=daoa.selectcaiwu(cl.getCode(),  year1,month1);
            	  					}
									int a=cai.getCsalary();
									int b=cai.getLeaveday();
									double c=cai.getSump();
									double d=cai.getMon();
							%>
				<table class="table table-hover text-center">
	
				<h3><%=cl.getcAuthority() %></h3>
					<tr>
					     <th>月份</th>
						<th>员工编号</th>
						<th>员工名称</th>
						<th>销售额</th>
						<th>基本工资</th>
						<th>请假时长</th>
						<th>工资</th>
					</tr>
					<volist name="list" id="vo">
					<tr>
                        <td width="10%"><%=month1 %></td>
						<td width="15%"><%=cai.getCode()%></td>
						<td width="15%"><%=cai.getCname() %></td>
						<td width="15%"><%=cai.getSump() %></td>
						<td width="15%"><%=cai.getCsalary() %></td>
						<td width="15%"><%=cai.getLeaveday() %></td>
						
						<td width="15%"><%=d %></td>	
					</tr>				
				</table>
				<%
								}
							}
					}
				 %>
				
				
			</div>
		</div>
	</div>
	</div>
	<div class="cellspacing">
		<div class="cell-zd"></div>
		<div class="cell-je"></div>
	</div>

	</div>



</body>
</html>

