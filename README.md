# workspace_servlet
 Lean servlet

발생한 오류 목록 및 해결 방법
1. 회원정보란의 한글입력부분이 깨져있는 상황

  -- 두군데의 정보 앞에 붙여줘야하는 처리
    
    // 파라메터로 전달되는 데이터의 한글 처리  
    request.setCharacterEncoding("utf-8");  

    // 브라우저로 보내지는 데이터의 한글 처리  
    response.setContentType("text/html;charset=utf-8");  
    PrintWriter out = response.getWriter();  

2. Map을 이용한 회원정보 기능 추가

강사님 자료에서 회원정보 기능을 해시맵을 통해 접근 가능하도록 변경
