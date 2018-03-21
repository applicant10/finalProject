$(document).ready(function(){
	var checkNick = 0;
	$('#m_nick').keyup(function(){
		var nick = $('#m_nick').val();
		
		$.ajax({
			url:'confirmNickMem.do',
			type:'post',
			data:{m_nick:nick},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='du'){
					checkNick=0;
					$('#message_nick').text('중복된 닉네임 입니다.');
				}else if(data.result=='solo'){
					if(nick.length<6){
						$('#message_nick').text('너무 짧아요.');
						checkNick=0;
					}else {
						$('#message_nick').text('사용 가능 합니다.');
						checkNick=1;
					}
					
				}
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	});                         
	var checkId = 0;
	//아이디 중복 체크              
	$('#confirmId').click(function(){
		if($('#m_id').val()==''){
			alert('아이디를 입력하세요.');
			$('#m_id').focus();
			return;
		}
		$('#message_id').text();//메시지 초기화
		$('#loading').show();//로딩 이미지 노출
		
		$.ajax({
			url:'confirmId.do',
			type:'post',
			data:{m_id:$('#m_id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();
				if(data.result=='idNotFound'){
					$('#message_id').css('color','#000').text('등록가능 ID');
					checkId = 1;
				}else if(data.result=='idDuplicated'){
					$('#message_id').css('color','red').text('중복된 ID');
					$('#m_id').val('').focus();
					checkId = 0;
				}else{
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
	$('#registerForm #m_id').keyup(function(){
		checkId = 0;
		$('#message_id').text('');
	});
	
	//submit이벤트 발생시 아이디 중복 체크 여부 확인
	$('#registerForm').submit(function(){
		if(checkId+checkNick<2){
			alert('아이디/닉네임 중복체크를 해주세요');
			if($('#m_id').val()==''){
				$('#m_id').focus();
				alert('아이디를 입력해 주세요');
			}else{
				$('#confirmId').focus();
			}
			return false;
		}
	});
});
























