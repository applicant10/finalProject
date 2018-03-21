$(document).ready(function(){
	$('#jungler').submit(function(){
		if($('select[id=r_loc] > option:selected').val()=='없음'&&$('#m_id').val()==''){
			return false;
		}
	});
	$('#nextResumeShow').on('click',function(){
		var resume = $('div[id^=resumes]').attr('id');
		var id = resume.substring(0,7);
		var numero = resume.substring(7,resume.length);
		if(numero==''){
			numero=0;
		}
		$.ajax({
			url:'addResume.do',
			type:'post',
			data:{numero:numero},
			dataType:'json',
			cache:false,
			timeout:10000,
			success:function(data){
				var list = data.list;
				if(data.result=='add'){
					if(data.num==-1){
						alert('더이상 자료가 없습니다.');
						$('#nextResumeShow').hide();
					}else{
						var resumeOut;
						$(list).each(function(index,item){
							resumeOut = '<div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">';
							resumeOut += '<input type="hidden" name="r_num" value="'+item.r_num+'">';
							resumeOut += '<div style="margin:10%;">';
							if(item.r_pname){
							resumeOut += '<a href="../user/enpriReView.do?m_id='+item.m_id+'" class=" col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">'
			          		resumeOut += '<img style="width:200px;height:200px;object-fit:cover;display:inline-block;border-radius:50%;overflow:hidden;" src="enpriImageView.do?m_id='+item.m_id+'" alt="">'
			          		resumeOut += '</a>';
							}else if(item.r_pname==null){
							resumeOut += '<a href="../user/enpriReView.do?m_id='+item.m_id+'" class=" col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">';
							resumeOut += '<img style="width:200px;height:200px;object-fit:cover;display:inline-block;border-radius:50%;overflow:hidden;" src="../resources/images/resume/blank-profile.png" alt="">';
							resumeOut += '</a>';
							}
							resumeOut += '</div>';
							resumeOut += '<h4><a href="../user/enpriReView.do?m_id='+item.m_id+'">아이디 : '+item.m_id+'</a></h4><br>';
							resumeOut += '<h5>희망 직종 : ';
							if(item.r_job){
							resumeOut += item.r_job+'</h5>';
							}else if(item.r_job==null){
								resumeOut += '어떤일이든 맡겨만 주세요!</h5>';	
							}
							if(item.r_intro){
							resumeOut += '<p>자기 소개 : '+item.r_intro+'</p>';
							}else if(item.r_intro==null){
							resumeOut +='<p>자기소개 : 뭐든 자신 있습니다!</p>';
							}
							resumeOut +='</div>';
							$('div[id^=resumes]').attr('id','resumes'+(data.num));
							//alert($('div[id^=resumes]').attr('id'));
							$('div[id^=resumes]').append(resumeOut);
						});
					}
				}else if(data.result=='fail'){
					alert('불러오기 실패');
				}
			},
			error:function(){
				alert('네트워크 오류');
			}
		});
	});
});