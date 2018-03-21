package kr.spring.team.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.team.dao.TeamBoardMapper;
import kr.spring.team.domain.TeamBoardCommand;
import kr.spring.team.domain.TeamBoardReplyCommand;
import kr.spring.team.domain.TeamMemberCommand;

@Service("teamBoardService")
public class TeamBoardServiceImpl implements TeamBoardService{
	
	@Resource
	private TeamBoardService teamBoardService;
	
	@Resource
	private TeamBoardMapper teamBoardMapper;

	@Override
	public List<TeamBoardCommand> list(Map<String, Object> map) {
		return teamBoardMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return teamBoardMapper.getRowCount(map);
	}

	@Override
	public void insert(TeamBoardCommand board) {
		teamBoardMapper.insert(board);
	}

	@Override
	public TeamBoardCommand select(Integer num) {
		return teamBoardMapper.select(num);
	}

	@Override
	public void update(TeamBoardCommand board) {
		teamBoardMapper.update(board);
		
	}

	@Override
	public void delete(Integer num) {
		//´ñ±Û
		teamBoardMapper.g_deleteReplyByNum(num);
		//ºÎ¸ð±Û
		teamBoardMapper.delete(num);
	}

	@Override
	public List<TeamBoardReplyCommand> teamReply(Map<String, Object> map) {
		return teamBoardMapper.teamReply(map);
	}

	@Override
	public int g_getRowCountReply(Map<String, Object> map) {
		return teamBoardMapper.g_getRowCountReply(map);
	}

	@Override
	public void g_insertReply(TeamBoardReplyCommand teamReply) {
		teamBoardMapper.g_insertReply(teamReply);
	}

	@Override
	public void g_updateReply(TeamBoardReplyCommand teamReply) {
		teamBoardMapper.g_updateReply(teamReply);
	}

	@Override
	public void g_deleteReply(Integer re_gnum) {
		teamBoardMapper.g_deleteReply(re_gnum);
	}


}
