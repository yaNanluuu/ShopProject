<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@page import="cn.sdcet.shop.domain.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>增加客户信息</title>
<!--
<link  type="text/css" rel="stylesheet"  href="css/addInfo.css"/>-->
<link  type="text/css" rel="stylesheet"  href="../css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="../css/index.css"/>

</head>

<body>
<jsp:useBean id="dao7"	class="cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl" scope="session"></jsp:useBean>


 <table cellpadding="0" cellspacing="0" border="0" class="formborder" style="z-index:99;position:absolute;display: block;" >
  <tbody>
   <tr>
   <td align="left" valign="top" style="width:880px;height: auto;background:#fff;">
    <div class="formcontentsize" style="width:auto;height:auto;">
     <!--仓库基本信息   开始-->
     	<div class="con-header">
         <ul class="ui-inline">
         <form action="search.jsp" method="post">
          <li>
           	<input type="text" class="ui-kh" placeholder="姓名" name="name">
            <input type="text" class="ui-kh" placeholder="电话" name="tel">  
          </li>
          <li><input type="submit" value="查询" class="ui-btn11 ui-btn-search"></li>
          </form>
         </ul>
        </div>
     <form method="post" class="form-x" action="<%=basePath%>/servlet/CustomerAdd"  accept-charset="utf-8">
     <div class="layoutitem">
      <div class="layout-xx">
       <ul>
        <li>
          <div class="item-input">
          <label class="item-label"><i>*</i>姓名</label>
          <input id="ctName" type="text" class="layoutitemcon" maxlength="50" name="ctName" />
          <% String message1 = (String) request.getAttribute("message1");
          	 String message2 = (String) request.getAttribute("message2");
          	if (message1 != null) {
          %>
          <font color="red"><%=message1 %></font>
          <%} %>
         </div>
        </li>
        
        <li>
         <div class="item-input">
          <label class="item-label">性别</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctSex">
         </div>
         <div class="item-input">
          <label class="item-label">等级</label>  
          <select name="catalogId" class="input w50">
				<option value="">请选择分类</option>
				<%
   			    	List<Catalog> catalogs = dao7.findAll();
    			    	for(Catalog catalog : catalogs) {%>
							<option value="<%=catalog.getCatalogId()%>"><%=catalog.getGrade()%></option>
						<%}%>
			</select>
         </div>
        </li>
        <li>
         <div class="item-input">
          <label class="item-label"> 联系电话</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctTel">
          <% 	if (message2 != null) {
          %>
          <font color="red"><%=message2 %></font>
          <%} %>
         </div>
           <div class="item-input">
          <label class="item-label">邮箱</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctEmail">
         </div>
        </li>
        <li>
         <div class="item-input">
          <label class="item-label">出生日期</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctBirthday">
         </div>
         <div class="item-input">
          <label class="item-label">家庭住址</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctAddress">
         </div>
        </li>
         <!-- 
        <li>     
         <div class="item-input">
          <label class="item-label">创建时间</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctCreateDate">
         </div>
        </li>
         -->
       </ul>
      </div>
     </div>

     <div class="layoutitem-add">
     <button class="bc" type="submit">保存</button>   
     <button class="bc" type="reset" onclick="window.history.back()">取消</button>          
     </div>
 </form>
    </div>
   </td>
   </tr>
   
   <tr>
   	<td align="left" valign="top" style="width:880px;height: auto;background:#fff;">
    <div class="formcontentsize" style="width:auto;height:auto;"></div>
   </td>
   </tr>
  </tbody>
 </table>     
</body>
</html>
