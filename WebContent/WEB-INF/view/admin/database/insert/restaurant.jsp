<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9c3c7b20eb601bfbad1aaa47ffc3dc8c"></script>


<h4>Restaurant Insert</h4>
<form action="/Qorder/login/admin/insertRestaurant.do" enctype="multipart/form-data" method="post">
	<div class="box-body">
	
		<div class="form-group">
			<label for="exampleInputName">OWNERID</label> <br> 
			<c:choose>
				<c:when test="${sessionScope.customerType eq 'admin'}">
					<input type="text" name="ownerId" placeholder="점주 ID" id="exampleInputPrice" value=${sessionScope.customerId }>
				</c:when>
				<c:otherwise>
					<input type="text" name="ownerId" placeholder="점주 ID" id="exampleInputPrice" value=${sessionScope.customerId } readonly="readonly">
				</c:otherwise>
			</c:choose>
			
		</div>
	
	
		<div class="form-group">
			<label for="exampleInputName">NAME</label> <br> <input type="text" name="restaurantName" placeholder="가게 상호명" id="exampleInputPrice" <form:errors path="restaurant.restaurantName" delimiter="/"/>>
		</div>
		<div class="form-group">
			<label for="exampleInputPrice">ADDRESS</label> <br>
			<input type="text" name="restaurantAddress" placeholder="가게 주소" id="exampleInputPrice" <form:errors path="restaurant.restaurantAddress" delimiter="/"/>>
		</div>
		<div class="form-group">
			<label for="exampleInputSort">PHONE</label> <br> <input type="number" name="restaurantPhone" id="exampleInputPrice" placeholder="가게 전화번호" <form:errors path="restaurant.restaurantPhone" delimiter="/"/>>
		</div>

		<input type="hidden" name="restaurantRating" value="0" >
		<input type="hidden" name="restaurantRatingCount" value="0">

		<div class="form-group">
			<label for="exampleInputSort">MILEAGE</label> <br> <input type="number" name="restaurantMileage" placeholder="적립율" id="exampleInputPrice" <form:errors path="Restaurant.restaurantMileagee" delimiter="/"/>>
		</div>
		
		<div id="map" style=" width:100%; height:350px;"></div>
		<p><em>지도를 클릭해주세요!</em></p> 
		
		
		<div class="form-group">
			<label for="exampleInputSort">LATITUDE</label> <br><input type="text" name="restaurantLatitude" id="latitude" placeholder="가게 위도" readonly>
		</div>
		
		<div class="form-group">
			<label for="exampleInputSort">LONGITUDE</label> <br><input type="text" name="restaurantLongitude" id="longitude" placeholder="가게 경도" readonly>
		</div>

		<div class="form-group">
			<textarea rows="10" cols="20" name="restaurantDescription" placeholder="DESCRIPTION"></textarea><form:errors path="restaurant.restaurantDescription" delimiter="/"/>	
		</div>
	</div>




	<div class="form-group">
		<label for="exampleInputFile">File input</label> <input type="file"
			id="exampleInputFile" name="profile">

	</div>



	<input type="submit" value="등록   ">

</form>

<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };
var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//지도를 클릭한 위치에 표출할 마커입니다
var marker = new daum.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);


// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng;
    
    var message = '식당위치는 요기?';
    document.getElementById("latitude").value = latlng.getLat();
    document.getElementById("longitude").value = latlng.getLng();
    var locPosition = new daum.maps.LatLng(latlng.getLat(), latlng.getLng());
    
 // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
 	
});

</script>




