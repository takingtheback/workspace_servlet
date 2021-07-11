package com.work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.dto.Member;
import com.work.service.MemberService;

public class MyInfoUpdateControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 내정보 변경 저장 요청 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내정보 변경 저장");
		
		// 기존 세션객체 가져오기
		HttpSession session = request.getSession(false);
		
		// 사용자 인증 검증 : 오류 처리
		if (session == null || session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
			request.setAttribute("message", "[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		request.setCharacterEncoding("utf-8");  
		// String memberId = (String)session.getAttribute("memberId");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		Map<String, Object> dtoMap = new HashMap<String, Object>();
		dtoMap.put("memberId", memberId);
		dtoMap.put("memberPw", memberPw);
		dtoMap.put("name", name);
		dtoMap.put("mobile", mobile);
		dtoMap.put("email", email);
		
//		HashMap<String, String> errorMap = new HashMap<String, String>();
//		if (!isRequired(memberId)) {
//			errorMap.put("memberId", "아이디를 입력하시기 바랍니다.");
//		}
//		if (!isRequired(memberPw)) {
//			errorMap.put("memberPw", "비밀번호를 입력하시기 바랍니다.");
//		}
//		if (!isRequired(name)) {
//			errorMap.put("name", "이름을 입력하시기 바랍니다.");
//		}
//		if (!isRequired(mobile)) {
//			errorMap.put("mobile", "휴대폰을 입력하시기 바랍니다.");
//		}
//		if (!isRequired(email)) {
//			errorMap.put("email", "이메일을 입력하시기 바랍니다.");
//		}
//		
//		if (errorMap.size() > 0) {
//			request.setAttribute("errorMap", errorMap);
//			request.getRequestDispatcher("result.jsp").forward(request, response);
//			return;
//		}
		

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (!isRequired(memberId) || !isRequired(memberPw) || !isRequired(name) ||
				!isRequired(mobile) || !isRequired(email)) {
			out.println("<script type='text/javascript'>");
			out.println("alert('[내정보변경저장 실패] 내정보 변경 필수 입력항목을 모두 입력하시기 바랍니다.');");
			out.println("location.href='myInfo'");
			out.println("</script>");
			return;
		}
	
			MemberService memberService = new MemberService();
			int result = memberService.updateMemberInfo(dtoMap);
//			System.out.println("addMember result: " + result);
			if (result >= 1) {
				out.println("<script type='text/javascript'>");
				out.println("alert('[내정보변경 성공] 내정보 변경이 완료되었습니다.');");
				out.println("location.href='main.jsp'");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('[내정보변경저장 실패] 내정보 변경 저장시 문제가 발생했습니다. 다시 확인하시기 바랍니다.');");
				out.println("location.href='main.jsp'");
				out.println("</script>");
			}
			
		}
		
		
	
//		int result = memberService.setMember(memberId, memberPw, name, mobile, email); 
//			if (result >= 1) {
//				out.println("<script type='text/javascript'>");
//				out.println("alert('[내정보변경 성공] 내정보 변경이 완료되었습니다.');");
//				out.println("location.href='main.jsp'");
//				out.println("</script>");
//			} else {
//				out.println("<script type='text/javascript'>");
//				out.println("alert('[내정보변경저장 실패] 내정보 변경 저장시 문제가 발생했습니다. 다시 확인하시기 바랍니다.');");
//				out.println("location.href='main.jsp'");
//				out.println("</script>");
//			}
//		}

		//	MemberService memberService = new MemberService();
			// int result = memberService.setMember(new Member(memberId, memberPw, name, mobile, email)); 
			// public int setMember(Member dto) {}
			// public int updateMemberPw(String memberId, String memberPw, String name, String mobile, String email){}
			
	
	
	public boolean isRequired(String data) {
		if (data != null && data.trim().length() > 0) {
			return true;
		}
		return false;
	}
}
