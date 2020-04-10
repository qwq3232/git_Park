<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<h2>구매 내역</h2>

<c:choose>
  <c:when test="${fn:length(requestScope.list)==0 }">
     구매내역이 없습니다.
  </c:when>
  <c:otherwise>
		<h3 class="box-title">OrderList Select</h3>
		<c:set var ="total" value="0"></c:set>
		<table class="table table-striped" border="1">
			<tr>
				<td>이름</td>
				<td>가격</td>
				<td>갯수</td>
				<td>총합</td>
			</tr>
			<c:forEach items="${requestScope.list }" var="orderlist">
				<tr>
					<td>${orderlist.item.itemName}</td>	
					<td>${orderlist.itemPrice} ₩</td>
					<td>${orderlist.itemCount}</td>
					<c:set var="result" value="${orderlist.itemPrice * orderlist.itemCount}"></c:set>
					<td><c:out value="${result }"></c:out> ₩</td>
					<c:set var="total" value="${total + result }"></c:set>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="3">TOTAL</td>
					<td><c:out value="${total }"></c:out> ₩</td>
				</tr>
		</table>
	</c:otherwise>
</c:choose>