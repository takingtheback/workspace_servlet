<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 | 회원관리</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div class="logo_menu">
	<a href="index.jsp"><img src="img/logo.png"></a>
</div>

<div class="top_menu">
<a href="login.jsp">로그인</a>
<a href="join.jsp">회원가입</a>
</div>

<h3>회원가입</h3>
<form action="join" method="post">
	<input type="text" name="memberId" placeholder="아이디">
	<input type="password" name="memberPw" placeholder="비밀번호">
	<input type="text" name="name" placeholder="이름">
	<input type="text" name="mobile" placeholder="휴대폰">
	<input type="text" name="email" placeholder="이메일">
	<div class="btn both">
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</div>
</form>
</body>
</html>