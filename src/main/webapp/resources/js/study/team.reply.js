$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//댓글 목록
	function selectData(pageNum,tb_num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			$('#output').empty();
		}
		$('#loading').show();
		
		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,tb_num:tb_num},
			url:"teamReply.do",
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
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
							output += '  <p>' + item.re_gcontent.replace(/</g,'&lt;').replace(/>/gi,'&gt;') + "</p>";
							output +=  	 item.re_gdate;
							if($('#m_nick').val()==item.m_nick){
								output += '  <input type="button" data-num="'+item.re_gnum+'" data-id="'+item.m_nick+'" value="수정" class="modify-btn btn btn-default">';
								output += '  <input type="button" data-num="'+item.re_gnum+'" data-id="'+item.m_nick+'" value="삭제" class="delete-btn btn btn-default">';
							}{
								
							}
							output += '  <hr size="1" noshade>';
							output += ' </div>';
							output += '</div>';
							
							$('#output').append(output);
					});
					if(currentPage >= Math.ceil(count/rowCount)){
						$('.paging-button').hide();
					}else{
						$('.paging-button').show();
					}
				}
			},
			errer:function(){
				$('#loading').hide();
				alert('네트워크 오류');
			}
		});
	}
	
	$('.paging-button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#tb_num').val());
	});
	
	//댓글 등록
	$('#re_gform').submit(function(event){
		if($('#re_gcontent').val()==''){
			alert('내용을 입력하세요!');
			$('#re_gcontent').focus();
			return false;
		}
		
		var data = $(this).serialize();
		
		//등록
		$.ajax({
			type:'post',
			data:data,
			url:'g_insertReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result == 'success'){
					initForm();
					selectData(1,$('#tb_num').val());
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
	
	//댓글 수정폼 노출
	$(document).on('click','.modify-btn',function(){
		var re_gnum = $(this).attr('data-num');
		var m_nick = $(this).attr('data-id');
		var re_gcontent = $(this).parent().find('p').html();
		
		var modifyUI = '<form id="mre_gform">';
			modifyUI += ' <input type="hidden" name="re_gnum" id="mre_gnum" value="'+re_gnum+'">';
			modifyUI += ' <input type="hidden" name="m_nick" id="muserNick" value="'+m_nick+'">';
			modifyUI += ' <textarea rows="3" class="form-control" cols="50" name="re_gcontent" id="mre_gcontent" class="rep-content">'+re_gcontent+'</textarea><br>';
			modifyUI += ' <div id="mre_second" style="text-align:right;">';
			modifyUI += '  <input type="submit" value="수정" class="btn btn-default">';
			modifyUI += '  <input type="button" value="취소" class="re-reset btn btn-default">';
			modifyUI += ' </div>';
			modifyUI += '</form>';
	
		initModifyForm();
		
		$(this).parent().hide();
		
		$(this).parents('.item').append(modifyUI);
	
	});
	
	//수정폼에서 취소 시 수정폼 초기화
	$(document).on('click','.re-reset',function(){
		initModifyForm();
	});
	
	//댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();
		$('#mre_gform').remove();
	}
	
	//댓글 수정
	$(document).on('submit','#mre_gform',function(event){
		if($('#mre_gcontent').val()==''){
			alert('내용을 입력하세요!');
			$('#mre_gcontent').focus();
			return false;
		}
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//수정
		$.ajax({
			type:'post',
			url:'g_updateReply.do',
			data:data,
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 수정할 수 있습니다.');
				}else if(data.result == 'success'){
					$('#mre_gform').parent().find('p').html($('#mre_gcontent').val().replace(/</g,'&lt;').replace(/>/gi,'&gt;'));
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
		event.preventDefault();
	});
	
	//댓글 삭제
	$(document).on('click','.delete-btn',function(){
		var re_gnum = $(this).attr('data-num');
		var m_nick = $(this).attr('data-id');
		
		$.ajax({
			type:'post',
			url:'g_deleteReply.do',
			data:{re_gnum:re_gnum,m_nick:m_nick},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 삭제할 수 있습니다.');
				}else if(data.result == 'success'){
					alert('삭제 완료!');
					selectData(1,$('#tb_num').val());
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
	
	selectData(1,$('#tb_num').val());
	
});