package kr.spring.team.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.record.domain.RecordCommand;
import kr.spring.team.dao.TeamAppliMapper;
import kr.spring.team.domain.TeamAppliCommand;

@Service("teamAppliService")
public class TeamAppliServiceImpl implements TeamAppliService{
	
	@Resource
	private TeamAppliService teamAppliService;
	
	@Resource
	private TeamAppliMapper teamAppliMapper;
	
	@Override
	public List<TeamAppliCommand> list(Map<String, Object> map) {
		return teamAppliMapper.list(map);
	}
	
	@Override
	public int getRowCount(Map<String, Object> map) {
		return teamAppliMapper.getRowCount(map);
	}

	@Override
	public void insert(TeamAppliCommand appli) {
		teamAppliMapper.insert(appli);
	}

	@Override
	public TeamAppliCommand select(Integer num) {
		return teamAppliMapper.select(num);
	}

	@Override
	public void delete(Integer num) {
		teamAppliMapper.delete(num);
	}

	@Override
	public void join(TeamAppliCommand join) {
		teamAppliMapper.join(join);
	}
 
	@Override
	public void after(Integer num) {
		teamAppliMapper.after(num);
	}

	@Override
	public void insertRecord(RecordCommand record) {
		teamAppliMapper.insertRecord(record);
	}

	@Override
	public int applyCount(Map<String, Object> map) {
		return teamAppliMapper.applyCount(map);
	}

	@Override
	public int joinCount(Map<String, Object> map) {
		return teamAppliMapper.joinCount(map);
	}


}