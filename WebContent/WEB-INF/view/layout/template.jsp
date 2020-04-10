<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie ie6 no-js" lang="en"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie ie7 no-js" lang="en"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie ie8 no-js" lang="en"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie ie9 no-js" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
<meta charset="UTF-8">
<title>Q 오더</title>
<meta name="description" content="Q Order" />
<meta name="keywords" content="qrcode,qr code,scanner,barcode,javascript" />
<meta name="language" content="Korean" />
<meta name="copyright" content="kosta bobos guys" />
<meta name="Revisit-After" content="1 Days"/>
<meta name="robots" content="index, follow"/>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<link rel="stylesheet" type="text/css" media="screen" href="/Qorder/css/bootstrap.css">
<link rel="stylesheet" href="/Qorder/css/font-awesome.css">
<link rel="stylesheet" href="/Qorder/css/animate.css">
<link rel="stylesheet" href="/Qorder/css/theme.css">

<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>

</head>

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

<script type="text/javascript">
jQuery(function($) {
$(document).ready( function() {
  //enabling stickUp on the '.navbar-wrapper' class
	$('.navbar-wrapper').stickUp({
		parts: {
		  0: 'banner',
		  1: 'aboutus',
		  2: 'specialties',
		  3: 'gallery',
		  4: 'feedback',
		  5: 'contact'
		},
		itemClass: 'menuItem',
		itemHover: 'active',
		topMargin: 'auto'
		});
	});
});
</script>

<body>
<!--wrapper start-->
<div class="wrapper" id="wrapper">

	<header>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header>
	
	<section>
		<div class="container">
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
	</section>
	
</div><!--wrapper end-->
</body>
</html>


