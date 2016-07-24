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
				<a class="navbar-brand" href="#">仓储配送管理系统SDMS</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">通知</a></li>
					<li><a href="#">仓库管理员：<c:out
								value="${sessionScope.warehouseManager.code}"></c:out></a></li>
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
					<li><a href="getNoProcessOrders">未处理订单 <span
							class="sr-only">(current)</span></a></li>
					<li><a href="gotoPage?page=createOrder">创建订单</a></li>
					<li><a href="getOrderByType?orderType=1">入库订单</a></li>
					<li><a href="getOrderByType?orderType=2">出库订单</a></li>
					<li><a href="getOrderByType?orderType=3">移仓单</a></li>
					<li><a href="getOrderByType?orderType=4">配送单</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="displayNoProcessSceneOrders">入/出库管理<b
							style="color:red" id="countOfSceneOrders"></b></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="warehouses">仓储情况</a></li>
					<li><a href="">查看入库序时簿</a></li>
					<li><a href="">查看出库序时簿</a></li>
					<li><a href="">订单执行情况</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">审核</h1>
				<div class="row placeholders">
					<h3>
					<c:if test="${sceneOrderAndOrderInfo.sceneOrder.sceneOrderType==1 }">现场入库单</c:if>
					<c:if test="${sceneOrderAndOrderInfo.sceneOrder.sceneOrderType==0 }">现场出库单</c:if>
					</h3>
					<table class="table table-hover">
						<tr><th>编号</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.sceneOrder.code }"></c:out></td></tr>
						<tr><th>订单编号</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.sceneOrder.orderCode }"></c:out></td></tr>
						<tr><th>运输工具</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.sceneOrder.tackelType }"></c:out></td></tr>
						<tr><th>运输工具编号</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.sceneOrder.tackelNumber }"></c:out></td></tr>
						<tr><th>运输者姓名</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.sceneOrder.carrier }"></c:out></td></tr>
						<tr><th>创建人</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.sceneOrder.creator }"></c:out></td></tr>
						<tr><th>创建日期</th><td align="left"><fmt:formatDate value="${sceneOrderAndOrderInfo.sceneOrder.createDate }" pattern="yyyy/MM/dd HH:mm"/></td></tr>
						<tr><th>类型</th><td align="left">
						<c:if test="${sceneOrderAndOrderInfo.sceneOrder.sceneOrderType==1 }">现场入库单</c:if>
						<c:if test="${sceneOrderAndOrderInfo.sceneOrder.sceneOrderType==2 }">现场出库单</c:if>
						</td></tr>
					</table>
					<h3>物资基本信息</h3>
					<div class="well">
						<span align="left"><c:out value="${sceneOrderAndOrderInfo.sceneOrder.description }"></c:out></span>
					</div>
					<hr/>
					<h3>订单详细信息</h3>
					<table class="table table-hover">
						<tr><th>编号</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.code }"></c:out></td></tr>
						<tr><th>创建日期</th><td align="left"><fmt:formatDate value="${sceneOrderAndOrderInfo.orderInfo.comeDate }" pattern="yyyy/MM/dd HH:mm"/></td></tr>
						<tr><th>是否分批</th><td align="left">
						<c:if test="${sceneOrderAndOrderInfo.orderInfo.isSpread==1 }">是</c:if>
						<c:if test="${sceneOrderAndOrderInfo.orderInfo.isSpread==0 }">否</c:if>
						</td></tr>
						<tr><th>运输工具</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.tackel }"></c:out></td></tr>
						<tr><th>客户企业</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.company }"></c:out></td></tr>
						<tr><th>来源</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.sourceLocation }"></c:out></td></tr>
						<tr><th>目的地</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.destinationLocation }"></c:out></td></tr>
						<tr><th>紧急等级</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.priority }"></c:out></td></tr>
						<tr><th>订单类型</th><td align="left">
						<c:if test="${sceneOrderAndOrderInfo.orderInfo.orderType==1 }">入库订单</c:if>
						<c:if test="${sceneOrderAndOrderInfo.orderInfo.orderType==2 }">出库订单</c:if>
						<c:if test="${sceneOrderAndOrderInfo.orderInfo.orderType==3 }">移仓单</c:if>
						<c:if test="${sceneOrderAndOrderInfo.orderInfo.orderType==4 }">配送单</c:if>
						</td></tr>
						<tr><th>出库仓库编号</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.fromWarehouseCode }"></c:out></td></tr>
						<tr><th>入库仓库编号</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.toWarehouseCode }"></c:out></td></tr>
						<tr><th>创建人/代理人</th><td align="left"><c:out value="${sceneOrderAndOrderInfo.orderInfo.signature }"></c:out></td></tr>
					</table>
					<h3>订单计划物资项</h3>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>物资名称</th>
								<th>数量(单位：件)</th>
								<th>价值(单位：￥)</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sceneOrderAndOrderInfo.orderInfo.orderItems }" var="item">
								<tr>
									<td align="left"><c:out value="${item.name }"></c:out></td>
									<td align="left"><c:out value="${item.count }"></c:out></td>
									<td align="left"><c:out value="${item.materialValue }"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<p align="right">
					<a href="examine?isPass=1&sceneOrderCode=<c:out value="${sceneOrderAndOrderInfo.sceneOrder.code }"/>&orderCode=<c:out value="${sceneOrderAndOrderInfo.sceneOrder.orderCode }"/>" class="btn btn-primary btn-lg">审核通过</a>
					&nbsp;&nbsp;
					<a href="examine?isPass=2&sceneOrderCode=<c:out value="${sceneOrderAndOrderInfo.sceneOrder.code }"/>&orderCode=<c:out value="${sceneOrderAndOrderInfo.sceneOrder.orderCode }"/>" class="btn btn-danger btn-lg">审核不通过</a>
					</p>
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

	<script src="<%=basePath%>/js/checkSceneOrders.js"></script>
</body>
</html>