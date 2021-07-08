<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basic</title>
</head>
<body>
<h3>JSP Basic : comment tag[jsp 페이지 오류 테스트]</h3>
<!--  html comment : 사용자가 보기 가능합니다. -->
<!-- <%= new Date() %> -->
<% // 자바 한줄 주석 :(디버깅목적) 변환된 자바소스코드에 포함되는 주석내용입니다. %>
<% /* 자바 여러줄 주석 : 변환된 자바소스코드에 포함되는 주석내용입니다. */ %>
<%-- JSP 페이지 주석 : 변환된 자바소스코드에 포함되지 않는 주석내용입니다. JSP 페이지에서만 보기 가능한 주석입니다. --%>
</body>
</html>