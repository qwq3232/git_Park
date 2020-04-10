<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>전체 메뉴 목록</h2>

<c:choose>
  <c:when test="${fn:length(requestScope.list)==0 }">
     등록된 고객이 없습니다.
  </c:when>
  <c:otherwise>
		<h3 class="box-title">Item Select</h3>

		<table border="1" class="table table-striped" style="text-align: center;">
			<tr>
					<td>아이템 이름</td>
					<td>아이템 가격</td>
					<td>아이템 설명</td>
					<td>아이템 평점</td>

			</tr>
			<c:forEach items="${requestScope.list.list }" var="item">

				<tr>
					<td><a href="/Qorder/login/admin/updateItem.do?itemId=${ item.itemId}"> ${item.itemName}</a></td>
					<td>${item.itemPrice}</td>
					<td>${item.itemDescription}</td>
					<td><span class="badge bg-red">${item.itemRating}점</span></td>
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
 		<a href="/Qorder/login/admin/selectItem.do?pageNo=${requestScope.list.paging.startPageOfPageGroup-1}">
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
			<a href="/Qorder/login/admin/selectItem.do?pageNo=${page }">
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
	
		<a href="/Qorder/login/admin/selectItem.do?pageNo=${requestScope.list.paging.endPageOfPageGroup+1}">
			▶
		</a>
	
	</c:when>
	<c:otherwise>▶</c:otherwise>
</c:choose>