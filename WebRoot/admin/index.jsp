<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="common.bean.OrderBean"%>
<%@ page language="java" import="common.bean.ViewBean"%>
<%@ page language="java" import="common.bean.GoodsBean"%>
<%@ page language="java" import="common.dao.impl.OrderDaoImpl"%>
<%@ page language="java" import="common.dao.impl.ViewDaoImpl"%>
<%@ page language="java" import="common.dao.impl.GoodsDaoImpl"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
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
<jsp:useBean id="odl" class="common.dao.impl.OrderDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="vd" class="common.dao.impl.ViewDaoImpl" scope="session"></jsp:useBean>
<jsp:useBean id="gdl" class="common.dao.impl.GoodsDaoImpl" scope="session"></jsp:useBean>


  <div class="main-hd">
   <div class="page-teb" style="height:887px;">
    
    <div class="l-tab-content" style="height:851px;">
     <div class="tab-content-item">
      <div class="home">
      <!--成交金额-->
       <div class="space-style">
        <div class="col-xs">
         <div class="title-button bg-deep">
          <div class="carousel">
           <div class="left-img" style="width:70px;">
            <i><img src="images/left-img1.png"></i>
            <p>成交金额</p>
           </div>
             <%
        	//OrderDaoImpl odl = new OrderDaoImpl();
        	Double sum = odl.getAllPrice();
        	Integer num = odl.getOrderNum();
        	Double s_sum = odl.getSupplyPrice();
        	Double c_sum = odl.getCancelPrice();
        	Integer c_num = odl.getCancelNum();
            %>
           <div class="right-info" style="margin-left:70px;"><%=sum%>元</div>
          </div>
         </div>
        </div>
        
         <div class="col-xs">
         <div  href="#" class="title-button bg-red">
          <div class="carousel">
           <div class="left-img bg-color-red" style="width:70px;">
            <i><img src="images/left-img2.png"></i>
            <p>订单数量</p>
           </div>
           <div class="right-info" style="margin-left:70px;"><%=num%>笔</div>
          </div>
         </div>
        </div>
        
         <div class="col-xs">
         <div  href="#" class="title-button bg-green">
          <div class="carousel">
           <div class="left-img bg-color-green" style="width:70px;">
            <i><img src="images/left-img3.png"></i>
            <p>进货金额</p>
           </div>
           <div class="right-info" style="margin-left:70px;"><%=s_sum%>元</div>
          </div>
         </div>
        </div>
        
         <div class="col-xs">
         <div  href="#" class="title-button bg-orange">
          <div class="carousel">
           <div class="left-img bg-color-orange" style="width:70px;">
            <i><img src="images/left-img4.png"></i>
            <p>退单金额</p>
           </div>
           <div class="right-info" style="margin-left:70px;"><%=c_sum%>元</div>
          </div>
         </div>
        </div>
        
         <div class="col-xs">
         <div  href="#" class="title-button bg-purple">
          <div class="carousel">
           <div class="left-img bg-color-purple" style="width:70px;">
            <i><img src="images/left-img5.png"></i>
            <p>退单数量</p>
           </div>
           <div class="right-info" style="margin-left:70px;"><%=c_num %>件</div>
          </div>
         </div>
        </div>
       </div>
       
       <!--折线图-->
       <div class="home-goods panel">
        <div id="chart" style="height:400px;">
        <%
        	String[] str = odl.getMonthPrice();
            %>
         <script type="text/javascript">
            var myChart = echarts.init(document.getElementById('chart'));
			// 指定图表的配置项和数据
            option = {
            	title : {
            		left: 'center',
                    text: '2019年销售金额分析'
            	},
    			xAxis: {
        			type: 'category',
        			data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
   			 	},
    			yAxis: {
        			type: 'value'
    			},
    			series: [{
        			data: [
					<%for(int j=0;j<12;j++){%>
						<%=str[j]%>,
					<%}%>
					],
       				type: 'line'
    			}]
			};
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
          </script>

        </div>
       </div>
       
       <!--销售情况-->
       <div class="order-form">
        <div class="col-xs-3 col-lg-7" style="width:40%">
         <div class="admin-info">
          <div class="title-name">
           <i></i>
            <mark>!!!</mark>紧急库存  
          </div>
          
          <table class="record-list">
           <tbody>
           	<tr>
             <th>商品代号</th>
             <th>商品颜色</th>
             <th>商品尺码</th>
             <th>库存数量</th>
            </tr>
            <%List<GoodsBean> lists = gdl.getUrgentNum();
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
        </div>
        
        <div class="col-xs-6 ranking-style" style="width:57%">
         <div class="frame">
          <div class="title-name">
            <i></i>
            商品销售排行
          </div>
          <table class="table table-list">
           <thead>
            <tr>
             <th width="40px">排名</th>
             <th>商品编号</th>
             <th>商品颜色</th>
             <th>商品类别</th>
             <th>销售数量</th>
            </tr>
           </thead>
           <tbody>
           <%
            	//ViewDaoImpl vd = new ViewDaoImpl();
            	List<ViewBean> view = vd.getTopGoods();
            	//for(ViewBean list:view){
            	for(int i=0;i<view.size();i++){
            		ViewBean list = (ViewBean)view.get(i);
            %>
            <tr>
             	<td><em style="margin-left:10px;"><%=i+1 %></em></td>
             	<td><%=list.getgId() %></td>
             	<td><%=list.getgColor() %></td>
             	<td><%=list.getgType() %></td>
             	<td><%=list.getNum() %></td>
            </tr>
            <%} %>
           </tbody>
          </table>
         </div>
        </div>
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>



</body>
</html>
