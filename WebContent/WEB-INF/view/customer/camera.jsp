

<%@page contentType="text/html; charset=UTF-8"%>
<style type="text/css">
body{
    width:100%;
    text-align:center;
}
img{
    border:0;
}
#main{
    margin: 0 auto;
    background:white;
    overflow: auto;
	width: 50%;
}
#header{
    background:white;
    margin-bottom:15px;
}
#mainbody{
    background: white;
    width:100%;
	display:none;
}
#footer{
    background:white;
}
#v{
    width:320px;
    height:240px;
}
#qr-canvas{
    display:none;
}
#qrfile{
    width:320px;
    height:240px;
}
#mp1{
    text-align:center;
    font-size:35px;
}
#imghelp{
    position:relative;
    left:0px;
    top:-160px;
    z-index:100;
    font:18px arial,sans-serif;
    background:#f0f0f0;
	margin-left:35px;
	margin-right:35px;
	padding-top:10px;
	padding-bottom:10px;
	border-radius:20px;
}
.selector{
    margin:0;
    padding:0;
    cursor:pointer;
    margin-bottom:-5px;
}
#outdiv
{
    width:320px;
    height:240px;
	border: solid;
	border-width: 3px 3px 3px 3px;
}
#result{
    border: solid;
	border-width: 1px 1px 1px 1px;
	padding:20px;
	width:320px;
	font-size: 18px;
}

ul{
    margin-bottom:0;
    margin-right:40px;
}
li{
    display:inline;
    padding-right: 0.5em;
    padding-left: 0.5em;
    font-weight: bold;
    border-right: 1px solid #333333;
}
li a{
    text-decoration: none;
    color: black;
}

#footer a{
	color: black;
}
.tsel{
    padding:0;
}

</style>

<script type="text/javascript" src="/Qorder/script/llqrcode.js"></script>
<script type="text/javascript" src="/Qorder/script/webqr.js"></script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-24451557-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>


<!-- 휴대폰 연동 코드  <input type="file" accept="image/*" capture="camera" /> -->
<body>
<br><br><br><br>
<div class="heading text-center">
	<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
	<h2>Scan</h2>
	<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>

<div class="papers text-center">
	<div id="main">
		<div id="header">
			<p id="mp1"></p>
		</div>
		<div id="mainbody">
		<img src="/Qorder/image/app/camera.png">
		<table class="tsel" border="0" >
			<tr>
				<td valign="top" align="center" width="50%">
					<table class="tsel" border="0">
						<tr>
							<td colspan="2" align="center">
								<div id="outdiv"></div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<div id="result" ></div>
				</td>
			</tr>
		</table>
		</div>
	      <div id="footer"></div>
	</div>
	<canvas id="qr-canvas" width="800" height="600"></canvas>
	<script type="text/javascript">load();</script>
</div>
</body>