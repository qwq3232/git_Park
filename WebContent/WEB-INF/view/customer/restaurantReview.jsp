<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<br><br><br><br>
<div class="heading text-center">
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
<h2>Menu</h2>
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>
<div class="papers text-center">

<c:choose>
<c:when test="${fn:length(requestScope.list)==0 }">
     등록된 댓글이 없습니다.
  </c:when>
  <c:otherwise>
		<h3 class="box-title">Review Select</h3>

		<table border="1" class="table table-striped" style="text-align: center;">
			<tr>
				<td>메뉴 이름</td>	
				<td>리뷰 내용</td>
				<td>리뷰 평점</td>
				<td>리뷰생성 날짜</td>
				<td>글쓴이</td>
				
			</tr>
			<c:forEach items="${requestScope.list.list}" var="review">
				<tr>
					
					<td>${review.item.itemName}</td>
					<td>${review.reviewDescription}</td>
					<td>${review.item.itemRating}</td>
					<td>${review.reviewCreateDate}</td>
					<td>${review.customerId}</td>

				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
	</c:choose>

<!-- Paging 처리 -->

 <c:choose>
 	<c:when test="${requestScope.list.paging.previousPageGroup }">
 		<a href="/Qorder/review/displayReview.do?pageNo=${requestScope.list.paging.startPageOfPageGroup-1}&restaurantId=${ requestScope.restaurantId}">
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
			<a href="/Qorder/review/displayReview.do?pageNo=${page }&restaurantId=${ requestScope.restaurantId}">
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
	
		<a href="/Qorder/review/displayReview.do?pageNo=${requestScope.list.paging.endPageOfPageGroup+1}&restaurantId=${ requestScope.restaurantId}">
			▶
		</a>
	
	</c:when>
	<c:otherwise>▶</c:otherwise>
</c:choose> 
 

</div>