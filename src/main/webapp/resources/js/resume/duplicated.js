$(document).ready(function(){
	$('#enterpriseRegisterForm').submit(function(){
		if($('input[type=text]').val()==''){
			alert('빈 칸을 모두 입력해 주세요');
			return false;
		}
		if($('input[type=number]').val()==''){
			alert('빈 칸을 모두 입력해 주세요');
			return false;
		}
		if($('input[type=email]').val()==''){
			alert('빈 칸을 모두 입력해 주세요');
			return false;
		}
	});
	
	$('#payInput').click(function(){
		if($("#pay").hide()&&$('#enterprise_pay').prop('disabled')==true){
			$("#pay").slideDown();              
			$('#enterprise_pay').attr('disabled',false);
		}else if($("#pay").show()&&$('#enterprise_pay').prop('disabled')==false){
			$("#pay").slideUp();
			$('#enterprise_pay').attr('disabled',true);                
		}
	});
	$('#payInput2').click(function(){
		if($("#pay_per").hide()&&$('#enterprise_pay_percent').prop('disabled')==true){
			$("#pay_per").slideDown();              
			$('#enterprise_pay_percent').attr('disabled',false);
		}else if($("#pay_per").show()&&$('#enterprise_pay_percent').prop('disabled')==false){
			$("#pay_per").slideUp();
			$('#enterprise_pay_percent').attr('disabled',true);                
		}
	});
	
	$('.nextButton').click(function(){
		$('#firstForm').fadeOut('fast');
		$('#h3Title').text('기업 회원 가입(2/2)');
		$('#secondForm').fadeIn('slow');
	});
	$('.prevButton').click(function(){
		$('#secondForm').fadeOut('fast');
		$('#h3Title').text('기업 회원 가입(1/2)');
		$('#firstForm').fadeIn('slow');
	});
	$('.nextButton2').click(function(){
		$('.firstForm').fadeOut('fast');
		$('.h3Title').text('기업 회원 정보 수정(2/2)');
		$('.secondForm').fadeIn('slow');
	});
	$('.prevButton2').click(function(){
		$('.secondForm').fadeOut('fast');
		$('.h3Title').text('기업 회원 정보 수정(1/2)');
		$('.firstForm').fadeIn('slow');
	});
	$('#enterprise_password').keydown(function(){
		if($('#enterprise_password').val().length<=5){
			$('#boxLength').css('color','red').text('*6자리 이상 적어 주세요.');
		}else if($('#enterprise_password').val().length>15){
			$('#boxLength').css('color','red').text('*15자리 이상은 사용할 수 없어요.');
		}else if($('#enterprise_password').val().length>6&&$('#enterprise_password').val().length<15){
			$('#boxLength').css('color','black').text('*다음 단계로 넘어가 주세요.');
		}
	});
	$('#enterprise_password_confirm').keyup(function(){
		if($('#enterprise_password').val()!=$('#enterprise_password_confirm').val()){
			$('#boxBox').css('color','red').text('*비밀번호는 일치해야 합니다.');
		}else if($('#enterprise_password').val()==$('#enterprise_password_confirm').val()){
			$('#boxBox').css('color','black').text('*다음 단계로 넘어 가시죠');
		}
	});
	$('#m_id').keyup(function(){
		$.ajax({
			url:'confirmEnterId.do',
			type:'post',
			data:{m_id:$('#m_id').val()},
			dataType:'json',
			cache:false,
			timeout:10000,
			success:function(data){
				if(data.result=='repeated'){
					$('#confirmEnterId').text('');
					$('#confirmEnterId').css('color','red').text('*아이디 중복.');
				}else if(data.result=='short'){
					$('#confirmEnterId').text('');
					$('#confirmEnterId').css('color','red').text('*올바른 형식이 아닙니다.');
				}else if(data.result=='canUse'){
					$('#confirmEnterId').text('');
					$('#confirmEnterId').css('color','black').text('*사용 가능합니다.');
				}else{
					alert('오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	});
	$('#enterprise_num').keyup(function(){
		$.ajax({
			url:'confirmEnterNum.do',
			type:'post',
			data:{num:$('#enterprise_num').val()},
			dataType:'json',
			cache:false,
			timeout:10000,
			success:function(data){
				if(data.result=='repeated'){
					$('#confirmEnterNum').css('color','red').text('*사업자 번호 중복.');
				}else if(data.result=='short'){
					$('#confirmEnterNum').css('color','red').text('*번호가 형식에 맞지 않습니다.');
				}else if(data.result=='canUse'){
					$('#confirmEnterNum').css('color','black').text('*사용 가능합니다.');
				}else{
					alert('오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	});
});