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
<title>无标题文档</title>

<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>


<script>
	$(function() {

		$("#username").focus(function() {
			$("#checkName").html("");
			$("#sub").attr("disabled", false);

			var username = $(this).val();
			if (username == '') {
				$(this).val('');
			}
		});

		$("#username").focusout(function() {
			var username = $(this).val();
			if (username != '') {
				$.ajax({
					type : 'POST',
					data : {
						sellerName : $("#username").val()
					},
					url : "seller/checkSellerName.do",
					success : function(data) {

						if (data != "false") {

							$("#checkName").html("商家名已存在！");
							$("#sub").attr("disabled", true);
						}

					}
				});
			}
		});

		/*密码区  */
		$("#secondpassword").focus(function() {
			$("#checkpassword").html("");
			$("#secondpassword").val("");
			$("#sub").attr("disabled", false);
		});

		$("#secondpassword").focusout(function() {
			
				var firstpassword = $("#firstpassword").val();
				var secondpassword = $("#secondpassword").val();
				if (firstpassword != secondpassword) {
					$("#checkpassword").html("两次输入的密码不相同！");
					$("#sub").attr("disabled", true);
				}
				

		});

	

		$("#address").focus(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('');
			}
		});

		$("#address").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('');

			}
		});

		$("#sub").click(function() {
			$("#myForm").submit();
		});
	});
</script>

</head>

<style type="text/css">
#id0 {
	width: 1300px;
	height: 640px;
	margin: 0;
	border: 1px;
	background-color: #3F9;
}

#id1 {
	width: 1300px;
	height: 300px;
	margin: 0;
	border: 1px;
	position: absolute;
	top: 10px;
	left: 10px;
}

#id2 {
	width: 1300px;
	height: 300px;
	margin: 0;
	border: 1px;
	position: absolute;
	top: 100px;
	left: 300px;
	height: 500px;
	width: 300px;
}

#id27 {
	position: absolute;
	top: 500px;
}
</style>
<body>
	<div id="id0">
		<img src="images/denglu.jpg" width="1300px" height="640" />
		<div id="id1">
			<h1>商家注册</h1>
		</div>
		<div id="id2">
			<form action="seller/addSeller.do" method="post" id="myForm">
				<div id="id21">
					<div id="checkName" style="color: red"></div>
					登陆名 <input type="text" style="width: 280px; height: 40px" value=""
						maxlength="100" id="username" name="name"  />
				</div>



				<div id="id22">
					输入密码<input type="password" name="password" id="firstpassword"
						style="width: 280px; height: 40px" />
				</div>

				<div id="id23">
					<div id="checkpassword" style="color: red"></div>
					确认密码<input type="password" name="password1" id="secondpassword"
						style="width: 280px; height: 40px" />
				</div>



				



				<div id="id25">
					地址 <input type="text" id="address" name="sellerAddress"
						style="width: 280px; height: 40px" value="" maxlength="100"
						 class="i-text" />
				</div>




				<div id="i27">
					<input type="button" value="同意以下协议并注册" id="sub"
						style="width: 280px; height: 40px; background-color: #6FF" />
				</div>
			</form>
		</div>

	</div>
</body>
</html>
