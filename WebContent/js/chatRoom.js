//聊天室JS
$(document).ready(function() {

	//$("#send").next("span").click(function() {
		$("#send").textbox().next("span").click(function(){
		if ($("#send").val() == "") {
			return false
		}

		$.post("send_message.json", {
			say : $("#send").val()
		}, function(result) {
			//$("#send").;
			$("#send").textbox('setValue','');
			refresh();
		});
	});

	$("#send").next("span").keypress(function(ev) {
		if (ev.keyCode == 13 && sendValidate()) {
			$("#send").next("span").click();
		}
	});
	
	refresh();
	window.setInterval(function() {
		refresh();
	}, 10000);
});

function refresh() {
	$.post("refresh_chat.json", function(result) {

		if (result != null) {
			var talks = $("#talks");
			var info = "";
			$.each(result.data, function(i, r) {
				info = info + "<li>[";

				var date = new Date();
				date.setTime(r.sendTime);
				info = info + date.toLocaleString();
				info = info + "]  ";

				info = info + r.username;
				info = info + " : ";
				info = info + r.said;
				info = info + "</li>";
			});
			talks.html(info);
			talks.parent()[0].scrollTop = talks[0].scrollHeight;
		}

	});
}

function sendValidate(){
	if ($("#send").val() == "") {
		return false;
	}else{
		return true;
	}
}

