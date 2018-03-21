package kr.spring.team.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.record.domain.RecordCommand;
import kr.spring.team.domain.TeamAppliCommand;
import kr.spring.team.domain.TeamMemberCommand;

public interface TeamAppliService {
	//지원 현황
	@Transactional(readOnly=true)
	public List<TeamAppliCommand> list(Map<String,Object> map);
	
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	
	public int applyCount(Map<String,Object> map);
	
	public int joinCount(Map<String,Object> map);
	
	public void insert(TeamAppliCommand appli);
	public void join(TeamAppliCommand join);
	public void after(Integer num);
	public void insertRecord(RecordCommand record);
	@Transactional(readOnly=true)
	public TeamAppliCommand select(Integer num);
	public void delete(Integer num);
	
}
