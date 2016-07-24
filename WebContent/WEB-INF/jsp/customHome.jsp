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
<link href="<%=basePath%>/boostrap/css/dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="<%=basePath%>/boostrap/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<!-- DWR JS -->
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
<script type='text/javascript'
	src='<%=basePath%>dwr/interface/OrderService.js'></script>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">TOP™ SDMS</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">通知</a></li>
					<li><a href="#">仓库管理员：<c:out value="${sessionScope.warehouseManager.code}"></c:out></a></li>
					<li><a href="#">退出</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="getNoProcessOrders">未处理订单 <span class="sr-only">(current)</span></a></li>
					<li><a href="gotoPage?page=createOrder">创建订单</a></li>
					<li><a href="getOrderByType?orderType=1">入库订单</a></li>
					<li><a href="getOrderByType?orderType=2">出库订单</a></li>
					<li><a href="getOrderByType?orderType=3">移仓单</a></li>
					<li><a href="getOrderByType?orderType=4">配送单</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="displayNoProcessSceneOrders">入/出库管理<b style="color:red" id="countOfSceneOrders"></b></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="warehouses">仓储情况</a></li>
					<li><a href="">查看入库序时簿</a></li>
					<li><a href="">查看出库序时簿</a></li>
					<li><a href="">订单执行情况</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">订单管理</h1>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<a href="getOrderByType?orderType=1"><img
							src="<%=basePath %>/image/2.png" class="img-thumbnail"
							width="100" height="100"
							alt="Generic placeholder thumbnail"></a>
						<h4>入库订单</h4>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<a href="getOrderByType?orderType=2"><img
							src="<%=basePath %>/image/3.png" class="img-thumbnail"
							width="100" height="100"
							alt="Generic placeholder thumbnail"></a>
						<h4>出库订单</h4>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<a href="getOrderByType?orderType=4"><img
							src="<%=basePath %>/image/1.png" class="img-thumbnail"
							width="100" height="100"
							alt="Generic placeholder thumbnail"></a>
						<h4>配送单</h4>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<a href="getOrderByType?orderType=3"><img
							src="<%=basePath %>/image/4.png" class="img-thumbnail"
							width="100" height="100"
							alt="Generic placeholder thumbnail"></a>
						<h4>移仓单</h4>
					</div>
				</div>

				<h2 class="sub-header">未处理订单</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>订单编号</th>
								<th>创建日期</th>
								<th>企业</th>
								<th>创建人</th>
								<th>订单类型</th>
								<th>状态</th>
								<th>紧急等级</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${notProcessOrders}" var="order">
								<tr>
									<td><c:out value="${order.code}"></c:out></td>
									<td><fmt:formatDate value="${order.comeDate}" pattern="yyyy/MM/dd"/></td>
									<td><c:out value="${order.company}"></c:out></td>
									<td><c:out value="${order.signature}"></c:out></td>
									<td>
										<c:choose>
										<c:when test="${order.orderType==1}">入库订单</c:when>
										<c:when test="${order.orderType==2}">出库订单</c:when>
										<c:when test="${order.orderType==3}">移仓单</c:when>
										<c:when test="${order.orderType==4}">配送单</c:when>
										</c:choose>
									</td>
									<td>
									<c:choose>
										<c:when test="${order.state==0}">未处理</c:when>
										<c:when test="${order.state==1}">已配送</c:when>
										<c:when test="${order.state==2}">正在处理</c:when>
										<c:when test="${order.state==3}">已完成</c:when>
									</c:choose>
									</td>
									<td><c:out value="${order.priority}"></c:out></td>
									<td><a href="orderDetails?id=<c:out value="${order.id}"/>">订单详情</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

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
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="<%=basePath%>/boostrap/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="<%=basePath%>/boostrap/assets/js/ie10-viewport-bug-workaround.js"></script>
		
	<script
		src="<%=basePath%>/js/checkSceneOrders.js"></script>
</body>
</html>tml>