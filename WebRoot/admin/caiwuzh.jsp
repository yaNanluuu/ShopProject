<%@page import="cn.sdcet.shop.domain.caiwuzh2"%>
<%@page import="cn.sdcet.shop.domain.caiwuzh1"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
int month2=0,year2=0;
String action=request.getParameter("action");
if(action!=null){
 year2=Integer.parseInt(request.getParameter("ye")); 
 month2=Integer.parseInt(request.getParameter("mo"));
 }
 %>
<html>
<head>
<meta charset="utf-8">
<title>财经-出款单</title>
<link  type="text/css" rel="stylesheet"  href="css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="css/index.css"/>
<script  src="js/jquery.min.js"></script>
<!-- 动态菜单JS -->
<script type="text/javascript"  src="js/menu.js"></script>
</head>

<body>
	<jsp:useBean id="daob" class="cn.sdcet.shop.dao.jdbc.caiwuzhDaoJDBCImpl"
		scope="session"></jsp:useBean>


        <div class="con-header">
         <div class="header-rg">
          <div class="ident">
          <!--  <label>录制时间：</label>
           <input type="text" class="input-txt11" autocomplete="off" value="2017-06-13"> -->
          </div>
          <div class="ident">
           <!-- <label>单据编号：</label>
           <input type="text" class="input-txt11" autocomplete="off" value="2017061456"> -->
          </div>
         </div>
        </div>
        
        <div class="yg-gl">
         <div class="layoutgr ckd">
           <form method="post" action="<%=basePath %>admin/caiwuzh.jsp?action=5""> 
         <li>
            <label class="ck">年</label>
            <input type="text" id="ye" name="ye" value="2019" class="buedit">
         
          	 月 <input type="text" id="mo"  name="mo" value="1" class="buedit">
          
                      </li>
           
            <li>
            <button type="submit">查询</button>
           </li>
         </div>
             </form>  
         <div class="yg-tab">
          <div class="grid">
          <div class="layoutitem" style="width:100%;border:none;">
         <%
         if(action!=null) {
               List<caiwuzh1> caizh1s=daob.selectcaiwuzh1(year2, month2);
                for(caiwuzh1 caizh1:caizh1s)
               {
               int num=caizh1.getNum();
               double price=caizh1.getPrice();
               
          %>
            <table class="gridbar bar" border="1" cellpadding="0" cellspacing="0">
            <thead>
             <tr>
             <th>月份</th> 
              <th>进货量</th> 
              <th>进货总价</th>          
             </tr>
             <tr >
             <td ><%=month2 %>月 </td>
              <td ><%=num %> 件</td>
              <td><%=price %>元</td>
             </tr>
           
             </thead>
            </table>
            <% 
            List<caiwuzh2> caizh2s=daob.selectcaiwuzh2(year2, month2);
         
            for(caiwuzh2 Caizh2:caizh2s ){
            int dingdan =Caizh2.getDingdan();
            int maichu=Caizh2.getMaichu();
            double shouru=Caizh2.getShouru();
            double s=shouru-price;
           
            %>
          
             <table class="gridbar bar" border="1" cellpadding="0" cellspacing="0">
            <thead>
             <tr>
 
              <th>订单总量</th>
              <th>卖出商品数量</th> 
              <th>收入</th>          
              <th>本月利润</th>
             </tr>
             <tr >
              <td> <%=dingdan %>件</td>
              <td><%=maichu %> 件</td>
              <td><%=shouru %> 元</td>
               <td ><%=s %>元</td>
             </tr>
           
             </thead>
            </table>
              <%}%><%} %>
           <%} %>  
           </div>           
          </div>
         </div>
        </div> 
        <div class="cellspacing">
           <div class="cell-zd">
           <!-- <p>制单人：<span>www</span></p>-->
           </div>
           <div class="cell-je">
          
            <!-- <a href="#" class="bc">保存</a>
            <a href="#" class="bc">打印</a> -->
           </div>
          </div>
         
      <!--出款单   结束-->
      </div>
      
   
  
</body>
</html>

