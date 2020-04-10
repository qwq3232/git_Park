<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h4>Customer UPDATE</h4>
<form action="/Qorder/login/admin/updateCustomer.do" method="post" enctype="multipart/form-data">
	<div class="box-body">
		<div class="form-group">

			<label for="exampleInputName">ID</label>
			 <br> <input type="text" name="customerId"  placeholder="ID를 입력하세요" value=${requestScope.cus.customerId } <form:errors path="customer.customerId" delimiter="/"/> >
		</div>
		<div class="form-group">
			<label for="exampleInputPrice">PASSWORD</label> <br>
			
			<input type="password" name="customerPassword" placeholder="비밀번호를 입력하세요" value=${requestScope.cus.customerPassword } ><form:errors path="customer.customerPassword" delimiter="/"/>
		</div>
		<div class="form-group">
			<label for="exampleInputSort">NAME</label> <br> <input type="text" name="customerName" placeholder="이름을 입력하세요" value=${requestScope.cus.customerName }><form:errors path="customer.customerName" delimiter="/"/>
		</div>
		
		<div class="form-group">
			<label for="exampleInputSort">MILEAGE</label> <br> <input type="number" name="customerMileage" placeholder="마일리지 포인트를 입력하세요" value=${requestScope.cus.customerMileage }><form:errors path="customer.customerMileage" delimiter="/"/>
		</div>
		
	</div>

	<div class="form-group">
		<label for="exampleInputFile">File input</label> <input type="file"
			id="exampleInputFile" name="profile">

	</div>



	<input type="submit" value="수정">
	<a href="/Qorder/login/admin/deletCustomer.do?customerId=${requestScope.cus.customerId}">삭제</a>

</form>