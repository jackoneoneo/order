<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link href="css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13" src="images/title_arrow.gif" />
				菜品列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 过滤条件 -->
	<div id="QueryArea" style="height: 40px; font-size: 20px">
		
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0"
			cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle"
					style="height: 50px">
					<td style="font-size: 20px">菜编号</td>
					<td style="font-size: 20px">菜名</td>
					<td style="font-size: 20px">价格</td>
					<td style="font-size: 20px">操作</td>

				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${pager.dataList }" var="sellerMenu">
					<tr class="TableDetail1">
						<td style="text-align: center; height: 50px; font-size: 20px"><c:out
								value="${sellerMenu.id }"></c:out></td>
						<td style="text-align: center; font-size: 20px"><c:out
								value="${sellerMenu.menuName }"></c:out></td>
						<td style="text-align: center; font-size: 20px"><c:out
								value="${sellerMenu.menuPrice }"></c:out></td>
						<td style="text-align: center; font-size: 20px">
						<td style="text-align: center; font-size: 20px"><a
							href="seller/deleteMenu/${sellerMenu.id }.do"
							class="FunctionButton"
							style="text-align: center; font-size: 20px; height: 30px">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center" style="height: 50px">
			<div class="FunctionButton" style="height: 30px;">
				<a href="seller/saveFood.do" style="height: 50px; font-size: 20px">添加</a>
			</div>


			<a href="seller/foodList/1.do" style="height: 50px; font-size: 20px">首页</a>
			<c:if test="${pager.currentPage > 1}">
				<a href="seller/foodList/${pager.currentPage -1 }.do"
					style="height: 50px; font-size: 20px">上一页</a>
			</c:if>
			<c:if test="${pager.currentPage < pager.totalPage }">
				<a href="seller/foodList/${pager.currentPage +1 }.do"
					style="height: 50px; font-size: 20px">下一页</a>
			</c:if>
			<a href="seller/foodList/${pager.totalPage }.do"
				style="height: 50px; font-size: 20px">尾页</a>
		</div>
	</div>
</body>
</html>
