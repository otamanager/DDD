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

<body style="background-image:url(./image/side2.jpg)">

	<div class="container">

		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<p>&nbsp;&nbsp;&nbsp;</p>
						<p>&nbsp;&nbsp;&nbsp;</p>
						<p>&nbsp;&nbsp;&nbsp;</p>
						<form class="form-signin" action="createCommand" method="post"
							style="padding:20px;border:color:#56abe4;border-bottom:5px solid #56abe4">
							<p style="color:#FFFFFF">
								<img src="<%=basePath%>/image/we_index.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font
									size="6px">Command</font>
							</p>
							<c:if test="${info!=null}">
								<b style="color:red"><b style="color:red"><c:out value="${info}"></c:out></b></b>
							</c:if>
							<label for="code" class="sr-only">值班人员编号</label> <input
								name="code" type="text" id="code" class="form-control"
								placeholder="值班人员编号" required autofocus>
							<p>&nbsp;</p>
							<label for="name" class="sr-only">值班人姓名</label> <input
								name="name" type="text" id="name" class="form-control"
								placeholder="值班人员姓名" required>
							<p>&nbsp;</p>
							<label for="warehouseCode"
								class="sr-only">仓库编号</label> <input name="warehouseCode" type="text"
								id="warehouseCode" class="form-control" placeholder="仓库编号" required>
							<p>&nbsp;</p>
							<div class="form-group">
								<label for="commandType" class="sr-only"></label> <select
									id="commandType" name="commandType" class="form-control">
									<option value="1">入库指令
									<option value="2">出库指令
								</select>
							</div>
							<button class="btn btn-lg btn-primary btn-block" type="submit">提交指令</button>
						</form>
						<p>&nbsp;</p>
						<p align="center">
							power by <a href="#">Chi.Lin</a>
						</p>
					</div>
					<div class="col-md-4 column"></div>
				</div>
			</div>
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