<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<%=basePath %>/image/logo_sm.png">

<title>SDMS</title>

<!-- Bootstrap core CSS -->
<link href="<%=basePath%>/boostrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="<%=basePath%>/boostrap/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=basePath%>/boostrap/css/starter-template.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="<%=basePath%>/boostrap/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>


	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">仓储管理 - SDMS</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li role="presentation" class="active"><c:if test="${sceneOrder.sceneOrderType==1 }"><a href="#">现场入库单</a></c:if><c:if test="${sceneOrder.sceneOrderType==2 }"><a href="#">现场出库单</a></c:if></li>
					<li role="presentation"><a href="displaySceneOrders">物资单队列</a></li>
					<li role="presentation"><a href="displayExamination">审核反馈</a></li>
					<li role="presentation"><a href="#">帮助</a></li>
					<li role="presentation"><a href="exit">退出</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3>现场物资单详情</h3><hr/>
				<table class="table table-hover">
					<tr>
						<th>编号</th>
						<td><c:out value="${sceneOrder.code }"></c:out></td>
					</tr>
					<tr>
						<th>订单编号</th>
						<td><c:out value="${sceneOrder.orderCode }"></c:out></td>
					</tr>
					<tr>
						<th>运输工具</th>
						<td><c:out value="${sceneOrder.tackelType }"></c:out></td>
					</tr>
					<tr>
						<th>运输工具编号</th>
						<td><c:out value="${sceneOrder.tackelNumber }"></c:out></td>
					</tr>
					<tr>
						<th>运送者姓名</th>
						<td><c:out value="${sceneOrder.carrier }"></c:out></td>
					</tr>
					<tr>
						<th>创建者</th>
						<td><c:out value="${sceneOrder.creator }"></c:out></td>
					</tr>
					<tr>
						<th>创建日期</th>
						<td><fmt:formatDate value="${sceneOrder.createDate }" pattern="yyyy/MM/dd HH:mm"/></td>
					</tr>
					<tr>
						<th>类型</th>
						<td><c:if test="${sceneOrder.sceneOrderType == 1 }">现场入库单</c:if><c:if test="${sceneOrder.sceneOrderType == 2 }">现场出库单</c:if></td>
					</tr>
				</table>
				<hr />
				<h5>物资信息</h5>
				<p>
					<c:out value="${sceneOrder.description }"></c:out>
				</p>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="<%=basePath%>/boostrap/dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="<%=basePath%>/boostrap/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>