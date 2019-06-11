<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set value="<%=basePath%>" var="basePath"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="content-Type" content="text/html;charset=utf-8">
<head>
<style>
input{ border: 1px solid #ccc; 
padding: 7px 0px; border-radius:
 3px; padding-left:5px; 
-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075); 
box-shadow: inset 0 1px 1px rgba(0,0,0,.075); 
-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s }
 input:focus{ border-color: #66afe9; outline: 0; 
-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6) 
     }

</style>
<title>My JSP 'add.jsp' starting page</title>

<link rel="stylesheet" href="${basePath}css/pintuer.css">
<link rel="stylesheet" href="${basePath}css/admin.css">
<script src="${basePath}js/jquery.js"></script>
<script src="${basePath}js/pintuer.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#gId").blur(function(){
		var gId = $("#gId").val();
		  // 根据输入框的编号查询商品
          $.ajax({
              type: "Post",//请求形式
              url: "${basePath}goods?type=find",//处理文件路径
              data: {
              	gId: gId//判断调用处理文件中的那个方法
              },
              dataType: "json",//返回的数据类型 
              success: function (data) {
              	$("#gId").val(data.gId);
              	$("#gSale").val(data.gSale);
              	$("#gNum").val(data.gNum);
              	$("#gType").find("option:contains('"+data.gType+"')").attr("selected",true);
              	
              	$("#gSize").find("option:contains('"+data.gSize+"')").attr("selected",true);
              	$("#gColor").val(data.gColor);
              	$("#gPrice").val(data.gPrice);
              	
              },
              error: function () {
                 
              }
		                    }) 
		}); 
	}); 


</script>

</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add" >
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content" >
			<form method="post" class="form-x"
				action="${basePath}goods?type=upload" accept-charset="utf-8" enctype="multipart/form-data">
				<div class="form-group">
					<div class="label">
						<label>商品图片：</label>
					</div>
					<div class="field">
					
						<input type="file" id="chooseImage" name="uplodefile">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group" >
					<div class="label">
						<label>商品代号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gId"
							data-validate="required:请输入商品代号" id="gId">
						<div class="tips">

							<font color="red">${ message}</font>

						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品类别：</label>
					</div>
					<div class="field">
						<select value="" name="gType" id="gType">
						<option>上衣</option>
						<option>连衣裙</option>
						<option>裤子</option>
						<option>半身裙</option>
						<option>卫衣</option>
						<option>短裤</option>
						<option>外套</option>
						<option>衬衫</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品颜色：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gColor"
							data-validate="required:请输入颜色" id="gColor">
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品尺码：</label>
					</div>
					<div class="field">
						<select name="gSize" id="gSize">
						<option>S</option>
						<option>M</option>
						<option>L</option>
						<option>XL</option>
						<option>XXL</option>
						<option>XXXL</option>
						<option>均码</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品库存：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gNum"
							data-validate="required:请输入库存" id="gNum">
						<div class="tips"></div>
					</div>
				</div>

				
				<div class="form-group">
					<div class="label">
						<label>商品价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gPrice"
							data-validate="required:请输入价格" id="gPrice">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品折扣：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gSale"
							data-validate="required:请输入折扣" id="gSale">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
						<!--        onclick="disp_confirm()" -->
					</div>
				</div>
			</form>
			<form name="importExcel" method="post" action="${basePath}goods?type=import" accept-charset="utf-8" enctype="multipart/form-data">
					<input width="70px" name="excel" type="file" value="导入">&nbsp;&nbsp;
					&nbsp;&nbsp;<button onclick="daoru()">确定导入</button> 
					</form>
		</div>
	</div>

</body>
</html>