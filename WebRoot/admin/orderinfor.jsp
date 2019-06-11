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
    
    <meta charset="utf-8">
<title>订单管理</title>
<link type="text/css" rel="stylesheet" href="admin/css/style.css" />
<link type="text/css" rel="stylesheet" href="admin/css/index.css" />
<script src="admin/js/jquery.min.js"></script>
<!-- 动态菜单JS -->
<script type="text/javascript" src="admin/js/menu.js"></script>
<link type="text/css" rel="stylesheet" href="admin/css/ordertest.css" />
<link type="text/css" rel="stylesheet" href="admin/css/tanchuinfo.css" />


<script type="text/javascript">
	/*显示隐藏订单信息*/
	function toggle(id) {
		var tb = document.getElementById(id);
		if (tb.style.display == 'none') {
			tb.style.display = 'block';
		} else
			tb.style.display = 'none';
	}
</script>


  </head>
  
  <body>
  <jsp:useBean id="order1" class="cn.sdcet.shop.dao.jdbc.orderinforDaoJDBCImpl" scope="session"></jsp:useBean>

<!--  <div class="right-menu"> -->
	<div class="main-hd">
		<div class="page-teb">
			<div class="l-tab-content" style="background:#fff;">
				<div class="tab-content-item">
					<div class="home">
						<!--员工管理   开始-->
						<div class="yg-gl">
							<div class="yg-add">
							
							<form action="FindServlet" method="post">
							<table>
                                <tr>订单状态&nbsp;&nbsp;</tr>
                                <tr>
                                    <select name="checkstat">
                                        <option value="显示全部" >显示全部</option>
                                        <option value="有效订单" >有效订单</option>
                                        <option value="退货订单" >退货订单</option>
                                    </select>
                                </tr>
                                <tr>&nbsp;&nbsp;&nbsp;&nbsp;查询条件&nbsp;&nbsp;&nbsp;&nbsp;</tr>
                                <tr>                           
                                    <select name="checkstat2">
                                        <option value="显示全部" >显示全部</option>
                                        <option value="订单编号" >订单编号</option>
                                        <option value="客户编号" >客户编号</option>
                                    </select>
                                </tr>
                                <tr><input type="text" class="buedit" name="textin" placeholder="请输入编号">&nbsp;&nbsp;</tr>
                                <tr>
                                    <input type="submit" class="ui-xz" style="width: 79px; " value="搜索">
                                </tr>
                            </table>
							</form>


							</div>

							<div class="yg-tab">
								<div class="grid">
									<div class="layoutitem" style="width:100%;border:none;">
										<form method="post" action="">
										
											<table class="gridbar" border="0" cellpadding="0"
												cellspacing="0">
												<thead>
													<tr>
														<th scope="col">订单编号</th>
														<th scope="col">客户编号</th>
														<th>商品代号</th>
														<th>尺寸</th>
														<th>颜色</th>
														<th>价格</th>
														<th>数量</th>
														<th>折扣</th>
														<th>总价</th>
														<th>状态</th>
														<th>创建时间</th>
														<th>操作</th>
													</tr>

													<!-- 订单信息展示 -->
													<%
														List<Orderinfor> orderinfors = order1.findAllOrderinfor();
														for(Orderinfor orderinfor : orderinfors){
															
														
													%>

													<tr align="center">
														<td><%=orderinfor.getOrId() %></td>
														<td><%=orderinfor.getCtId() %></td>
														<td><%=orderinfor.getgId() %></td>
														<td><%=orderinfor.getgSize() %></td>
														<td><%=orderinfor.getgColor() %></td>
														<td><%=orderinfor.getgPrice() %></td>
														<td><%=orderinfor.getQuantity() %></td>
														<td><%=orderinfor.getgSale() %></td>
														<td><%=orderinfor.getSumprice() %></td>
														<td><%=orderinfor.getOrState() %></td>
														<td><%=orderinfor.getOrDate() %></td>
														<td>
															<!-- <button class="ui-xz" data-method="offset">
																<a href="admin/">修改状态</a>
															</button> -->
															<%
																String message = orderinfor.getOrState();
															if(("有效".equals(message))==true){
															%>
															<input type="button" class="ui-xz" value="修改状态" onClick="toggle('<%=orderinfor.getOrId() %>forup')" style="width: 79px; " />
															<input type="button" class="ui-xz" value="详细信息" onClick="toggle('<%=orderinfor.getOrId() %>')" style="width: 79px; " />
															<%}else{ %> 
															<input type="button" class="ui-xz" value="禁止修改"  style="width: 79px; " />
															<input type="button" class="ui-xz" value="详细信息" onClick="toggle('<%=orderinfor.getOrId() %>')" style="width: 79px; " />
															<%} %>
														</td>
													</tr>
												<%} %>



												</thead>
											</table>
										</form>



									</div>
									<div class="pagin">
										<div class="message">
											共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页
										</div>
										<ul class="paginList">
											<li class="paginItem"><a href="#"><span
													class="pagepre"><img src="admin/images/jt1.png"></span></a></li>
											<li class="paginItem"><a href="#">1</a></li>
											<li class="paginItem current"><a href="#">2</a></li>
											<li class="paginItem"><a href="#">3</a></li>
											<li class="paginItem"><a href="#">4</a></li>
											<li class="paginItem"><a href="#">5</a></li>
											<li class="paginItem more"><a href="#">...</a></li>
											<li class="paginItem"><a href="#">10</a></li>
											<li class="paginItem"><a href="#"><span class="pagenxt"><img src="admin/images/jt.png"></span></a></li>
										</ul>
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
	<!--  </div> -->
	<!-- 弹窗 -->
	<!-- 显示订单的详细信息 -->
	<form action="" method="post">
