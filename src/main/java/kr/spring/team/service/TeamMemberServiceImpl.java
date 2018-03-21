package kr.spring.team.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.record.domain.RecordCommand;
import kr.spring.team.dao.TeamBoardMapper;
import kr.spring.team.dao.TeamMemberMapper;
import kr.spring.team.domain.TeamMemberCommand;

@Service("teamMemberService")
public class TeamMemberServiceImpl implements TeamMemberService{
	
	@Resource
	private TeamMemberService teamMemberService;
	
	@Resource 
	private TeamMemberMapper teamMemberMapper;
		
	@Override
	public List<TeamMemberCommand> list(Map<String, Object> map) {
		return teamMemberMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return teamMemberMapper.getRowCount(map);
	}

	@Override
	public TeamMemberCommand selectBoard(Integer num) {
		return teamMemberMapper.selectBoard(num);
	}

	@Override
	public void delete(Integer num) {
		teamMemberMapper.deleteByNum(num);
		teamMemberMapper.delete(num);
	}
	@Override
	public void insertInfo(TeamMemberCommand teamInfo) {
		teamMemberMapper.insertInfo(teamInfo);
	}
	@Override
	public void insertRecord(RecordCommand record) {
		teamMemberMapper.insertRecord(record);
	}

	@Override
	public void deleteInfo(Map<String,Object> map) {
		teamMemberMapper.deleteInfo(map);
	}

	@Override
	public void deleteRecord(RecordCommand record) {
		teamMemberMapper.deleteRecord(record);
	}

	@Override
	public void deleteInfoRecord(Map<String,Object> map) {
		teamMemberMapper.deleteInfoRecord(map);
	}

	@Override
	public List<TeamMemberCommand> memberList(Map<String, Object> map) {
		return teamMemberMapper.memberList(map);
	}

	@Override
	public void redCard(Map<String,Object> map) {
		teamMemberMapper.redCard(map);
	}
	
	@Override
	public void redCardRecord(Map<String, Object> map) {
		teamMemberMapper.redCardRecord(map);
	}

	@Override
	public int memberCount(Map<String, Object> map) {
		return teamMemberMapper.memberCount(map);
	}


}
