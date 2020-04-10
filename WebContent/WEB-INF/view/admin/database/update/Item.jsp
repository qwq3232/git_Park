<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h4>Item UPDATE</h4>
<form action="/Qorder/login/admin/updateItem.do"
	enctype="multipart/form-data" method="post">
	
	<div class="box-body">
		<div class="form-group">
			
			<input type="hidden" name="itemId" value=${requestScope.item.itemId }><br>
			
			<label for="exampleInputName">NAME</label> <br> <input
				type="text" name="itemName" placeholder="아이템이름"
				id="exampleInputName" value=${requestScope.item.itemName }
				<form:errors path="item.itemName"  delimiter="/"/>>
		</div>
	<div class="form-group">
			<label for="exampleInputPrice">PRICE</label> <br> <input
				type="number" name="itemPrice" placeholder="아이템가격"
				id="exampleInputPrice" value=${requestScope.item.itemPrice }
				<form:errors path="item.itemPrice" delimiter="/"/>>
		</div>
	<div class="form-group">
			<label for="exampleInputSort">SORT</label> <br> <input
				type="text" name="itemSort" placeholder="아이템종류"
				id="exampleInputSort" value=${requestScope.item.itemSort }
				<form:errors path="item.itemSort" delimiter="/"/>>
		</div>

	<div class="form-group">
			<label for="exampleInputSort">SORT</label> <br> <input
				type="hidden" name="restaurantId" placeholder="레스토랑"
				id="exampleInputSort" value=${requestScope.item.restaurantId }
				<form:errors path="item.itemSort" delimiter="/"/>>
		</div>

	<div class="form-group">
			<label for="exampleInputSort">Description</label><br>
			<textarea name="itemDescription" placeholder="설명"  id="exampleInputSort" rows="10"
			cols="20">${requestScope.item.itemDescription }</textarea>
			<form:errors path="item.itemDescription" delimiter="/" />
		</div>
	
		
		<input type="hidden" name="itemRating" value="0"><br>
		<input type="hidden" name="itemRatingCount" value="0"><br>


	<div class="form-group">
		<label for="exampleInputFile">File input</label> <input type="file"
			id="exampleInputFile" value=${requestScope.item.itemImage }
			name="profile">

	</div>
</div>


	<input type="submit" value="수정"> 
	<%-- <a href="/Qorder/login/admin/deletItem.do?itemId=${requestScope.item.itemId}">삭제</a> --%>
</form> 
	
