<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.work.dto.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	
</script>
</head>
<body>
<!-- Controller에서 내정보조회 응답결과 설정 -->
<%
	Member dto1 = new Member("user01", "password01", "홍길동", "aa", "bb", "cc", "G", 1000, null);
	request.setAttribute("dto", dto1);
%>

<!-- Controller에서 설정한 응답결과를 jsp에서 사용하기 -->
<%
	Member dto = (Member)request.getAttribute("dto");
%>
<form action="#" method="post">
	아이디 <input type="text" name="memberId" readonly="readonly" value="<%= dto.getMemberId() %>"> <br>
	비밀번호 <input type="text" name="memberPw" value="<%= dto.getMemberPw() %>"> <br>
	이름 <input type="text" name="name"  value="<%= dto.getName() %>"> <br>
	휴대폰 <input type="text" name="mobile"  value="<%= dto.getMobile() %>"> <br>
	이메일 <input type="text" name="email"  value="<%= dto.getEmail() %>"> <br>
	가입일 <input type="text" name="entryDate" readonly="readonly" value="<%= dto.getEntryDate() %>"> <br>
	등급 <input type="text" name="grade" readonly="readonly" value="<%= dto.getGrade() %>"> <br>
	마일리지 <input type="text" name="mileage" readonly="readonly" value="<%= dto.getMileage() %>"> <br>
	담당자 <input type="text" name="manager" readonly="readonly" value="<%= dto.getManager() %>"> <br>

</form>
</body>
</html>