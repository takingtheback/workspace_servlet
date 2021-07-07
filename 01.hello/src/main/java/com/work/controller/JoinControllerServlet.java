package com.work.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.work.service.MemberService;

/**
 * Servlet implementation class JoinControllerServlet
 */
public class JoinControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ## jsp 응답페이지 이동하기
	 * ## 서블릿 서비스 메서드 재정의 순서
		1. 요청객체에 대한 한글 인코딩 설정
		2. 요청데이터 추출 : 요청페이지 로그인요청페이지 login.jsp name="변수명"
		3. 요청데이터 검증
		4. Model 요청의뢰
		5. Model 요청결과를 받아서 응답을 위한 설정
		6. 응답페이지 이동 : jsp
		7. 응답페이지 응답결과 보여주기 : jsp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 0. 요청확인 되는지 확인
			System.out.println("회원가입 요청"); 
			// 1. 요청객체에 대한 한글 인코딩 설정
			request.setCharacterEncoding("utf-8");
			// 2. 요청데이터 추출 : 요청페이지 로그인요청페이지 login.jsp name="변수명"
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			String name = request.getParameter("name");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			
			Map<String, String> dtoMap = new HashMap <String, String>();
			dtoMap.put("memberId", memberId);
			dtoMap.put("memberPw", memberPw);
			dtoMap.put("name", name);
			dtoMap.put("mobile", mobile);
			dtoMap.put("email", email);
			
			System.out.println(dtoMap);
			
			ArrayList<String> errorList = new ArrayList<String>();
						
 			if(memberId == null || memberId.trim().length() > 30 || memberId.trim().length() == 0) {
 				errorList.add("아이디는 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
 			}
 			
 			if(memberPw == null || memberPw.trim().length() > 20 || memberPw.trim().length() == 0) {
 				errorList.add("비밀번호는 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
 			}
 			
 			if(name == null || name.trim().length() > 20 || name.trim().length() == 0) {
 				errorList.add("이름은 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
 			}
			
 			if(mobile == null || mobile.trim().length() > 13 || mobile.trim().length() == 0) {
 				errorList.add("휴대폰은 필수입력항목이며 13자리 이내로 입력하시기 바랍니다.");
 			}
 			
 			if(email == null || email.trim().length() > 30 || email.trim().length() == 0) {
 				errorList.add("이메일은 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
 			}
			
 			
 			HashMap<String, String> errorMap = new HashMap<String, String>();
			
 			if(memberId == null || memberId.trim().length() > 30 || memberId.trim().length() == 0) {
 				errorMap.put("memberId", "아이디는 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
 			}
 			
 			if(memberPw == null || memberPw.trim().length() > 20 || memberPw.trim().length() == 0) {
 				errorMap.put("memberPw", "비밀번호는 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
 			}
 			
 			if(name == null || name.trim().length() > 20 || name.trim().length() == 0) {
 				errorMap.put("name", "이름은 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
 			}
			
 			if(mobile == null || mobile.trim().length() > 13 || mobile.trim().length() == 0) {
 				errorMap.put("mobile", "휴대폰은 필수입력항목이며 13자리 이내로 입력하시기 바랍니다.");
 			}
 			
 			if(email == null || email.trim().length() > 30 || email.trim().length() == 0) {
 				errorMap.put("email", "이메일은 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
 			}
 			
 			if(!errorList.isEmpty()) {
 				request.setAttribute("errorList", errorList);
 				request.setAttribute("errorMap", errorMap);
 				request.getRequestDispatcher("result.jsp").forward(request, response);
				return;
 			}
 				
 		MemberService memberService = new MemberService();	
 		MemberService.addMember(dtoMap);
 		}
	}
