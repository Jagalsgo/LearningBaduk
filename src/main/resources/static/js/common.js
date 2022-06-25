$(document).ready(function() {

	userMenuOpend = 0;
	userMenuOpendC = 0;

	// 다른 지역 클릭 시 회원 메뉴 숨기기
	$('html').click(function(e) {
		if (!$(e.target).hasClass('userMenuClick')) {
			$('.boardIdAll').empty();
			userMenuOpend = 0;
		}
	});
	// 다른 지역 클릭 시 댓글의 회원 메뉴 숨기기
	$('html').click(function(e) {
		if (!$(e.target).hasClass('userMenuClick')) {
			$('.commentIdAll').empty();
			userMenuOpendC = 0;
		}
	});

})

// 회원 클릭 시 회원 메뉴
function openUserMenu(boardId, userId) {

	$.ajax({
		type: "POST",
		url: "/popup/checkUserRole",
		success: function(data) {
			if (userMenuOpend == 0) {
				$('.boardIdAll').empty();
				var str = "";
				str += "<ul class='userMenuBox'>" +
					"<li class='m-2'><a class='fw-bold' onclick='viewUserProfile(\"" + userId + "\")'><i class='fa fa-solid fa-user'></i> 프로필 보기</a></li>" +
					"<li class='m-2'><a class='fw-bold' onclick='sendMessage(\"" + userId + "\")'><i class='fa fa-solid fa-envelope'></i> 쪽지 보내기</a></li>" +
					"<li class='m-2'><a class='fw-bold' onclick='reportUser(\"" + userId + "\")'><i class='fa fa-solid fa-flag'></i> 신고하기</a></li>";
				if (data.userRole == "admin") {
					str += "<li class='m-2'><a class='fw-bold' onclick='deleteUser(\"" + userId + "\")'><i class='fa fa-solid fa-ban'></i> 회원 제거</a></li>";
				}
				str += "</ul>";

				$('#boardId' + boardId).html(str);
				userMenuOpend = 1;

			} else {
				$('.boardIdAll').empty();
				userMenuOpend = 0;

			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

// 댓글의 회원 클릭 시 회원 메뉴
function openUserMenuC(commentId, userId) {

	$.ajax({
		type: "POST",
		url: "/popup/checkUserRole",
		success: function(data) {
			if (userMenuOpendC == 0) {
				$('.commentIdAll').empty();
				var str = "";
				str += "<ul class='userMenuBox'>" +
					"<li class='m-2'><a class='fw-bold' onclick='viewUserProfile(\"" + userId + "\")'><i class='fa fa-solid fa-user'></i> 프로필 보기</a></li>" +
					"<li class='m-2'><a class='fw-bold' onclick='sendMessage(\"" + userId + "\")'><i class='fa fa-solid fa-envelope'></i> 쪽지 보내기</a></li>" +
					"<li class='m-2'><a class='fw-bold' onclick='reportUser(\"" + userId + "\")'><i class='fa fa-solid fa-flag'></i> 신고하기</a></li>";
				if (data.userRole == "admin") {
					str += "<li class='m-2'><a class='fw-bold' onclick='deleteUser(\"" + userId + "\")'><i class='fa fa-solid fa-ban'></i> 회원 제거</a></li>";
				}
				str += "</ul>";

				$('#commentId' + commentId).html(str);
				userMenuOpendC = 1;

			} else {
				$('.commentIdAll').empty();
				userMenuOpendC = 0;

			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

// 프로필 보기
function viewUserProfile(userId) {
	window.open("/popup/userProfile?userId=" + userId, "userProfile", "width=400,height=500");
}

// 유저 신고하기
function reportUser(userId) {

	$.ajax({
		type: "POST",
		url: "/popup/checkUserRole",
		success: function(data) {
			if (data.userRole == "guest") {
				var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
				if (goLoginPage) {
					location.href = '/user/login';
				}
			} else {
				window.open("/popup/reportUser?userId=" + userId, "reportUser", "width=400,height=500");
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

// 쪽지 보내기
function sendMessage(userId) {
	
	$.ajax({
		type: "POST",
		url: "/popup/checkUserRole",
		success: function(data) {
			if (data.userRole == "guest") {
				var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
				if (goLoginPage) {
					location.href = '/user/login';
				}
			} else {
				window.open("/popup/sendMessage?userId=" + userId, "sendMessage", "width=400,height=500");
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});
	
}

// 받은 쪽지함
function receivedMessage() {
	
	$.ajax({
		type: "POST",
		url: "/popup/checkUserRole",
		success: function(data) {
			if (data.userRole == "guest") {
				var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
				if (goLoginPage) {
					location.href = '/user/login';
				}
			} else {
				window.open("/popup/receivedMessage", "receivedMessage", "width=400,height=500");
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});
	
}

// 회원 제거
function deleteUser(userId) {

	if (confirm('정말 회원을 제거하시겠습니까?')) {
		$.ajax({
			type: "POST",
			url: "/user/deleteUser",
			data: { "userId": userId },
			success: function(data) {
				if (data >= 1) {
					alert('회원 제거 완료');
					window.opener.location.reload();
				} else {
					alert('회원 제거 불가');
				}
			},
			error: function(error) {
				alert('error : ' + error);
			}
		});
	}


}