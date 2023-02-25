$(document).ready(function() {

	userMenuOpend = 0;
	userMenuOpendC = 0;
	alarmsOpend = 0;

	// Hide User Menu Click Other Place
	$('html').click(function(e) {
		if (!$(e.target).hasClass('userMenuClick')) {
			$('.boardIdAll').empty();
			userMenuOpend = 0;
		}
	});
	// Hide Comment User Menu Click Other Place
	$('html').click(function(e) {
		if (!$(e.target).hasClass('userMenuClick')) {
			$('.commentIdAll').empty();
			userMenuOpendC = 0;
		}
	});
	// HIde Alarm Menu Click Other Place
	$('html').click(function(e) {
		if (!$(e.target).hasClass('alarmClick')) {
			$('#alarmsOpen').empty();
			alarmsOpend = 0;
		}
	});

	if ($('#userId').val()) {
		getAlarmCount();
	}

})

// Need Login
function needLogin() {
	var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
	if (goLoginPage) {
		location.href = '/user/login';
	}
}

// Open User Menu
function openUserMenu(boardId, userId) {

	$.ajax({
		type: "GET",
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

// Open Comment User Menu
function openUserMenuC(commentId, userId) {

	$.ajax({
		type: "GET",
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

// View User Profile
function viewUserProfile(userId) {
	window.open("/popup/userProfile?userId=" + userId, "userProfile", "width=400,height=500");
}

// Report User
function reportUser(userId) {

	$.ajax({
		type: "GET",
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

// Send Message
function sendMessage(userId) {

	$.ajax({
		type: "GET",
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

// Received Message
function receivedMessage() {

	$.ajax({
		type: "GET",
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

// Delete User
function deleteUser(userId) {

	if (confirm('정말 회원을 제거하시겠습니까?')) {
		$.ajax({
			type: "DELETE",
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

// Get Alarm Count
function getAlarmCount() {
	$.ajax({
		url: "/user/getAlarmCount",
		type: "GET",
		data: { "receiver": $('#userId').val() },
		success: function(data) {
			if (data >= 1) {
				$('#alarmCountView').show();
				if (data >= 100) {
					data = '99+';
				}
				$('#alarmCountText').html(data);
			} else {
				$('#alarmCountView').hide();
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});
}

// Get Alarms (5)
function getAlarms() {

	$.ajax({
		url: "/user/getAlarms",
		type: "GET",
		data: { "receiver": $('#userId').val() },
		success: function(data) {

			var str = "";

			$(data).each(function() {

				if (this.alarmType == 'comment') {
					str += "<div><a class='alarmText' onclick='clickCommentAlarm(" + this.alarmId + ", " + this.boardId + ", " + this.commentId + ")'><span class='text-secondary'>" + this.senderNickname + "</span>님이 내 게시글에 댓글을 달았습니다</a></div>";
				} else if (this.alarmType == 'message') {
					str += "<div><a class='alarmText' onclick='clickMessageAlarm(" + this.alarmId + ")'><span class='text-secondary'>" + this.senderNickname + "</span>님이 쪽지를 보내셨습니다</a></div>";
				} else if (this.alarmType == 'reComment') {
					str += "<div><a class='alarmText' onclick='clickCommentAlarm(" + this.alarmId + ", " + this.boardId + ", " + this.commentId + ")'><span class='text-secondary'>" + this.senderNickname + "</span>님이 내 댓글에 답글을 달았습니다</a></div>";
				}

			});
			str += "<div><a class='removeAlarmText text-muted' onclick='deleteAllAlarm(\"" + $('#userId').val() + "\")'>모두 지움</a></div>"

			if (alarmsOpend == 0) {
				$('.alarmsOpen').html(str);
				alarmsOpend = 1;
			} else {
				$('.alarmsOpen').empty();
				alarmsOpend = 0;
			}

		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

function clickCommentAlarm(alarmId, boardId, commentId) {
	console.log(alarmId, boardId, commentId);
	$.ajax({
		url: "/user/deleteAlarm",
		type: "DELETE",
		data: {
			"alarmId": alarmId,
			"commentId": commentId,
			"boardId": boardId
		},
		success: function(data) {
			location.href = '/detail/detail?id=' + boardId;
			localStorage.setItem('page', data);
			localStorage.setItem('commentId', commentId);
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

function clickMessageAlarm(alarmId) {
	$.ajax({
		url: "/user/deleteAlarm",
		type: "DELETE",
		data: { "alarmId": alarmId },
		success: function() {
			getAlarmCount();
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

	receivedMessage();

}

function deleteAllAlarm(receiver) {

	$.ajax({
		url: "/user/deleteAllAlarm",
		type: "DELETE",
		data: { "receiver": receiver },
		success: function() {
			getAlarmCount();
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}