<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.work.dto.Member" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<script type="text/javascript">
	alert("회원가입이 정상처리되었습니다. 로그인 후 회원전용서비스를 이용하시기 바랍니다.");
	location.href="login.jsp";
</script>
 -->
</head>
<body>

<!-- Controller에서 내정보조회 응답결과 설정  -->
<%
	Member dto1 = new Member("user01", "password01", "홍길동", "aa", "bb", "cc", "G", 1000, null);
	request.setAttribute("dto", dto1);
%>

<!-- Controller에서 설정한 응답결과를 jsp에서 사용하기 -->
<%
	Member dto = (Member)request.getAttribute("dto");
%>
<form action="#" method="post">
	아이디 : <input type="text" name="memberId" readonly="readonly" value="<%= dto.getMemberId() %>"> <br>
	비밀번호 : <input type="text" name="memberPw" value="<%= dto.getMemberPw() %>"><br> 
	이름 : <input type="text" name="name" value="<%= dto.getName() %>"> 
</form>
</body>
</html>










