package com.work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("회원가입 요청");
      request.setCharacterEncoding("utf-8");
      String memberId = request.getParameter("memberId");
      String memberPw = request.getParameter("memberPw");
      String name = request.getParameter("name");
      String mobile = request.getParameter("mobile");
      String email = request.getParameter("email");
      //System.out.println(memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email);
      Map<String, String> dtoMap = new HashMap<String, String>();
      dtoMap.put("memberId", memberId);
      dtoMap.put("memberPw", memberPw);
      dtoMap.put("name", name);
      dtoMap.put("mobile", mobile);
      dtoMap.put("email", email);
      
      System.out.println(dtoMap);
      
      ArrayList<String> errorList = new ArrayList<String>();
      
      if(memberId == null || memberId.trim().length() > 30 || memberId.trim().length() == 0) {
         errorList.add("아이디는 필수 입력항목이며 30자리 이내로 입력하시기 바랍니다");   
      }
      if(memberPw == null || memberPw.trim().length() > 20 || memberPw.trim().length() == 0) {
         errorList.add("비밀번호는 필수 입력항목이며 20자리 이내로 입력하시기 바랍니다");   
      }
      if(name == null || name.trim().length() > 20 || name.trim().length() == 0) {
         errorList.add("이름은 필수 입력항목이며 20자리 이내로 입력하시기 바랍니다");   
      }
      if(mobile == null || mobile.trim().length() > 13 || mobile.trim().length() == 0) {
         errorList.add("휴대폰은 필수 입력항목이며 13자리 이내로 입력하시기 바랍니다");   
      }
      if(email == null || email.trim().length() > 30 || email.trim().length() == 0) {
         errorList.add("이메일은 필수 입력항목이며 30자리 이내로 입력하시기 바랍니다");   
      }
      
      HashMap<String, String> errorMap = new HashMap<String, String>();
      
      if(memberId == null || memberId.trim().length() > 30 || memberId.trim().length() == 0) {
         errorMap.put("memberId","아이디는 필수 입력항목이며 30자리 이내로 입력하시기 바랍니다");   
      }
      if(memberPw == null || memberPw.trim().length() > 20 || memberPw.trim().length() == 0) {
         errorMap.put("memberPw","비밀번호는 필수 입력항목이며 20자리 이내로 입력하시기 바랍니다");   
      }
      if(name == null || name.trim().length() > 20 || name.trim().length() == 0) {
         errorMap.put("name","이름은 필수 입력항목이며 20자리 이내로 입력하시기 바랍니다");   
      }
      if(mobile == null || mobile.trim().length() > 13 || mobile.trim().length() == 0) {
         errorMap.put("mobile","휴대폰은 필수 입력항목이며 13자리 이내로 입력하시기 바랍니다");   
      }
      if(email == null || email.trim().length() > 30 || email.trim().length() == 0) {
         errorMap.put("email","이메일은 필수 입력항목이며 30자리 이내로 입력하시기 바랍니다");   
      }
      
      if(!errorList.isEmpty()) {
         request.setAttribute("errorList", errorList);
         request.setAttribute("errorMap", errorMap);
         request.getRequestDispatcher("result.jsp").forward(request, response);
         return;
      }
      
      MemberService memberService = new MemberService();
      int result = memberService.addMember(dtoMap);
      
      if(result == 1) {
         //request.setAttribute("message", "회원가입성공 : " + memberId + "님 로그인하세요" );
         //response.sendRedirect("login.jsp");
         response.setContentType("text/html; charset=UTF-8");
         PrintWriter out = response.getWriter();
         /*
          * <script type='text/javascript'>
            alert("회원가입이 정상처리되었습니다. 로그인 후 회원전용서비스를 이용하시기 바랍니다.");
            location.href="login.jsp";
            </script>
          */
         out.println("<script type='text/javascript'>");
         out.println("alert(\"회원가입이 정상처리되었습니다. 로그인 후 회원전용서비스를 이용하시기 바랍니다.\");");
         out.println("location.href=\"login.jsp\";");
         out.println("</script>");
         
         out.close();
      } else {
         errorList.add("회원가입이 정상 처리 되지 않았습니다.");
         errorMap.put("result", "회원가입이 정상 처리되지 않았습니다.");
         request.setAttribute("message", "회원가입이 정상 처리되지 않았습니다.");
         request.getRequestDispatcher("result.jsp").forward(request, response);
      }
//      request.setAttribute("message", "회원가입성공");
//      RequestDispatcher nextView = request.getRequestDispatcher("login.jsp");
//      nextView.forward(request, response);
   }

}