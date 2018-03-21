$(document).ready(function(){
	var checkId = 0;
	//아이디 중복 체크
	$('#confirmId').click(function(){
		if($('#m_nick').val()==''){
			alert('아이디를 입력하세요.');
			$('#m_nick').focus();
			return;
		}
		$('#message_id').text();//메시지 초기화
		
		$.ajax({
			url:'confirmNick.do',
			type:'post',
			data:{m_nick:$('#m_nick').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='idNotFound'){
					$('#message_id').css('color','#000').text('등록가능 Nick입니다.');
					checkId = 1;
				}else if(data.result=='idDuplicated'){
					$('#message_id').css('color','red').text('중복된 Nick입니다.');
					$('#m_nick').val('').focus();
					checkId = 0;
				}else if(data.result=='sameAs'){
					$('#message_id').css('color','#000').text('이전과 같은 Nick, 사용가능.');
					checkId = 1;
				}
				else{
					alert('ID 중복체크 오류');
				}
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 오류 발생');
				checkId = 0;
			}
		});
	});
	//아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	$('#modifyForm #m_nick').keyup(function(){
		checkId = 0;
		$('#message_id').text('');
	});
	//submit이벤트 발생시 아이디 중복 체크 여부 확인
	$('#modifyForm').submit(function(){
		if(checkId==0){
			alert('아이디 중복체크를 해주세요');
			if($('#m_nick').val()==''){
				$('#m_nick').focus();
				alert('아이디를 입력해 주세요');
			}else{
				$('#confirmId').focus();
			}
			return false;
		}
	});
});
























