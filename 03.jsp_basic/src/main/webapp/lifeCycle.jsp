<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 라이프사이클</title>
</head>
<body>
<h3>JSP 라이프사이클</h3>
<%!

	/* 멤버변수 선언 : 요청 카운트 정보 저장*/
	public int requestCount;
	
	/* 초기화 수행 메서드 재정의 */
	public void jspInit() {
		System.out.println("jsp 초기화 수행 : 변경");
	}

	/* 자원해제 수행 메서드 재정의 */
	public void jspDestroy() {
		System.out.println("jsp 자원해제 수행 : 변경");
	}
	
%>

<h3>변경 요청 카운트 : <%= ++requestCount %> </h3>

<!--
  scriptlet tag : 동적 서비스를 위한 서비스 자바코드 
  _jspServicet(){ // 서비스코드 수행문으로 자동변환 }
  지역변수 
  -->
 <%
 	String message = "여러분 잠시 쉬었다 할까요";
 %> 
 <h3>메세지 : <%= message %></h3>
  
</body>
</html>