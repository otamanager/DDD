<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li role="presentation" class="active"><a href="#">现场入库单</a></li>
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
			<div class="col-md-3 column"></div>
			<div class="col-md-6 column">
			<h3>创建现场入库单</h3><hr/>
				<form action="createSceneOrder" class="form-horizontal" method="post">
					<!-- 现场单类型 -->
					<input type="text" value="1" hidden="hidden" name="sceneOrderType">
					<div class="form-group">
						<label for="orderCode" class="col-sm-2 control-label">订单编号</label>
						<div class="col-sm-10">
							<input name="orderCode" type="text" class="form-control" id="orderCode"
								placeholder="此处填写订单编号">
						</div>
					</div>
					<div class="form-group">
						<label for="tackelType" class="col-sm-2 control-label">运输工具</label>
						<div class="col-sm-10">
							<input name="tackelType" type="text" class="form-control" id="tackelType"
								placeholder="如：大型货柜车">
						</div>
					</div>
					<div class="form-group">
						<label for="tackelNumber" class="col-sm-2 control-label">工具编号</label>
						<div class="col-sm-10">
							<input name="tackelNumber" type="text" class="form-control" id="tackelNumber"
								placeholder="如：粤A00000">
						</div>
					</div>
					<div class="form-group">
						<label for="carrier" class="col-sm-2 control-label">运输者姓名</label>
						<div class="col-sm-10">
							<input name="carrier" type="text" class="form-control" id="carrier"
								placeholder="如：张三">
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">物资信息</label>
						<div class="col-sm-10">
							<textArea name="description" style="width:100%" class="form-control" id="description"></textArea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<p align="right"><button type="submit" class="btn btn-primary btn-lg">提交</button></p>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-3 column"></div>
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