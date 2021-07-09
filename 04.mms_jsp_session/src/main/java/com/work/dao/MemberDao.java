package com.work.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.work.dto.Member;
import com.work.util.Utility;

/** 
 * 회원 테이블에 대한 DAO 클래스
 * -- DAO pattern
 * -- 싱글톤패턴
 * -- 팩토리패턴
 */
public class MemberDao {
   /** Factory pattern : DB연결 및 DB자원해제 메서드 제공 */
   private FactoryDao factory = FactoryDao.getInstance();

   private static MemberDao instance = new MemberDao();
   
   /**
    * singleton pattern : 객체 생성 불가 제한
    */
   private MemberDao() {   
   }
   
   public static MemberDao getInstance() {
      return instance;
   }
   
   /**
    * 로그인
    * @param memberId
    * @param memberPw
    * @return 회원등급 , 미존재시 null
    */
   public String login(String memberId, String memberPw) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;

      try {
         conn = factory.getConnection();
         
         String sql = "select Grade from member where member_ID =? and member_pw = ?"; // 로그인
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, memberId);
         stmt.setString(2, memberPw);
         
         rs = stmt.executeQuery();
         
         if(rs.next()) {
        	 return rs.getString("grade");
         }
         
      } catch (SQLException e) {
         System.out.println("[오류] 로그인");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt, rs);
      }
      return null;	// 아이디 미존재, 비밀번호 틀린경우, sql 수행예외발생시 null!
   }


   /**
    * 회원 상세조회 / 내정보조회
    * @param memberId
    * @return
    */
   public Member selectOne(String memberId) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;

      try {
         conn = factory.getConnection();
         
         String sql = "select * from member where member_ID = ?";
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, memberId);
         
         rs = stmt.executeQuery();
         
         if(rs.next()) {
            String memberPw = rs.getString("member_pw");
            String name = rs.getString("name");
            String mobile = rs.getString("mobile");
            String email = rs.getString("email");
            String entryDate = rs.getString("entry_date");
            String grade = rs.getString("grade");
            int mileage = rs.getInt("mileage");
            String manager = rs.getString("manager");
            
            Member dto = new Member(memberId, memberPw, name, mobile, email, entryDate, grade, mileage, manager);
            return dto;  // 생성한 Member객체 반환
         }
         
      } catch (SQLException e) {
         System.out.println("[오류] 회원상세조회");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt, rs);
      }
      
      return null;
   }

   /**
    * 전체회원조회
    * @return
    */
   public ArrayList<Member> selectList() {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;

      ArrayList<Member> list = new ArrayList<Member>();
      
      try {
         conn = factory.getConnection();
         
         String sql = "select * from member";
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery();
         
         while(rs.next()) {
            String memberId = rs.getString("member_Id"); 
            String memberPw = rs.getString("member_pw");
            String name = rs.getString("name");
            String mobile = rs.getString("mobile");
            String email = rs.getString("email");
            String entryDate = rs.getString("entry_date");
            String grade = rs.getString("grade");
            int mileage = rs.getInt("mileage");
            String manager = rs.getString("manager");
            
            Member dto = new Member(memberId, memberPw, name, mobile, email, entryDate, grade, mileage, manager);
            list.add(dto);
         }
         
      } catch (SQLException e) {
         System.out.println("[오류] 회원전체조회");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt, rs);
      }
      return list;
   }

   
   /**
    * 등급별 전체회원조회
    * @param grade
    * @return
    */
   public ArrayList<Member> selectListByGrade(String grade) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;

      ArrayList<Member> list = new ArrayList<Member>();
      
      try {
         conn = factory.getConnection();
         
         String sql = "select * from member where grade=?";
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, grade);
         
         rs = stmt.executeQuery();
         
         while(rs.next()) {
            String memberId = rs.getString("member_Id"); 
            String memberPw = rs.getString("member_pw");
            String name = rs.getString("name");
            String mobile = rs.getString("mobile");
            String email = rs.getString("email");
            String entryDate = rs.getString("entry_date");
            int mileage = rs.getInt("mileage");
            String manager = rs.getString("manager");
            
            Member dto = new Member(memberId, memberPw, name, mobile, email, entryDate, grade, mileage, manager);
            list.add(dto);
         }
         
      } catch (SQLException e) {
         System.out.println("[오류] 등급별 회원전체조회");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt, rs);
      }
      
      return list;
   }

   
   /**
    * 아이디 찾기
    * @param name
    * @param mobile
    * @return
    */
   public String selectMemberIdByMobile(String name, String mobile) {
      return null;
   }
   
   /**
    * 아이디 찾기
    * @param name
    * @param mobile
    * @return
    */
   public String selectMemberIdByEmail(String name, String mobile) {
      return null;
   }
   
   /**
    * 비밀번호 찾기
    * @param memberId
    * @param name
    * @param mobile
    * @return
    */
   public String selectMemberPwByMobile(String memberId, String name, String mobile) {
      return null;
   }
   
   /**
    * 1단계 : 비밀번호 찾기 : 해당 회원 존재 유무 체킹 (코드 구현)
    * 
    * @param memberId
    * @param name
    * @param mobile
    * @return 성공 true, 실패 false
    */
   public boolean selectMemberPwByEmail(String memberId, String name, String email) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;

      try {
         conn = factory.getConnection();
         
         String sql = "select member_pw from member where MEMBER_ID = ? and name = ? and email = ?";
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, memberId);
         stmt.setString(2, name);
         stmt.setString(3, email);
         
         rs = stmt.executeQuery();
         
         if(rs.next()) {
            return true;
         }
         
         rs.close();
         stmt.close();
         conn.close();
         
      } catch (SQLException e) {
         System.out.println("[오류] 비밀번호찾기 정보 검증");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt, rs);
      }
      
      return false;
   }

   /**
    * 2단계 : 비밀번호(임시발급)변경
    * @param memberId
    * @param memberNewPw
    * @return 성공 true, 실패 false
    */
   public boolean updateMemberPw(String memberId, String memberNewPw) {
      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = factory.getConnection();
         
         String sql = "UPDATE MEMBER SET MEMBER_PW = ? WHERE MEMBER_ID = ?";
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, memberNewPw);
         stmt.setString(2, memberId);
         
         int rows = stmt.executeUpdate();
         if (rows > 0) {
            return true;
         }
         
      } catch (SQLException e) {
         System.out.println("[오류] 비밀번호(임시발급)변경");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt);
      }
      
      return false;
   }
   
   /**
    * 비밀번호 변경
    * @param memberId 아이디
    * @param memberPw 기존암호
    * @param modifyMemberPw 변경암호
    * @return 성공 1, 실패 0
    */
   public int updateMemberPw(String memberId, String memberPw, String modifyMemberPw) {
      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = factory.getConnection();
         
         String sql = "UPDATE MEMBER SET MEMBER_PW = ? WHERE MEMBER_ID = ? AND MEMBER_PW=?";
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, modifyMemberPw);
         stmt.setString(2, memberId);
         stmt.setString(3, memberPw);
         
         return stmt.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("[오류] 비밀번호 변경");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt);
      }
      
      return 0;
   }
   
   /**
    * 아이디 중복여부
    * @param memberId
    * @return
    */
   public boolean selectMemberId(String memberId) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;

      try {
         conn = factory.getConnection();
         
         String sql = "select 1 from member where member_ID =?"; 
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, memberId);
         
         rs = stmt.executeQuery();
         
         return rs.next();
         
      } catch (SQLException e) {
         System.out.println("[오류] 아이디 중복조회");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt, rs);
      }
      return false;
   }

   /**
    * 휴대폰 중복여부
    * @param mobile
    * @return
    */
   public boolean selectMobile(String mobile) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;

      try {
         conn = factory.getConnection();
         
         String sql = "select 1 from member where mobile =?"; 
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, mobile);
         
         rs = stmt.executeQuery();
         
         return rs.next();
         
      } catch (SQLException e) {
         System.out.println("[오류] 휴대폰 중복조회");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt, rs);
      }
      return false;
   }   
   /**
    * 회원가입 
    * @return 성공 0, 실패 1
    */
   public int insertMember(Member dto) {
      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = factory.getConnection();
         
         String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, dto.getMemberId());
         stmt.setString(2, dto.getMemberPw());
         stmt.setString(3, dto.getName());
         stmt.setString(4, dto.getMobile());
         stmt.setString(5, dto.getEmail());
         stmt.setString(6, dto.getEntryDate());
         stmt.setString(7, dto.getGrade());
         stmt.setInt(8, dto.getMileage());
         stmt.setString(9, dto.getManager());
         
         return stmt.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("[오류] 회원가입");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt);
      }
      
      return 0;
      
   }

   public int insertMember(Map<String, String> dtoMap) {
      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = factory.getConnection();
         
         String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, dtoMap.get("memberId"));
         stmt.setString(2, dtoMap.get("memberPw"));
         stmt.setString(3, dtoMap.get("name"));
         stmt.setString(4, dtoMap.get("mobile"));
         stmt.setString(5, dtoMap.get("email"));
         stmt.setString(6, dtoMap.get("entryDate"));
         stmt.setString(7, dtoMap.get("grade"));
         stmt.setInt(8, Integer.parseInt(dtoMap.get("mileage")));
         stmt.setString(9, dtoMap.get("manager"));
         
         return stmt.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("[오류] 회원가입");
         e.printStackTrace();
      } finally {
         factory.close(conn, stmt);
      }
      
      return 0;
      
   }
   
}