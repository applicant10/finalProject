package kr.spring.team.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.team.domain.TeamBoardCommand;
import kr.spring.team.domain.TeamBoardReplyCommand;

@Transactional
public interface TeamBoardService {
	@Transactional(readOnly=true)
	public List<TeamBoardCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(TeamBoardCommand board);
	@Transactional(readOnly=true)
	public TeamBoardCommand select(Integer num);
	public void update(TeamBoardCommand board);
	public void delete(Integer num);
	
	//´ñ±Û
	@Transactional(readOnly=true)
	public List<TeamBoardReplyCommand> teamReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int g_getRowCountReply(Map<String,Object> map);
	public void g_insertReply(TeamBoardReplyCommand teamReply);
	public void g_updateReply(TeamBoardReplyCommand teamReply);
	public void g_deleteReply(Integer re_gnum);
	
	
}
