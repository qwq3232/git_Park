<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<h2>전체 계산서 목록</h2>

<c:choose>
  <c:when test="${fn:length(requestScope.list)==0 }">
     등록된 계산서가 없습니다.
  </c:when>
  <c:otherwise>
		<h3 class="box-title">Receipt Select</h3>

		<table class="table table-striped" border="1">
			<tr>
				<td>계산 날짜</td>
				<td>테이블번호</td>
				<td>구매내역</td>
				<td>고객 ID</td>
			</tr>
			<c:forEach items="${requestScope.list.list }" var="receipt">
				<tr>
					<td>${receipt.receiptDate}</td>	
					<td>${receipt.receiptTable}</td>
					<td><a href="/Qorder/login/admin/selectOrderList.do?receiptId=${receipt.receiptId }">확인하기</a></td>
					<td>${receipt.customerId}</td>
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
 		<a href="/Qorder/login/admin/selectReceipt.do?pageNo=${requestScope.list.paging.startPageOfPageGroup-1}">
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
			<a href="/Qorder/login/admin/selectReceipt.do?pageNo=${page }">
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
	
		<a href="/Qorder/login/admin/selectReceipt.do?pageNo=${requestScope.list.paging.endPageOfPageGroup+1}">
			▶
		</a>
	
	</c:when>
	<c:otherwise>▶</c:otherwise>
</c:choose>