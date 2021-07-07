<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과메세지</title>
</head>
<body>
<h3>결과 메세지</h3>
<!--  7. 응답페이지 응답결과 보여주기 : jsp -->
<%= request.getAttribute("message") %>
</body>
</html>