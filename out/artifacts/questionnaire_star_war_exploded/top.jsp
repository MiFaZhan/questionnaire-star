<%@ page language="java" contentType="text/html; charset=utf-8"
		 import="com.qst.pojo.*,java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>top</title>
	<style type="text/css">
		body {
			font-size: 10pt;
			background:  #0091E6;
			margin: 5px;
			color: #ffffff;
		}

		div {
			font-size: 36px;
			line-height: 60px;
			text-align: center;
			text-decoration: none;
			color: #ffffff;
			letter-spacing: 6px;
			position: relative;
		}
		.info{
			position: absolute;
			top: 5px;
			right: 10px;
			font-size: 8px;
		}
	</style>
</head>
<body>
<div>
	问卷星管理系统
	<div class="info">
		欢迎: ${sessionScope.user.userNick }
	</div>
</div>
</body>
</html>
