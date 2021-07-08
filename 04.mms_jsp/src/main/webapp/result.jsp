<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="java.util.HashMap" %>    
<%@ page import="java.util.Set" %>    
<%@ page import="java.util.Collection" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과메세지</title>
</head>
<body>
<h3>결과 메세지</h3>
<!--  7. 응답페이지 응답결과 보여주기 : jsp -->
<%
	if(request.getAttribute("message") != null) {
%>
	<%= request.getAttribute("message") %>
<%
	}
%>

<%
	if(request.getAttribute("errorList") != null) {
		ArrayList<String> errorList = (ArrayList<String>)request.getAttribute("errorList");
%>
	<hr>
	<h3>오류메세지 목록</h3>
	<ul>
		<%
			// errorList 크기만큼 반복하면서 에러메세지 가져와서 목록데이터로 출력
			for(int index = 0; index < errorList.size(); index++) {
		%>
			<li><%= errorList.get(index) %></li>
		<%
			}
		%>	
	</ul>
<%
	}
%>
<!-- 실습 : 순서있는 목록 출력, KEY = VALUE 형식 출력 -->
<%
	if(request.getAttribute("errorMap") != null) {
		HashMap<String, String> errorMap =  (HashMap<String, String>)request.getAttribute("errorMap");
%>
<hr>
	<h3>오류메세지 목록</h3>
	<ul>
		<%
			// errorList 크기만큼 반복하면서 에러메세지 가져와서 목록데이터로 출력
			for(int index = 0; index < errorMap.size(); index++) {
				Set<String> key = errorMap.keySet();
				Collection<String> value = errorMap.values();
				
				
		%>
			<li><%= errorMap.get(index) %></li>
		<%
			}
		%>	
	</ul>
<%
	}
%>
</body>
</html>