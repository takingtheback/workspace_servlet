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
<%@ include file="inc/logoMenu.jsp" %>
<%@ include file="inc/beforeTopMenu.jsp" %>

<h3>로그인</h3>
<!--  url-pattern 확인 2.x web.xml -->
<form action="login" method="post">
	<input type="text" name="memberId" placeholder="아이디" autofocus="autofocus">
	<input type="password" name="memberPw" placeholder="비밀번호">
	<div class="btn">
		<input type="submit" value="로그인">
	</div>
</form>

<jsp:include page="inc/footerMenu.jsp" >
	<jsp:param name="year" value="2020-2021" />
</jsp:include>

</body>
</html>