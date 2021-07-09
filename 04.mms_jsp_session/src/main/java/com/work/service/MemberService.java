package com.work.service;

import java.util.Map;

import com.work.dao.MemberDao;
import com.work.dto.Member;
import com.work.util.Utility;

public class MemberService {
   private MemberDao memberDao = MemberDao.getInstance();

   public int addMember(Map<String, String> dtoMap) {
      System.out.println("service addmember()" +  dtoMap);
      dtoMap.put("entryDate", Utility.getCurrentDate());
      dtoMap.put("grade", "G");
      dtoMap.put("mileage", String.valueOf(5000));
      int result = memberDao.insertMember(dtoMap);
      
      System.out.println("addMember result : 1");
      return result;
   }
   
   
   /**
	 * 로그인
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 회원등급, 미존재시 null
	 */
	public String loginGrade(String memberId, String memberPw) {
		// 로그인 성공한 회원의 등급 반환 : 바로 return
		return memberDao.login(memberId,memberPw);
		
		// 로그인 성공한 회원의 등급이 "G" 인 경우에 별도의 서비스를 진행
	}

	/**
	 * 내정보조회 / 회원상세조회
	 * @param member_Id 아이디
	 * @return 회원정보
	 */
	public Member getMember(String memberId) {
		return memberDao.selectOne(memberId);
	}

   
}