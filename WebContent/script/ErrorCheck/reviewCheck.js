//리뷰를 체크하는 js 파일


//댓글 달기 클릭시 댓글 다는 형식을 출력하는 함수

$(document).ready(function(){ 
	
	$(".reviewButton").click(function(){
		
		var tableValue = $(this).val();
		
		$(".reviewButton").each(function(){
			
			if($(this).val() == tableValue){
					
				$(this).parent().append(
						"<textarea class='review' rows='5' cols='30'></textarea><span>평점</span><input type='number' min = '1' max='5'><button class='review_insert'>댓글달기</button>");
				$(".review_insert").val($(this).val());
						
				$(this).remove();
		
			}
			
		});
		
	});
	
	//댓글 저장 처리 및 ajax처리로 처리 완료를 반환하는 함수
	
 	$(document).on("click", ".review_insert", function(){
	
		var txt = "";
		var id = 0;
		var num = 0;
		
		var tableValue1 = $(this).val();
		
		$(".reviewVisible").each(function(){
			
			if($(this).val() == tableValue1){
				
				id = $(this).val();
				txt = $(this).next().val();
				num = $(this).next().next().next().val();
				
			}	
				
		});
	
		$.ajax({
	         "url":"/Qorder/review/insertReview.do",
	         "data":{"itemId":id, "reviewText":txt, "itemRate":num},//요청파라미터 - JS객체||queryString 문자열
	         "type":"POST",
	         "dataType":"json",
	       
	         "success":function(txt){
	            
	        	var itemId = txt.itemId;

	        	$(".reviewVisible").each(function(){
	        		
	        		if($(this).val() == itemId){
	        			 
	        			 $(this).next().remove();
	        			 $(this).next().remove();
	        			 $(this).next().remove();
	        			 $(this).next().remove();
	        			 $(this).parent().append("<label>작성완료</label>");	
	        			 
	        		}
	        		
	        		
	        	});
	        	
	        	 
	         },
	         "error":function(){
	            
	        	 alert("양식에 맞게 제대로 작성해주세요.");
	         	
	         }   
	      
			});
		
		
	});

}); 


function review(itemId)
{
	$("#tableid > tbody:last").append("<tr><td><br><input type='text' maxlength='50' placeholder='리뷰입력'></td></tr>");
}