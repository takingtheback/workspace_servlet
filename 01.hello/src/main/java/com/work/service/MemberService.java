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
   
   
}