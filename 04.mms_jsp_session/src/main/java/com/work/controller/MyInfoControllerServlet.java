package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.dto.Member;
import com.work.service.MemberService;

/**
 * Servlet implementation class MyInfoControllerServlet
 */
public class MyInfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내정보 요청 : " + request.getRequestURI()); 
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		MemberService memberService = new MemberService();
		Member dto = memberService.getMember(memberId);
		request.setAttribute("dto", dto);
		
		System.out.println("dto : " + dto);
		
//		response.sendRedirect("myInfo.jsp");
		request.getRequestDispatcher("myInfo.jsp").forward(request, response);
	}

}
