//선택된 메뉴 보낼 시 에러 체크 js 파일

//메뉴 체크 
function Check_Checked(){
   
   var chkList = document.getElementsByName("check_item");
   //var table = $("#table").value;
   var cnt = 0;
   
   for(var i = 0; i < chkList.length; i++){
         if(chkList[i].checked){   
            cnt++;
         
         }
   }
   
   if(table == ''){
      alert("테이블 번호를 입력하세요.");
      return false;
   
   }else if(!cnt){
      alert("메뉴를 하나 이상 선택하세요.");
      return false;
   
   }else if(Count_Checked() == false){
      return false;
      
   }else if(Double_Checked() == false){
      return false;
   
   }else{
      return true;
      
   }
   
} 

//수량 오류 체크
function Count_Checked(){
   
   var countList = document.getElementsByName("count");
   var cnt = 0;
   
   for(var i = 0; i < countList.length; i++){
         if(countList[i].value != 0){   
            cnt++;
         }
   }
      
   if(!cnt){
      alert("수량을 선택하세요.");
      return false;
   
   }
   
   return true;
} 

//변형된 오류 체크
function Double_Checked(){
   
   var chkList = document.getElementsByName("check_item");
   var countList = document.getElementsByName("count");
   var number = $("#itemListLength").val();
   
   for(var i = 0; i < number; i++){
      
       if(countList[i].value == 0 && chkList[i].checked == true){
          alert("오류");
          return false;
       
       }else if(countList[i].value != 0 && chkList[i].checked == false){
          alert("오류");
          return false;
       }   
      
   }
            
   return true;
   
}

function check(itemId)
{
	if($("#"+itemId).is(":checked"))
		$("#"+itemId).prop("checked", false);
	else
		$("#"+itemId).prop("checked", true);
}
