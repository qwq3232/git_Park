<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
#name {
   text-align: center;
   font-face: Malgun Gothic;
   font-size: 30px;
}

#center
{
	margin-right:50%;
}
.form-horizontal {
   margin-left: 30%;
   width: 100%;
   padding: 10px;
}


#s1 {
   margin-left: -100%;
}

#s2 {
   margin-left: -80%;
   margin-bottom: -1%; 
}   
 

</style>

<script type="text/javascript" src="/Qorder/script/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
      $("#withdraw").on("submit", function() {

         var flag = confirm("정말 탈퇴 하시겠습니까?")
         if (flag) {

            return true;

         } else {
            return false;
         }

      });
   
   
      $("#receipt").click(function(){
         $.ajax({
            "url":"/Qorder/login/getReceiptList.do",
            "data":
            {
               "customerId":$("#customerId").val()
            },
            "type":"POST",
            "dataType":"json", 
            "success":function(list){
               if(list.length!=0)
               {
            	  var table = '<table class="table table-striped" style="width: 800px; margin: 0 auto">';
            	  table +="<tr><td>식당이름</td><td>주문날짜</td><td>메뉴이름</td><td>메뉴갯수</td><td>가격</td><td>총합</td></tr>";
            	  
                  for(var i = 0; i< list.length; i++)
                  {
               		table+="<tr>";
               		table+="<td>"+list[i].restaurant.restaurantName+"</td>";
               		table+="<td>"+list[i].receiptDate+"</td>";
               		//orderlist
               		var orderList = list[i].orderList;
               		for(var j = 0; j < orderList.length; j++)
               		{
               			table+="<td>"+orderList[j].item.itemName+"</td>";
               			table+="<td>"+orderList[j].itemCount+"</td>";
               			table+="<td>"+orderList[j].itemPrice+"</td>";
               			table+="<td>"+orderList[j].itemCount*orderList[j].itemPrice+"</td>";
               			table+="</tr>";
               		}
                  }
                  table+="</table>";
                  $("#receiptList").html(table);
               }
               else
               {
                  alert("구매내역이 없습니다")
               }
            },
            "error":function(xhr,status,error){
               alert("code:"+xhr.status);
            }
         });
      });
      
      $("#review").click(function(){
          $.ajax({
             "url":"/Qorder/login/getReviewList.do",
             "data":
             {
                "customerId":$("#customerId").val()
             },
             "type":"POST",
             "dataType":"json", 
             "success":function(list){
                if(list.length!=0)
                {
                	var table = '<table class="table table-striped" style="width:800 px;">';
                	table +="<tr><td>메뉴이름</td><td>작성시각</td><td>리뷰내용</td></tr>";
                   for(var i = 0; i< list.length; i++)
                   {
                	  	table+="<tr>";
                  		table+="<td>"+list[i].item.itemName+"</td>";
                  		table+="<td>"+list[i].reviewCreateDate+"</td>";
                  		table+="<td>"+list[i].reviewDescription+"</td>";
                  		table+="</tr>";
                   }
                   table+="</table>";
                   $("#reviewList").html(table);
                }else{
                   alert("리뷰내역이 없습니다")
                }
             
             },
             "error":function(xhr,status,error){
                console.log("code:"+xhr.status);
             }
          });
       });
   });
</script>


<br><br><br><br>
<div class="heading text-center">
   <img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
   <h2>My Page</h2>
   <img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>

<div class="papers text-center">

<div class="center">


   <!-- 이미지 -->
   <c:choose>
      <c:when test="${requestScope.customer.customerImage != null}">
         <img src="${requestScope.customer.customerImage }" class="img-circle" width="250px" height="250px">
         <br>
      </c:when>
      <c:otherwise>
         <img src="/Qorder/image/app/profile.jpg" class="img-circle" width="250px" height="250px">
         <br>
      </c:otherwise>
   </c:choose>

   <!-- 이름 -->
   <div id="name">${requestScope.customer.customerName }</div>

   <form class="form-horizontal" action="/Qorder/login/update.do"
      method="post" enctype="multipart/form-data" >
      
      <input type="hidden" name="customerId" id="customerId" value="${requestScope.customer.customerId }">
      
      <div class="form-group" >
         <label for="inputId3" class="col-xs-1 control-label">아이디</label> <label
            for="inputId3" class="col-xs-1 control-label">
            ${requestScope.customer.customerId }</label>
      </div>
      <div class="form-group">
         <label for="inputPassword3" class="col-sm-1 control-label">비밀번호</label>
         <div class="col-xs-2">
            <input type="password" class="form-control" id="inputPassword1" name="customerPassword" value="${requestScope.customer.customerPassword }">
         </div>
      </div>
      
      <div class="form-group">
         <label for="inputName3" class="col-sm-1 control-label">이름</label>
         <div class="col-xs-2">
            <input type="text" class="form-control" id="inputName1" name="customerName" value="${requestScope.customer.customerName}">
         </div>
      </div>
      
      <div class="form-group">
         <label for="inputNumber3" class="col-xs-1 control-label">마일리지</label>
         <label for="inputNumber3" class="col-xs-1 control-label">
            ${requestScope.customer.customerMileage} point</label>
      </div>
      <div class="form-group">
         <label for="inputText1" class="col-xs-1 control-label">사진수정</label>
         <div class="col-sm-2">
            <input type="file" name="profile" class="inputfile">
         </div>
      </div>
      
      <div id="center">
      <input type="button" class="btn btn-default" id="receipt" value="구매내역">
      <p id="receiptList" ></p>
      <input type="button" class="btn btn-default" id="review" value="리뷰내역">
      <p id="reviewList" ></p>
	  </div>

      <div class="form-group" id="s2">
            <button type="submit" class="btn btn-default">수정</button>
      </div>
   </form>


   <form class="form-horizontal" action="/Qorder/login/withdraw.do"
      id="withdraw">
      <div class="form-group" id="s2">
            <button type="submit" class="btn btn-default">탈퇴</button>
      </div>
   </form>


</div>
</div>