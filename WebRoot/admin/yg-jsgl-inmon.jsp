<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <title>弹窗-角色管理</title>

<style>
html,body,div,span,ul,li,h1,h2,h3,h4,p,a,img,input,form{margin:0;padding:0;border:0;list-style:none;outline:0;}
div,td,ul,li,dl,dt,dd,h2,h3,h4{list-style:none;margin:0;padding:0;}
div{display:block;}
body{font-size:12px;font-family:"微软雅黑", "宋体", Arial;color:#666;}
li{display:list-item;text-align:-webkit-match-praent;}
img{vertical-align:middle;}
em{font-style:normal;color:#fff;}
input, textarea, select, button { font-family: inherit; font-size: 100%; outline:0;}
a img{border:0}
body{color:#333;font:12px "微软雅黑";}
ul, ol, li{list-style-type:none;vertical-align:0}
a{outline-style:none;color:#535353;text-decoration:none;cursor:pointer}
a:hover{text-decoration:none;}
.clear{height:0;overflow:hidden;clear:both}
i,s{text-decoration:none;font-style:normal;}


.formoverlay{cursor:default;width:500px;height:300px;z-index:5;opacity:0.5;background:#999;position:absolute;left:0;top:0;width:100%;height:100%;display: block;}
.jsgl{width:440px;border:none;height:auto;}
.lay-list{width:420px;margin:15px auto;border:1px solid #ddd;}
.lay-list ul{padding:5px;}
.lay-list li{height:40px;line-height:40px;margin-bottom:5px;display:block;overflow:hidden;}
.lay-js{float:left;overflow:hidden;display:inline-block;width:50%;}
.iten-js{width:68px;line-height:40px;display:inline-block;text-align:right;}
.jsedit{width:120px;background:#fff;height:24px;line-height:24px;border:1px solid #ddd;text-indent:5px;margin-left:5px;}
.lay-js1{float:left;overflow:hidden;display:inline-block;width:100%;}
.text-js{border:1px solid #ddd;width:80%;height:80px;text-indent:10px;}
.jsedit1{width:300px;background:#fff;height:24px;line-height:24px;border:1px solid #ddd;text-indent:5px;margin-left:5px;}


.layoutitem-add{float:right;padding-right:15px;}
.layoutitem-add a{width:45px;height:24px;line-height:24px;margin:12px 8px ;display:inline-block;padding:2px 3px;}
.add{background:#ff0303;color:#fff;border-radius:3px;text-align:center;}
.bc{background:#f94913;border-radius:3px;text-align:center;color:#fff;}
.tc{background:#333;border-radius:3px;text-align:center;color:#fff;}
</style>
</head>

<body>
<%
 String id= request.getParameter("id");
//System.out.println(id);

%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form action="<%=basePath %>clmon?action=insert&id=<%=id %>" method="post">

<div class="formoverlay"></div>
 <table cellpadding="0" cellspacing="0" border="0" class="formborder" style="z-index:99;position:absolute;left:350px;top:100px;width:440px;display: block;" >
  <tbody>
   
   <tr>
   <td align="left" valign="top" style="width:440px;height: auto;background:#fff;overflow:hidden;">
    <div class="formcontentsize" style="width:auto;height:auto;">
     
     <div class="layoutitem jsgl">
      <div class="lay-list">
       <ul>
       
         <li>
         
         
          <div class="lay-js1">
          <label class="iten-js"> 请假时间:</label>
          <input class="jsedit1" type="text" maxlength="66" name="lday">
         </div>
        </li>
         
       
       </ul>
      </div>
     </div>
     <!--仓库基本信息   结束-->
     <!--联系人信息   开始-->
     <div class="layoutitem-add">
    <input type="submit" class="bc" value="保存">
      <a href="yg-jbxx-se.jsp" class="tc">退出</a>               
     </div>
    </div>
   </td>
   </tr>
  </tbody>
 </table>
       <!--弹窗 仓库管理开始-->
   </form>    
</body>
</html>

