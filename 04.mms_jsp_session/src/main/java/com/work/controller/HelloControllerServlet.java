package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloControllerServlet
 */
public class HelloControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("1. 서블릿 메모리 로딩 수행");
	}
	
	/** 기본 객체 생성 */
	public HelloControllerServlet() {
		System.out.println("2. 서블릿 객체 생성 수행");
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		사용자 초기화 코드 수행문
//	}
	
	/**
	 * init 은 자동완성 하지말 것
	 * 
	 */
	public void init() throws ServletException {
		System.out.println("3. 서블릿 초기화 수행");
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("5. 서블릿 자원해제 수행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("4. Get 요청 서비스 수행");
		// dispatch
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("4. Post 요청 서비스 수행");
		process(request, response);
	}

	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String HTTP_METHOD = request.getMethod();
		System.out.println("HTTP_METHOD : " + HTTP_METHOD);
		System.out.println("request.getRequestURI() : " + request.getRequestURI()); // /mms01/hi
		System.out.println("request.getRequestURL() : " + request.getRequestURL()); // http://localhost:8070/mms01/hi
		
	}
}
