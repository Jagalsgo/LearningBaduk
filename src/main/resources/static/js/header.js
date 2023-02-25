$(document).ready(function() {

	// Open User Info Box
	$('#userInfoBtn, .headerProfileImg').click(function() {
		$('#openUserInfoBox').toggle();
		$('#alarmsOpen').empty();
		alarmsOpend = 0;
	})

	// Hide User Info Box when Click Other Plcae
	$('html').click(function(e) {
		if (!$('#userInfoFormBox').has(e.target).length) {
			$('#openUserInfoBox').hide();
		}
	});

})