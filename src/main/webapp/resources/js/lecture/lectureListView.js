$(document).ready(function(){
	$('button[id^=SubjectToggleBtn]').click(function(){
		var lv1 = $(this).data('lv1');
		$('div[data-lv1="'+lv1+'"]').toggle();
	});
});