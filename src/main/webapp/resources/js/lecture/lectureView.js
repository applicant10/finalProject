$(document).ready(function(){
	
	$('#enrollBtn').click(function(){
		var ask = confirm('해당 강좌를 수강하시겠습니까?');
		
		if(ask){
			//yes
			location.href='enrollment.do?l_num='+$('#hiddenTitle').val();
		}else{
			
		}
	});
	
});