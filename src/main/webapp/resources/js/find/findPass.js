$(document).ready(function(){
	$('#passSubmit').submit(function(){
		if($('input[id=m_id]').val()==''){
			alert("필수 항목입니다.");
			$('input[id=m_id]').focus();
			return false;
		}
		if($('input[id=m_nick]').val()==''){
			alert("필수 항목입니다.");
			$('input[id=m_nick]').focus();
			return false;
		}
		if($('input[id=md_name]').val()==''){
			alert("필수 항목입니다.");
			$('input[id=md_name]').focus();
			return false;
		}
	});
	$('input[id=m_id]').keyup(function(){
		if($('input[id=m_id]').val().length<2){
			$('#id').text(' *너무 짧습니다.');
		}else{
			$('#id').text(' *그뤠잇');
		}
	});
	$('input[id=m_nick]').keyup(function(){
		if($('input[id=m_nick]').val().length<2){
			$('#nick').text(' *너무 짧습니다.');
		}else{
			$('#nick').text(' *그뤠잇');
		}
	});
	$('input[id=md_name]').keyup(function(){		
		if($('input[id=md_name]').val().length<2){
			$('#name').text(' *너무 짧습니다.');
		}else{
			$('#name').text(' *그뤠잇');
		}
	});
});