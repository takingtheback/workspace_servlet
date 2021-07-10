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
<%@ include file="inc/logoMenu.jsp" %>
<%@ include file="inc/beforeTopMenu.jsp" %>


<h3>회원가입</h3>
<form action="join" method="post">
	<input type="text" name="memberId" placeholder="아이디" autofocus="autofocus">
	<input type="password" name="memberPw" placeholder="비밀번호">
	<input type="text" name="name" placeholder="이름">
	<input type="text" name="mobile" placeholder="휴대폰">
	<input type="text" name="email" placeholder="이메일">
	<div class="btn both">
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</div>
</form>

<%@ include file="inc/footerMenu.jsp" %>
</body>
</html>
