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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/script2.js"></script>
<script type="text/javascript">
	$(function() {

		$("#payMoney").click(function() {
			$("#myForm").submit();
		});
	});
</script>
</head>

<style>
#id00 {
	width: 1300px;
}

#idtop {
	height: 200px;
	background-color: #069;
	position: absolute;
	top: 0px;
	left: 180px;
	width: 940px;
	background-image: url(themes/shop_top2.jpg);
}

#id1 {
	position: absolute;
	left: 180px;
	top: 200px;
}

.page {
	position: relative;
	float: left;
	width: 70px;
}
</style>



<body>

	<div id="id00">

		<div id="idtop"></div>

		<div id="id1">
			<form action="main/getOrder.do" method="post" id="myForm">
				<table id="cartTable">
					<thead>
						<tr>
							<th><label><input class="check-all check"
									type="checkbox" />&nbsp;全选</label></th>
							<th>商品</th>
							<th>单价</th>
							<th>数量</th>
							<th>小计</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${menus }" var="menu">
							<tr>
								<td class="checkbox"><input class="check-one check"
									type="checkbox" name="checkBox" value="${menu.id }" /></td>
								<td class="goods"><img src="${menu.menuImage }" alt="" /><span>${menu.menuName }</span></td>
								<td class="price">${menu.menuPrice }</td>
								<td class="count"><span class="reduce">-</span> <input
									class="count-input" type="text" name="account"
									value="${menu.amount }" /> <span class="add">+</span></td>
								<td class="subtotal">${menu.menuPrice * menu.amount}</td>
								<td class="operation"><a class="delete" href="main/deleteCartMenu/${menu.id }.do">删除</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</form>
			<div class="foot" id="foot">
				<label class="fl select-all"><input type="checkbox"
					class="check-all check" />&nbsp;全选</label>
				<div class="fr closing">
					<button id="payMoney" style="width: 100px;height: 46px;font-size:20px">结 算</button>
				</div>
				<div class="fr total">
					合计：￥<span id="priceTotal">0.00</span>
				</div>
				<div class="fr selected" id="selected">
					已选商品 <span id="selectedTotal">0</span>件 <span class="arrow up">︽</span>
					<span class="arrow down">︾</span>
				</div>
				<div class="selected-view">
					<div id="selectedViewList" class="clearfix">
						<!--<div><img src="images/1.jpg"><span>取消选择</span></div>-->
					</div>
					<span class="arrow">◆<span>◆</span></span>
				</div>






			</div>



		</div>

	</div>
</body>
</html>