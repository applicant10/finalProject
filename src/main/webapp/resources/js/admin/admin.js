$(document).ready(function(){
	$('#memberBtn').click(function(){
		$('#enterpriseBtn').css('background','#ffffff');
		$('#enter').hide();
		$('#memberBtn').css('background','#efefef');
		$('#member').fadeIn('fast');
		count=1;
	});
	$('#enterpriseBtn').click(function(){
		$('#memberBtn').css('background','#ffffff');
		$('#member').css('display','none');
		$('#enterpriseBtn').css('background','#efefef');
		$('#enter').fadeIn('fast');
		count=0;
	});
	
	$('.accessMember').click(function(){
		var btn = $(this).val();
		var id = $(this).data('id');
		if(btn=='비재명'){
			$(this).val('재명');
			$(this).parent().prev().text('활동 가능');
		}
		if(btn=='재명'){
			$(this).val('비재명');
			$(this).parent().prev().text('재명 됨');
		}
		$.ajax({
			url:'accessMember.do',
			type:'post',
			data:{btn:btn,id:id},
			dataType:'json',
			cache:false,
			timeout:10000,
			success:function(data){
				if(data.result=='active'){
					alert('계정 활성화 되었습니다.');
				}else if(data.result=='inactive'){
					alert('계정 비활성화 되었습니다.');
				}else{
					alert('오류 발생');
				}
			},
			error:function(data){
				alert('네트워크 오류');
			}
		});
	});
});