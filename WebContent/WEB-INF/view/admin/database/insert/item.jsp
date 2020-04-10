<%--  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Item

<form action="/Qorder/login/admin/insertItem1.do"  enctype="multipart/form-data" method="post" >
<input type="text" name="itemName" placeholder="아이템이름"<form:errors path="item.itemName" delimiter="/"/>><br>
아이템설명<br>
<textarea name="itemDescription" rows="10" cols="20"></textarea>
<form:errors path="item.itemDescription" delimiter="/"/><br>
<input type="number" name="itemPrice" placeholder="아이템가격" <form:errors path="item.itemPrice" delimiter="/"/>><br>
<input type="text" name="itemSort" placeholder="아이템종류" <form:errors path="item.itemSort" delimiter="/"/>><br>
<input type="hidden" name="itemRating" value="0"><br>
<input type="hidden" name="itemRatingCount" value="0"><br>


<!-- 따로 처리 해야할 것들 -->
아이템등록 : <input type="file" name="profile">
<input type="submit" value="확인">

</form>
------------------------------------------------------------------------ -- --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h4>Item Insert</h4>
<form action="/Qorder/login/admin/insertItem1.do"
	enctype="multipart/form-data" method="post">
	<div class="box-body">
		<div class="form-group">

			<label for="exampleInputName">NAME</label> <br> <input type="text"
				name="itemName" placeholder="아이템이름" id="exampleInputName"
				<form:errors path="item.itemName" delimiter="/"/>>
		</div>
		<div class="form-group">
			<label for="exampleInputPrice">PRICE</label> <br>
			
			<input type="number" name="itemPrice" placeholder="아이템가격"
				id="exampleInputPrice"
				<form:errors path="item.itemPrice" delimiter="/"/>>
		</div>
		<div class="form-group">
			<label for="exampleInputSort">SORT</label> <br> <input type="text"
				name="itemSort" placeholder="아이템종류" id="exampleInputSort"
				<form:errors path="item.itemSort" delimiter="/"/>>
		</div>
		<br>
		<div class="form-group">
			<textarea name="itemDescription" rows="10" cols="20"
				placeholder="DESCRIPTION"></textarea>
			<form:errors path="item.itemDescription" delimiter="/" />
		</div>
	</div>




	<div class="form-group">
		<label for="exampleInputFile">File input</label> <input type="file"
			id="exampleInputFile" name="profile">

	</div>



	<input type="submit" value="등록   ">

</form>


