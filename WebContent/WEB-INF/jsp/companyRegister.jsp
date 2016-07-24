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

<title>SDMS-企业用户注册</title>

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

<body style="background:#FFFFFF">

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h1 style="color:#56abe4"><img alt="" src="image/logo_sm.png" style="width:40px;height:40px">&nbsp;&nbsp;企业用户注册&nbsp;&nbsp;<img alt="" src="image/step1.png" style="width:40px;height:40px">&nbsp;<img alt="" src="image/step2_1.png" style="width:40px;height:40px">&nbsp;<img alt="" src="image/step3_1.png" style="width:40px;height:40px"></h1><hr/>
			</div>
		</div>
		<div class="row clearfix">
			<!-- 图片 -->
			<div class="col-md-4 column" style="border-right:2px solid #56abe4">
				<img style="width:300px;hegit:300px" alt="" src="image/register.png">
			</div>
			<!-- 同意协议 -->
			<div class="col-md-4 column" style="border-right:2px solid #56abe4">
				<dl>
				<dt style="color:#56abe4">
					Description lists
				</dt>
				<dd>
					A description list is perfect for defining terms.
				</dd>
				<dt style="color:#56abe4">
					Euismod
				</dt>
				<dd>
					Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.
				</dd>
				<dd>
					Donec id elit non mi porta gravida at eget metus.
				</dd>
				<dt style="color:#56abe4">
					Malesuada porta
				</dt>
				<dd>
					Etiam porta sem malesuada magna mollis euismod.
				</dd>
				<dt style="color:#56abe4">
					Felis euismod semper eget lacinia
				</dt>
				<dd>
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.
				</dd>
			</dl>
			<p align="left"><input id="agree" type="checkbox">我已同意用户使用协议</p>
			</div>
			<!-- 注册表单 -->
			<div class="col-md-4 column">
				<form role="form" action="companyRegister" method="post">
				<div class="form-group">
					 <label for="email">电子邮箱</label><input name="email" type="email" class="form-control" id="email" />
				</div>
				<div class="form-group">
					 <label for="password1">密码</label><input name="password" type="password" class="form-control" id="password1" />
				</div>
				<div class="form-group">
					 <label for="password2">再次确认密码</label><input type="password" class="form-control" id="password2" />
				</div>
				<div class="form-group">
					 <label for="company">企业名称</label><input name="company" type="text" class="form-control" id="company" />
				</div>
				<div class="form-group">
					 <label for="name">法人代表</label><input name="name" type="text" class="form-control" id="name" />
				</div>
				<div class="form-group">
					 <label for="tel">电话</label><input name="tel" type="tel" class="form-control" id="tel" />
				</div>
				<div class="form-group">
					 <label for="fax">传真</label><input name="fax" type="tel" class="form-control" id="fax" />
				</div>
				<button type="submit" class="btn btn-primary">提交</button>
			</form>
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