$(document).ready(function(){
	$('#dialog').dialog({
		autoOpen:true,
		modal:true,
		resizable:false,
		open:function(event,ui){
			$('.ui-dialog-titlebar-close',$(this).parent()).hide();
		}
	});

});