<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과메세지</title>
</head>
<body>
<h3>메인페이지</h3>
<!--  7. 응답페이지 응답결과 보여주기 : jsp -->
<!-- 로그인 회원의 전용 서비스 페이지 -->
<!-- 로그인 사용자 인증 검증 -->
<%
	if(session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
		request.setAttribute("message", "[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다.");
		request.getRequestDispatcher("result.jsp").forward(request, response);
		return;
	}
%>
로그인 회원 : <%= session.getAttribute("memberId") %>	[<%= session.getAttribute("grade") %>] 
<hr>
<a href="myInfo">내정보조회</a>
<a href="logout">로그아웃</a>



</body>
</html>