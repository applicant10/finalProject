package kr.spring.member.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.member.domain.MemberCommand;

@Transactional
public interface MemberService {
	public void insert(MemberCommand member);	//register member
	@Transactional(readOnly=true)
	public MemberCommand selectMember(String id);	//login
	public String selectMemberByNick(String m_nick);
	public void updateMember(MemberCommand member);
	public void deleteMember(String id);
	public MemberCommand selectMemberDetail(String id);
	public String selectFindId(MemberCommand memberCommand);
	public void insertMemberDetail(MemberCommand memberCommand);
	public String selectFindPasswd(MemberCommand memberCommand);
	public void updatePassword(MemberCommand member);
	//강의 번호로 회원 닉네임 검색
	@Transactional(readOnly=true)
	public String lectureWriter(Integer l_num);
	public List<MemberCommand> selectAllMember();
	public void updateAccess(MemberCommand memberCommand);
}