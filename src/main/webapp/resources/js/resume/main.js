$(document).ready(function(){
	var count = 0;
	setInterval(function(){
		if(count==1){
			$('#secondLady').hide();
			$('#firstLady').fadeIn('fast');
			count=0;
		}else if(count==0){
			$('#firstLady').hide();
			$('#secondLady').fadeIn('fast');
			count=1;
		}
	},4000);
});