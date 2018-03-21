$(document).ready(function(){
	//섬머노트 설정
	$('.summernote').summernote({
		height: 300,          // 기본 높이값
		minHeight: null,      // 최소 높이값(null은 제한 없음)
		maxHeight: null,      // 최대 높이값(null은 제한 없음)
		lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
	});

	//스터디 모집글 유효성 체크
	$('#studyWrite_form').submit(function(){
		if($('#t_title').val()==''){
			alert('제목을 입력하세요!');
			$('#t_title').focus();
			return false;
		}
		if($('#t_area').val()==''){
			alert('활동 지역을 입력하세요!');
			$('#t_area').focus();
			return false;
		}
		if($('#t_sub').val()==''){
			alert('과목을 선택하세요!');
			$('#t_sub').focus();
			return false;
		}
		if($('#t_content').val()==''){
			alert('내용을 입력하세요!');
			$('.note-editable').focus();
			return false;
		}
		if($('.note-editable').html()=='<p><br></p>'){
			alert('내용을 입력하세요!');
			$('.note-editable').focus();
			return false;
		}
	});
	
	//스터디 모집글 수정 유효성 체크
	$('#studyUpdate_form').submit(function(){
		if($('#t_title').val()==''){
			alert('제목을 입력하세요!');
			$('#t_title').focus();
			return false;
		}
		if($('#t_area').val()==''){
			alert('지역을 입력하세요!');
			$('#t_area').focus();
			return false;
		}
		if($('#t_sub').val()==''){
			alert('과목을 선택하세요!');
			$('#t_sub').focus();
			return false;
		}
		if($('#t_content').val()==''){
			alert('내용을 입력하세요!');
			$('.note-editable').focus();
			return false;
		}
		if($('.note-editable').html()=='<p><br></p>'){
			alert('내용을 입력하세요!');
			$('.note-editable').focus();
			return false;
		}
	});
});