<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>列表页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
	<link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/css/subject.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/layer.js"></script>
</head>
<body>
<div style="margin: 0 20px;">
	<div class="cztable">
		<div class="query">
			<input type="button" style="width:150px;" value="新增题目" class="btn-primary" id="addBtn"/>
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
			<tr style="height: 25px" align="center">
				<th>编号</th>
				<th>题目标题</th>
				<th>查看详情</th>
			</tr>
			<c:forEach var="s" items="${requestScope.subjectList }" varStatus="status">
				<tr style="height: 25px" align="center">
					<td>${status.count }</td>
					<td>${s.subjectTitle }</td>
					<td>
						<a id="${s.subjectId}" class="showBtn" href="javascript:void(0)">查看</a>
					</td>
				</tr>
				<div id="detail${s.subjectId}" style="display:none" class="subject">
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
		<form action="${pageContext.request.contextPath}/questionnaire/subjectsave" method="post" onsubmit="return validateForm()">
			<input type="hidden" name="questionnaireId" value="${requestScope.questionnaireId }"/>
			<table width="310px" cellpadding="0" cellspacing="0">
				<tbody>
				<tr>
					<td align="left" width="60">题目标题:</td>
					<td align="left" colspan="3">
						<input type="text" name="subjectTitle" id="title" class="input" value=""/>
					</td>
				</tr>
				<tr>
					<td align="left" width="60">答案一:</td>
					<td align="left" colspan="3">
						<input type="text" name="choiceOne" id="c1" class="input" value=""/>
					</td>
				</tr>
				<tr>
					<td align="left" width="60">答案二:</td>
					<td align="left" colspan="3">
						<input type="text" name="choiceTwo" id="c2" class="input" value=""/>
					</td>
				</tr>
				<tr>
					<td align="left" width="60">答案三:</td>
					<td align="left" colspan="3">
						<input type="text" name="choiceThree" id="c3" class="input" value=""/>
					</td>
				</tr>
				<tr>
					<td align="left" width="60">答案四:</td>
					<td align="left" colspan="3">
						<input type="text" name="choiceFour" id="c4" class="input" value=""/>
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
		$("#addBtn").on("click",function(){ //新增
			layer.open({
				type:1,
				title: '新增题目',
				content: $("#addDiv")
			})
		});
		$(".showBtn").on("click",function(){ //查看
			let id=$(this).attr("id");//获取id属性
			layer.open({
				title: '试题详情',
				content: $("#detail"+id).html() //将详情显示在弹层中
			});
		});
	});
	function isEmpty(s){//判断标题是否正确
		console.log(s)
		console.log(!/^\S{1,50}$/.test(s))
		if(!/^\S{1,50}$/.test(s)){
			layer.msg("数据不完整")
			return false
		}
		return true
	}
	function validateForm(){//验证登录表单
		let title=$("#title").val();//获取标题
		let c1=$("#c1").val();
		let c2=$("#c2").val();
		let c3=$("#c3").val();
		let c4=$("#c4").val();
		return isEmpty(title)&&isEmpty(c1)&&isEmpty(c2)&&isEmpty(c3)&&isEmpty(c4)
	}
</script>
