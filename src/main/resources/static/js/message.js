$(document).ready(function() {

	// All Check
	$("#allChk").click(function() {
		if ($("#allChk").is(":checked")) {
			$("input[name=chk]").prop("checked", true);
		} else {
			$("input[name=chk]").prop("checked", false);
		}
	});

	// If All Check
	$("input[name=chk]").click(function() {
		var total = $("input[name=chk]").length;
		var checked = $("input[name=chk]:checked").length;

		if (total != checked) {
			$("#allChk").prop("checked", false);
		} else {
			$("#allChk").prop("checked", true);
		}
	});

})

function sendMessagePost() {

	if ($('#messageTitle').val() == '') {
		alert('제목을 작성하세요.');
		$('#messageTitle').focus();
		return false;
	}
	if ($('#messageContent').val() == '') {
		alert('내용을 작성하세요.');
		$('#messageContent').focus();
		return false;
	}

	$.ajax({
		type: "POST",
		url: "/popup/sendMessagePost",
		data: {
			"receiverNickname": $('#receiverNickname').val(),
			"messageTitle": $('#messageTitle').val(),
			"messageContent": $('#messageContent').val()
		},
		success: function(data) {
			if (data == -1) {
				alert('해당 회원이 없습니다.');
			} else {
				alert('쪽지 전송 완료');
				$('#messageTitle').val('');
				$('#messageContent').val('');
			}

		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

function deleteReceivedMessage() {

	var chk_arr = $("input[name='chk']");
	var chkArray = [];
	for (var i = 0; i < chk_arr.length; i++) {
		if (chk_arr[i].checked == true) {
			chkArray.push(chk_arr[i].value);
		}
	}

	if (chkArray.length == 0) {
		alert("삭제할 쪽지를 선택하세요.");
	} else {
		var deleteMessageConfirm = confirm('쪽지를 삭제하겠습니까?');
		if (deleteMessageConfirm) {
			$.ajax({
				url: "/popup/deleteReceivedMessage",
				type: "DELETE",
				data: {
					"chkArray": chkArray
				},
				success: function() {
					alert('삭제 완료');
					window.location.reload();
				},
				error: function(error) {
					alert("error : " + error);
				}
			})
		}
	}

}

function deleteSentMessage() {

	var chk_arr = $("input[name='chk']");
	var chkArray = [];
	for (var i = 0; i < chk_arr.length; i++) {
		if (chk_arr[i].checked == true) {
			chkArray.push(chk_arr[i].value);
		}
	}

	if (chkArray.length == 0) {
		alert("삭제할 쪽지를 선택하세요.");
	} else {
		var deleteMessageConfirm = confirm('쪽지를 삭제하겠습니까?');
		if (deleteMessageConfirm) {
			$.ajax({
				url: "/popup/deleteSentMessage",
				type: "DELETE",
				data: {
					"chkArray": chkArray
				},
				success: function() {
					alert('삭제 완료');
					window.location.reload();
				},
				error: function(error) {
					alert("error : " + error);
				}
			})
		}
	}

}