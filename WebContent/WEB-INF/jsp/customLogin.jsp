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
<link rel="icon" href="<%=basePath%>/image/logo_sm.png">

<title>SDMS-用户登录</title>

<!-- Bootstrap core CSS -->
<link href="<%=basePath%>/boostrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="<%=basePath%>/boostrap/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=basePath%>/boostrap/css/signin.css" rel="stylesheet">

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

<body style="background: #FFFFFF">

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h1 style="color: #56abe4">
					用户登录
				</h1>
				<hr />
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-2 column"></div>
			<!-- 图片 -->
			<div class="col-md-4 column" style="border-right: 2px solid #56abe4">
				<img style="width: 300px; hegit: 300px" alt="" src="image/login.png">
			</div>
			<div class="col-md-4 column">
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<h4 style="color:red"><c:out value="${info}"/></h4>
				<form role="form" action="customLogin" method="post">
				<div class="form-group">
					 <label for="email">电子邮箱</label><input name="email" type="email" class="form-control" id="email" />
				</div>
				<div class="form-group">
					 <label for="password">密码</label><input name="password" type="password" class="form-control" id="password" />
				</div>
				<div class="form-group">
					<label for="password">用户类型</label>
					<select id="customType" name="customType" class="form-control">
						<option value="1" selected="selected">个人用户
						<option value="2">企业用户
					</select>
				</div>
				<div class="checkbox">
					 <label><input type="checkbox" />Remember me</label>
				</div> <p align="right"><button type="submit" class="btn btn-lg btn-primary">登录</button></p>
			</form>
			</div>
			<div class="col-md-2 column"></div>
		</div>
	</div>
	<!-- /container -->


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