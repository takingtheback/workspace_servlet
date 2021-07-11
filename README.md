# workspace_servlet
 Lean servlet

발생한 오류 목록 및 해결 방법
1. 회원정보란의 한글입력부분이 깨져있는 상황

두군데의 정보 앞에 붙여줘야하는 처리
// 파라메터로 전달되는 데이터의 한글 처리  
request.setCharacterEncoding("utf-8");  

// 브라우저로 보내지는 데이터의 한글 처리  
response.setContentType("text/html;charset=utf-8");  
PrintWriter out = response.getWriter();  

2. HTTP 상태 405 – 허용되지 않는 메소드  
메시지 HTTP 메소드인 POST는 이 URL에 의해 지원되지 않습니다.  
설명 요청 행에 포함된 해당 메소드는, origin 서버에 의해 인지되었으나, 대상 리소스에 의해 지원되지 않습니다.  

방법 찾는 중...Processing
