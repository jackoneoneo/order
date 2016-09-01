
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>无线点餐平台</title>





<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/index_1.css" />


<link rel="stylesheet" href="css/back.css" />
</head>

<body>

	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
			  修改店铺信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="seller/updateSellerInfo.do" method="post"
			enctype="multipart/form-data">
			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
			  店铺信息&nbsp;
		  </div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table width="92%" cellpadding="0" cellspacing="0"
							class="mainForm">
							<tr>
								<td width="70">店铺名</td>
								<td width="333"><input type="text" name="storeName"
									class="InputStyle" value="${seller.storeName }" /> *</td>
							</tr>
							<tr>
								<td>店铺地址</td>
								<td><input type="text" name="sellerAddress" class="InputStyle"
									value="${seller.sellerAddress }" /> *</td>
							</tr>
							<tr>
								<td width="48">店铺类型</td>
								<td><select name="storeType" style="width: 100px">
										<option value="1">快餐便当</option>
										<option value="2">小吃夜宵</option>
										<option value="3">甜品饮食</option>
										<option value="4">果蔬生鲜</option>
										<option value="5">特色菜系</option>
										<option value="6">异国料理</option>
								</select></td>
							</tr>
							<tr>
								<td width="48">店铺Logo</td>
								<td><input type="file" name="file" /> *</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" value="添加" class="FunctionButtonInput" style="height:30px">
				<a href="javascript:history.go(-1);" class="FunctionButton" style="height:30px">返回</a>
			</div>
		</form>
	</div>
</body>
</html>
