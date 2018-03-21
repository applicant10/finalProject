//delete l_content 버튼 동작 함수
function deleteConfirm(data) {
	var result = confirm('정말 해당 강의를 삭제하시겠습니까?');

	if(result){
		//yes...
		location.href='lcontentDelete.do?lc_num='+data;
	}else{
		//no!!
	}
}
//복수개를 띄워놓으면 발생하는 에러 해결 필요. 어이없게 버그 해결. 길이가 0인 배열이 생성되었을 경우, AJAX통신 시도하지 않으면 됩니다 ㅎㅎ
$(document).ready(function(){
	$('button[id^=lecture_]').click(function(){
		var child = $(this).parent().parent().children('div[id^=child_]');
		var childId = child.attr('id');
		var l_num = childId.substr(childId.indexOf('_')+1, childId.length);

		if($(this).data('state') === 'close'){
			if($(this).data('load') === 'off'){
				$.ajax({
					url:'myLcShow.do',
					type:'post',
					data:{l_num:l_num},
					dataType:'json',
					cache:false,
					timeout:3000,
					success:function(data){
						child.empty();
						if(data.count <= 0){
							var str = '<br>등록된 내용이 없습니다.';
							str += '<a href="insertLcontent.do?l_num='+l_num+'"><span class="glyphicon glyphicon-plus" style="#67ea75"></span></a>';
							child.append(str);
						}else{
							var list = data.list;
							var str = '<br><ul class="list-group" id="sortable">';
							$(list).each(function(index, item){
								str += '<li class="list-group-item ui-state-default">';
								str += ' <input type="hidden" name="listIndex_l_num_'+l_num+'" id="listIndex_l_num_'+l_num+'" value="'+item.lc_num+'"/>';
								str += ' <span class="ui-icon ui-icon-arrowthick-2-n-s"></span>'+item.lc_title;
								str += ' <div class="btn-group btn-group-xs pull-right">';
								str += '  <button onclick="location.href=\'lcontentUpdate.do?lc_num='+item.lc_num+'\'" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-pencil"></button>';
								str += '  <button id="lcontentDeleteBtn" onclick="deleteConfirm('+item.lc_num+')" class="btn btn-warning btn-xs"><span class="glyphicon glyphicon-minus"></button>';
								str += ' </div>';
								str += '</li>';
							});
							str += '<li class="list-group-item ui-state-disabled-KJH">';
							str += ' <a href="insertLcontent.do?l_num='+l_num+'"><span class="glyphicon glyphicon-plus" style="#67ea75"></span></a>';
							str += '</li>';
							str += '</ul>';
							child.append(str);
							
							$( "#sortable" ).sortable({
								items: "li:not(.ui-state-disabled-KJH)"
							});
							$( "#sortable li" ).disableSelection();
						}
					},
					error:function(){
						alert('네트워크 오류 발생');
					}
				});

				$(this).data('load', 'on');
				var str = '&nbsp;<button id="sortChild_lnum_'+l_num+'" class="btn btn-default btn-sm">강의 순서 저장</button>';

				var switchSequenceBtn = $(this).parent().parent().children('span[id^=lecture_title_]');
				switchSequenceBtn.append(str);

				//강의 순서 변경 Ajax
				$('button[id^=sortChild_lnum_]').click(function(){
					var list = [];
					var l_contents = $(this).parent().parent().children().children().children().children('input[id^=listIndex_l_num_'+l_num+']');

					l_contents.each(function(i){
						console.log((l_contents).eq(i).val());//강의 목록 뽑는데 성공. 순서 바꾸면 바꾼 순서대로 출력해준다. DB 수정만 하면 될듯
						console.log(list.push(l_contents.eq(i).val()));
					});
					console.log(list);

					if(list.length == 0){

					}else{
						$.ajax({
							url:'lcSequenceSort.do',
							type:'post',
							data:{list:list},
							dataType:'json',
							cache:false,
							timeout:3000,
							success:function(data){
								if(data.result == 'success'){
									alert('강의 순서 설정 완료!');
								}else{
									alert('강의 순서 설정 중 에러 발생...');
								}

							},
							error:function(){
								alert('네트워크 오류 발생...');
							}
						});
					}
				});

			}else if($(this).data('load') === 'on'){
				child.show();
				$(this).parent().parent().children().children('button[id^=sortChild_lnum_]').show();
			}else{
				alert('데이터 로딩 에러 발생!');
			}
			$(this).data('state', 'open');
		}else if($(this).data('state') === 'open'){
			child.hide();
			$(this).parent().parent().children().children('button[id^=sortChild_lnum_]').hide();
			$(this).data('state', 'close');
		}else{
			alert('컨텐츠 탭 기능 오작동');
		}
	});

	//공개 비공개 전환 Ajax 접근
	$('button[id^=lectureClose-l-num_]').click(function(){
		var str = $(this).attr('id');
		var l_num = str.substring(str.indexOf('_')+1, str.length);
		var childIcon = $(this).children('#iconEye');

		$.ajax({
			url:'lectureClose.do',
			type:'post',
			data:{l_num:l_num},
			dataType:'json',
			cache:false,
			timeout:3000,
			success:function(data){
				if(data.result == 'success'){
					alert('강좌 비공개 전환 완료!');
					$(this).attr('id', 'lectureOpen-l-num_'+l_num);
					
					//childIcon.attr('class', 'glyphicon glyphicon-eye-open');
					childIcon.toggleClass('glyphicon glyphicon-eye-open').toggleClass('glyphicon glyphicon-eye-close');
					
				}else{
					alert('강의 순서 설정 중 에러 발생...');
				}
			},
			error:function(){
				alert('네트워크 오류 발생...');
			}
		});
	});

	$('button[id^=lectureOpen-l-num_]').click(function(){
		var str = $(this).attr('id');
		var l_num = str.substring(str.indexOf('_')+1, str.length);
		var childIcon = $(this).children('#iconEye');

		$.ajax({
			url:'lectureOpen.do',
			type:'post',
			data:{l_num:l_num},
			dataType:'json',
			cache:false,
			timeout:3000,
			success:function(data){
				if(data.result == 'success'){
					alert('강좌 공개 전환 완료!');
					$(this).attr('id', 'lectureClose-l-num_'+l_num);
					
					childIcon.toggleClass('glyphicon glyphicon-eye-close').toggleClass('glyphicon glyphicon-eye-open');
				}else{
					alert('강의 순서 설정 중 에러 발생...');
				}
			},
			error:function(){
				alert('네트워크 오류 발생...');
			}
		});
	});
	
});