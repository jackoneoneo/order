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


<title>网站主页</title>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<style>
#id0 {
	width: 1200px;
	height: 1300px;
	border-color: #000;
	position: relative;
	text-align: center;
	margin: 1px;
}

#id1 {
	height: 60px;
	background-color: #069;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 1300px;
}

#id11 {
	
	position: absolute;
	top: 20px;
	right:40px;
	
}

#id12 {
	
	position: absolute;
	top: 20px;
	right:90px;
	
}

.id1 ul {
	position: relative;
	float: left;
	top: 10px;
	height: 50px;
}

.id1 ul li {
	width: 140px;
	height: 50px;
	position: relative;
	float: left;
	font-size: 20px;
	list-style-type: none;
	border: 1px;
	border-color: #000;
	font-size: 20px;
	color: #FFF;
}

#id2 {
	position: absolute;
	top: 70px;
	height: 50px;
	width: 1180px;
	left: 0px;
}

#id21 {
	position: absolute;
	right: 10px;
	top: 3px;
	width: 300px;
	height: 38px;
}

#id22 {
	position: absolute;
	left: 36px;
	top: 13px;
}

#id3 {
	position: absolute;
	top: 120px;
	width: 1279px;
	height: 300px;
	text-align: center;
}

#id30 {
	position: absolute;
}

#id31 {
	position: absolute;
	right: 189px;
	height: 120px;
	width: 20px;
	height: 20px;
	top: 180px;
}

#id32 {
	position: absolute;
	right: 148px;
	height: 120px;
	width: 20px;
	height: 20px;
	top: 180px;
}

#id33 {
	position: absolute;
	right: 101px;
	height: 120px;
	width: 20px;
	height: 20px;
	top: 180px;
}

#id34 {
	position: absolute;
	right: 62px;
	height: 120px;
	width: 20px;
	height: 20px;
	top: 580px;
	border: 1px;
	border-color: #000;
}

#id4 {
	position: absolute;
	top: 430px;
	width: 1190px;
	left: 110px;
	border: 1px solid #999;
	height: 70px;
	background-color: #069;
}

#zhuangshi {
	position: absolute;
	left: 0px;
	top: 420px;
}

.notice {
	width: 1100px;
	height: 100px;
	
	
}

.notice-tit {
	height: 40px;
	position: relative;
}

.notice-tit ul {
	position: absolute;
	width: 1180px;
	border: -1px;
	text-decoration: none;
	color:#000;
	
}

.notice-tit ul li {
	float: left;
	height: 40px;
	line-height: 26px;
	text-align: center;
	overflow: hidden;
	background-color:;
	border-bottom: 1px solid:#0F3;
	font-size: 20px;
	color: #000;
	cursor:hand;
}

.notice-con .mod {
	margin: 10px 10px 10px 19px;
	position: absolute;
	top: 60px;
}

.notice-con .mod ul li {
	float: left;
	width: 134px;
	height: 40px;
	overflow: hidden;
}

.notice-tit li a:hover {
	color: #F00;
}

.notice-con .mod {
	margin: 10px 10px 10px 19px
}

.notice-con .mod ul li {
	float: left;
	width: 134px;
	height: 25px;
	overflow: hidden;
	background-color:;
}

.notice-con .mod ul li a:hover {
	color: #F00;
}

a {
	text-decoration: none;
	font-size: 18px;
	font-size: 20px;
	color: #000;
	text-align: center;
}



#id5 {
	width: 1300px;
	height: 400px;
	top: 520px;
	position: absolute;
}

#id6 {
	position: absolute;
	top: 1170px;
	width: 1300px;
	height: 40px;
	text-align: center;
}

#id7 {
	position:float;
	width: 1300px;
	height: 100px;
	background-color: #039;
	
}

.select{
color:#000;
}
</style>


</head>

<script>
	var no = 1;//当前的图的编号
	var timer = null; //计时器，默认为空

	function myInit() //初始化各个div标签的事件
	{
		//1 获取所有的div标签

	}
	function start_timer() //启动计时器
	{
		timer = window.setInterval("change()", 2000); //每隔1秒，执行一段js代码
	}

	function stop_timer() {
		window.clearInterval(timer);//清除计时器
	}
	//颜色重置
	function resetDivs() {
		for ( var i = 1; i <= 4; i++) {
			document.getElementById("id3" + i).style.backgroundColor = "white";
		}
	}
	function change() //修改img标签当前的图片
	{
		//改变编号
		no++;
		if (no > 4)
			no = 1;
		changeToNo(no);
	}

	//改变到第i张
	function changeToNo(i) {
		//修改图片的src属性
		document.getElementById("img").src = "images/" + i + ".jpg";
		//将所有的div背景重新设置成白色
		resetDivs();//重设背景
		//修改小div的背景色
		document.getElementById("id3" + i).style.backgroundColor = "yellow";
		no = i;//让计时器的编号发生改变

	}

	function changemenu(j) {
		//改变编号
		for ( var i = 1; i <= 9; i++) {
			document.getElementById("id4" + i).style.display = "none";
		}

		document.getElementById("id4" + j).style.display = "";
	}
