$(document).ready(function(){
	//#bfL_num이 존재할 경우
	if($('#bfL_num').length > 0){
		$('#bfBtn').attr('onclick', "location.href='learnStudent.do?'+$('#bfL_num').val()");
		$('#bfBtn').attr('class', 'btn btn-default btn-lg');
	}
	//#afL_num이 존재할 경우
	if($('#afL_num').length > 0){
		$('#afBtn').attr('onclick', "location.href='learnStudent.do?'+$('#afL_num').val()");
		$('#afBtn').attr('class', 'btn btn-default btn-lg');
	}
});