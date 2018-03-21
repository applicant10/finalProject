$(document).ready(function(){
	$('#select_intro').click(function(){
		if($("#select_intro2").hide()&&$('#r_intro').prop('disabled')==true){
			$("#select_intro2").slideDown();              
			$('#r_intro').attr('disabled',false);
		}else if($("#select_intro2").show()&&$('#r_intro').prop('disabled')==false){
			$("#select_intro2").slideUp();
			$('#r_intro').attr('disabled',true);                
		}
	});
	
	$('#select_price').click(function(){
		if($("#r_price_content").hide()&&$('#r_price').prop('disabled')==true){
			$("#r_price_content").slideDown();
			$("#r_price").attr('disabled',false);
		}else if($("#r_price_content").show()&&$('#r_price').prop('disabled')==false){
			$("#r_price_content").slideUp();
			$("#r_price").attr('disabled',true);
		}                  
	});
	$('#select_job').click(function(){  
		if($("#r_job_content").hide()&&$('#r_job').prop('disabled')==true){
			$("#r_job_content").slideDown();
			$('#r_job').attr('disabled',false);
		}else if($("#r_job_content").show()&&$('#r_job').prop('disabled')==false){
			$("#r_job_content").slideUp();
			$('#r_job').attr('disabled',true);
		}
	});
	$('#select_guitar').click(function(){  
		if($("#r_guitar_content").hide()&&$('#r_guitar').prop('disabled')==true){
			$("#r_guitar_content").slideDown();
			$('#r_guitar').attr('disabled',false);
		}else if($("#r_guitar_content").show()&&$('#r_guitar').prop('disabled')==false){
			$("#r_guitar_content").slideUp();
			$('#r_guitar').attr('disabled',true);
		}
	});
	$('#select_pic').click(function(){  
		if($("#r_picture_content").hide()&&$("#r_picture").prop('disabled')==true){
			$("#r_picture_content").slideDown();
			$('#r_picture').attr('disabled',false);
		}else if($("#r_picture_content").show()&&$('#r_picture').prop('disabled')==false){
			$("#r_picture_content").slideUp();
			$('#r_picture').attr('disabled',true);
		}
	});
	$('#rl_checkCareer').click(function(){  
		if($("#rl_all_content").hide()&&$("input[id^=rl_]").prop('disabled')==true){
			$("#rl_all_content").slideDown();
			$('input[id^=rl_]').attr('disabled',false);
		}else if($("#rl_all_content").show()&&$('input[id^=rl_]').prop('disabled')==false){
			$("#rl_all_content").slideUp();
			$('input[id^=rl_]').attr('disabled',true);
		}
	});
	$('#rc_checkAwards').click(function(){  
		if($("#rc_all_content").hide()&&$("input[id^=rc_]").prop('disabled')==true){
			$("#rc_all_content").slideDown();
			$('input[id^=rc_]').attr('disabled',false);
		}else if($("#rc_all_content").show()&&$('input[id^=rc_]').prop('disabled')==false){
			$("#rc_all_content").slideUp();
			$('input[id^=rc_]').attr('disabled',true);
		}
	});
	$('#a_checkAchieve').click(function(){  
		if($("#a_all_content").hide()&&$("input[id^=a_]").prop('disabled')==true){
			$("#a_all_content").slideDown();
			$('input[id^=a_]').attr('disabled',false);
			$('select[name^=a_]').attr('disabled',false);
		}else if($("#a_all_content").show()&&$('input[id^=a_]').prop('disabled')==false){
			$("#a_all_content").slideUp();
			$('input[id^=a_]').attr('disabled',true);
			$('select[name^=a_]').attr('disabled',true);
		}
	});
	$('#h_checkHobby').click(function(){  
		if($("#h_all_content").hide()&&$("input[id^=h_]").prop('disabled')==true){
			$("#h_all_content").slideDown();
			$('input[id^=h_]').attr('disabled',false);
		}else if($("#h_all_content").show()&&$('input[id^=h_]').prop('disabled')==false){
			$("#h_all_content").slideUp();
			$('input[id^=h_]').attr('disabled',true);
		}
	});
	$('#l_checkLicense').click(function(){  
		if($("#l_all_content").hide()&&$("input[id^=l_]").prop('disabled')==true){
			$("#l_all_content").slideDown();
			$('input[id^=l_]').attr('disabled',false);
		}else if($("#l_all_content").show()&&$('input[id^=l_]').prop('disabled')==false){
			$("#l_all_content").slideUp();
			$('input[id^=l_]').attr('disabled',true);
		}
	});
	$('div#f_checkPortfolio').click(function(){  
		if($("#f_all_content").hide()&&$("input[id*=fFile]").prop('disabled')==true){
			$("#f_all_content").slideDown();
			$('input[id*=fFile]').attr('disabled',false);
		}else if($("#f_all_content").show()&&$('input[id*=fFile]').prop('disabled')==false){
			$("#f_all_content").slideUp();
			$('input[id*=fFile]').attr('disabled',true);
		}
	});
});