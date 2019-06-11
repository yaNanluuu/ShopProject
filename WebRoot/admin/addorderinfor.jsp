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

<%//
String action1 = "1";
	String idorder = "";
	action1 = request.getParameter("action1");
	String ttt = "6";
	//System.out.println(ttt);
	if( ("5".equals(action1)) == true){
		idorder = request.getParameter("addgid"); //获取商品代号
		ttt = "1";
		
		System.out.println(idorder);
	}
	
	//库存
	/* String action2 = "";
	int test = 1;
	action2 = request.getParameter("action2");
	if(("5".equals(action2))==true){
		test = 0;
		action1 ="5";
	} */
	
%>


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
                    <div class="layoutitem">
                        <div class="layout-tit">添加订单</div>
                        <div class="layout-xx">
                            <ul>
                                <li>
                                
                                	<form id="first1" action="<%=basePath%>admin/addorderinfor.jsp?action1=5" method="post">
                                    <div class="item-input">
                                        <label class="item-label"> 商品代号:</label>
                                        <input type="text" name="addgid" value="<%=idorder %>" class="layoutitemcon" maxlength="50" >
                                        <button type="submit" class="ui-xz">查询</button>
                                    </div>
                                    </form>
                                    
                                    <div class="item-input">
                                        <label class="item-label">订单编号:</label>
                                        <input type="text" value="添加后自动生成" class="layoutitemcon" maxlength="50" readOnly="true">
                                    </div>

                                </li>
                                
                        		<!-- 原位置 -->
                                
                                <form id="second2" action="AddOrderinforServlet" method="post">
                                <%
                                	if(("6".equals(ttt))==true){
                                		//在数据库中查询显示的信息
                                	
                                 	
                                %>
                                
                                <!-- 查询显示 -->
								
                                <li>
	                                <div class="item-input">
	                                    <label class="item-label">商品类别:</label>
	                                    <input type="text" name="addgtype" value="" class="layoutitemcon" maxlength="50" readOnly="true">
	                                </div>
                                    <div class="item-input">
                                        <label class="item-label"> 单价:</label>
                                        <input type="text" name="addgprice" value="" class="layoutitemcon" maxlength="50" readOnly="true">
                                    </div>
                                    <input type="submit" class="ui-xz" value="查询"/>

                                </li>
                                <li>

                                    <div class="item-input">
                                        <label class="item-label"> 商品颜色:</label>
                                        <!-- <input type="text" value="" class="layoutitemcon" maxlength="50" readOnly="true">-->
                                        <select name="addgcolor" style="width: 235px" class="layoutitemcon">
                                            <option value=""></option>
                                        </select>
                                        
                                    </div>

                                    <div class="item-input">
                                        <label class="item-label"> 折扣:</label>
                                        <input type="text" name="gsale" value="" class="layoutitemcon" maxlength="50" readOnly="true">
                                    </div>
                                    <input type="submit" class="ui-xz" value="查询"/>
                                </li>
                                <li>
                                    <div class="item-input">
                                        <label class="item-label">商品尺寸:</label>
                                        <!--<input type="text" value="" class="layoutitemcon" maxlength="50" readOnly="true">-->
                                        <select name="addgsize" style="width: 235px" class="layoutitemcon">
                                            <option value=""></option>
                                        </select>
                                        
                                    </div>
								<!-- 查询显示 -->
								
								<%}
                                	else{
                                		//默认显示信息
                                	
                                %>
								
								
								<!-- 查询显示 -->
                                <li>
	                                <div class="item-input">
	                                <%
	                                	List<Orderinfor> orderinforinfos = addorder.findOrderinforbygid(idorder);
	                                	
	                                %>
	                                    <label class="item-label">商品类别:</label>
	                                    <%for(Orderinfor orderinfor : orderinforinfos){
	                                    %>
	                                    <input type="text" name="addgtype" value="<%=orderinfor.getgType() %>" class="layoutitemcon" maxlength="50" readOnly="true">
	                                    <%} %>
	                                </div>
                                    <div class="item-input">
                                        <label class="item-label"> 单价:</label>
                                        <%for(Orderinfor orderinfor : orderinforinfos){ %>
                                        <input type="text" name="addgprice" value="<%=orderinfor.getgPrice() %>" class="layoutitemcon" maxlength="50" readOnly="true">
                                        <%}%>
                                    </div>
                                    <!-- <input type="submit" class="ui-xz" value="查询"/> -->

                                </li>
                                <li>

                                    <div class="item-input">
                                        <label class="item-label"> 商品颜色:</label>
                                        <!-- <input type="text" value="" class="layoutitemcon" maxlength="50" readOnly="true">-->
                                        <select name="addgcolor" style="width: 235px" class="layoutitemcon">
                                       <%
                                       List<Orderinfor> orderinforcolor = addorder.findcolor(idorder);
                                       for(Orderinfor orderinfor1 :orderinforcolor){ %>
                                            <option value="<%=orderinfor1.getgColor()%>"><%=orderinfor1.getgColor()%></option>
                                       <%} %>
                                        </select>
                                        
                                    </div>

                                    <div class="item-input">
                                        <label class="item-label"> 折扣:</label>
                                        <%for(Orderinfor orderinfor : orderinforinfos){ %>
                                        <input type="text" name="gsale" value="<%=orderinfor.getgSale() %>" class="layoutitemcon" maxlength="50" readOnly="true">
                                        <%} %>
                                    </div>
                                    <input type="submit" class="ui-xz" value="查询"/>
                                </li>
                                <li>
                                    <div class="item-input">
                                        <label class="item-label">商品尺寸:</label>
                                        <!--<input type="text" value="" class="layoutitemcon" maxlength="50" readOnly="true">-->
                                        <select name="addgsize" style="width: 235px" class="layoutitemcon">
                                        <%List<Orderinfor> orderinforsize = addorder.findsize(idorder);
                                          for(Orderinfor orderinfor2 : orderinforsize){%>
                                            <option value="<%=orderinfor2.getgSize() %>"><%=orderinfor2.getgSize() %></option>
                                            <%} %>
                                        </select>
                                        
                                    </div>
								<!-- 查询显示 -->
								
								<% }%>
								
                                    <div class="item-input">
                                        <label class="item-label">数量:</label>
                                        <input type="text" name="quantity" value="" class="layoutitemcon" maxlength="50" >
                                    </div>
                   					
                                </li>
                                
                                <li>
                                    
                                    <div class="item-input">
                                        <!-- <label class="item-label">数量:</label>
                                        <input type="text" name="quantity" value="" class="layoutitemcon" maxlength="50" > -->
                                    </div>

                                    <div class="item-input">
                                        <!-- <label class="item-label">总价:</label>
                                        <input type="text" name="sumprice" value="" class="layoutitemcon" maxlength="50" > -->
                                    </div>
                                </li>
                                <li>
                                
                           			<div class="item-input">
                                        <label class="item-label">客户编号:</label>
                                        <select name="addctid" style="width: 235px" class="layoutitemcon">
                                        <option value="0">请选择客户编号</option>
                                        <% List<Orderinfor> orderinforsctid = addorder.findAllctid();
                                        	for(Orderinfor orderinfor : orderinforsctid){%>
                                            <option value="<%=orderinfor.getCtId() %>"><%=orderinfor.getCtId() %></option>
                                        <%} %>
                                        </select>
                                    </div>
                                    <div class="item-input">
                                        <label class="item-label"> 店员代号:</label>
                                        <!--<input type="text" value="" class="layoutitemcon" maxlength="50" readOnly="true">-->
                                        <select name="addcode" style="width: 235px" class="layoutitemcon">
                                        	<option value="">请选择店员代号</option>
                                        <% List<Orderinfor> orderinforcode = addorder.findAllcode();
                                        	for(Orderinfor orderinfor : orderinforcode){%>
                                            <option value="<%=orderinfor.getCode() %>"><%=orderinfor.getCode() %></option>
                                        <%} %>
                                        </select>
                                    </div>
                                </li>
                                <li>

                                    <div class="item-input">
                                        <label class="item-label">订单状态:</label>
                                        <input type="text" name="addsata" value="有效" class="layoutitemcon" maxlength="50" readOnly="true">
                                    </div>
                                    <div class="item-input">
                                        <label class="item-label"> 支付方式:</label>
                                        <!--<input type="text" value="" class="layoutitemcon" maxlength="50" readOnly="true">-->
                                        <select name="addorpay" style="width: 235px" class="layoutitemcon">
                                            <option value="现金">现金</option>
                                            <option value="支付宝">支付宝</option>
                                            <option value="微信">微信</option>
                                            <option value="银行卡">银行卡</option>
                                        </select>
                                    </div>
                                </li>
                                <!--<li>
                                    <div class="item-input">
                                        <label class="item-label"> 创建时间:</label>
                                        <input type="text" value="" class="layoutitemcon" maxlength="50" readOnly="true">
                                    </div>
                                </li>-->


                            </ul>
                        </div>
                    </div>



                    <div class="layoutitem-add">
                        <button type="submit" class="ui-xz">添加</button>
                        <a type="button" class="ui-xz" href="admin/index.jsp">取消</a>
                    </div>
                    
                    			</form>
                    
                </div>
               
            </td>
        </tr>
        
        </tbody>
    </table>


  </body>
</html>
