<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="admin.css" rel="stylesheet">
<script src="jquery-3.4.1.js"></script>
<style>

</style>
</head>
<body>
<section class = "login-form">
	<h1>관리자 로그인</h1>
	<form action="">
		<div class = "int-area">
			<input type = "text" name ="id" id="id" autocomplete="off" required>
			<label for="id">USER NAME</label>
		</div>
		<div class = "int-area">
			<input type = "password" name="pw" id="pw" autocomplete="off" required>
			<label for="pw">PASS WORD</label>
		</div>
		<div class = "btn-area">
			<button id="btn" type = "submit">LOGIN</button>
		</div>
	</form>
	<div class="caption">
		<a href="">Forgot Password?</a>	
	</div>
</section>
<script>
let id = $('#id');
let pw  = $('#pw');
let btn = $('#btn');
$(btn). on('click',function(){
	if($(id).val() ==""){
		$(id).next('label').addClass('warning');
		setTimeout(function(){
			$('label').removeClass('warning');
		},1500);
	}
	else if($(pw).val()==""){
		$(pw).next('label').addClass('warning');
		setTimeout(function(){
			$('label').removeClass('warning');
		},1500);
	}
});
</script>
</body>
</html>