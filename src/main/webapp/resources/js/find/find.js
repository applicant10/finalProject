$(document).ready(function(){
	$('#searchId').click(function(){
		var nick = $('#m_nick').val();
		var name = $('#md_name').val();
		$.ajax({
			url:"findId.do",
			dataType:'json',
			type:'post',
			data:{m_nick:nick,md_name:name},
			cache:false,
			timeout:10000,
			success:function(data){
				if(data.result=='yes'){
					$('#resultId').text(data.id+"입니다.");
				}else{
					$('#resultId').text('아이디가 확인 되지 않습니다.');
				}
			},
			error:function(){
				alert('네트워크 에러');
			}
			
		});
	});
});