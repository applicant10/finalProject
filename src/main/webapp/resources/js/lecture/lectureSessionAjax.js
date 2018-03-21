$(document).ready(function(){
	var count = 0;
	//5분마다 서버에 AJAX요청 날리기
	setInterval(function(){
		console.log(count);
		$.ajax({
			url:'studySessionSend.do',
			type:'post',
			data:{count:count},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = count+1;
			},
			error:function(){}
		});
	}, 60000);
});