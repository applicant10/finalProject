package kr.spring.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberCommand;

public interface MemberMapper {
	//회원 정보 뷰
	@Select("SELECT * FROM member join member_detail using(m_id) WHERE m_id=#{m_id}")
	public MemberCommand selectMemberDetail(String id);
	@Select("select * from member where m_grade<20")
	public List<MemberCommand> selectAllMember();
	
	//로그인시 사용
	@Select("SELECT * FROM member join member_detail using(m_id) WHERE m_id=#{m_id}")
	public MemberCommand selectUser(String id);
	@Select("SELECT m_nick from member where m_nick=#{m_nick}")
	public String selectMemberByNick(String m_nick);
	@Select("select m.m_id from member m join member_detail md on m.m_id=md.m_id where m_nick=#{m_nick} and md_name=#{md_name}")
	public String selectFindId(MemberCommand memberCommand);
	@Select("select md.m_pw from member_detail md join member m on md.m_id=m.m_id where md.m_id=#{m_id} and m.m_nick=#{m_nick} and md.md_name=#{md_name}")
	public String selectFindPasswd(MemberCommand memberCommand);
	
	//회원 가입
	@Insert("INSERT INTO member (m_id, m_nick, m_grade) VALUES (#{m_id}, #{m_nick}, #{m_grade})")
	public void insertMember(MemberCommand member);
	@Insert("INSERT INTO member_detail (m_id, m_pw, md_name, md_phone, md_regdate) VALUES (#{m_id},#{m_pw},#{md_name},#{md_phone},sysdate)")
	public void insertMemberDetail(MemberCommand member);
	
	//회원정보 수정
	@Update("UPDATE member SET m_nick=#{m_nick} WHERE m_id=#{m_id}")
	public void updateMember(MemberCommand member);
	@Update("UPDATE member_detail SET m_pw=#{m_pw} WHERE m_id=#{m_id}")
	public void updatePassword(MemberCommand member);
	@Update("UPDATE member_detail SET m_pw=#{m_pw}, md_name=#{md_name}, md_phone=#{md_phone} WHERE m_id=#{m_id}")
	public void updateMemberDetail(MemberCommand member);
	@Update("update member_detail set m_pw=#{m_pw} where m_id=#{m_id}")
	public void updateNewPasswd(MemberCommand member);
	@Update("update member set m_access=#{m_access} where m_id=#{m_id}")
	public void updateAccess(MemberCommand command);
	
	//회원 탈퇴 트랜젝션
	@Update("UPDATE member SET m_grade=0 WHERE m_id=#{m_id}")
	public void zeroToGrade(String id);		//회원 등급 0으로 지정
	@Delete("DELETE FROM member_detail WHERE m_id=#{m_id}")
	public void deleteMemberDetail(String id);	//회원 상세 테이블 삭제
	
	//강의 번호로 회원 닉네임 검색
	@Select("SELECT m_nick FROM member WHERE m_id=(SELECT m_id FROM lecture WHERE l_num=#{l_num})")
	public String lectureWriter(Integer l_num);
}