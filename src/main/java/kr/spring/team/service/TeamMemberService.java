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
	
	//�׷쿡 ���Ե� ȸ�� ���
	@Transactional(readOnly=true)
	public List<TeamMemberCommand> memberList(Map<String,Object> map);
	//��� ����Ʈ ī��Ʈ
	@Transactional(readOnly=true)
	public int memberCount(Map<String,Object> map);
	
	//ȸ������
	public void redCard(Map<String,Object> map);
	public void redCardRecord(Map<String,Object> map);
	
	//�׷� ����
	public void insertInfo(TeamMemberCommand teamInfo);
	public void insertRecord(RecordCommand record);
	
	@Transactional(readOnly=true)
	public TeamMemberCommand selectBoard(Integer num);
	
	//�׷� ����
	public void delete(Integer num);
	public void deleteRecord(RecordCommand record);
	
	//�׷�� Ż��
	public void deleteInfo(Map<String,Object> map);
	public void deleteInfoRecord(Map<String,Object> map);
}
