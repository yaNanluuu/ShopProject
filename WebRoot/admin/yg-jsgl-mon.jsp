<%@page import="cn.sdcet.shop.dao.jdbc.clerkserviceimpi"%>
<%@page import="cn.sdcet.shop.domain.clerkbean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="cn.sdcet.shop.domain.clmon"%>
<%@page import="cn.sdcet.shop.dao.jdbc.clmonserviceimpi"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'yg-jsgl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<head>
<meta charset="utf-8">
<title>员工-角色管理</title>
<link  type="text/css" rel="stylesheet"  href="css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="css/index.css"/>
<script  src="js/jquery.min.js"></script>
<!-- 动态菜单JS -->
<script type="text/javascript"  src="js/menu.js"></script>
</head>

<body>


 
  
  <div class="main-hd">
   <div class="page-teb" >
    <div class="l-tab-links">
     <ul style="left:0;">
      <li class="l-select">
       <a href="#" style="padding:0 25px;">首页</a>
      </li>
       <li class="l-select">
       <a href="#">角色管理</a>
       <span class="close"></span>
      </li>
     </ul>
    </div>

    <div class="l-tab-content" style="background:#fff;">
     <div class="tab-content-item">
      <div class="home">
      <!--员工管理   开始-->
      <%String id= request.getParameter("id"); %>
        <div class="yg-gl">
         <div class="yg-add">
         <a href="yg-jsgl-inmon.jsp?id=<%=id %>"><button  class="ui-btn-js" data-method="offset" >新增</button></a> 
         
         </div>
         
         <div class="yg-tab">
          <div class="grid">
          <div class="layoutitem" style="width:100%;border:none;">
           <form method="post"> 
            <table class="gridbar" border="0" cellpadding="0" cellspacing="0">
            <thead>
             <tr>
              
              <th>员工编号</th>
              <th>请假时间</th>
              <th>请假天数</th>
              <th>当月薪资</th>
              
             
             </tr>
             <%
             
             SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
             clerkserviceimpi ci=new clerkserviceimpi();
             clmonserviceimpi cli=new clmonserviceimpi();
             List<clmon> cls=cli.findallbyid(id);
             for(clmon cl:cls){
             %>
             <tr>
             
              <td><%=cl.getCode() %></td>
              <td><%=cl.getLdate()%></td>
              <td><%=cl.getLday() %></td>
              
              <%
              
               Date da=f1.parse(cl.getLdate());
              SimpleDateFormat f2=new SimpleDateFormat("MM");
               SimpleDateFormat fy=new SimpleDateFormat("yyyy");
             String date=f2.format(da);
             	int month=Integer.parseInt(date);
             	 date=fy.format(da);
             	int year=Integer.parseInt(date);
             	//System.out.println(d);
             	
             	
             	clerkbean cb=ci.findbyid(cl.getCode());
             	
             	int t1=0;
       	 		 int t2=0;
       	 		t1=cli.getPrice(cl.getCode(), month,year);
           		t2=cli.getLdy(cl.getCode(),  month,year);
           	
           		double sa=0.00;
					
       	  		if(t1==0&&t2==0)
   		   			sa=cb.getcSalary();
   	  			else if(t1==0){
   		  			cl=cli.getLdy1(cl.getCode(), month,year);
		  			sa=cl.getMon(); 
   	  			}
   	  			else if(t2==0){
   		  			cl=cli.getPrice2(cl.getCode(), month,year);
		  			sa=cl.getMon(); 
   	  			} 
   	  			else {
   		  			cl=cli.findmon(cl.getCode(), month,year);
   		  			sa=cl.getMon(); 
   	  			}
       	  //double sa=cl.getcSalary()+t1*0.03-t2*50;
         %>
         <td><%=sa %></td>
             
            
              
             </tr>
            <%} %>
             </thead>
            </table>
            </form>
            <br/>
            <div class="yg-add">
            
        	 <a href="yg-jbxx-se.jsp"><button  class="ui-btn-js" data-method="offset" >返回</button></a> 
         
         	</div>
           </div>
            
          </div>
         </div>
        </div>       
      <!--员工管理   结束-->
      </div>
     </div>
    </div>
   </div>
  </div>

  
</body>
</html>
