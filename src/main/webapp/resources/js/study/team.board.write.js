$(document).ready(function(){
	//섬머노트 설정
	$('.summernote').summernote({
		height: 300,          // 기본 높이값
		minHeight: null,      // 최소 높이값(null은 제한 없음)
		maxHeight: null,      // 최대 높이값(null은 제한 없음)
		lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
	});
	
	//팀 게시판 글쓰기 유효성 체크
	$('#teamBoardWrite_form').submit(function(){
		if($('#tb_title').val()==''){
			alert('제목을 입력하세요!');
			$('#tb_title').focus();
			return false;
		}
		if($('#tb_content').val()==''){
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
	
	//팀 게시판 글 수정 유효성 체크
	$('#teamBoardUpdate_form').submit(function(){
		if($('#tb_title').val()==''){
			alert('제목을 입력하세요!');
			$('#tb_title').focus();
			return false;
		}
		if($('#tb_content').val()==''){
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