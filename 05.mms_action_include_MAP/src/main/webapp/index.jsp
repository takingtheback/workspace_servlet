<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="inc/logoMenu.jsp" %>

<jsp:include page="inc/beforeTopMenu.jsp" />

<!-- 컨텐츠 내용 -->
<h3>회원관리메인</h3>

<jsp:include page="inc/footerMenu.jsp" >
	<jsp:param name="year" value="2020-2021" />
</jsp:include>
</body>
</html>