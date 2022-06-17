$(document).ready(function(){
	
	boardId = $('#boardId').val();
	userId = $('#userId').val();
	detailsPage = $('#detailsPage').val();

	getBoards(detailsPage);
	
})

// detail view 아래 list 불러오기
function getBoards(boardPage){
	
	$('.boardPage').removeClass('text-warning');
	$('.listPage'+boardPage).addClass('text-warning');
	
	var data = {
		"boardPage": boardPage
	}
	
	$.ajax({
		url:"/detail/getMyBoards",
		type:"POST",
		data: data,
		dataType: 'json',
		success: function(data){
			
			var str = "";
			
			$(data).each(function(){
				
				str += "<tr>"
			                    +"<td class='boardDate text-muted text-center'>"+this.myBoardDate+"</td>"
			                    
                if(this.myBoardId == boardId){
					str += "<td class='boardTitle'><a class='text-primary fw-bold' href='/detail/myOwnDetail?id="+this.myBoardId+"'>"+this.myBoardTitle+"</a></td>";
				}else{
					str += "<td class='boardTitle'><a href='/detail/myOwnDetail?id="+this.myBoardId+"'>"+this.myBoardTitle+"</a></td>";
				}
			         
				            
			});
			
			$('#boards').html(str);
			
		},
		error: function(error){
			alert("error : " + error);
		}
		
	});
	
}