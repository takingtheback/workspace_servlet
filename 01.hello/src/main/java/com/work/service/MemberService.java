package com.work.service;

import java.util.Map;

import com.work.dao.MemberDao;
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
		String grade = memberDao.login(memberId,memberPw);
		if(grade != null) {
			
			return grade;
		}
		return null;
	}



   
}