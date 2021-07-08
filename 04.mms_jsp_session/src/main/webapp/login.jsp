<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 | 회원관리</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%
	System.out.println("login.jsp 세션정보" + session.getId() + ", " + session.isNew() + ", " + session.getCreationTime());
%>
<div class="logo_menu">
	<a href="index.jsp"><img src="img/logo.png"></a>
</div>

<div class="top_menu">
<a href="login.jsp">로그인</a>
<a href="join.jsp">회원가입</a>
</div>

<h3>로그인</h3>
<!-- url-pattern 확인 2.x web.xml -->
<form action="login" method="post">
	<input type="text" name="memberId" placeholder="아이디">
	<input type="password" name="memberPw" placeholder="비밀번호">
	<div class="btn">
		<input type="submit" value="로그인">
	</div>
</form>
</body>
</html>