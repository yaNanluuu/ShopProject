<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>修改商品信息</title>

<link rel="stylesheet" href="${basePath}css/pintuer.css">
<link rel="stylesheet" href="${basePath}css/admin.css">
<script src="${basePath}js/jquery.js"></script>
<script src="${basePath}js/pintuer.js"></script>

</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改商品信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="${basePath}goods?type=doUpdate" enctype="multipart/form-data">
			<input type="hidden" name="gNo" value="${goods.gNo }" >
			<input type="hidden" name="page" value="${page}" >
			<div class="form-group">
					<div class="label">
						<label>商品图片：</label>
					</div>
					<div class="field">
					    <img src="${imgPath}/${goods.gImage}" width="80px" height="80px">
						<input type="file" id="chooseImage" name="uplodefile" value="更换图片">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品代号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${goods.gId }"  name="gId"
							data-validate="required:请输入商品代号"  placeholder=" ${goods.gId }" >
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
						<select value="" name="gType">
						<option ${goods.gType=='牛仔裤'?'selected':''}>牛仔裤</option>
						<option ${goods.gType=='连衣裙'?'selected':''}>连衣裙</option>
						<option ${goods.gType=='雪纺衬衣'?'selected':''}>雪纺衬衣</option>
						<option ${goods.gType=='半身裙'?'selected':''}>半身裙</option>
						<option ${goods.gType=='雪纺衫'?'selected':''}>雪纺衫</option>
						<option ${goods.gType=='外套女'?'selected':''}>外套女</option>
						<option ${goods.gType=='外套男'?'selected':''}>外套男</option>
						<option ${goods.gType=='短袖女'?'selected':''}>短袖女</option>
						<option ${goods.gType=='短袖男'?'selected':''}>短袖男</option>
						<option ${goods.gType=='短裤女'?'selected':''}>短裤女</option>
						<option ${goods.gType=='上衣'?'selected':''}>上衣</option>
						<option ${goods.gType=='裤子'?'selected':''}>裤子</option>
						<option ${goods.gType=='短裤男'?'selected':''}>短裤男</option>
						</select>
						<div class="tips">
						</div>
					</div>
				</div>
				
<div class="form-group">
					<div class="label">
						<label>商品尺码：</label>
					</div>
					<div class="field">
						<select name="gSize" >
						<option ${goods.gSize=='S'?'selected':''}>S</option>
						<option ${goods.gSize=='XS'?'selected':''}>XS</option>
						<option ${goods.gSize=='M'?'selected':''}>M</option>
						<option ${goods.gSize=='L'?'selected':''}>L</option>
						<option ${goods.gSize=='XL'?'selected':''}>XL</option>
						<option ${goods.gSize=='XXL'?'selected':''}>XXL</option>
						<option ${goods.gSize=='XXXL'?'selected':''}>XXXL</option>
						</select>
						<div class="tips">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品颜色：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${goods.gColor }"  name="gColor"
							data-validate="required:请输入名称" placeholder=" ${goods.gColor }">
						<div class="tips">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>增加库存：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${goods.gNum }"  name="gNum"
							data-validate="required:请输入名称" placeholder=" ${goods.gNum }">
						<div class="tips">
						</div>
					</div>
				</div>


			<div class="form-group">
					<div class="label">
						<label>商品价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${goods.gPrice }" name="gPrice"
							data-validate="required:请输入价格" placeholder=" ${goods.gPrice }">
						<div class="tips"></div>
					</div>
				</div>
<div class="form-group">
					<div class="label">
						<label>商品折扣：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${goods.gSale }" name="gSale"
							data-validate="required:请输入价格" placeholder=" ${goods.gSale }" >
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							修改</button>
						<!--        onclick="disp_confirm()" -->
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
	</html> </i>