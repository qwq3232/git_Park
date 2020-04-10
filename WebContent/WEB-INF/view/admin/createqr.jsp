<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>


<style type="text/css">
img {
   border: 0;
}

#main {
   margin: 15px auto;
   background: white;
   overflow: auto;
   width: 750px;
}

#mainbody {
   text-align: center;
   font-size: 20px;
}

#mp1 {
   text-align: center;
   font-size: 35px;
}

#header ul {
   margin-bottom: 0;
   margin-right: 40px;
}

p.quote1 {
   font-weight: bold;
   margin-left: 10%;
   margin-right: 10%;
   color: black;
}

a {
   color: black;
}

div.button {
   
   border: 2px solid #333333;;
   border-radius: 15px;
   width: 100px;
   cursor: pointer;
   font-weight: bold;
}
</style>
<script type="text/javascript">
   var resId=<%=session.getAttribute("restaurantId")%>
   function create() {
      var table = document.getElementById("table").value
      var data = "http://127.0.0.1:8888/Qorder/login/itemListQr.do?restaurantId=" + resId + "&table=" + table;
      document.getElementById("qrimage").innerHTML = "<img src='https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl="
            + encodeURIComponent(data) + "'/>";
      document.getElementById("qrInfo").innerHTML = data;
   }
</script>
<div id="main">
   <div id="header">
      <p id="mp1">Create QR Code</p>
   </div>
   <div id="mainbody">
      <p style="font-size: 20px; text-align: center;">테이블 번호 입력</p>

      <input type="number" id="table">
      <br>
      <table align="center"  border="0">
      <br>
      <tr><td align="center"><div class="button" onclick="create()">Create</div>
      </td></tr>
      </table>

      <div id="qrimage"></div>
      <div id="qrInfo"></div>
      
   </div>
</div>