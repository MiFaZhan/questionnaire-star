<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>列表页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
	<link href="${pageContext.request.contextPath}/css/subject.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/layer.js"></script>
</head>
<body>
<div style="margin: 0 20px;">
	<c:forEach items="${requestScope.subjectList }" var="s" varStatus="status">
		<div class="subject">
			<div class="title">
					${status.count }.${s.subjectTitle }
			</div>
			<div class="choice">
				<input type="radio" class="rdo"/>${s.choiceOne }
			</div>
			<div class="choice">
				<input type="radio" class="rdo"/>${s.choiceTwo }
			</div>
			<div class="choice">
				<input type="radio" class="rdo"/>${s.choiceThree }
			</div>
			<div class="choice">
				<input type="radio" class="rdo"/>${s.choiceFour }
			</div>
		</div>
	</c:forEach>
	<div id="msg" style="color: red">
		${requestScope.msg}
	</div>
</div>
</body>
</html>
