$(document).ready(function(){
	//섬머노트 설정
	$('.summernote').summernote({
		height: 300,          // 기본 높이값
		minHeight: null,      // 최소 높이값(null은 제한 없음)
		maxHeight: null,      // 최대 높이값(null은 제한 없음)
		lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
	});

	//과목 정보 로드 AJAX
	$('#lv2').hide();
	$('#subSelectBtn').hide();
	$('#lv1').change(function(){
		$('#lv2').empty();
		$.ajax({
			url:'../subject/loadSubjectLv2.do',
			type:'post',
			data:{lv1:$('#lv1 option:selected').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();
				$('#lv2').show();
				var list = data.list;

				if(list == null){
					alert('분야 목록 호출 중 오류가 발생했습니다.');
				}else{
					$(list).each(function(index, item){
						var output = '<option value="'+item.s_num+'">'+item.lv2+'</option>';
						$('#lv2').append(output);
					});
					$('#lv1').attr('size', data.count);
					$('#lv2').attr('size', data.count);
				}
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 오류 발생');
			}
		});
	});
	
	$('#lv2').focus(function(){
		$('#subSelectBtn').show();
	});
	$('#lv2').change(function(){
		$('#selectedSubject').empty();
		$('#selectedSubject').append('  분야 : ' + $('#lv1 option:selected').text() + ' > ' + $('#lv2 option:selected').text());
	});
	
	//유효성 검사
	$('#insertLectureForm').submit(function(){
		if($('#lv2').val() == null || $('#lv2').val() == ''){
			alert('분야를 선택하세요.');
			return false;
		}
		if($('#l_title').val()==''){
			alert('제목을 입력하세요.');
			return false;
		}
		if($('#l_content').val()==''){
			alert('내용을 입력하세요.');
			return false;
		}
	});
	
	//l_shortcon 글자 수 체크
	$('#l_shortcon').keyup(function(){
        var inputLength = $(this).val().length;

        if(inputLength > 300){  //300자를 넘어선 경우
            $(this).val($(this).val().substring(0,300));
        }else{  //300자 이하인 경우
            var remain = 300 - inputLength;
            remain += '/300';
            $('#scCount').text(remain);
        }
    });
}); 