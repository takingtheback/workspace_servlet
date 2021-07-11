<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.work.dto.Member" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 | 회원관리</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="inc/logoMenu.jsp" %>
<%@ include file="inc/afterTopMenu.jsp" %>

<!-- 로그인 회원의 전용 서비스 페이지 -->
<%
	if (session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
		request.setAttribute("message", "[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다.");
		request.getRequestDispatcher("result.jsp").forward(request, response);
		return;
	}
%>
로그인회원: <%= session.getAttribute("memberId") %>[<%= session.getAttribute("grade") %>]

<%
	Member dto = (Member)request.getAttribute("dto");
	if (dto == null) {
		out.write("<script>");
		out.write("alert('내정보 조회 서비스를 먼저 요청하시기 바랍니다.');");
		out.write("location.href='main.jsp'");
		out.write("</script>");
		return;
	}
%>

<h3>내정보</h3>
<form action="myInfoUpdate" method="post">
	<div>아이디</div>
	<input type="text" name="memberId" value="<%= dto.getMemberId() %>" 
		readonly="readonly">
	
	<div>비밀번호</div>
	<input type="password" name="memberPw" value="<%= dto.getMemberPw() %>">
	
	<div>이름</div>
	<input type="text" name="name" value="<%= dto.getName() %>">
	
	<div>휴대폰</div>
	<input type="text" name="mobile" value="<%= dto.getMobile() %>">
	
	<div>이메일</div>
	<input type="text" name="email" value="<%= dto.getEmail() %>">
	
	<div>가입일</div>
	<input type="text" name="entryDate" value="<%= dto.getEntryDate() %>" readonly="readonly">
	
	<div>등급</div>
	<input type="text" name="grade" value="<%= dto.getGrade() %>" readonly="readonly">
	
	<div>마일리지</div>
	<input type="text" name="mileage" value="<%= dto.getMileage() %>" readonly="readonly">
	
	<div>담당자</div>
	<input type="text" name="manager" value="<%= dto.getManager() %>" readonly="readonly">
	
	<div class="btn both">
		<input type="submit" value="내정보변경">
		<input type="reset" value="취소">
	</div>
</form>
<hr>

<%
	HashMap<String, Object> dtoMap = (HashMap<String, Object>)request.getAttribute("dtoMap");
	if (dto == null) {
		out.write("<script>");
		out.write("alert('내정보 조회 서비스를 요청하시기 바랍니다.')");
		out.write("location.href='main.jsp'");
		out.write("</script>");
		return;
	}
%>
<h3>내정보</h3>
<form action="myInfoUpdate" method="post">
	<div>아이디</div>
	<input type="text" name="memberId" value="<%= dtoMap.get("memberId") %>" readonly="readonly">
	
	<div>비밀번호</div>
	<input type="password" name="memberPw" value="<%= dtoMap.get("memberPw") %>" autofocus="autofocus">
	
	<div>이름</div>
	<input type="text" name="name" value="<%= dtoMap.get("name") %>">
	
	<div>휴대폰</div>
	<input type="text" name="mobile" value="<%= dtoMap.get("mobile") %>">
	
	<div>이메일</div>
	<input type="text" name="email" value="<%= dtoMap.get("email") %>">
	
	<div>가입일</div>
	<input type="text" name="entryDate" value="<%= dtoMap.get("entryDate") %>" readonly="readonly">
	
	<div>등급</div>
	<input type="text" name="grade" value="<%= dtoMap.get("grade") %>" readonly="readonly">
	
	<div>마일리지</div>
	<input type="text" name="mileage" value="<%= dtoMap.get("mileage") %>" readonly="readonly">
	
	<div>담당자</div>
	<input type="text" name="manager" value="<%= dtoMap.get("manager") %>" readonly="readonly">
	
	<div class="btn both">
		<input type="submit" value="내정보변경">
		<input type="reset" value="취소">
	</div>
</form>

<%@ include file="inc/footerMenu.jsp" %>
</body>
</html>
