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
	
<!-- DWR JS -->
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
<script type='text/javascript'
	src='<%=basePath%>dwr/interface/OrderService.js'></script>
	
<script
		src="<%=basePath%>/js/addOrderItem.js"></script>
<script
		src="<%=basePath%>/js/selectOrderType.js"></script>

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
					<li class="active"><a href="gotoPage?page=createOrder">创建订单</a></li>
					<li <c:if test="${orders[0].orderType==1}">class="active"</c:if>><a
						href="getOrderByType?orderType=1">入库订单</a></li>
					<li <c:if test="${orders[0].orderType==2}">class="active"</c:if>><a
						href="getOrderByType?orderType=2">出库订单</a></li>
					<li <c:if test="${orders[0].orderType==3}">class="active"</c:if>><a
						href="getOrderByType?orderType=3">移仓单</a></li>
					<li <c:if test="${orders[0].orderType==4}">class="active"</c:if>><a
						href="getOrderByType?orderType=4">配送单</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">入/出库管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="warehouses">仓储情况</a></li>
					<li><a href="">查看入库序时簿</a></li>
					<li><a href="">查看出库序时簿</a></li>
					<li><a href="">订单执行情况</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">创建订单</h1>

				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-6 column">
								<h2 class="sub-header">订单基本信息</h2>
								<div class="table-responsive">
									<!-- 创建订单表单 -->
									<form role="form" action="createOrder" method="post">
										<div class="form-group">
											<label for="company">企业/个人</label><input name="company"
												class="form-control" id="company" type="text" />
										</div>
										<div class="form-group">
											<label for="orderType">订单类型</label> <select name="orderType"
												id="orderType" class="form-control" onchange="selectOrderType()">
												<option value="1" selected="selected">入库订单
												<option value="2">出库订单
												<option value="3">移仓单
												<option value="4">配送单
											</select>
										</div>
										<div class="checkbox">
											<label><input type="checkbox" />是否分批</label>
										</div>
										<div id="sourceLocationInput" class="form-group">
											<label for="sourceLocation">来源地</label><input
												name="sourceLocation" class="form-control"
												id="sourceLocation" type="text" />
										</div>
										<div id="destinationLocationInput" class="form-group" hidden="hidden">
											<label for="destinationLocation">目的地</label><input
												name="destinationLocation" class="form-control"
												id="destinationLocation" type="text"/>
										</div>
										<div class="form-group">
											<label for="priority">紧急等级</label> <select name="priority"
												id="priority" class="form-control">
												<option value="1">1
												<option value="2">2
												<option value="3">3
												<option value="4">4
												<option value="5">5
												<option value="6">6
												<option value="7">7
												<option value="8">8
												<option value="9">9
												<option value="10">10
											</select>
										</div>
										<div class="form-group">
											<label for="tel">联系电话</label><input name="tel"
												class="form-control" id="tel" type="tel" />
										</div>
										<div id="fromWarehouseCodeInput" class="form-group" hidden="hidden">
											<label for="fromWarehouseCode">出库仓库编号</label><input
												name="fromWarehouseCode" class="form-control"
												id="fromWarehouseCode" type="text" />
										</div>
										<div id="toWarehouseCodeInput" class="form-group">
											<label for="toWarehouseCode">入库仓库编号</label><input
												name="toWarehouseCode" class="form-control"
												id="toWarehouseCode" type="text" />
										</div>
										<div class="form-group">
											<label for="description">备注</label>
											<textarea class="form-control" rows="5" style="width:100%"
												name="description" id="description"></textarea>
										</div>
										<div class="form-group">
											<label for="tackel">运输工具</label><input
												name="tackel" class="form-control"
												id="tackel" type="text" />
										</div>
										<div class="form-group">
											<label for="signature">创建人姓名确认</label><input
												name="signature" class="form-control"
												id="signature" type="text" />
										</div>
										<button type="reset" class="btn btn-default btn-lg">  清空  </button>&nbsp;&nbsp;<button type="submit" class="btn btn-primary btn-lg">提交订单</button>
									</form>
								</div>
							</div>
							<div class="col-md-6 column">
								<h2 class="sub-header">订单物资项</h2>
								<form role="form">
									<div class="form-group">
										<label for="itemName">物资名称</label><input name="itemName"
											class="form-control" id="itemName" type="text" />
									</div>
									<div class="form-group">
										<label for="itemCount">数量(单位：件)</label><input name="itemCount"
											class="form-control" id="itemCount" type="number" />
									</div>
									<div class="form-group">
										<label for="itemValue">总价值(单位：￥)</label><input name="itemValue"
											class="form-control" id="itemValue" type="number" />
									</div>
									<button type="button" class="btn btn-danger" onclick="deleteItem()">撤销</button>&nbsp;<button type="button" class="btn btn-primary" onclick="addItem()">添加</button>
								</form>
								<hr/>
								<table class="table">
									<thead><tr><th>物资名称</th><th>数量(单位：件)</th><th>总价值(单位：￥)</th></tr></thead>
									<tbody id="tbody"></tbody>
								</table>
							</div>
						</div>
					</div>
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