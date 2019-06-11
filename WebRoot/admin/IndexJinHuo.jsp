<%@ page language="java" import="java.util.*" import="java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%@ page language="java" import="common.bean.GoodsBean"%>
<%@ page language="java" import="common.dao.impl.GoodsDaoImpl"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<base href="<%=basePath%>">
    
<title></title>
    
<link  type="text/css" rel="stylesheet"  href="css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="css/index.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/echarts.min.js"></script>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<!-- 动态菜单JS -->
<script type="text/javascript"  src="js/menu.js"></script>
  </head>
  
  <body>
   <jsp:useBean id="gdl" class="common.dao.impl.GoodsDaoImpl" scope="session"></jsp:useBean>
    
		<div>
          <div class="title-name">
           <i></i>
            	<font color="red">紧急库存</font>  
          </div>
          
          <table class="record-list">
           <tbody>
           	<tr>
             <th>商品代号</th>
             <th>商品颜色</th>
             <th>商品尺码</th>
             <th>库存数量</th>
            </tr>
            <%List<GoodsBean> lists = gdl.getAllUrgentNum();
      		for(GoodsBean list:lists){ %>
            <tr>
             <td><%=list.getgId() %></td>
             <td><%=list.getgColor() %></td>
             <td><%=list.getgSize() %></td>
             <td><%=list.getgNum() %></td>
            </tr>
            <%} %>
           </tbody>
          </table>

</div>
  </body>
</html>
