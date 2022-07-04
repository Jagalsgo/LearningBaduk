$(document).ready(function() {

	userMenuOpend = 0;
	userMenuOpendC = 0;
	alarmsOpend = 0;

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
	// 다른 지역 클릭 시 알림 메뉴 숨기기
	$('html').click(function(e) {
		if (!$(e.target).hasClass('alarmClick')) {
			$('#alarmsOpen').empty();
			alarmsOpend = 0;
		}
	});
	// 알림 버튼 토글
	/*$('#alarmClick').click(function() {
		if (aa >= 1) {
			$('#alarmsOpen').toggle();
		}
	})*/

	connectSockJs();
	if ($('#userId').val()) {
		getAlarmCount();
	}

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

// sockjs 알림
function connectSockJs() {
	var sock = new SockJS("/WebSocketAlarm");
	socket = sock;
	sock.onopen = function() {

		sock.onmessage = function(event) {

			var data = event.data;
			msgData = JSON.parse(data);
			getAlarmCount();

		};

		sock.onclose = function(event) {
			console.log('Info : connection colsed');
		};
	}

	sock.onerror = function(error) {
		console.log('error :', error);
	}
}

// 알림 개수
function getAlarmCount() {
	$.ajax({
		url: "/user/getAlarmCount",
		type: "POST",
		data: { "receiver": $('#userId').val() },
		success: function(data) {
			if (data >= 1) {
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

// 알림 아이콘 클릭 시 알림들 보여주기 (5개씩)
function getAlarms() {

	$.ajax({
		url: "/user/getAlarms",
		type: "POST",
		data: { "receiver": $('#userId').val() },
		success: function(data) {

			var str = "";

			$(data).each(function() {

				if (this.alarmType == 'comment') {
					str += "<div><a class='alarmText' onclick='clickCommentAlarm(" + this.alarmId + ", " + this.boardId + ")'><span class='text-secondary'>" + this.senderNickname + "</span>님이 내 게시글에 댓글을 달았습니다</a></div>";
				} else if (this.alarmType == 'message') {
					str += "<div><a class='alarmText' onclick='clickMessageAlarm(" + this.alarmId + ")'><span class='text-secondary'>" + this.senderNickname + "</span>님이 쪽지를 보내셨습니다</a></div>";
				}
				str += "<div><a class='removeAlarmText text-muted' onclick='deleteAllAlarm(\"" + this.receiver + "\")'>모두 지움</a></div>"

			});

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

function clickCommentAlarm(alarmId, boardId) {
	$.ajax({
		url: "/user/deleteAlarm",
		type: "POST",
		data: { "alarmId": alarmId },
		success: function() {

		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

	location.href = '/detail/detail?id=' + boardId;

}

function clickMessageAlarm(alarmId) {
	$.ajax({
		url: "/user/deleteAlarm",
		type: "POST",
		data: { "alarmId": alarmId },
		success: function() {

		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

	getAlarmCount();
	receivedMessage();

}

function deleteAllAlarm(receiver) {

	$.ajax({
		url: "/user/deleteAllAlarm",
		type: "POST",
		data: { "receiver": receiver },
		success: function() {

		},
		error: function(error) {
			alert('error : ' + error);
		}
	});
	
	getAlarmCount();

}