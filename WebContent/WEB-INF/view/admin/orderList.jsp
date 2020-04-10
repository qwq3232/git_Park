<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- page script -->
<script type="text/javascript">



var refreshinterval=10 //옆에서 10은 10초마다 리프레쉬 된다는 뜻.(변경가능) 
var displaycountdown="yes" //상태바에 카운트 다운을 나타낼것인지 여부 
var nowtime 
var reloadseconds=0 
var secondssinceloaded=0 
function countTime() { 
countTime=new Date() 
countTime=countTime.getTime() 
countdown() 
} 
function countdown() { 
nowtime= new Date() 
nowtime=nowtime.getTime() 
secondssinceloaded=(nowtime-countTime)/1000 
reloadseconds=Math.round(refreshinterval-secondssinceloaded) 
if (refreshinterval>=secondssinceloaded) { 
var timer=setTimeout("countdown()",5000) 
if (displaycountdown=="yes") { 
window.status="본 문서는 "+reloadseconds+ " 초 후에 새로고침 됩니다" 
} 
} 
else { 
clearTimeout(timer) 
window.location.reload(true) 
} 
} 
window.onload=countTime;





function check(receiptId){
   $.ajax({
        "url":"/Qorder/login/admin/orderListCheck.do",
        "data":
        {
           "receiptId" : receiptId
        },
        "type":"POST",
        "dataType":"text",
        "success":function(text)
        {
        	alert(text);
        	window.location.href=window.location.href;
        },
        "error":function(xhr,status,error)
        {
        	alert("code:"+xhr.status);
        }
     });
}
   
</script>

<c:choose>
   <c:when test=" ${fn:length(requestScope.list)==0}">
      <h3>주문목록이 없습니다</h3>
   </c:when>
	
   <c:otherwise>
      <table class="table table-striped" style="text-align: center;">
         <tr>
            <td>테이블번호</td>
            <td>주문시간</td>
            <td>주문상태</td>
            <td>메뉴이름</td>
            <td>주문갯수</td>
            <td>메뉴가격</td>
            <td>총계</td>
            <td>확인</td>
         </tr>
			<c:forEach items="${requestScope.list }" var="receipt">
				<c:forEach items="${receipt.orderList }" var="orderList">
					<tr>
						<td>${receipt.receiptTable }</td>
						<td>${receipt.receiptDate }</td>
						<td>${receipt.receiptState }</td>
						<td>${orderList.item.itemName }</td>
						<td>${orderList.itemCount }</td>
						<td>${orderList.itemPrice } ₩</td>
						<td><c:out value="${orderList.itemCount * orderList.itemPrice }"></c:out> ₩</td>
						<td><button class="btn btn-default" onclick="check(${receipt.receiptId})">확인</button></td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
   </c:otherwise>

</c:choose>