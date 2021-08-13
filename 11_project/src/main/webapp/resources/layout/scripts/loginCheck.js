function loginCheck(){
	var userid = document.getElementById("userid");
	var userpwd = document.getElementById("userpwd");
	if (userid.value == '' || userpwd.value.length == 0) {
		alert('ID와 비밀번호를 입력하세요.');
		userid.focus();
		return;
	}
	var form = document.getElementById("loginForm");
	form.submit();
}