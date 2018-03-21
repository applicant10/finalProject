package kr.spring.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberCommand;

@Service("userLoginService")
public class MemberServiceImpl implements MemberService{
	
	@Resource
	private MemberMapper memberMapper;
	
	@Override
	public void insert(MemberCommand member) {
		memberMapper.insertMember(member);
		memberMapper.insertMemberDetail(member);
	}
	
	@Override
	public MemberCommand selectMember(String id) {
		return memberMapper.selectUser(id);
	}
	
	@Override
	public void updateMember(MemberCommand member) {
		memberMapper.updateMember(member);
		memberMapper.updateMemberDetail(member);
	}
	
	@Override
	public void deleteMember(String id) {
		memberMapper.zeroToGrade(id);
		memberMapper.deleteMemberDetail(id);
	}

	@Override
	public MemberCommand selectMemberDetail(String id) {
		return memberMapper.selectMemberDetail(id);
	}

	@Override
	public String lectureWriter(Integer l_num) {
		return memberMapper.lectureWriter(l_num);
	}

	@Override
	public String selectFindId(MemberCommand memberCommand) {
		String mdId = memberMapper.selectFindId(memberCommand);
		return mdId;
	}

	@Override
	public void insertMemberDetail(MemberCommand member) {
		memberMapper.updateNewPasswd(member);
	}

	@Override
	public String selectFindPasswd(MemberCommand memberCommand) {
		String passwd = memberMapper.selectFindPasswd(memberCommand);
		return passwd;
	}

	@Override
	public String selectMemberByNick(String m_nick) {
		String member = memberMapper.selectMemberByNick(m_nick);
		return member;
	}
	@Override
	public void updatePassword(MemberCommand member) {
		memberMapper.updatePassword(member);
		
	}

	@Override
	public List<MemberCommand> selectAllMember() {
		List<MemberCommand> list = memberMapper.selectAllMember();
		return list;
	}

	@Override
	public void updateAccess(MemberCommand command) {
		memberMapper.updateAccess(command);
	}

}