$(document).ready(function(){
   var currentPate;
   var count;
   var rowCount;
   
   //댓글 목록
   function selectData(pageNum,b_num){
      currentPage = pageNum;
      
      if(pageNum == 1){
         //처음 호출시는 해당 ID의 div의 내부 내용물을 제거
         $('#output').empty();
      }
      
      //로딩 이미지 노출
      $('#loading').show();
      
      $.ajax({
         type:'post',
         data:{pageNumg:pageNum,b_num:b_num},
         url:'listReply.do',
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
                     output += ' <h4>' + item.m_id + '</h4>';
                     output += ' <div class="sub-item">';
                     output += ' <p>' + item.br_content.replace(/</gi,'&lt;').replace(/</gi,'&gt;') + '</p>';
                     output +=    item.br_date;
                     if($('#userId').val()==item.m_id){
                        output += ' <input type="button" class="btn btn-default modify-btn" data-num="'+item.br_num+'" data-id="'+item.m_id+'" value="수정">';
                        output += ' <input type="button" class="btn btn-default delete-btn" data-num="'+item.br_num+'" data-id="'+item.m_id+'" value="삭제">';
                     }
                     output += ' </div>';
                     output += '</div>';   
                     
                     $('#output').append(output);
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
         error:function(){
            //로딩 이미지 감추기
            $('#loading').hide();
            alert('네트워크 오류');
         }
      });
      
   }
   
   //다음 댓글 보기 버튼 클리시 데이터 추가
   $('.paging-button input').click(function(){
      var pageNum = currentPage + 1;
      selectData(pageNum,$('#br_num').val());
   });
   
   //댓글 등록
   $('#re_form').submit(function(event){
      if($('#br_content').val()==''){
         alert('내용을 입력하세요!');
         $('#br_content').focus();
         return false;
      }
      
      var data = $(this).serialize();
      
      //등록
      $.ajax({
         type:'post',
         data:data,
         url:'writeReply.do',
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            if(data.result == 'logout'){
               alert('로그인해야 작성할 수 있습니다.');
            }else if(data.result == 'success'){
               //폼 초기화
               initForm();
               //댓글 작성이 성공하면 새로 삽입한 글을 포함해서 첫번째 페이지의 게시글들을 다시 호출함
               selectData(1,$('#b_num').val());
            }else{
               alert('등록시 오류 발생!')
            }
         },
         error:function(){
            alert('네트워크 오류!');
         }
      });
      //기본 이벤트 제거
      event.preventDefault();
   });
   
   //대글 작성 폼 초기화
   function initForm(){
      $('textarea').val('');
      $('#br_first .letter-count').text('300/300');
   }
   //textarea에 내용입력시 글자수 체크
      $(document).on('keyup','textarea',function(){
         //남은 글자수 구함
         var inputLength = $(this).val().length;

         if(inputLength>300){//300자를 넘어선 경우
            $(this).val($(this).val().substring(0,300));
         }else{//300자 이하인 경우
            var remain = 300 - inputLength;
            remain += '/300';
            if($(this).attr('m_id')=='br_content'){
               //등록폼 글자수
               $('#br_first .letter-count').text(remain);
            }else{//수정폼 글자수
               $('#br_first .letter-count').text(remain);
            }   
         }
      });
      
      //댓글 수정 버튼 클릭시 수정폼 노출
      $(document).on('click', '.modify-btn', function(){
         //댓글 번호
         var br_num = $(this).attr('data-num');
         //작성자 아이디
         var userId = $(this).attr('data-id');
         //댓글 내용
         var br_content = $(this).parent().find('p').html();
         
         //댓글 수정폼 UI
         var modifyUI = '<form id="mre_form">';
            modifyUI += '   <input type="hidden" name="br_num" id="br_num" value="' + br_num +'">';
            modifyUI += '   <input type="hidden" name="m_id" id="muserId" value="' + userId +'">';
            modifyUI += '   <textarea row="3" cols="50" name="br_content" id="mbr_content" class="br-content">' + br_content + '</textarea>';
            modifyUI += '   <div id="br_first"><span class="letter-count">300/300</span></div>';
            modifyUI += '   <div id="br_second" class="align-right">';
            modifyUI += '       <input type="submit" class="btn btn-default" value="수정">';
            modifyUI += '       <input type="button" class="btn btn-default mbr-reset" value="취소">';
            modifyUI += '   </div>'    ;
            modifyUI += '</form>';
            
         //이전에 이미 수정하는 댓글이 있을 경우 수정버튼을 클릭하면 숨김 sub-item를 환원시키고
         //수정폼을 초기화함
         initModifyForm();
         
         //지금 클릭해서 수정하고자 하는 데이터는 감추기
         //수정버튼을 감싸고 있는 div
         $(this).parent().hide();
         
         //수정폼을 수정하고자하는 데이터가 있느 div에 노출
         $(this).parents('.item').append(modifyUI);
         
         //입력한 글자수 셋팅
         var inputLength = $('#br_content').val().length;
         var remain = 300 - inputLength;
         remain += '/300';
         
         //문서 객체에 반영
         $('#br_first .letter-conut').text(remain);
      });
      
      //수정폼에서 취소버튼 클릭시 수정폼 초기화
      $(document).on('click','.mbr-reset',function(){
         initModifyForm();
      });
      
      //댓글 수정 폼 초기화
      function initModifyForm(){
         $('.sub-item').show();//item : 자기자신 하위영역 지움
         $('#mre_form').remove();//자기자신을 지움
      }
      
   //댓글 수정
   $(document).on('submit','#mre_form',function(event){
      if($('#mbr_content').val()==''){
         alert('내용을 입력하세요1');
         $('#mbr_content').focus();
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
               $('#mre_form').parent().find('p').html($('#mbr_content').val().replace(/</gi,'&lt;').replace(/>/gi,'&gt;'));
               //수정폼 초기화
               initModifyForm();
            }else if(data.result == 'wrongAccess'){
               alert('타인의 글은 수정할 수 없습니다.');
            }else{
               alert('수정 오류 발생!');
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
      var br_num = $(this).attr('data-num');
      //작성자 아이디
      var id = $(this).attr('data-id');
      
      $.ajax({
         type:'post',
         url:'deleteReply.do',
         data:{br_num:br_num,m_id:id},
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            if(data.result == 'logout'){
               alert('로그인해야 삭제할 수 있습니다.');
            }else if(data.result == 'success'){
               alert('삭제 완료!');
               selectData(1,$('#b_num').val());
            }else if(data.result == 'wrongAccess'){
               alert('타인의 글을 삭제할 수 없습니다.');
            }else{
               alert('오류 발생!');
            }
         },
         error:function(){
            alert('네트워크 오류 발생!');
         }
      });
      
   });
   
   //초기 데이터(목록) 호출
   selectData(1,$('#b_num').val());
   
});
