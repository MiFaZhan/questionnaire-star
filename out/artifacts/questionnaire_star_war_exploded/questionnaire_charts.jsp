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
	<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
</head>
<body>

<div id="main" style="margin-top:25px; margin-left:120px; width: 600px;height:400px;"></div>
<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	// 指定图表的配置项和数据
	var option = {
		title: {
			text: '各类型问卷数量统计'
		},
		tooltip: {},
		legend: {
			data: ['试卷数量']
		},
		xAxis: {
			data: ['就业调查', '性格测试', '情感评测', '消费调查']
		},
		yAxis: {},
		series: [
			{
				name: '试卷数量',
				type: 'bar',
				data: []
			}
		]
	};
	// 使用刚指定的配置项和数据显示图表。
	$().ready(function(){
		option.series[0].data=${requestScope.data};//获取图表数据
		myChart.setOption(option);//显示图表
	});
</script>
</body>
</html>
