<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>전체 식당 목록</h2>

<c:choose>
  <c:when test="${fn:length(requestScope.list)==0 }">
     등록된 고객이 없습니다.
  </c:when>
  <c:otherwise>
		<h3 class="box-title">Restaurant Select</h3>

		<table border="1" class="table table-striped" style="text-align: center;">
			<tr>
				<td>레스토랑 이름</td>
				<td>레스토랑 주소</td>
				<td>레스토랑 전화번호</td>
				<td>레스토랑 상세설명</td>
				<td>레스토랑 평점</td>
			</tr>
			<c:forEach items="${requestScope.list.list }" var="restaurant">
				<tr>
					<td><a href="/Qorder/login/admin/updateRestaurant.do?restaurantId=${ restaurant.restaurantId}">${ restaurant.restaurantName}</a></td>
					<td>${restaurant.restaurantAddress}</td>
					<td>${restaurant.restaurantPhone}</td>
					<td>${restaurant.restaurantDescription}</td>
					<td><span class="badge bg-red">${restaurant.restaurantRating}점</span></td>
				</tr>
			</c:forEach>
		</table>

	</c:otherwise>
</c:choose>

<!-- Paging 처리 -->
<!-- 
1. 이전 페이지 그룹으로 이동 처리
  이전페이지 그룹이 있으면 링크처리 없으면 <- 모양만 나오도록 처리.
 -->
 <c:choose>
 	<c:when test="${requestScope.list.paging.previousPageGroup }">
 		<a href="/Qorder/login/admin/selectRestaurant.do?pageNo=${requestScope.list.paging.startPageOfPageGroup-1}">
 			◀
 		</a>
 	</c:when>
 	<c:otherwise>
 		◀
 	</c:otherwise>
 </c:choose>

<!-- Page Group 내의 page들 링크 처리
	- PageGroup의 시작/끝페이지 번호 - 반복문 처리
 -->
<c:forEach begin="${requestScope.list.paging.startPageOfPageGroup }" 
		   end="${requestScope.list.paging.endPageOfPageGroup }" var="page">
	<c:choose>
		<c:when test="${page == requestScope.list.paging.currentPage }">
			[${page}]
		</c:when>
		<c:otherwise>
			<a href="/Qorder/login/admin/selectRestaurant.do?pageNo=${page }">
				${page }
			</a>
		</c:otherwise>
	</c:choose>
	&nbsp;&nbsp;
</c:forEach>

<!-- 3. 다음 페이지 그룹 링크
    다음 페이지 그룹이 있으면 링크 처리 없으면 그냥 화살표만 나오도록 처리.
 -->

<c:choose>
	<c:when test="${requestScope.list.paging.nextPageGroup }">
	
		<a href="/Qorder/login/admin/selectRestaurant.do?pageNo=${requestScope.list.paging.endPageOfPageGroup+1}">
			▶
		</a>
	
	</c:when>
	<c:otherwise>▶</c:otherwise>
</c:choose>
