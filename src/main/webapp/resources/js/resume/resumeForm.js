
$(document).ready(function(){
	$('#myResume,#myResumeModify').submit(function(){
		//disabled가 아닐시를 다시 확인
		//필수 항목
		if($('#md_name')==''){
			alert('필수 항목입니다!');
			return false;
		}
		if($('#md_phone')==''){
			alert('필수 항목입니다!');
			return false;
		}
		if($('#r_loc').val()==''){
			alert('필수 항목입니다!');
			return false;
		}
		
		//기본 이력서 항목
		if($('#r_price').val()==''&&$('#r_price').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#r_job').val()==''&&$('#r_job').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#r_intro').val()==''&&$('#r_intro').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#r_guitar').val()==''&&$('#r_guitar').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#r_pic').val()==''&&$('.r_pname').text()=='등록된 파일이 없습니다.'&&$('#r_pic').prop('disabled')!=true){
			alert('등록된 사진을 확인해 주세요!');
			return false;
		}
		
		//캐리어
		if($('#rl_title').val()==''&&$('#rl_title').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rl_position').val()==''&&$('#rl_position').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rl_sd').val()==''&&$('#rl_sd').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rl_ed').val()==''&&$('#rl_ed').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rl_def').val()==''&&$('#rl_def').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		
		//수상경력
		if($('#rc_title').val()==''&&$('#rc_title').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rc_inst').val()==''&&$('#rc_inst').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rc_year').val()==''&&$('#rc_year').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rc_content').val()==''&&$('#rc_content').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		
		//학력
		if($('#a_title').val()==''&&$('#a_title').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#a_ed').val()==''&&$('#a_ed').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#rl_grade').val()==''&&$('#rl_grade').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		
		//취미
		if($('#h_name').val()==''&&$('#h_name').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		
		//자격증
		if($('#l_name').val()==''&&$('#l_name').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#l_com').val()==''&&$('#l_com').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		if($('#l_year').val()==''&&$('#l_year').prop('disabled')!=true){
			alert('빈 항목이 있습니다! 입력란을 확인해 주세요! 혹은 비활성화 해주세요!');
			return false;
		}
		
		//포트 폴리오
		if($('#fFile').val()==''&&$('.fname').text()=='등록된 파일이 없습니다.'&&$('#fFile').prop('disabled')!=true){
			alert('파일 등록을 확인해 주세요!');
			return false;
		}
	});
});



























