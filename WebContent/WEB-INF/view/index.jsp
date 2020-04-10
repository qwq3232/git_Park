<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" sizes="16x16" href="/Qorder/image/app/qorder.ico">
<link rel="shortcut icon" sizes="72x72" href="/Qorder/image/app/android.png">
<link rel="apple-touch-icon" sizes="144x144" href="/Qorder/image/app/ios.png"/>
<meta charset="UTF-8">
<title>시작하기</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="/Qorder/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link href="/Qorder/css/font-awesome.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/Qorder/css/AdminLTE.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->

</head>

<body class="bg-black">

	<div class="form-box" id="login-box">
	<div class="header">Sign In</div>
	<form action="/Qorder/index/login.do" method="post">
	    <div class="body bg-gray">
	        <div class="form-group">
	            <input type="text" name="customerId" class="form-control" placeholder="User ID"/><br>
	            <form:errors path="customer.customerId" delimiter="/"/>
	        </div>
	        <div class="form-group">
	            <input type="password" name="customerPassword" class="form-control" placeholder="Password"/><br>
	            <form:errors path="customer.customerPassword" delimiter="/"/>
	        </div>          
	    </div>
	    <div class="footer">                                                               
	        <button type="submit" class="btn bg-olive btn-block">Sign me in</button>  
	        <a href="/Qorder/index/join.do" class="text-center">Register a new membership</a>
	    </div>
	</form>
	<div class="margin text-center">
	</div>
	</div>
	<!-- jQuery 2.0.2 -->
	<script src="/Qorder/script/jquery.js"></script>
	<!-- Bootstrap -->
	<script src="/Qorder/script/bootstrap.js" type="text/javascript"></script>        
</body>
</html>