
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@page import="cn.sdcet.shop.dao.*"%>

<%@page import="cn.sdcet.shop.domain.*"%>
<%@page import="cn.sdcet.shop.dao.jdbc.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>客户信息管理</title>
<link  type="text/css" rel="stylesheet"  href="css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="css/index.css"/>


<script  src="js/jquery.min.js"></script>
<!-- 动态菜单JS -->
<script type="text/javascript"  src="js/menu.js"></script>
</head>

<body>
 <% String message = (String) request.getAttribute("message");
    if (message != null) {
 %>
   <script type="text/javascript">
      alert("<%=message%>");
   </script>
 <%} %>

  <div class="main-hd">
   <div class="page-teb" >

    <div class="l-tab-content" style="background:#fff;">
     <div class="tab-content-item">
      <div class="home">
      <!--员工管理   开始-->
        
        <div class="yg-gl">
         <div class="khgl-rg " style="margin-bottom:15px;">
          <a href="addInfo.jsp" class="xz">新增</a>
          <a href="addInfo.jsp" class="xz">退出</a>
         </div>
         <div class="yg-tab">
          <div class="wrap-li">
            <table class="gridbar" border="0" cellpadding="0" cellspacing="0">
            <thead>
             <tr>
              <th>编号</th>
              <th>姓名</th> 
              <th>性别</th>          
              <th>等级</th>
              <th>联系电话</th>
              <th>邮箱</th>
			  <th>出生日期</th>
			  <th>家庭住址</th>
			  <th>操作</th>
             </tr>
            </thead>
         
            <thead>
            <%
            request.setCharacterEncoding("utf-8");
            String ctName=request.getParameter("name");
            String ctTel=request.getParameter("tel");
            Customer customer1=new Customer();
            customer1.setCtName(ctName);
            customer1.setCtTel(ctTel);
    		//System.out.println(ctTel);
    		CustDaoJDBCImpl dao = new CustDaoJDBCImpl();
			List<Customer> customers = dao.findCustomerByOther(customer1);
            CatalogDaoJDBCImpl cli=new CatalogDaoJDBCImpl();
				if(customers.size() != 0){
					for(Customer customer : customers){
						Catalog c=cli.findbyid(customer.getCatalogId() );
			%>			
             <tr>
              <td><%=customer.getCtId() %></td>
              <td><%=customer.getCtName() %></td> 
              <td><%=customer.getCtSex() %></td>          
              <td><%=c.getGrade() %></td>
              <td><%=customer.getCtTel() %></td>
              <td><%=customer.getCtEmail() %></td>
              <td><%=customer.getCtBirthday() %></td>
              <td><%=customer.getCtAddress() %></td>
              <td><a href="UpdateInfo.jsp?id=<%=customer.getCtId()%>">修改</a></td>

             </tr>             
            </thead>
          
           <%}} 
				else{
			%>
			<font size="6" color="black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;搜索结果：</font><br><br>
					<center>
					<font size="5" color="black"> 对不起，此客户不存在!!!</font>
					</center>
			
			<%} %>
          </div>         
         </div> 
      </div>
     </div>
    </div>
   </div>
  </div>

  
</body>
</html>

