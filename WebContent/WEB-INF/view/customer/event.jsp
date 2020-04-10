<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br><br><br><br>
<div class="heading text-center">
	<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
	<h2>Category</h2>
	<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>
<div class="papers text-center">

<c:choose>
  <c:when test="${fn:length(requestScope.list)==0 }">
     등록된 식당이 없습니다.
  </c:when>
  <c:otherwise>
		<table style="width: 100%" style="border-style: solid , border-color:#ffffff">
			<c:forEach items="${requestScope.list }" var="restaurant">
				<tr>
					<!-- 식당 이미지 -->
					<td rowspan="3"> <img src="${restaurant.restaurantImage }" width="300" height="200"> </td>
					<!-- 식당 이름 -->
					<td> <a href="/Qorder/login/itemList.do?restaurantId=${ restaurant.restaurantId}"> ${restaurant.restaurantName }</a></td>
				</tr>
				<tr>
					<td>
						<!-- 식당 평점 -->
						<c:choose>
							<c:when test="${restaurant.restaurantRating == 0 || restaurant.restaurantRatingCount == 0}" >
								평가가 없습니다
							</c:when>
							<c:otherwise>
								<c:set var="rating" value=" ${restaurant.restaurantRating }/${restaurant.restaurantRatingCount } " />
								<fmt:parseNumber var="i" type="number" integerOnly="true" value="${rating }"/>
								<c:forEach begin="1" end= "${i }">
									<img alt="rating star" src="/Qorder/image/app/star_rating_full.png" width="24px" height="24px">
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</td>
					<td> ${restaurant.restaurantAddress}</td>
					<td> ${restaurant.restaurantPhone}</td>
					<td> ${restaurant.restaurantDescription}</td>
				</tr>
				<tr>
					<td>

						<a href="/Qorder/review/displayReview.do?pageNo=0&restaurantId=${ restaurant.restaurantId}">리뷰보기</a>						

					</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	
</div>