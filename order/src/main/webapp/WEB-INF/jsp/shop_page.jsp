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

<title>店铺主页</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="text/javascript" href="js/jquery1.42.min.js">
<link rel="stylesheet" href="css/shop_page.css" />
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/jquery1.42.min.js" ></script>





</head>
<script>
	$(function() {
		$(".click").click(function() {
			alert("已加入购物车！");
		});
	});
	function changecolor(i) {
		document.getElementById("id21" + i).style.backgroundColor = "yellow";

	}

	function clear(i) {
		document.getElementById("id21" + i).style.backgroundColor = "white";

	}
</script>




<body>

	<div id="id0">

		<div id="id1" class="id1">

		
		</div>
	</div>

	<div id="id2">

		<div id="id21">



			<div class="mod"></div>
			<div class="mod"></div>



		</div>

		<div id="id22">

			<img src="images/shop1.jpg" width="100px" height="100px" />
		</div>



	</div>


	<div id="id3">
		<div id="id31">
		<form action="main/getSearchConditionMenu/${sellerId }.do" method="post">
			<input type="text" name="menuName" title="请输入菜品名称"
				style="width: 200px; height: 30px;"> <input type="submit"
				value="菜名搜索" style="width: 70px; height: 30px; background-color: #06C">
		</form>
		</div>

		<div id="id32">
			<h2>
				<B>商家公</B>告
			</h2>
		</div>

		<div id="id33">

			<p>在线支付满30减10，满60减18</p>
			<p></p>
			<p>以加入"外卖保"计划，食品安全有保障</p>
			<p></p>
			<p>准时必达，超时必赔</p>

		</div>

	</div>


	<div id="id4">
		<div id="id41">

			<table id="cartTable">
				<thead>
					<tr>
						<th>商品</th>
						<th>评价</th>
						<th>加入购物车</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sellerMenus }" var="sellerMenu">
						<tr>
							<td class="goods"><img src="${sellerMenu.menuImage }" alt=""
								width="180px" /> <span>${sellerMenu.menuName }</span> <span>价格<i>${sellerMenu.menuPrice }</i>元
							</span></td>
							<td class="price">
								<p>好评数：100</p>
								<p>差评数：4</p>
							</td>
							<td class="subtotal"><a
								href="main/saveCart/${sellerId}/${sellerMenu.id}.do"
								class="click">加入购物车</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>



		</div>





		<div class="foot" id="foot">


			<div class="fr closing">
				<a href="main/cart.do">购物车</a>
			</div>


			<div class="selected-view">
				<div id="selectedViewList" class="clearfix">
					<!--<div><img src="images/1.jpg"><span>取消选择</span></div>-->


					<div class="page"></div>
					<div class="page"></div>
					<div class="page"></div>
					<div class="page"></div>
					<div id="shang" class="page">
						<a href="">上一页</a>
					</div>
					<div id="shou" class="page">
						<a href="">首页</a>
					</div>
					<div id="wei" class="page">
						<a href="">尾页</a>
					</div>
					<div id="xia" class="page">
						<a href="">下一页 </a>
					</div>

				</div>



			</div>
</body>
</html>
