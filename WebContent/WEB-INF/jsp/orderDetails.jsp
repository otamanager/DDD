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
					<li><a href="getNoProcessOrders">未处理订单 <span class="sr-only">(current)</span></a></li>
					<li><a href="gotoPage?page=createOrder">创建订单</a></li>
					<li><a href="getOrderByType?orderType=1">入库订单</a></li>
					<li><a href="getOrderByType?orderType=2">出库订单</a></li>
					<li><a href="getOrderByType?orderType=3">移仓单</a></li>
					<li><a href="getOrderByType?orderType=4">配送单</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">入/出库管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="warehouses">仓储情况</a></li>
					<li><a href="">查看入库序时簿</a></li>
					<li><a href="">查看出库序时簿</a></li>
					<li class="active"><a href="">订单执行情况</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header" style="color:#56abe4">订单管理</h1>

				<div class="row placeholders"></div>

				<h2 class="sub-header" style="color:#56abe4">订单详情</h2>
				<h3 style="color:#56abe4">订单基本信息</h3>
				<div class="table-responsive">
					<p>
						<b>订单编号：</b>
						<c:out value="${order.code}"></c:out>
					</p>
					<p>
						<b>创建日期：</b>
						<fmt:formatDate value="${order.comeDate}" pattern="yyyy/MM/dd HH:mm"/>
					</p>
					<p>
						<b>是否分批：</b>
						<c:if test="${order.isSpread==1}">是</c:if>
						<c:if test="${order.isSpread==0}">否</c:if>
					</p>
					<p>
						<b>创建人：</b>
						<c:out value="${order.signature}"></c:out>
					</p>
					<p>
						<b>运输工具：</b>
						<c:out value="${order.tackel}"></c:out>
					</p>
					<p>
						<b>订单状态：</b>
						<c:choose>
							<c:when test="${order.state==0}">
								<b style="color:#eb4f38">未处理</b>
							</c:when>
							<c:when test="${order.state==1}">
								<b style="color:#ea8010">已配送</b>
							</c:when>
							<c:when test="${order.state==2}">
								<b style="color:#56abe4">正在处理</b>
							</c:when>
							<c:when test="${order.state==3}">
								<b style="color:#00bb9c">已完成</b>
							</c:when>
						</c:choose>
					</p>
					<p>
						<b>客户公司：</b>
						<c:out value="${order.company }"></c:out>
					</p>
					<p>
						<b>紧急等级：</b>
						<c:out value="${order.priority }"></c:out>
					</p>
					<p>
						<b>订单类型：</b>
						<c:choose>
							<c:when test="${order.orderType==1}">入库订单</c:when>
							<c:when test="${order.orderType==2}">出库订单</c:when>
							<c:when test="${order.orderType==3}">移仓单</c:when>
							<c:when test="${order.orderType==4}">配送单</c:when>
						</c:choose>
					</p>
					<c:if test="${order.sourceLocation!=null }">
						<p>
							<b>来源地：</b>
							<c:out value="${order.sourceLocation }"></c:out>
						</p>
					</c:if>
					<c:if test="${order.destinationLocation!=null }">
						<p>
							<b>目的地：</b>
							<c:out value="${order.destinationLocation }"></c:out>
						</p>
					</c:if>
					<c:if test="${order.fromWarehouseCode!=null }">
						<p>
							<b>出库仓库编号：</b>
							<c:out value="${order.fromWarehouseCode }"></c:out>
						</p>
					</c:if>
					<c:if test="${order.toWarehouseCode!=null }">
						<p>
							<b>入库仓库编号：</b>
							<c:out value="${order.toWarehouseCode }"></c:out>
						</p>
					</c:if>
					<p>
						<b>备注信息：</b>
						<c:out value="${order.description }"></c:out>
					</p>
					<hr />
					<h4 style="color:#56abe4">订单项</h4>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>物资名称</th>
								<th>数量(单位：件)</th>
								<th>价值(单位：￥)</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order.orderItems }" var="item">
								<tr>
									<td><c:out value="${item.name }"></c:out></td>
									<td><c:out value="${item.count }"></c:out></td>
									<td><c:out value="${item.materialValue }"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr/>
					<h3 style="color:#56abe4">物资盘点单</h3>
					<c:if test="${order.inventoryReport.createDate!=null }">
						<p>
							<b>盘点日期：</b>
							<fmt:formatDate value="${order.inventoryReport.createDate }"
								pattern="yyyy/MM/dd HH:mm" />
						</p>
						<p>
							<b>盘点人编号：</b>
							<c:out value="${order.inventoryReport.employeeCode }"></c:out>
						</p>
						<p>
							<b>盘点人：</b>
							<c:out value="${order.inventoryReport.employeeName }"></c:out>
						</p>
						<p>
							<b>盘点仓库编号：</b>
							<c:out value="${order.inventoryReport.warehouseCode }"></c:out>
						</p>
						<p>
							<b>备注信息：</b>
							<c:out value="${order.inventoryReport.description }"></c:out>
						</p>
						<hr />
					<h4 style="color:#56abe4">物资盘点单物资项</h4>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>编码</th>
								<th>物资类型</th>
								<th>名称</th>
								<th>所属单位</th>
								<th>价值(单位：￥)</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order.inventoryReport.inventoryReportItems }"
								var="item">
								<tr>
									<td><c:out value="${ item.barCode}"></c:out></td>
									<td><c:out value="${ item.substance}"></c:out></td>
									<td><c:out value="${ item.name}"></c:out></td>
									<td><c:out value="${ item.owner}"></c:out></td>
									<td><c:out value="${ item.materialValue}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
					<c:if test="${order.inventoryReport.createDate==null }">
						<h5>未盘点</h5>
					</c:if>
					<hr />
					<h3 style="color:#56abe4">物资报损单</h3>
					<c:if test="${order.lossReport.createDate != null }">
						<p>
						<b>盘点日期：</b>
						<fmt:formatDate value="${order.lossReport.createDate }"
							pattern="yyyy/MM/dd HH:mm" />
					</p>
					<p>
						<b>盘点人：</b>
						<c:out value="${order.lossReport.employee }"></c:out>
					</p>
					<p>
						<b>盘点仓库编号：</b>
						<c:out value="${order.lossReport.warehouseCode }"></c:out>
					</p>
					<p>
						<b>备注信息：</b>
						<c:out value="${order.lossReport.description }"></c:out>
					</p>
					<hr/>
					<h4 style="color:#56abe4">物资报损单物资项</h4>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>编码</th>
								<th>物资类型</th>
								<th>名称</th>
								<th>所属单位</th>
								<th>报损原因</th>
								<th>所在仓库编号</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order.lossReport.lossReportItems }"
								var="item">
								<tr>
									<td><c:out value="${item.barCode }"></c:out></td>
									<td><c:out value="${item.substance }"></c:out></td>
									<td><c:out value="${item.name }"></c:out></td>
									<td><c:out value="${item.owner }"></c:out></td>
									<td><c:out value="${item.lossReason }"></c:out></td>
									<td><c:out value="${item.warehouseCode }"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
					<c:if test="${order.lossReport.createDate == null }">
					未盘点
					</c:if>
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
</body>
</html>