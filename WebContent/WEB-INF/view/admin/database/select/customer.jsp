<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<h2>전체 회원 목록</h2>

<c:choose>
	<c:when test="${fn:length(requestScope.list)==0 }">
     등록된 고객이 없습니다.
  </c:when>
  
	<c:otherwise>
		<h3 class="box-title" style="text-align: center;">Customer Select</h3>

		<table border="1" class="table table-striped" style="text-align: center;">
			<tr>
				<td>회원 아이디</td>
				<td>회원 이름</td>
				<td>회원 type</td>
				<td>회원 Image</td>
				<td>회원 마일리지</td>
			</tr>
			
			<c:forEach items="${requestScope.list }" var="customer">
			
				<tr>
					<td><a href="/Qorder/login/admin/updateCustomer.do?customerId=${ customer.customerId}">${customer.customerId}</a></td>
					<td>${customer.customerName}</td>
					<td>${customer.customerType}</td>
					<td>${customer.customerImage }</td>
					<td><span class="badge bg-red">${customer.customerMileage}point</span></td>
				</tr>
			</c:forEach>
			
		</table>


	</c:otherwise>
</c:choose>








