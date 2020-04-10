<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie ie6 no-js" lang="en"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie ie7 no-js" lang="en"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie ie8 no-js" lang="en"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie ie9 no-js" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js" lang="en">
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<!-- bootstrap meta data -->
<meta name="description" content="Onepage Multipurpose Bootstrap HTML Template">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" media="screen" href="/Qorder/css/bootstrap.css">
<link rel="stylesheet" href="/Qorder/css/font-awesome.css">
<link rel="stylesheet" href="/Qorder/css/animate.css">
<link rel="stylesheet" href="/Qorder/css/theme.css">

<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>

<!--Javascripts-->
<script src="/Qorder/script/jquery.js"></script>
<script src="/Qorder/script/modernizr.js"></script>
<script src="/Qorder/script/bootstrap.js"></script>
<script src="/Qorder/script/menustick.js"></script>
<script src="/Qorder/script/parallax.js"></script>
<script src="/Qorder/script/easing.js"></script>
<script src="/Qorder/script/wow.js"></script>
<script src="/Qorder/script/smoothscroll.js"></script>
<script src="/Qorder/script/masonry.js"></script>
<script src="/Qorder/script/imgloaded.js"></script>
<script src="/Qorder/script/classie.js"></script>
<script src="/Qorder/script/colorfinder.js"></script>
<script src="/Qorder/script/gridscroll.js"></script>
<script src="/Qorder/script/contact.js"></script>
<script src="/Qorder/script/common.js"></script>

<style type="text/css">
 header{
	background-color:black;
	color:white;
	text-align:center;
	padding: 25px;
} 
nav{
	line-height: 50px;/*줄 간격 - 메뉴이므로 줄간격을 넓게*/
	background-color:#CC0000;
	
	padding: 15px;
	height:100%;
	width:40%;
	float:left;
}
 section{
 	width:60%;
	padding: 20px;
	height:100%;
	float:left;
	
}
</style>


</head>


<body>
<div class="wrapper" id="wrapper">
	<header>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header>
		
	<nav>
		<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	</nav>
	
	<section>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</section>
</div><!--wrapper end-->
</body>
</html>


