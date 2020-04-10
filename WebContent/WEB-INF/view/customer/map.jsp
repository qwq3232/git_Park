<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   

<script type="text/javascript" src="/Qorder/script/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9c3c7b20eb601bfbad1aaa47ffc3dc8c"></script>

<br><br><br><br>
<div class="heading text-center">
	<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
	<h2>Map</h2>
	<img class="dividerline" src="/Qorder/image/app/sep.png" alt="">
</div>

<div class="papers text-center">
<div id="map" style="width:100%;height:800px;"></div>
</div>


<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨 
    }; 
var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

getRestaurant();

// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        
        var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px; text-align:center;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    var locPosition = new daum.maps.LatLng(33.450701, 126.570667),    
        message = 'geolocation을 사용할수 없어요..'
        
    displayMarker(locPosition, message);
}

//전체 식당 리스트의 좌표를 받아서 맵에 마커를 그려줌
function getRestaurant(){
	$.ajax({
		"url":"/Qorder/login/maplist.do",
		"type":"POST",
		"dataType":"json",
		"success":function(list){
			if(list.length > 0)
			{
				for(var i = 0; i < list.length; i++)
				{
				//	alert(list[i].restaurantName+' 위도 '+list[i].restaurantLatitude+ ' 경도 '+list[i].restaurantLongitude);
					var lat = list[i].restaurantLatitude;
					var lon = list[i].restaurantLongitude;
					var locPosition = new daum.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
			        var message = '<div style="padding:5px;text-align:center;">'+list[i].restaurantName+'</div>'; 
			        displayMarkerRestaurant(locPosition, message);
				}
			}
		},
		"error":function(){
			alert("식당정보를 가져올수 없음");
		}
	});
}

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new daum.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new daum.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}    
function displayMarkerRestaurant(locPosition, message) {

    // 마커를 생성합니다
    var marker = new daum.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new daum.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
}    


</script>



