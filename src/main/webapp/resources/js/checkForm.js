$(document).ready(function(){
	$('input[id^="rl_check"]').click(function(){  
		var id = $(this).attr("id");
		  
		if(this.checked){
			$("input[name^='rl_']").removeAttr('disabled');
		}else{
			$("input[name^='rl_']").attr('disabled',true);
		}
	});
});