</script>



<body onload="myInit();start_timer()" leftmargin="0" topmargin="0"
	marginheight="0" marginwidth="0">

	<div id="id0">

		<div id="id1" class="id1">

			<ul>
				
				<li><a href="main/mainPage.do"> 首页</a></li>
				<li ><a href="main/userOrder.do">我的订单</a></li>
				<li>加盟合作</li>
				<li>积分商城</li>
				<li>服务中心</li>
				<li><a href="main/cart.do">购物车</a></li>
			</ul>


			<div id="id11">
				<a href="user/userRegister.do">注册</a>
			</div>

            <div id="id12">
				<a href="user/userLogin.do">登录</a>
			</div>


				<div id="id2">
					<div id="id21">
						<form action="main/searchStore.do">
							<input type="text" name="storeName" title="请输入商店名"
								style="width: 200px; height: 20px;"> <input
								type="submit" value="商家搜索"
								style="width: 70px; height: 30px; background-color: #06C">
						</form>
					</div>

					<div id="id22">
						<font color="#000000">地址：</font><a href="">福建省厦门市软件园二期望海路13栋
							楼</a> <a href="">【切换地址】</a>
					</div>

				</div>

				<div id="id3">

					<div id="id30"></div>

					
					<img id="img" src="images/1.jpg" height="300px" width="1300px" />


				</div>

				<div id="id4">

					<div id="notice" class="notice">
						<div id="notice2" class="notice">
							<div id="notice-tit" class="notice-tit">
								<ul>
									<li>商家分类</li>
									<li class="select" onclick="changemenu(1)"
										style="text-decoration: none"><a href="main/mainPage.do">全部商家</a></li>
									<li class="select" ><a href="main/getTypeStore/1.do">快餐便当</a></li>
									<li class="select" ><a href="main/getTypeStore/2.do">小吃夜宵</a></li>
									<li class="select" ><a href="main/getTypeStore/3.do">甜品饮品</a></li>
									<li class="select" ><a href="main/getTypeStore/4.do">果蔬生鲜</a></li>
									<li class="select" ><a href="main/getTypeStore/5.do">特色菜系</a></li>
									<li class="select" ><a href="main/getTypeStore/6.do">异国料理</a></li>
									
								
								</ul>
							</div>
							
						</div>
					</div>

				</div>


				<div id="id5">

					<table width="1300" height="378" border="0">
						<c:forEach items="${sellerList }" var="lineSeller">
							<tr>
								<c:if test="${lineSeller.firstSeller != null }">
									<td width="320" height="201">
										<table width="312" border="1">
											<tr>
												<td width="302" height="80"><img
													src="${lineSeller.firstSeller. sellerLogo }" width="302"
													height="157" />&nbsp;</td>
											</tr>
											<tr>

												<td height="37">&nbsp;&nbsp;&nbsp;&nbsp;<a href="main/getStore/${lineSeller.firstSeller.sellerId }.do"><b>${lineSeller.firstSeller.storeName }</b></a></td>
											</tr>
										</table>
									</td>
								</c:if>
								<c:if test="${lineSeller.secondSeller != null }">
									<td width="320" height="201">
										<table width="312" border="1">
											<tr>
												<td width="302" height="80"><img
													src="${lineSeller.secondSeller. sellerLogo }" width="302"
													height="157" />&nbsp;</td>
											</tr>
											<tr>

												<td height="37">&nbsp;&nbsp;&nbsp;&nbsp;<a href="main/getStore/${lineSeller.secondSeller.sellerId }.do"><b>${lineSeller.secondSeller.storeName }</b></a></td>
											</tr>
										</table>
									</td>
								</c:if>
								<c:if test="${lineSeller.thirdSeller != null }">
									<td width="320" height="201">
										<table width="312" border="1">
											<tr>
												<td width="302" height="80"><img
													src="${lineSeller.thirdSeller. sellerLogo }" width="302"
													height="157" />&nbsp;</td>
											</tr>
											<tr>

												<td height="37">&nbsp;&nbsp;&nbsp;&nbsp;<a href="main/getStore/${lineSeller.thirdSeller.sellerId }.do"><b>${lineSeller.thirdSeller.storeName }</b></a></td>
											</tr>
										</table>
									</td>
								</c:if>
								<c:if test="${lineSeller.fourSeller != null }">
									<td width="320" height="201">
										<table width="312" border="1">
											<tr>
												<td width="302" height="80"><img
													src="${lineSeller.fourSeller. sellerLogo }" width="302"
													height="157" />&nbsp;</td>
											</tr>
											<tr>

												<td height="37">&nbsp;&nbsp;&nbsp;&nbsp;<a href="main/getStore/${lineSeller.fourSeller.sellerId }.do"><b>${lineSeller.fourSeller.storeName }</b></a></td>
											</tr>
										</table>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>



				</div>


				<div id="zhuangshi">
					<img src="themes/shi1.jpg" height="100px" width="100px" />
				</div>

			</div>




			
</body>
</html>
