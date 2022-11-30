$(document).ready(function(){
	
	boardId = $('#boardId').val();
	userId = $('#userId').val();
	detailsPage = $('#detailsPage').val();

	getBoards(detailsPage);
	
})

// Get Board Llist under Detail
function getBoards(boardPage){
	
	$('.boardPage').removeClass('text-warning');
	$('.listPage'+boardPage).addClass('text-warning');
	
	var data = {
		"boardPage": boardPage
	}
	
	$.ajax({
		url:"/detail/getMyBoards",
		type:"GET",
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