$(document).ready(function(){
	$('input[id^="select_"]').click(function(){
		var name = $(this).attr('id');
		name = name.substring(6);
		if(this.checked){
			$("input[name*="+name+"]").removeAttr('disabled');
		}else{
			$("input[name*="+name+"]").attr('disabled',true);
		}
	});
	$('input[id^="rl_check"]').click(function(){  
		var id = $(this).attr("id");
		  
		if(this.checked){
			$("input[name^='rl_']").removeAttr('disabled');
		}else{
			$("input[name^='rl_']").attr('disabled',true);
		}
	});
	$('input[id^="a_check"]').click(function(){  
		var id = $(this).attr("id");
		  
		if(this.checked){
			$("input[name^='a_']").removeAttr('disabled');
			$("select[name^='a_']").removeAttr('disabled');
		}else{
			$("input[name^='a_']").attr('disabled',true);
			$("select[name^='a_']").attr('disabled',true);
		}
	});
	$('input[id^="h_check"]').click(function(){  
		var id = $(this).attr("id");
		  
		if(this.checked){
			$("input[name^='h_']").removeAttr('disabled');
		}else{
			$("input[name^='h_']").attr('disabled',true);
		}
	});
	$('input[id^="l_check"]').click(function(){  
		var id = $(this).attr("id");
		  
		if(this.checked){
			$("input[name^='l_']").removeAttr('disabled');
		}else{
			$("input[name^='l_']").attr('disabled',true);
		}
	});
	$('input[id^="rc_check"]').click(function(){  
		var id = $(this).attr("id");
		  
		if(this.checked){
			$("input[name^='rc_']").removeAttr('disabled');
		}else{
			$("input[name^='rc_']").attr('disabled',true);
		}
	});
	$('input[id^="f_check"]').click(function(){  
		var id = $(this).attr("id");
		
		if(this.checked){
			$("input[name^='f']").removeAttr('disabled');
		}else{
			$("input[name^='f']").attr('disabled',true);
		}
	});
});