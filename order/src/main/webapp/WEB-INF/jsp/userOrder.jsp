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
		<title>用户订单详情</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery1.42.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
	</head>
	<body>
		<table class="table table-striped"> 
         <caption style="text-align: center;font-size: 30px;">用户订单详情</caption> 
    <thead> 
        <tr> 
            <th style="font-size: 20px"><strong>菜单名</strong></th> 
            <th style="font-size: 20px"><strong>菜单价格</strong></th> 
            <th style="font-size: 20px"><strong>菜单数量</strong></th> 
            <th style="font-size: 20px"><strong>下单的时间</strong></th> 
            <th style="font-size: 20px"><strong>下单商家名</strong></th> 
        </tr> 
    </thead> 
    <tbody> 
    <c:forEach items="${orders }" var="order">
        <c:forEach items="${order.menus }" var="menu">
        <tr> 
            <td>${menu.menuName }</td> 
            <td>${menu.menuPrice }</td> 
            <td>${menu.amount }</td> 
             
             <td>${order.orderTime }</td> 
             <td>${order.seller.storeName }</td> 
        </tr> 
       </c:forEach>
        </c:forEach>
    </tbody> 
</table>
	</body>
</html>
