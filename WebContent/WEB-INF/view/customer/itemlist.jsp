<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="/Qorder/script/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/Qorder/script/ErrorCheck/errorCheck.js"></script>

<style type="text/css">
/* .roundedOne */
	.roundedOne {
    width:25px;
    height:25px;
/* end .roundedOne */

</style>
   
<br><br><br><br>
<div class="heading text-center">
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
<h2>Menu</h2>
<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>
<div class="papers text-center" style="height:1000px;">

   <form action = "/Qorder/login/itemBucketList.do" onsubmit="return Check_Checked();" >
   
   <c:choose>
      <c:when test="${fn:length(requestScope.list)==0 }">
            	등록된 메뉴가 없습니다.
      </c:when>   
    <c:otherwise>
         
   <!--  조회되는 item 개수를 hidden으로 숨김 -->
   <input type="hidden" id = "itemListLength" value = "${fn:length(requestScope.list)}">	
 
     
     <div class="form-group">
     	<input type="submit" value="주문" class="btn btn-default" style="width:80px; height:50px; font-size: 20px;"><br>
     </div>
      <!-- 테이블 번호 조회  ! qr로 들어왔을 시 테이블 번호가 들어있기 때문에 따로 뜨지 않음 -->
     <c:if test = "${sessionScope.table == '0' || sessionScope.table == null}">
	     <div class="form-group" style="font-size: 20px;">
	       테이블 번호 <input type="number" id="table" name="table" min="1" max="100" value="1" style="width:50px; height:40px; border: none; border-bottom: solid 2px #c9c9c9; padding: 10px;"><br>
	     </div>   
     </c:if>
         
  
  <div id="grid-gallery" class="grid-gallery">
  <section class="grid-wrap">
  	<ul class="grid">
  		<li class="grid-sizer">
  			<c:forEach items="${requestScope.list }" var="item">
  				<li>
  					<figure>
  						<img src="${item.itemImage }" width="225px" height="225px" onclick="check(${item.itemId });">
  						<figcaption>
  							<h3>${item.itemName}</h3>
  							<p>
  								${item.itemPrice} ₩<br>
  								<c:choose>
  									<c:when test="${item.itemRating!='0'}">
  										<c:set var="rating" value="${item.itemRating }/${item.itemRatingCount} " />
  										<fmt:parseNumber var="i" type="number" integerOnly="true" value="${rating }" />
  										<c:forEach begin="1" end="${i }"><img alt="rating star" src="/Qorder/image/app/star_rating_full.png" width="24px" height="24px"></c:forEach><br>
  									</c:when>
  									<c:otherwise>
  										평가가 없습니다<br>
  									</c:otherwise>
  								</c:choose>
  								${item.itemDescription}<br>
  								<input type="number" name="count" min="0" max="100" value="0" style="border: none; border-bottom: solid 2px #c9c9c9; padding: 2px; font-size: 20px; width:100px;">
  								<input type="checkbox" name="check_item" class="roundedOne" id="${item.itemId }" value="${item.itemId }">
  							</p>
  						</figcaption>
  					</figure>
  				</li>
  			</c:forEach>
  		</li>
  	</ul>
  </section>
  </div>
  
   
   </c:otherwise>
   </c:choose>
   </form>
   
</div>
