<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>列表页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
	<link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/layer.js"></script>
</head>
<body>
<div style="margin: 0 20px;">
	<div class="cztable">
		<div class="query">
			<input type="button" style="width:150px;" value="新增问卷" class="btn-primary" id="addBtn"/>
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
			<tr style="height: 25px" align="center">
				<th>编号</th>
				<th>问卷标题</th>
				<th>编辑</th>
				<th>查看</th>
			</tr>
			<c:forEach var="q" items="${requestScope.questionnaireList }" varStatus="status">
				<tr style="height: 25px" align="center">
					<td>${status.count }</td>
					<td>${q.questionnaireTitle }</td>
					<td>
						<a href="${pageContext.request.contextPath}/questionnaire/subjectlist?questionnaireId=${q.questionnaireId}"">编辑</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/questionnaire/subjectshow?questionnaireId=${q.questionnaireId}">查看</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="msg" style="color: red">
		${requestScope.msg}
	</div>
</div>
</body>
</html>
<div id="addDiv" style="display:none" >
	<div class="cztable">
		<form action="${pageContext.request.contextPath}/questionnaire/save" method="post" onsubmit="return validateForm()">
			<input type="hidden" name="questionnaireTypeId" value="${requestScope.questionaireTypeId }"/>
			<table width="100%" cellpadding="0" cellspacing="0">
				<tbody>
				<tr>
					<td align="left" width="60">问卷标题:</td>
					<td align="left" colspan="3">
						<input type="text" name="questionnaireTitle" class="input" id="title" value=""/>
					</td>
				</tr>
				<tr align="center">
					<td colspan="5" height="40">
						<div align="center">
							<input type="submit" id="button2" value="保存" class="input2">
						</div>
					</td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
<script>
	$().ready(function(){
		$("#addBtn").on("click",function(){ //单击
			layer.open({
				type:1,
				title: '新增问卷',
				content: $("#addDiv")
			})
		});
	});
	function isTitle(s){//判断标题是否正确
		console.log(s)
		console.log(!/^\S{1,50}$/.test(s))
		if(!/^\S{1,50}$/.test(s)){
			layer.msg("标题格式错误")
			return false
		}
		return true
	}
	function validateForm(){//验证登录表单
		let title=$("#title").val();//获取标题
		return isTitle(title)
	}
</script>