<%
			
		for(Orderinfor orderinfor : orderinfors){
															
														
													%>
		<div id="<%=orderinfor.getOrId() %>" class="tanch" style="display: none;">

			<!-- 弹窗内容 -->
			<div class="tanch2">

				<table cellpadding="0" cellspacing="0" border="0" class="formborder"
					style="z-index:99;position:absolute;left:1px;top:7px;width:880px; display: block;">
					<tbody>

						<tr>
							<td align="left" valign="top"
								style="width:880px;height:579px;background:#fff;">
								<div class="formcontentsize" style="width:auto;height:auto;">
									<!--订单基本信息   开始-->
									<div class="layoutitem">
										<div class="layout-tit">订单基本信息</div>
										<div class="layout-xx">
											<ul>
												<li>
													<div class="item-input">
														<label class="item-label"> 订单编号:</label> 
														<input type="text" value="<%=orderinfor.getOrId() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">客户编号:</label>  
														<input type="text" value="<%=orderinfor.getCtId() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>

												<li>
													<div class="item-input">
														<label class="item-label"> 商品代号:</label> <input
															type="text" value="<%=orderinfor.getgId() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">商品编号:</label> <input type="text"
															value="<%=orderinfor.getgNo() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>
												<li>
													<div class="item-input">
														<label class="item-label"> 店员代号:</label> <input
															type="text" value="<%=orderinfor.getCode() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">商品类别:</label> <input type="text"
															value="<%=orderinfor.getgType() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>
												<li>
													<div class="item-input">
														<label class="item-label"> 商品颜色:</label> <input
															type="text" value="<%=orderinfor.getgColor()%>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">商品尺寸:</label> <input type="text"
															value="<%=orderinfor.getgSize() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>
												<li>
													<div class="item-input">
														<label class="item-label"> 单价:</label> <input type="text"
															value="<%=orderinfor.getgPrice() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">数量:</label> <input type="text"
															value="<%=orderinfor.getQuantity() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>
												<li>
													<div class="item-input">
														<label class="item-label"> 折扣:</label> <input type="text"
															value="<%=orderinfor.getgSale() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">总价:</label> <input type="text"
															value="<%=orderinfor.getSumprice() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>
												<li>
													<div class="item-input">
														<label class="item-label"> 支付方式:</label> <input
															type="text" value="<%=orderinfor.getOrPay() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">订单状态:</label> <input type="text"
															value="<%=orderinfor.getOrState() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>
												<li>
													<div class="item-input">
														<label class="item-label"> 创建时间:</label> <input
															type="text" value="<%=orderinfor.getOrDate() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>


											</ul>
										</div>
									</div>



									<div class="layoutitem-add">
										<!--<button id="closeinfo" class="tc">退出</button>-->
										<input type="button" class="ui-xz" value="关闭"
											onClick="toggle('<%=orderinfor.getOrId() %>')" />
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>

			</div>

		</div>
<%} %>
	</form>


	<!-- 修改订单的状态 -->
		<form action="UpdateOrderinforstatServlet" method="post">
<%
			
		for(Orderinfor orderinfor : orderinfors){
															
														
													%>
		<div id="<%=orderinfor.getOrId() %>forup" class="tanch" style="display: none;">
			<!-- 弹窗内容 -->
			<div class="tanch2">

				<table cellpadding="0" cellspacing="0" border="0" class="formborder"
					style="z-index:99;position:absolute;left:1px;top:7px;width:880px; display: block;">
					<tbody>

						<tr>
							<td align="left" valign="top"
								style="width:880px;height:579px;background:#fff;">
								<div class="formcontentsize" style="width:auto;height:auto;">
									<!--订单基本信息   开始-->
									<div class="layoutitem">
										<div class="layout-tit">修改订单状态</div>
										<div class="layout-xx">
											<ul>
												<li>
													<div class="item-input">
														<label class="item-label"> 订单编号:</label> 
														<input type="text" name="uporid" value="<%=orderinfor.getOrId() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">客户编号:</label>  
														<input type="text" value="<%=orderinfor.getCtId() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>

												<li>
													<div class="item-input">
														<label class="item-label"> 商品代号:</label> <input
															type="text" value="<%=orderinfor.getgId() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">商品编号:</label> <input type="text"
															value="<%=orderinfor.getgNo() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
												</li>
												
												<li>
													<div class="item-input">
														<label class="item-label">总价:</label> <input type="text"
															value="<%=orderinfor.getSumprice() %>" class="layoutitemcon" maxlength="50" readOnly="true">
													</div>
													<div class="item-input">
														<label class="item-label">订单状态:&nbsp;&nbsp;&nbsp;&nbsp;</label> 
														<%-- <input type="text" name="upstat"
															value="<%=orderinfor.getOrState() %>" class="layoutitemcon" maxlength="50" >
														<select name="upstat">
															<option value="有效">有效</option>
															<option value="退单">退单</option>
														</select> --%>
														<input type="radio" name="upstat" value="有效"/>有效
														<input type="radio" name="upstat" value="退单" />退单
													</div>
												</li>

											</ul>
										</div>
									</div>



									<div class="layoutitem-add">
										
										<button type="submit" class="ui-xz" >保存</button>
										<input type="button" class="ui-xz" value="关闭"
											onClick="toggle('<%=orderinfor.getOrId() %>forup')" />
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>

			</div>

		</div>
<%} %>
	</form>

	

  </body>
</html>
