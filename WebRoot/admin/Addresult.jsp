<%@page import="cn.sdcet.shop.domain.Orderinfor"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addorderinfor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />
    <link type="text/css" rel="stylesheet" href="admin/css/index.css" />
    <script src="admin/js/jquery.min.js"></script>
    <!-- 动态菜单JS -->
    <script type="text/javascript" src="js/menu.js"></script>
    <link type="text/css" rel="stylesheet" href="admin/css/ordertest.css" />
    <link type="text/css" rel="stylesheet" href="admin/css/tanchuinfo.css" />




  </head>
  
  <body>
  <jsp:useBean id="addorder" class="cn.sdcet.shop.dao.jdbc.orderinforDaoJDBCImpl" scope="session"></jsp:useBean>



     <table cellpadding="0" cellspacing="0" border="0" class="formborder"
           style="z-index: 99; position: absolute; left: 1px; top: 7px; width: 880px; display: block;">
        <tbody>

        <tr>
            <td align="left" valign="top"
                style="width:880px;height:579px;background:#fff;">
                <div class="formcontentsize" style="width:auto;height:auto;">
                    <!--订单基本信息   开始-->
                    
                    <%//String message = request.getAttribute("message"); 
                    
                    %>
                    <div class="layoutitem">
                        <div class="layout-tit"></div>
                        <div class="layout-xx">
                            <ul>
                            	<li>
                            		<font size="6" color="black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加失败：</font><!-- <br><br> -->
                            	</li>
                            	<li>
                            		
									<center>
									<font size="5" color="black">剩余库存量: <%out.println(request.getAttribute("message"));%></font>
									</center>
                            	</li>
                            </ul>
                        </div>
                    </div>



                    <div class="layoutitem-add">
                        <a type="button" class="ui-xz" href="admin/addorderinfor.jsp">确认</a>
                    </div>
                    
                    		
                    
                </div>
               
            </td>
        </tr>
        
        </tbody>
    </table>


  </body>
</html>
