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
		<title>支付成功</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/bootstrap.js" ></script>

	</head>
	<body>
		<hr style="color: #000000;margin-top: 10%;"/>
		<p style="font-size: 40px; align-content: center; margin-left: 40%; ">订单提价成功！</p>
		<hr />
		<p style="font-size: 20px;margin-left: 40%; ">你选择的支付方式：<strong style="color: red;">曾氏在线银行</strong></p>
		<hr />
		<p style="font-size: 20px;margin-left: 40%; ">你的订单总额￥：<strong style="color: red;">${totalMoney }</strong></p>
		<hr />
	</body>
</html>