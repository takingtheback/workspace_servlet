<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과메세지</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="inc/logoMenu.jsp" %>

<!-- 로그인 회원의 메뉴 조각페이지 -->
<%@ include file="inc/afterTopMenu.jsp" %>


<h3>메인페이지</h3>
<!-- 7. 응답페이지 응답결과 보여주기 : jsp -->
<!-- 로그인 회원의 전용 서비스 페이지 -->
<!-- 로그인 사용자 인증 검증 -->
<%
	// 액션태그를 이용해서 아래의 코드를 변경 해보세요
	if (session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
%>		
	<jsp:forward page="result.jsp">
		<jsp:param name="message" value="[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다." />
	</jsp:forward>
<%		
	}
%>


로그인회원: <%= session.getAttribute("memberId") %>[<%= session.getAttribute("grade") %>]

<%
	if (request.getAttribute("message") != null) {
%>
	<%= request.getAttribute("message") %>
<%
	}
%>

<%@ include file="inc/footerMenu.jsp" %>
</body>
</html>
















