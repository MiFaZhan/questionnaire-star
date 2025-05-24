<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>left</title>
<link rel="stylesheet" type="text/css" href="css/left.css">
<style type="text/css"></style>
</head>
<body>
	<div class="leftbox">
		<div class="l_nav2">
			<div class="ta1">
				<strong>问卷星</strong>
				<div class="leftbgbt2"></div>
			</div>	
			<div class="cdlist">
				<div>
					<a href="${pageContext.request.contextPath}/questionnaire/questionnairetypelist" target="body">试卷管理</a>
				</div>
			</div>	
			<div class="cdlist">
				<div>
					<a href="${pageContext.request.contextPath}/questionnaire/statistics" target="body">试卷统计</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>