package kr.spring.team.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.record.domain.RecordCommand;
import kr.spring.team.domain.TeamMemberCommand;

public interface TeamMemberService {
	@Transactional(readOnly=true)
	public List<TeamMemberCommand> list(Map<String,Object> map);
	
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	
	//그룹에 가입된 회원 목록
	@Transactional(readOnly=true)
	public List<TeamMemberCommand> memberList(Map<String,Object> map);
	//멤버 리스트 카운트
	@Transactional(readOnly=true)
	public int memberCount(Map<String,Object> map);
	
	//회원강퇴
	public void redCard(Map<String,Object> map);
	public void redCardRecord(Map<String,Object> map);
	
	//그룹 개설
	public void insertInfo(TeamMemberCommand teamInfo);
	public void insertRecord(RecordCommand record);
	
	@Transactional(readOnly=true)
	public TeamMemberCommand selectBoard(Integer num);
	
	//그룹 폐지
	public void delete(Integer num);
	public void deleteRecord(RecordCommand record);
	
	//그룹원 탈퇴
	public void deleteInfo(Map<String,Object> map);
	public void deleteInfoRecord(Map<String,Object> map);
}
