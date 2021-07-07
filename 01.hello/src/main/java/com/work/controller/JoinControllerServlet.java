package com.work.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinControllerServlet
 */
public class JoinControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ## jsp 응답페이지 이동하기
	 * ## 서블릿 서비스 메서드 재정의 순서
		1. 요청객체에 대한 한글 인코딩 설정됨
		2. 요청데이터 추출 : 요청페이지 로그인요청페이지 login.jsp name="변수명"
		3. 요청데이터 검증
		4. Model 요청의뢰
		5. Model 요청결과를 받아서 응답을 위한 설정
		6. 응답페이지 이동 : jsp
		7. 응답페이지 응답결과 보여주기 : jsp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 0.
			System.out.println("회원가입 요청"); 
			// 1.
			request.setCharacterEncoding("utf-8");
			
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			String name = request.getParameter("name");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			
			System.out.println(
			"memberId : " + memberId + "\n" +
			"memberPw : " + memberPw + "\n" +
			"name : " + name + "\n" +		
			"mobile : " + mobile + "\n" +		
			"email : " + email); 
			
			// 데이터 올바르지 않은 경우 처리
			if(memberId == null || memberId.trim().length() == 0 ||
				memberPw == null || memberPw.trim().length() == 0 || 
				name == null || name.trim().length() == 0 || 
				mobile == null || mobile.trim().length() == 0 || 
				email == null || email.trim().length() == 0 ) {
				// 5. Model 요청결과를 받아서 응답을 위한 설정
				// 요청객체에 응답메세지 설정
				request.setAttribute("message", "회원가입 실패 : 회원가입 정보를 올바르게 입력하시기 바랍니다.");
				
				// result.jsp forward 이동
				RequestDispatcher nextView = request.getRequestDispatcher("result.jsp");
				nextView.forward(request, response);
				return; // 요청 서비스 완료됨, else가 있으면 필요없음
	 		} else {
	 			// 로그인 데이터 검증 완료 => 로그인 모델 요청 처리 진행
	 			request.setAttribute("message", "회원가입 성공 : " + memberId);
	 			
	 			// result.jsp forward 이동
	 			RequestDispatcher nextView = request.getRequestDispatcher("main.jsp");
	 			nextView.forward(request, response);
	 		}
		}
	}