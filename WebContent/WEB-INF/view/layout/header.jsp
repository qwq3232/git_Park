<%@page contentType="text/html; charset=UTF-8"%>

<script src="/Qorder/script/fallingsnow_v6.js"></script>
<style type="text/css">
#logout
{
	position:fixed;
	bottom:50px;
	right:70px;
	font-size:24px;
	font-family:Comic Sans MS;
	color:black;
}
#snowflakeContainer {
    position: absolute;
    left: 0px;
    top: 0px;
}
.snowflake {
    padding-left: 15px;
    font-family: Cambria, Georgia, serif;
    font-size: 14px;
    line-height: 24px;
    position: fixed;
    color: #FFFFFF;
    user-select: none;
    z-index: 1000;
    color:black;
}
.snowflake:hover {
    cursor: default;
}
</style>
<a href="/Qorder/login/admin/logout.do" id="logout">Logout</a>
<link rel="shortcut icon" sizes="16x16" href="/Qorder/image/app/qorder.ico">
<link rel="shortcut icon" sizes="72x72" href="/Qorder/image/app/android.png">
<link rel="apple-touch-icon" sizes="144x144" href="/Qorder/image/app/ios.png"/>


<!-- 인클루드 되므로 보여질 부분만 작성한다. -->
<div class="banner row" id="banner">		
	<div class="parallax text-center" style="background-image: ;">
		<div class="parallax-pattern-overlay">
			<div class="container text-center" style="height:580px; padding-top:170px; ">
				<a href="#"><img id="site-title" class=" wow fadeInDown" wow-data-delay="0.0s" wow-data-duration="0.9s" src="/Qorder/image/app/logo.png" alt="logo"/></a>
				<h1 class="intro wow zoomIn" wow-data-delay="0.4s" wow-data-duration="0.9s" style="font-size:100px;"><font color="black" face="Sans-serif">Q order</font></h1>
				<h6 class="intro wow zoomIn" wow-data-delay="0.4s" wow-data-duration="0.9s" style="font-size:30px;"><font color="pink" >Ordering with QRcode</font></h6>
			</div>
		</div>
	</div>
</div>	

<div class="menu">
	<div class="navbar-wrapper">
		<div class="container">
			<div class="navwrapper">
				<div class="navbar navbar-inverse navbar-static-top">
					<div class="container">
						<div class="navArea">
							<div class="navbar-collapse collapse">
								<ul class="nav navbar-nav">
									<li class="menuItem active"><a href="/Qorder/login/camera.do">Camera</a></li>
									<li class="menuItem"><a href="/Qorder/login/event.do">Category</a></li>
									<li class="menuItem"><a href="/Qorder/login/mypage.do">MyPage</a></li>
									<li class="menuItem"><a href="/Qorder/login/map.do">Map</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
