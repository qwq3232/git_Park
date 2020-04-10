<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>전체 리뷰 목록</h2>

<c:choose>
  <c:when test="${fn:length(requestScope.list)==0 }">
     등록된 리뷰가 없습니다.
  </c:when>
  <c:otherwise>
		<h3 class="box-title">Review Select</h3>

		<table class="table table-striped" style="text-align: center;">
			<tr>
				<td>고객 ID</td>
				<td>아이템이름</td>
				<td>리뷰 날짜</td>
				<td>리뷰 내용</td>
			</tr>
			<c:forEach items="${requestScope.list }" var="review">
				<tr>
					<td>${review.customerId}</td>
					<td>${review.item.itemName}</td>
					<td>${review.reviewCreateDate}</td>
					<td>${review.reviewDescription}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>