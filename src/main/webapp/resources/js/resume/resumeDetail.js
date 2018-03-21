$(document).ready(function(){
	var rG = 20; 
	var falta = "";
	if($('#rC').css('display')!=undefined){
		rG += 10;
	}else{
		falta +='경력, ';
	}
	if($('#rA').css('display')!=undefined){
		rG += 10;
	}else{
		falta += '수상 경력, ';
	}
	if($('#rAc').css('display')!=undefined){
		rG += 10;
	}else{
		falta += '학력, ';
	}
	if($('#rH').css('display')!=undefined){
		rG += 10;
	}else{
		falta += '취미, ';
	}
	if($('#rL').css('display')!=undefined){
		rG += 10;
	}else{
		falta += '자격증, ';
	}
	if($('#rF').css('display')!=undefined){
		rG += 10;
	}else{
		falta += '포트 폴리오, ';
	}
	if($('#userFoto').css('display')!=undefined){
		rG += 20;
	}else{
		falta += '사진, ';
	}
	
	falta = falta.substring(0,falta.length-2);
	
	if(rG==100){
		$('.progress-label').text('완성!');
		$('#falta').text('없어여!');
	}else{
		$('.progress-label').text(rG + '%');
		$('#falta').text(falta);
	}
	$( "#barProgress" ).progressbar({
	    value: rG,
	    create: function(event, ui) {$(this).find('.ui-widget-header').css({'background-color':'powderblue'})}
	    });
	$('#likeResume').click(function(){
		var m_id = $('#emailCopy').val();
		$.ajax({
			url:'likeResume.do',
			type:'post',
			data:{m_id:m_id},
			dataType:'json',
			cache:false,
			timeout:10000,
			success:function(data){
				if(data.result=='AlreadyHas'){
					alert('이미 관심있는 목록에 있는 이력서 입니다.');
				}else if(data.result=='canInsert'){
					alert('등록 되었습니다.');
					$('#imgSize').attr('src','../resources/images/resume/liked.png');
				}else if(data.result=='full'){
					alert('20개 이상 등록 할 수 없습니다.');
				}else if(data.result=='add'){	
					alert('추가 되었습니다.');
					$('#imgSize').attr('src','../resources/images/resume/liked.png');
				}else{
					alert('오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	});
	
	$('a[id^=r]').click(function(){
		var id = $(this).attr('id');
		$('div[id^=r]').not('div[id='+id+'_resume]').hide();
		//$('div[id='+id+'_resume]').fadeTo("slow",1);
		var loc = $('div[id='+id+'_resume]').offset();
		$('div[id='+id+'_resume]').slideDown();
	});
	$('#deleteConfirm').on('click',function(){
		$('#conDelete').dialog({
			display:"",
			width:350,
			height:300,                
			modal:true,
			resizable:false,
			open:function(event,ui){
				$('.ui-dialog-titlebar-close',$(this).parent()).hide();
			}
		});
	});
	
	$('#regularMember').hover(function(){
		$('#img1').hide();
		$('#img2').fadeIn('fast');              
	});
	$('#enterpriseMember').hover(function(){
		$('#img2').hide();
		$('#img1').fadeIn('fast');
	});
	
	$('div[id^=r]').on('click',function(e){
		var id =$(this).attr('id');
		$('#'+id+'_resume').dialog({              
			show:{
				effect:'slideDown',
				duration:500
			},
			hide:{
				effect:'slideUp',
				duration:500
			},                                        
			modal:true,
			resizable:false,
			open:function(event,ui){                       
				$('.ui-dialog-titlebar-close',$(this).parent()).hide();
			},            
			buttons:{                                        
				cancel:function(){
					$(this).dialog('close');
				}
			}
		});
		e.preventdefault();
	});
	
	
	
});
function copyClipboard(){
	var copy = document.getElementById('emailCopy');   
	copy.select();                                            
	document.execCommand("copy");        
	alert('주소가 복사되었습니다.');
}





























