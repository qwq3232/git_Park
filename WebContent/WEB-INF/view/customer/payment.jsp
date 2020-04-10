<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="/Qorder/script/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/Qorder/script/ErrorCheck/reviewCheck.js"></script>

<br><br><br><br>
<div class="heading text-center">
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
<h2>Menu</h2>
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>
<div class="papers text-center">

<c:choose>
   <c:when test="${fn:length(requestScope.list)==0 }">
    	  오류, 박태희에게 문의하세요.
   </c:when>
   <c:otherwise>
		<c:set var="total" value="0"></c:set>
		<table class="table table-striped" id="tableId">
			<tr>
				<td>이름</td>
				<td>종류</td>
				<td>가격</td>
				<td>갯수</td>
				<td>총합</td>
				<td>리뷰</td>
			</tr>
			<c:forEach items="${requestScope.list }" var="orderList">
			<tr>
				<td>${orderList.item.itemName}</td>
				<td>${orderList.item.itemSort}</td>
				<td>${orderList.itemPrice} ₩</td>
				<td>${orderList.itemCount}</td>
				<c:set var="result" value="${orderList.itemPrice*orderList.itemCount }"></c:set>
				<td><c:out value="${result }"></c:out> ₩</td>
				<c:set var="total" value="${total+result }"></c:set>
				<td>
					<button class="reviewButton" value="${orderList.itemId}">댓글작성</button>	
					<!-- 정확한 위치에 함수처리 위해 hidden으로  아디 값 받는 input 태그 생성 -->
					<input type="hidden" class = "reviewVisible" value="${orderList.itemId}"/>
				</td>
			</tr>
			<tbody></tbody>
			</c:forEach>
			
		</table>
		
	</c:otherwise>
	
</c:choose>

<br><br>

${sessionScope.customerId}님 ${total } ₩을 결제 해주세요.

</div>