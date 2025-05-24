<%@ page language="java"
		 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>列表页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/question.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/layer.js"></script>
	<script src="${pageContext.request.contextPath}/js/iconfont.js"></script>
</head>
<body>
<div style="margin: 0 20px;">
	<div class="card-container">
		<div class="card-container">
			<c:forEach items="${requestScope.questionnaireTypeList }" var="q" >
				<div class="card">
					<div class="card-top" id="${q.questionnaireTypeId}">
							${q.questionnaireTypeDesc}
					</div>
					<div class="card-tools">
						<a href="${pageContext.request.contextPath}/questionnaire/questionnairelist?questionnaireTypeId=${q.questionnaireTypeId}">
							<svg class="icon" aria-hidden="true">
								<use xlink:href="#icon-wendang"></use>
							</svg>
							查看
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="msg" style="color: red">
		${requestScope.msg}
	</div>
</div>
</body>
</html>
