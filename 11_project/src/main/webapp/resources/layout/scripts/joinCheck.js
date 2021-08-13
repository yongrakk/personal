function joinCheck(){
	userid= document.getElementById("userid");
	userpwd1 = document.getElementById("userpwd1");
	userpwd2 = document.getElementById("userpwd2");
	username=document.getElementById("username");
	useremail= document.getElementById("usesremail");
	
	if(userid.value.length == 0){
		alert("ID 를 입력하세요");
		userid.focus();
		return false;
	}
	if(userpwd1.value.length == 0 || userpwd2.value.length ==0){
		alert("비밀번호를 입력하세요");
		userpwd1.focus();
		return false;
	}
	if(userpwd1.value != userpwd2.value){
		alert("비밀번호가 일치하지 않습니다.");
		userpwd1.focus();
		return false;
	}
	if(username.value.length == 0){
		alert("이름을 입력하세요");
		username.focus();
		return false;
	}
	if(useremail.value.length ==0){
		alert("email 를 입력하세요");
		useremail.focus();
		return false;
	}
	
}