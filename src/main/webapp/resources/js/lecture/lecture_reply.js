$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//다음 댓글 보기 버튼 클릭시 데이터 추가
	$('.paging-button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#l_num').val());
	});
	
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#re_first .letter-count').text('300/300');
	}
	
	//textarea에 내용 입력시 글자수 체크
	$(document).on('keyup','textarea',function(){
		//남은 글자수를 구함
		var inputLength = $(this).val().length;

		if(inputLength>300){//300자를 넘어선 경우
			$(this).val($(this).val().substring(0,300));
		}else{
			//300자 이하인 경우
			var remain = 300 - inputLength;
			remain += '/300';
			if($(this).attr('id')=='lr_content'){
				//등록폼 글자수
				$('#re_first .letter-count').text(remain);
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').text(remain);
			}
		}

	});
	
	selectData(1, $('#l_num').val());
	
	//목록 출력 함수
	function selectData(pageNum, l_num){
		currentpage = pageNum;
		
		if(pageNum == 1){
			//첫 호출 시 댓글리스트가 들어갈 영역 클리어시키기
			$('#lcreplyOutput').empty();
		}
		
		//로딩 이미지 출력
		$('#loading').show();
		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,l_num:l_num},
			url:'listLReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩 이미지 감추기
				$('#loading').hide();
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;
				
				if(count < 0 || list == null){
					alert('목록 호출 중 오류 발생!');
				}else{
					$(list).each(function(index,item){
						var output = '<div class="item">';
						
						output += ' <h4>' + item.m_id + '</h4>';
						output += ' <div class="sub-item">';
						output += ' <div class="radio">';
						
						//별표 시작
						output += '<span class="star-rating-control">';
						output += ' <div class="rating-cancel" style="display:none;">';
						output += '  <a title="Cancel Rating"></a>';
						output += ' </div>';
						
						for(var i=1; i<6; i++){
							output += '<div role="text" aria-label class="star-rating rater-0 star star-rating-applied star-rating-live';
							if(i <= item.lr_point)
								output+= ' star-rating-on';
							output += '"><a title="'+i+'">'+i+'</a></div>';
						}
						
						output += ' </span><br>';
						
						for(var i=1; i<6; i++){
							output += '<input name="lr_point" type="radio" class="star star-rating-applied" value="'+i+'" style="display: none;">';
						}
						//별표 끝
						
						output += '  <p>' + item.lr_content.replace(/</g,'&lt;').replace(/>/gi,'&gt;') + "</p>";
						output +=    item.lr_date;
						
						output += '  <hr size="1" noshade>';
						output += ' </div>';
						output += '</div>';

						//문서 객체에 추가
						$('#lcreplyOutput').append(output);
					});
					
					//paging button 처리
					if(currentPage >= Math.ceil(count/rowCount)){
						//다음 페이지가 없음
						$('.paging-button').hide();
					}else{
						//다음 페이지가 존재
						$('.paging-button').show();
					}
				}
			},
			error:function(data){
				//로딩 이미지 감추기
				$('#loading').hide();
				alert('네트워크 오류');
			}
		});
	}
	
	//댓글 등록 함수
	$('#reply_form').submit(function(event){
		if($('#lr_content').val()==''){
			alert('내용을 입력하세요!');
			$('#lr_content').focus();
			return false;
		}

		var data = $(this).serialize();

		//등록
		$.ajax({
			type:'post',
			data:data,
			url:'writeLReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result == 'success'){
					//폼초기화
					initForm();
					//댓글 작성이 성공하면 새로 삽입한 글을 포함해서 첫번째 페이지의 게시글들을 다시 호출함
					selectData(1, $('#l_num').val());
				}else{
					alert('등록시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	
});