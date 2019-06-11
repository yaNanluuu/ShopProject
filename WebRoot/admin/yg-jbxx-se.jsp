<%@page import="java.text.SimpleDateFormat"%>
<%@page import="cn.sdcet.shop.dao.jdbc.clmonserviceimpi"%>
<%@page import="cn.sdcet.shop.domain.clmon"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="cn.sdcet.shop.domain.clerkbean"%>
<%@ page import="cn.sdcet.shop.dao.jdbc.clerkserviceimpi"%>
<%request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>员工-基本信息</title>
<link  type="text/css" rel="stylesheet"  href="css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="css/index.css"/>
<script  src="js/jquery.min.js"></script>
<!-- 动态菜单JS -->
<script type="text/javascript"  src="js/menu.js"></script>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>


<style type="text/css">
.a{width:120px;background:#fff;height:24px;margin:0;padding:0;border:0;list-style:none;outline:0; font-size: 100%; outline:0;}
</style>
</head>

<body>



  <div class="main-hd">
   <div class="page-teb" >
    

    <div class="l-tab-content" style="background:#fff;">
     <div class="tab-content-item">
      <div class="home">
      <!--员工管理   开始-->
        <div class="yg-gl">
         <div class="yg-add">

          
          
         </div>
         <form action="yg-jbxx-se.jsp " method="post">
          	
          	<table align="center" width="500px" border="0" cellpadding="0" cellspacing="0" >
          	<tr >
          	<td>代号:<input type="text" name="id" class="a"></td>
          	<td>姓名:<input type="text" name="cname" class="a"></td>
          	</tr>
          	<tr>
          	<td>员工角色:<input type="radio" name="au" value=1>进货员
          				<input type="radio" name="au" value=2>销售员
          				<input type="radio" name="au" value=3>全部
          	
          	</td>
          	<td>状态：<input type="radio" name="state" value=1>有效
          				<input type="radio" name="state" value=2>无效
          				<input type="radio" name="state" value=3>全部</td>
          	</tr>
          	<tr>
          	<td colspan="2" align="center"> 
          	<input type="submit" value="查询" class="ui-xz" >
          	<input type="reset" value="重置" class="ui-xz" >
          	</td></tr>
          	</table>
         
          
          
          
          
          </form>
         <div class="yg-tab">
          <div class="grid">
          <div class="layoutitem" style="width:100%;border:none;">
           
            <table class="gridbar" border="0" cellpadding="0" cellspacing="0">
            <thead>
             <%SimpleDateFormat f2=new SimpleDateFormat("MM");
            SimpleDateFormat f1=new SimpleDateFormat("yyyy");
            String mo=f2.format(new Date());
            String ye=f2.format(new Date());
            int month=Integer.parseInt(mo); 
            int year=Integer.parseInt(ye);%>
             <tr>
              <th scope="col">编号</th>
             
              <th>员工账号</th>
             
              
              <th>员工真实姓名</th>
            
              <th>手机号码</th>
                <th>员工角色</th>
              <th>状态</th>
              <th>工资(<%=month-1 %>月)</th>
              <th>修改</th>
              
              <th>请假</th>
              
             </tr>
             <%
             clerkserviceimpi ci=new clerkserviceimpi();
             clmonserviceimpi cli=new clmonserviceimpi();
             
             String code=request.getParameter("id");
 			String cName=request.getParameter("cname");
 			//System.out.println(cName);
 			String cAuthority=request.getParameter("au");
 			if("1".equals(cAuthority))
 				cAuthority="进货员";
 			else if("2".equals(cAuthority))
 				cAuthority="销售员";
 			else if("3".equals(cAuthority))
 				cAuthority="";
 			String cState=request.getParameter("state");
 			if("1".equals(cState))
 				cState="有效";
 			else if("2".equals(cState))
 				cState="无效";
 			else if("3".equals(cState))
 				cState="";
 			
 			 List<clerkbean> cls=new ArrayList<clerkbean>();
 			clerkbean cb=new clerkbean(code,"",cName ,"" ,"", 
 					"" ,"" ,"",cState, 0, cAuthority);
 			//
             //clerkbean c=request.getAttribute("cb");
             if(code==null&&cName==null&&cAuthority==null&&cState==null){
 				  cls=ci.findall();}
 			else{
            cls=ci.findby(cb);}
             int i=0;
             for(clerkbean cl:cls){
            	 i++;
            	 clmon cl1=new clmon(); 
            	 if("店长".equals(cl.getcAuthority())){
            		 i=i-1;
             %>	<tr hidden>
             <%}else{ %>
             <tr>
              <td><%=i %></td>
              <td><%=cl.getCode() %></td>
              <td><%=cl.getcName() %></td>
              <td><%=cl.getcTel() %></td>
              <td><%=cl.getcAuthority() %></td>
              <td><%=cl.getcState() %></td>
              <%
              
              if("有效".equals(cl.getcState())) {
            	  	int t1=0;
            	 	 int t2=0;
            	 	t1=cli.getPrice(cl.getCode(),  month-1,year);
	            	t2=cli.getLdy(cl.getCode(),  month-1,year);
	            	
	            	double sa=0.00;
					
	            	
	            	
            	//  String s1=getPrice(id));
            	  if(t1==0&&t2==0)
            		   sa=cl.getcSalary();
            	  else if(t1==0){
            		  cl1=cli.getLdy1(cl.getCode(), month-1,year);
        		  		sa=cl1.getMon(); 
            	  }
            	  else if(t2==0){
            		  cl1=cli.getPrice2(cl.getCode(), month-1,year);
        		  	sa=cl1.getMon(); 
            	  } 
            	  else {
            		  cl1=cli.findmon(cl.getCode(), month-1,year);
            		  sa=cl1.getMon(); 
            	  }
            	  //double sa=cl.getcSalary()+t1*0.03-t2*50;
              %>
              <td><%=sa %></td>
              
              <td><a href="yg-jsgl-up.jsp?id=<%=cl.getCode()%>">修改</a></td>
              
              <td><a href="yg-jsgl-mon.jsp?id=<%=cl.getCode()%>">请假</a></td>
              
              <%} %>
              
             </tr>
             <%}} %>
             
             </thead>
            </table>
            
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
