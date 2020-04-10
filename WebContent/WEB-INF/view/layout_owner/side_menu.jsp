<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="treeview">
<h2><a href="/Qorder/login/admin/main.do"><font color="white"> Main </font></a></h2>
	<ul class="treeview-menu">
		<li><a href="/Qorder/login/admin/orderList.do"><font color="white"> 주문목록 </font></a></li>
		<li><a href="/Qorder/login/admin/createqr.do"><font color="white"> QR생성</font></a></li>
	</ul>
</div>

<div class="treeview">
<h2><font color="white"> Insert </font></h2>
	<ul class="treeview-menu">
		<li><a href="/Qorder/login/admin/insertRestaurant.do"><h7><font color="white"> 식당 </font></h7></a></li>
		<li><a href="/Qorder/login/admin/insertItem.do"><h7><font color="white"> 아이템</font></h7></a></li>
		
		<c:if test="${sessionScope.customerType eq 'admin'}">
		<li><a href="/Qorder/login/admin/insertCustomer.do"><h7><font color="white"> 고객</font></h7></a></li>
		</c:if>
	</ul>
</div>

<div class="treeview">
<h2><font color="white"> Select </font></h2>
	<ul class="treeview-menu">
		<li><a href="/Qorder/login/admin/selectRestaurant.do?pageNo=0"><h7><font color="white"> 식당 </font></h7></a></li>
		<li><a href="/Qorder/login/admin/selectItem.do?pageNo=0"><h7><font color="white"> 아이템 </font></h7></a></li>
		<li><a href="/Qorder/login/admin/selectReceipt.do?pageNo=0"><h7><font color="white"> 계산서 </font></h7></a></li>
		<li><a href="/Qorder/login/admin/selectReview.do"><h7><font color="white"> 리뷰 </font></h7></a></li>
		<c:if test="${sessionScope.customerType eq 'admin'}">
		<li><a href="/Qorder/login/admin/selectCustomer.do"><h7><font color="white"> 고객 </font></h7></a></li>
		</c:if>
	</ul>
</div>










