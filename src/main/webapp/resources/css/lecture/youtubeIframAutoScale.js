$(document).ready(function(){
	//youtube iframe태그 찾아서 반응형 스타일 div태그로 덮어 씌움.
	$('iframe[src^="//www.youtube.com/"]').wrap('<div class="youtubeWrap"></div>');
});