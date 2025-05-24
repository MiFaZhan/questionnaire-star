<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/css/login.css" rel='stylesheet' type='text/css' />
</head>
<body>
<div class="main">
	<div class="login">
		<h1>问卷星管理系统</h1>
		<div class="inset">
			<!--start-main-->
			<form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return validateForm()">
				<div>
					<h2>用户登录</h2>
					<span><label>用户名</label></span>
					<span><input type="text" name="uname" class="textbox" value="admin"></span>
				</div>
				<div>
					<span><label>密码</label></span>
					<span><input type="password" name="upass" class="password" value="123456"></span>
				</div>
				<div class="sign">
					<input type="submit" value="登录" class="submit" />
				</div>
			</form>
			<div id="msg" style="margin-top: 10px; color: #ff0000">
				${requestScope.msg }
			</div>
		</div>
	</div>
	<!--//end-main-->
</div>
</body>
</html>
<script>
	function isUserName(s) {//判断用户名是否正确
		if (!/^[a-zA-Z0-9]{3,10}$/.test(s)) {
			document.querySelector("#msg").innerHTML = "用户名格式错误"
			return false
		}
		return true
	}
	function isPassword(s) {//判断密码是否正确
		if (!/^[a-zA-Z0-9]{3,10}$/.test(s)) {
			document.querySelector("#msg").innerHTML = "密码格式错误"
			return false
		}
		return true
	}
	function validateForm() {//验证登录表单
		let un = document.querySelector("#un").value;//获取用户名
		let up = document.querySelector("#up").value;//获取密码
		return isUserName(un) && isPassword(up)
	}
</script>
