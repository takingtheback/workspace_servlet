package com.work.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.dto.Member;
import com.work.service.MemberService;

public class MyInfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 내정보조회 요청 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내정보조회");
		
		// 기존 세션객체 가져오기
		HttpSession session = request.getSession(false);
		
		// 사용자 인증 검증 : 오류 처리
		if (session == null || session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
			request.setAttribute("message", "[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		// 세션객체에 설정되어 있는 로그인 사용자 아이디 가져오기
		String loginMemberId = (String)session.getAttribute("memberId");
		MemberService memberService = new MemberService();
		
		Member dto = memberService.getMemberToDto(loginMemberId);
		HashMap<String, Object> dtoMap = memberService.memberServiceToMap(loginMemberId);
		
		if (dto == null) {
			request.setAttribute("message", "[실패] 내정보 조회를 다시 확인하시기 바랍니다.");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		
		if (dtoMap == null) {
			request.setAttribute("message", "[실패] 내정보 조회를 다시 확인하시기 바랍니다.");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("dtoMap", dtoMap);
		request.getRequestDispatcher("myInfo.jsp").forward(request, response);
	}
}




