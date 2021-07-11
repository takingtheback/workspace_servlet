package com.work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.work.service.MemberService;

public class JoinControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 회원가입 요청 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원가입요청");
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		Map<String, String> dtoMap = new HashMap<String, String>();
		dtoMap.put("memberId", memberId);
		dtoMap.put("memberPw", memberPw);
		dtoMap.put("name", name);
		dtoMap.put("mobile", mobile);
		dtoMap.put("email", email);
		
		System.out.println(dtoMap);
		
		// 오류 메세지를 위한 collection
		ArrayList<String> errorList = new ArrayList<String>();
		
		if (memberId == null || memberId.trim().length() == 0 || memberId.trim().length() > 30) {
			errorList.add("아이디는 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}
		if (memberPw == null || memberPw.trim().length() == 0 || memberPw.trim().length() > 20) {
			errorList.add("비밀번호는 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (name == null || name.trim().length() == 0 || name.trim().length() > 20) {
			errorList.add("이름은 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (mobile == null || mobile.trim().length() == 0 || mobile.trim().length() > 13) {
			errorList.add("휴대폰은 필수입력항목이며 13자리 이내로 입력하시기 바랍니다.");
		}
		if (email == null || email.trim().length() == 0 || email.trim().length() > 30) {
			errorList.add("이메일은 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}
		
		HashMap<String, String> errorMap = new HashMap<String, String>();
		
		if (memberId == null || memberId.trim().length() == 0 || memberId.trim().length() > 30) {
			errorMap.put("memberId", "필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}
		if (memberPw == null || memberPw.trim().length() == 0 || memberPw.trim().length() > 20) {
			errorMap.put("memberPw", "필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (name == null || name.trim().length() == 0 || name.trim().length() > 20) {
			errorMap.put("name", "필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (mobile == null || mobile.trim().length() == 0 || mobile.trim().length() > 13) {
			errorMap.put("mobile", "필수입력항목이며 13자리 이내로 입력하시기 바랍니다.");
		}
		if (email == null || email.trim().length() == 0 || email.trim().length() > 30) {
			errorMap.put("email", "필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}		
		
		// 오류메세지 여부 검증 : 데이터 검증결과 오류메세지 
		if (!errorList.isEmpty()) { //if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			request.setAttribute("errorMap", errorMap);
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		MemberService memberService = new MemberService();
		int result = memberService.addMember(dtoMap);
		
		// Model 요청결과에 따라서 응답위한 설정
		if (result == 1) {	// 회원가입 성공
			//??
			///request.setAttribute("message", "회원가입 성공 : " + memberId + "님 로그인후 회원전용서비스를 이용하시기 바랍니다.");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			
			//response.sendRedirect("login.jsp"); // index.jsp => 로그인 클릭
		
			// 서블릿에서 javascript 경고창으로 회원가입메세지 띄워주고 로그인페이지 이동 응답처리
			// 응답을 위한 mime-type 및 한글인코딩 설정
			response.setContentType("text/html; charset=UTF-8");
			
			// 응답을 위한 출력스트림 생성
			PrintWriter out = response.getWriter();
			/*
			 <script type='text/javascript'>
			alert("회원가입이 정상처리되었습니다. 로그인 후 회원전용서비스를 이용하시기 바랍니다.");
			location.href="login.jsp";
			</script>
			 */
			out.println("<script type='text/javascript'>");
			out.println("alert(\"회원가입이 정상처리되었습니다. 로그인 후 회원전용서비스를 이용하시기 바랍니다.\");");
			out.println("location.href=\"login.jsp\";");
			out.println("</script>");
			
			out.close();
			
		} else { // 회원가입 실패
			// 응답페이지 이동 : forward, redirect
			// 실패이유 알려줘야겠지요
			errorList.add("회원가입이 정상 처리되지 않았습니다. 다시 확인하시기 바랍니다.");
			errorMap.put("result", "회원가입이 정상 처리되지 않았습니다. 다시 확인하시기 바랍니다.");
			request.setAttribute("message", "회원가입이 정상 처리되지 않았습니다. 다시 확인하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
		
	}

}











