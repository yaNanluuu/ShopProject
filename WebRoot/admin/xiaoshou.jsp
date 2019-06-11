<%@ page language="java" import="java.util.*" import="java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理员页面</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
   
    
      
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   

  </head>
  
  <body>
 
 <body style="background-color:#f2f9fd;">
 
 
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l">
  
  <a class="button button-little bg-red" href="rootlogin.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  
  
 
  
  <h2><span class="icon-caret-right"></span>商品管理</h2>

  <ul>
    <li><a href="goods?type=findAll " target="right">商品查询</a></li>
	</ul>
<h2><span class="icon-caret-right"></span>客户管理</h2>
	<ul>
    <li><a href="admin/addInfo.jsp" target="right">新增客户</a></li>
    <li><a href="admin/addInfo.jsp" target="right">查询客户</a></li>
	</ul>  
<h2><span class="icon-caret-right"></span>订单管理</h2>
<ul>
<li><a href="admin/addorderinfor.jsp" target="right">添加订单</a></li>  
    <li><a href="admin/orderinfor.jsp" target="right">查询订单</a></li>  
</ul>
  

</div>
<script language="javascript">
function realSysTime(clock){
var now=new Date(); //创建Date对象
var year=now.getFullYear(); //获取年份
var month=now.getMonth(); //获取月份
var date=now.getDate(); //获取日期
var day=now.getDay(); //获取星期
var hour=now.getHours(); //获取小时
var minu=now.getMinutes(); //获取分钟
var sec=now.getSeconds(); //获取秒钟
month=month+1;
var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
var week=arr_week[day]; //获取中文的星期
var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间
clock.innerHTML=time; //显示系统时间
}
window.onload=function(){
window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间
}
</script> 
<script type="text/javascript">

$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>


<ul class="bread">
  <li><a href="admin/xiaoshou.jsp"  class="icon-home"> 首页</a></li>
  <li><a href="admin/admin.jsp" id="a_leader_txt">网站信息</a></li>
 <% 
   //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); -->
	//Date date = new Date(); -->
	//String a = df.format(date); -->
	
 %> 
  
  <li><b>当前系统时间：</b><span style="color:red;" id="clock" ></php></span>
  


</ul>

<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="admin/images/welcome.PNG" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
	
</div>

 
 
  </body>
</html>

