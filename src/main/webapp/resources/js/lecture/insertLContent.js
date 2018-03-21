$(document).ready(function(){
	//섬머노트 설정
	$('.summernote').summernote({
		height: 300,          // 기본 높이값
		minHeight: null,      // 최소 높이값(null은 제한 없음)
		maxHeight: null,      // 최대 높이값(null은 제한 없음)
		lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
	});
});