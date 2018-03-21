$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//댓글 목록
	function selectData(pageNum,t_num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			$('#output').empty();
		}
		//로딩 이미지 노출
		$('#loading').show();
		
		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,t_num:t_num},
			url:"studyReply.do",
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
					alert('목록 호출 오류 발생!');
				}else{
					$(list).each(function(index,item){
						var output = '<div class="item">';
							output += ' <h4>' + item.m_nick + '</h4>';
							output += ' <div class="sub-item">';
							output += '  <p>' + item.re_tcontent.replace(/</g,'&lt;').replace(/>/gi,'&gt;') + "</p>";
							output +=  	 item.re_tdate;
							if($('#m_nick').val()==item.m_nick){
								//로그인 한 nick이 댓글 작성자 nick과 같으면
								output += ' <input type="button" data-num="'+item.re_tnum+'" data-id="'+item.m_nick+'" value="수정" class="modify-btn btn btn-default">';
								output += ' <input type="button" data-num="'+item.re_tnum+'" data-id="'+item.m_nick+'" value="삭제"  class="delete-btn btn btn-default">';
							}{
								
							}
							output += '   <hr size="1" noshade>';
							output += '  </div>';
							output += ' </div>';
							
							$('#output').append(output);
					});
					//paging button 처리
					if(currentPage >= Math.ceil(count/rowCount)){
						$('.paging-button').hide();
					}else{
						$('.paging-button').show();
					}
				}
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 오류');
			}
		});
	}
	
	$('.paging-button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#t_num').val());
	});
	
	//댓글 등록
	$('#re_tform').submit(function(event){
		if($('#re_tcontent').val()==''){
			alert('내용을 입력하세요!');
			$('#re_tcontent').focus();
			return false;
		}
		
		var data = $(this).serialize();
		
		//등록
		$.ajax({
			type:'post',
			data:data,
			url:'insertReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result == 'success'){
					initForm();
					selectData(1,$('#t_num').val());
				}else{
					alert('등록시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류!');
			}
		});
		event.preventDefault();
	});
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
	}
	
	//댓글 수정 버튼 클릭시 수정폼 노출
	$(document).on('click','.modify-btn',function(){
		//댓글 번호
		var re_tnum = $(this).attr('data-num');
		//작성자 아이디
		var m_nick = $(this).attr('data-id');
		//댓글 내용
		var re_tcontent = $(this).parent().find('p').html();
		
		//댓글 수정폼 UI
		var modifyUI = '<form id="mre_tform">';
			modifyUI += ' <input type="hidden" name="re_tnum" id="mre_tnum" value="'+re_tnum+'">';
			modifyUI += ' <input type="hidden" name="m_nick" id="muserNick" value="'+m_nick+'">';
			modifyUI += ' <textarea rows="3" class="form-control" cols="50" name="re_tcontent" id="mre_tcontent" class="rep-content">'+re_tcontent+'</textarea><br>';
			modifyUI += ' <div id="mre_second" style="text-align:right;">';
			modifyUI += '  <input type="submit" value="수정" class="btn btn-default">';
			modifyUI += '  <input type="button" value="취소" class="re-reset btn btn-default">';
			modifyUI += ' </div>';
			modifyUI += '</form>';
			
		initModifyForm();
		
		$(this).parent().hide();
		
		$(this).parents('.item').append(modifyUI);
		
	});
	
	//수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$(document).on('click','.re-reset',function(){
		initModifyForm();
	});
	
	//댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();
		$('#mre_tform').remove();
	}
	
	//댓글 수정
	$(document).on('submit','#mre_tform',function(event){
		if($('#mre_tcontent').val()==''){
			alert('내용을 입력하세요!');
			$('#mre_tcontent').focus();
			return false;
		}
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//수정
		$.ajax({
			type:'post',
			url:'updateReply.do',
			data:data,
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 수정할 수 있습니다.');
				}else if(data.result == 'success'){
					$('#mre_tform').parent().find('p').html($('#mre_tcontent').val().replace(/</g,'&lt;').replace(/>/gi,'&gt;'));
					initModifyForm();
				}else if(data.result == 'wrongAccess'){
					alert('타인의 글은 수정할 수 없습니다.')
				}else{
					alert('수정 오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 삭제
	$(document).on('click','.delete-btn',function(){
		//댓글 번호
		var re_tnum = $(this).attr('data-num');
		//작성자 닉네임
		var m_nick = $(this).attr('data-id');
		
		$.ajax({
			type:'post',
			url:'deleteReply.do',
			data:{re_tnum:re_tnum,m_nick:m_nick},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 삭제할 수 있습니다.');
				}else if(data.result == 'success'){
					alert('삭제 완료!');
					selectData(1,$('#t_num').val());
				}else if(data.result == 'wrongAccess'){
					alert('타인의 글을 삭제할 수 없습니다.');
				}else{
					alert('오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}
		});
	});
	
	selectData(1,$('#t_num').val());
	
});