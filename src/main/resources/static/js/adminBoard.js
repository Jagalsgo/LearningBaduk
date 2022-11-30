$(document).ready(function() {

	// Boards All Check
	$("#allChk").click(function() {
		if ($("#allChk").is(":checked")) {
			$("input[name=chk]").prop("checked", true);
		} else {
			$("input[name=chk]").prop("checked", false);
		}
	});

	// If All Checked All Check Box Check
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

// Admin Delete Boards
function deleteBoards() {

	var chk_arr = $("input[name='chk']");
	var chkArray = [];
	for (var i = 0; i < chk_arr.length; i++) {
		if (chk_arr[i].checked == true) {
			chkArray.push(chk_arr[i].value);
		}
	}

	if (chkArray.length == 0) {
		alert("삭제할 글을 선택하세요.");
	} else {
		var deleteBoardConfirm = confirm('체크된 글들을 삭제하시겠습니까?');
		if (deleteBoardConfirm) {
			$.ajax({
				url: "/admin/deleteBoards",
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

// Admin Init Board's Reports
function initBoardReports() {

	var chk_arr = $("input[name='chk']");
	var chkArray = [];
	for (var i = 0; i < chk_arr.length; i++) {
		if (chk_arr[i].checked == true) {
			chkArray.push(chk_arr[i].value);
		}
	}

	if (chkArray.length == 0) {
		alert("신고 횟수를 초기화 할 글을 선택하세요.");
	} else {
		var initBoardReportConfirm = confirm('체크된 글들의 신고 횟수를 초기화 하겠습니까?');
		if (initBoardReportConfirm) {
			$.ajax({
				url: "/admin/initBoardReports",
				type: "PUT",
				data: {
					"chkArray": chkArray
				},
				success: function() {
					alert('초기화 완료');
					window.location.reload();
				},
				error: function(error) {
					alert("error : " + error);
				}
			})
		}
	}

}

// Admin Init User's Reports
function initUserReports() {

	var chk_arr = $("input[name='chk']");
	var chkArray = [];
	for (var i = 0; i < chk_arr.length; i++) {
		if (chk_arr[i].checked == true) {
			chkArray.push(chk_arr[i].value);
		}
	}

	if (chkArray.length == 0) {
		alert("신고 횟수를 초기화 할 유저를 선택하세요.");
	} else {
		var initUserReportConfirm = confirm('체크된 유저들의 신고 횟수를 초기화 하겠습니까?');
		if (initUserReportConfirm) {
			$.ajax({
				url: "/admin/initUserReports",
				type: "PUT",
				data: {
					"chkArray": chkArray
				},
				success: function() {
					alert('초기화 완료');
					window.location.reload();
				},
				error: function(error) {
					alert("error : " + error);
				}
			})
		}
	}

}

function viewUserReports(userId) {

	window.open("/popup/userReports?userId=" + userId, "userReports", "width=400,height=500");

}