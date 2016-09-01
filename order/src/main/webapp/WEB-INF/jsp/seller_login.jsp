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
<title>系统登录</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>

<script>

$(function() {
	$(".i-text").focus(function() {
		$(this).addClass('h-light');
	});

	$(".i-text").focusout(function() {
		$(this).removeClass('h-light');
	});

	$("#sellername").focus(function() {
		$("#sellercheckName").html("");
		var sellername = $(this).val();
		if (sellername != '') {
			$(this).val('');
		}
	});

 	$("#sellername").focusout(function() {
		var sellername = $(this).val();
		if(sellername == ''){
			$("#send-btn").attr("disabled", true);
		}
		if (sellername != '') {
			$("#send-btn").attr("disabled", false);
			$.ajax({
				type : 'POST',
				data:{
					sellerName:$("#sellername").val()
				},
				url : "seller/checkSellerName.do",
				success :function(data){
					if(data =="false")
						$("#sellercheckName").html("商家名不存在！");
				}
			});
		}
	}); 

 	
 	
 	
 	/* 密码区 */
	$("#password").focus(function() {
		$("#sellercheckpassword").html("");
		var username = $(this).val();
		if (username != '') {
			$(this).val('');
		}
	});
	$("#password").focusout(function() {
		var password = $(this).val();
		if(password ==''){
			$("#send-btn").attr("disabled", true);
		}
		if (password != '') {
			$("#send-btn").attr("disabled", false);
			$.ajax({
				type : 'POST',
				data:{
					sellerName:$("#sellername").val(),
					password:$("#password").val()
				},
				url : "seller/checkSellerPassword.do",
				success :function(data){
					if(data =="false")
						$("#sellercheckpassword").html("密码错误！");
				}
			});
		}
	}); 
	
/* 验证码 */
	$("#yzm").focus(function() {
		$("#sellercheckvalidNumber").html("");
		var username = $(this).val();
		if (username != '') {
			$(this).val('');
		}
	});

	 $("#yzm").focusout(function() {
		var validNumber = $(this).val();
		if (validNumber != '') {
			$.ajax({
				type : 'POST',
				data:{
					code:$("#yzm").val()
				},
				url : "seller/checkSellerValidNumber.do",
				success :function(data){
					if(data =="false")
						$("#sellercheckvalidNumber").html("验证码错误！");
				}
			});
		}
	}); 
	
	 
	 
	 
	$(".yzm-img").click(function() {
		$.ajax({
			type : 'POST',
			url : "seller/validNumber.do",
			success :function(data){
				$(".yzm-img").attr("src","seller/validNumber.do");
			}
		});
	});
	


});




</script>


</head>

<body>




<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
   <form class="registerform"action="seller/checkSeller.do" method="post">
   <div class="fm-item">
    <div id="sellercheckName" style="color:red"></div>
	   <label for="logonId" class="form-label">商家登陆账号：</label>
	   <input type="text" value="" maxlength="100" id="sellername"  name="sellerName" class="i-text"  style="color:black"  >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
   <div id="sellercheckpassword" style="color:red"></div>
	   <label for="logonId" class="form-label">商家登陆密码：</label>
	   <input type="password" value="" maxlength="100" id="password"  name="password" class="i-text" style="color:black" >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item pos-r">
	   <label for="logonId" class="form-label">验证码</label>
	   <input type="text" value="" maxlength="100" id="yzm" class="i-text yzm" style="color:black"  name="code" >    
       <div class="ui-form-explain"><img src="seller/validNumber.do" class="yzm-img" /></div>
       <div id="sellercheckvalidNumber" style="color:red"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label"></label>
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login"> 
       
  </div>
  
  </form>
  
  </div>

</div>

	<div class="bd">
		<ul>
			<li style="background:url(themes/zc2.jpg) #CCE1F3 center 0 no-repeat;"><a target="_blank" href="http://sc.chinaz.com/"></a></li>
			<li style="background:url(themes/zc2.jpg) #BCE0FF center 0 no-repeat;"><a target="_blank" href="http://sc.chinaz.com/"></a></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
  
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
