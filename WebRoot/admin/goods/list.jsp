<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
<c:set value="<%=imgPath%>" var="imgPath"></c:set>
<c:set value="<%=basePath%>" var="basePath"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理页面</title>
    <link rel="stylesheet" href="${basePath}css/pintuer.css">
	<link rel="stylesheet" href="${basePath}css/admin.css">
	<script src="${basePath}js/jquery.js"></script>
	<script src="${basePath}js/pintuer.js"></script>
	<script type="text/javascript">
		//checkbox 全选/取消全选
		var isCheckAll = false;
		function swapCheck() {
			if (isCheckAll) {
				$("input[type='checkbox']").each(function() {
					this.checked = false;
				});
				isCheckAll = false;
			} else {
				$("input[type='checkbox']").each(function() {
					this.checked = true;
				});
				isCheckAll = true;
			}
		}
		
	</script>
	<script>
	   function daochu(){
		   $.ajax({
			    type:"GET",
			    url:"${basePath}/goods?type=export",
			    async:false,
			    success:function(data){
			    if(data=='success'){
			    	alert('导出成功');
			    }else{
			    	alert('导出失败');
			    }
			    },
			    error:function(jqXHR){
			    aler("发生错误");
			    }
			   });
	   }
	   function daoru(){
		   $("importExcel").submit(function(e){
			   alert("Submitted");
			 });
	   }
	   
	</script>

  </head>
  
  <body>
  
   <form method="post" action="${basePath}goods?type=findAll" id="listform" accept-charset="utf-8">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择查询方式&nbsp;&nbsp;
    <select name="gType">
      
      <option value="gId">代号</option>
      <optgroup  label="类型">    
       <c:forEach items="${gTypes}" var="gType">
         <option value="${gType }">${gType }</option>    
         </c:forEach>
         </optgroup> 
   </select>
<input type="text" value="${gId}" name="gId" data-validate="required:请输入商品代号"/>
<button>查询</button></strong></form>
<!--  
<form name="importExcel" method="post" action="${basePath}goods?type=import" accept-charset="utf-8" enctype="multipart/form-data">
<input width="70px" name="excel" type="file" value="导入">&nbsp;&nbsp;
&nbsp;&nbsp;<button onclick="daoru()">确定导入</button> 
</form>
-->
&nbsp;&nbsp;<button onclick="daochu()">&nbsp;导出</button>



 </div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th> 
         <th>商品图片</th>     
        <th>商品代号</th>    
        <th>商品类别</th>
        <th>商品颜色</th>
        <th>商品尺码</th>
        <th>商品库存</th>
        
        <th>商品价格</th>
        <th>商品折扣</th>

        <th width="310">操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全选删除&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" onclick="swapCheck(this)" id="all" /><button color="#4daff9" onclick="DelSelect()">删除</button></th>
      </tr>
      <volist name="list" id="vo">
      
      
      <c:forEach items="${pageList.recordList}" var="goods" varStatus="s">
      
    
        <tr>
          <td style="text-align:left; padding-left:20px;"> ${goods.gNo}</td>
                <td><img src="${imgPath}/${goods.gImage}" width="80px" height="80px"></td>
				<td>${goods.gId}</td>
				<td>${goods.gType}</td>
				<td>${goods.gColor}</td>
				<td>${goods.gSize}</td>
				<td>${goods.gNum>3?'充足':'低库存'}(${goods.gNum})</td>
				
				<td>${goods.gPrice}</td>
				<td>${goods.gSale}</td>
					<td><div class="button-group">
							<a class="button border-main"href="${basePath}/goods?type=toFrom&gNo=${goods.gNo}&page=${pageList.currentPage}"><span class="icon-edit"></span> 修改</a> 
							<a class="button border-red"
								href="${basePath}/goods?type=doDelete&gNos=${goods.gNo}"
								onclick="return confirm('你确定要删除吗！！');">
								
								<span
								class="icon-trash-o"></span> 删除</a>&nbsp;&nbsp;<input name="item" type="checkbox" value="${goods.gNo}"/>
						</div></td>
				</tr>
<!--         结束 -->
  </c:forEach>


   		
<!--       <tr> -->
<!--         <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>全选 </td> -->
<!--         <td colspan="7" style="text-align:left;padding-left:20px;"> -->
<!--         <a href="" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除</a>  -->

<!--       </tr> -->
      <tr>
      </tr>
    </table>
  </div>
<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<td>
								<a href="${basePath}/goods?type=findAll&page=1&gId=${gId}&gType=${gType}">第一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${basePath}/goods?type=findAll&page=${pageList.prevPage}&gId=${gId}&gType=${gType}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<%-- <c:forEach items="${pageList.pageCount}" var="itempage"
									varStatus="stuts">
									<c:choose>
										<c:when test="${pageList.currentPage ==stuts.index}">
											<a style="color: red"> ${stuts.index}</a>
										</c:when>
										<c:otherwise>
										${stuts.index}
										</c:otherwise>
									</c:choose>
								</c:forEach> --%>
								<c:forEach var="s"  begin="1" end="${ pageList.pageCount}">
								<c:choose>
										<c:when test="${pageList.currentPage ==s}">
											<a style="color: red" href="${basePath}/goods?type=findAll&page=${s}&gId=${gId}&gType=${gType}">${s}</a>
										</c:when>
										<c:otherwise>
										
										<a href="${basePath}/goods?type=findAll&page=${s}&gId=${gId}&gType=${gType}">${s}</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${basePath}/goods?type=findAll&page=${pageList.nextPage}&gId=${gId}&gType=${gType}">
									下一页</a> &nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${basePath}/goods?type=findAll&page=${pageList.pageCount}&gId=${gId}&gType=${gType}">最后页</a>
								&nbsp;&nbsp;&nbsp;&nbsp;总数： ${ pageList.recordCount}
								&nbsp;&nbsp;&nbsp;&nbsp;总页数： ${ pageList.pageCount}
							</td>
						</tr>
					</table>
<script type="text/javascript">


//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var gNos ='';
	var Checkbox=false;
	 $("input[name='item']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;
		if(gNos==''){
			gNos = this.value;
		
		}else{
			gNos = gNos+","+this.value;
		}
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;
		$.ajax({url:"${basePath}/goods?type=doDelete&gNos="+gNos,async:false});
		// location.reload();
		alert("删除成功");
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}



</script>
   
   
   
  </body>
</html>
