<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<h3 class="box-title">관리할 매장을 선택해주세요</h3>

<c:choose>
  <c:when test="${fn:length(requestScope.list)==0 }">
     등록된 식당이 없습니다. 식당을 등록해주세요<br>
   <a href="/Qorder/login/admin/insertRestaurant.do">등록하러가기</a>
  </c:when>
  <c:otherwise>
       <table class="table table-bordered">
         <tr class="active">
         <th>레스토랑 이름</th>
            <th>레스토랑 주소</th>
            
            
         </tr>
         <c:forEach items="${requestScope.list }" var="restaurant">
            <tr>
               
               <td><a href="/Qorder/login/admin/restaurantId.do?restaurantId=${ restaurant.restaurantId}">${restaurant.restaurantName }</a></td>
               <td>${restaurant.restaurantAddress}</td>
            </tr>
         </c:forEach>
      </table>
   </c:otherwise>
</c:choose>