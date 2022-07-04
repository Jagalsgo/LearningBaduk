$(document).ready(function() {

	// 회원 정보 클릭 시 박스 오픈
	$('#userInfoBtn, .headerProfileImg').click(function() {
		$('#openUserInfoBox').toggle();
	})

	// 다른 지역 클릭 시 회원 박스 숨기기
	$('html').click(function(e) {
		if (!$('#userInfoFormBox').has(e.target).length) {
			$('#openUserInfoBox').hide();
		}
	});

})

// stomp 알림
/*function connectStomp() {
	var sock = new SockJS("/stomp");
	var client = Stomp.over(sock);
	socket = client;

	client.connect({}, function() {
		console.log('Connected stomp');
		client.send('/hello', {}, "msg : hello");

		client.subscribe('/sub/channel', function(event) {
			console.log('!!!!!!sub channel > ', event);
		})
	})
}*/

// websocket 실시간 알림
/*function connectWS() {
	var ws = new WebSocket("ws://localhost:8080/replyEcho");
	socket = ws;

	ws.onopen = function() {
		console.log('Info : connected opened');
	};

	ws.onmessage = function(event) {
		console.log('receiveMessage : ', event.data + '\n');
		$("#socketAlert").html(event.data);
		$('#socketAlert').show();
		setTimeout(function() {
			$('#socketAlert').hide();
		}, 5000);
	};

	ws.onclose = function(event) {
		console.log('Info : connection colsed');
	};

	ws.onerror = function(error) {
		console.log('error :', error);
	}
}*/