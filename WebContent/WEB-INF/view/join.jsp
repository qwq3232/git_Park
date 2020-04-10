<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" sizes="16x16" href="/Qorder/image/app/qorder.ico">
<link rel="shortcut icon" sizes="72x72" href="/Qorder/image/app/android.png">
<link rel="apple-touch-icon" sizes="144x144" href="/Qorder/image/app/ios.png"/>
<meta charset="UTF-8">
<title>환영합니다</title>
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

<script type="text/javascript" src="/Qorder/script/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	var idCheck = false;
	$(document).ready(function(){
	   $("#customerId").keyup(function(){
	      $.ajax({
	         "url":"/Qorder/index/idCheck.do",//요청할 URL
	         "data":{"customerId":$("#customerId").val()},//요청파라미터 - JS객체||queryString 문자열
	         "type":"POST", //요청방식. GET일 경우 생략 가능.
	         "dataType":"text", //응답 데이터의 type - text(기본값), json, jsonp, xml
	         "beforeSend":function(){
	            //(비동기)요청을 서버로 전송하기 전에 호출할 함수
	            //함수가 return false을 하면 요청을 취소한다.
	            if(!$("#customerId").val()){
	          		$("#ajaxReturn").html("아이디를 입력하세요");
	               $("#customerId").focus();//포커스 이동.
	               return false;//서버로 요청하지 않는다.
	            }
	         },
	         "success":function(txt){
	            //성공 응답이 온 경우 호출
	            //매개변수 : 1. 응답데이터받을 변수. 2. 응답 상태 메세지,
	            //            3. XMLHttpRequest (셋다 생략가능)
	            if( $("#customerId").val() == txt){
	            	$("#ajaxReturn").html("<font color='green'>"+txt+"는(은) 사용가능한 아이디입니다"+"</font>");
	            idCheck = true;
	            }else{
	            	$("#ajaxReturn").html("<font color='red'>"+$("#customerId").val()+"는(은) 사용할수 없는 아이디입니다"+"</font>");
	            }
	         },
	         "error":function(){
	            alert("오류 발생");
	            //에러 응답이 온 경우 호출.
	            /*
	               매개변수(다 생략 가능)
	               1. XMLHttpRequest
	               2. 응답 코드 메세지 (success, error)
	               3. 에러 메세지 (http 응답 상태 메세지)
	            */
	         }   
	      });
	   });
	   
	   
	   $("#joinForm").on("submit", function(){
	      if ( idCheck == false ){
	         alert("사용가능한 아이디 입력하세요")
	         return false;
	      }
	      return true;
	   });
	});
</script>

	<body class="bg-black">
	       <div class="form-box" id="login-box">
	           <div class="header">Register New Membership</div>
	           <form action="/Qorder/index/join.do" method="post" id="joinForm">
	               <div class="body bg-gray">
	                   <div class="form-group">
	                       <input type="text" name="customerName" id="customerName" required class="form-control" placeholder="Name"/><br>
	                       <form:errors path="customer.customerName" delimiter="/"/>
	                   </div>
	                   <div class="form-group">
	                       <input type="text" name="customerId" id="customerId" required class="form-control" placeholder="User ID" /><br>
	                       <div id="ajaxReturn"></div>
	                   </div>
	                   <div class="form-group">
	                       <input type="password" name="customerPassword" id="customerPassword" required class="form-control" placeholder="Password"/><br>
	                       <form:errors path="customer.customerPassword" delimiter="/"/>
	                   </div>
	                   <input type="hidden" name="customerMileage" value="0">
						<input type="hidden" name="customerType" value="customer">
	               </div>
	               <div class="footer">
	                   <button type="submit" class="btn bg-olive btn-block">Sign me up</button>
	                   <a href="/Qorder/index/login.do" class="text-center">I already have a membership</a>
	               </div>
	           </form>
	           <div class="margin text-center"></div>
		
		</div>
        <!-- jQuery 2.0.2 -->
		<script src="/Qorder/script/jquery.js"></script>
		<!-- Bootstrap -->
		<script src="/Qorder/script/bootstrap.js" type="text/javascript"></script>        
    </body>
</html>
