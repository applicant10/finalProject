$(document).ready(function(){
	$('#deleteConfirm').submit(function(){
		var msg = confirm("정말 삭제 하시겠습니까?");
		if(msg==true){
			return true;
		}else{
			return false;
		}
	});
});