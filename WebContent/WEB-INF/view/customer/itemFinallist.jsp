<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br><br><br><br>

<style type="text/css">
.center {
    margin: auto;
    width: 60%;
    padding: 10px;
}
</style>
<div class="heading text-center">
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
<h2>Menu</h2>
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>
<div class="papers text-center">

<div class="center">
  <form action = "/Qorder/login/item_insert.do" method="post">
  
  
  
	<h2>구매내역</h2>
	
	<c:choose>
	   <c:when test="${fn:length(requestScope.list)==0 }">
	    	  오류, 박태희에게 문의하세요.
	   </c:when>
   <c:otherwise>
   <c:set var="total" value="0"></c:set>
		<table id="tableId" class="table table-striped">
			<tr>
				<td>이름</td>
				<td>종류</td>
				<td>가격</td>
				<td>갯수</td>
				<td>총합</td>
			</tr>
			
			<c:forEach items="${requestScope.list }" var="orderList">
			<tr>
				<td>${orderList.item.itemName}</td>
				<td>${orderList.item.itemSort}</td>
				<td>${orderList.itemPrice}</td>
				<td>${orderList.itemCount} ₩</td>
				<c:set var="result" value="${orderList.itemPrice*orderList.itemCount }"></c:set>
				<td><c:out value="${result }"></c:out> ₩</td>
				<c:set var="total" value="${total+result }"></c:set>
			</tr>
			</c:forEach>

		</table>
		</c:otherwise>
	</c:choose>

총 결제 금액 : <c:out value="${total }"></c:out> ₩
<br><br>
<input type="hidden" name="receiptId" value="${requestScope.receiptId }">
<input type="submit" value="결제하기"/>	

</form>
</div>
</div>