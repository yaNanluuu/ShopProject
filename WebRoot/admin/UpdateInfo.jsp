
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.sdcet.shop.domain.*"%>
<%@page import="cn.sdcet.shop.dao.jdbc.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改信息</title>
    <link  type="text/css" rel="stylesheet"  href="css/addInfo.css"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script>
	function ok(){
		alert("修改信息成功！");
	}
</script>
  </head>
  
  <body>
	<jsp:useBean id="dao7"	class="cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl" scope="session"></jsp:useBean>
	<%
		String ctId = request.getParameter("id");
	System.out.println(ctId);
	    
	    CustDaoJDBCImpl cs = new CustDaoJDBCImpl();
	    Customer customer = new Customer();
	    customer=cs.findbyid(ctId);
	    
		String message = (String) request.getAttribute("message");
		
	%>
	
	<div class="formoverlay"></div>
	<form method="post" class="form-x" action="<%=basePath%>/servlet/UpdateInfoServlet?id=<%=ctId%>"  accept-charset="utf-8">
<%System.out.println(request.getContextPath()); %>

 	<table cellpadding="0" cellspacing="0" border="0" class="formborder" style="z-index:99;position:absolute;display: block;" >
 	 <tbody>
  	 <tr>
   	<td align="left" valign="top" style="width:880px;height: auto;background:#fff;">
    <div class="formcontentsize" style="width:auto;height:auto;">
     <div class="layoutitem">
      <div class="layout-xx">
       <ul>
        <li>
          <div class="item-input">
          <label class="item-label"><i>*</i>姓名</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctName" value=<%=customer.getCtName() %> >
         </div>
        </li>
        <li>
         <div class="item-input">
          <label class="item-label">性别</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctSex" value=<%=customer.getCtSex() %> readonly="readonly">
         </div>
         <div class="item-input">
          <label class="item-label">等级</label>
          <select name="catalogId" class="input w50">
          <%
   			    	List<Catalog> catalogs = dao7.findAll();
    			    for(Catalog catalog : catalogs) {
    			    %>
				
					<option value="<%=catalog.getCatalogId()%>"><%=catalog.getGrade()%></option>
					<%}%>
			</select>
         </div>
        </li>
        <li>
         <div class="item-input">
          <label class="item-label"> 联系电话</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctTel" value=<%=customer.getCtTel() %>>
         </div>
           <div class="item-input">
          <label class="item-label">邮箱</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctEmail" value=<%=customer.getCtEmail() %>>
         </div>
        </li>
        <li>
         <div class="item-input">
          <label class="item-label">出生日期</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctBirthday" value=<%=customer.getCtBirthday() %> readonly="readonly">
         </div>
         <div class="item-input">
          <label class="item-label">家庭住址</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctAddress" value=<%=customer.getCtAddress() %>>
         </div>
        </li>
        <li>
         <div class="item-input">
          <label class="item-label">创建时间</label>
          <input type="text" class="layoutitemcon" maxlength="50" name="ctCreateDate" value=<%=customer.getCtCreateDate() %> readonly="readonly">
         </div>
        <div class="item-input">
        </li>
       </ul>
      </div>
     </div>
    </div>
   </td>
   </tr>
   
   <tr>
   <td align="left" valign="top" style="width:880px;height: auto;background:#fff;">
    <div class="formcontentsize" style="width:auto;height:auto;">

     <div class="layoutitem-add">
     <button class="bc" type="submit" onclick="ok()">保存</button>   
     <button class="bc" type="reset" onclick="window.history.back()">取消</button>          
     </div>
    </div>
   </td>
   </tr>
  </tbody>
 </table>
</form>
       
  </body>
</html>
