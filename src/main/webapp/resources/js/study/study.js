$(document).ready(function(){
	//검색 유효성 체크
	$('#search_form').submit(function(){
		if($('#keyword').val()==''){
			alert('검색어를 입력하세요!');
			$('#keyword').focus();
			return false;
		}
	});
	$('#search_form2').submit(function(){
		if($('#keyword').val()==''){
			alert('검색어를 입력하세요!');
			$('#keyword').focus();
			return false;
		}
	});
	
	//팀 개설 유효성 체크
	$('#studyEstablish_form').submit(function(){
		if($('#g_name').val()==''){
			alert('팀이름을 입력하세요!');
			$('#g_name').focus();
			return false;
		}
	});
	$('#studyEstablish_form').submit(function(){
		if($('#g_greet').val()==''){
			alert('인사말을 입력하세요!');
			$('#g_greet').focus();
			return false;
		}
	});
	//팀 지원 유효성 체크
	$('#teamAppli_form').submit(function(){
		if($('#a_content').val()==''){
			alert('간단한 자기소개 또는 포부를 입력해주세요!');
			$('#a_content').focus();
			return false;
		}
	});
});