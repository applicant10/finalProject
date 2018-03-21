package kr.spring.lecture.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.lecture.dao.Lc_replyMapper;
import kr.spring.lecture.domain.Lc_replyCommand;
import kr.spring.lecture.domain.LecturePointCommand;

@Service("lc_replyService")
public class Lc_replyServiceImpl implements Lc_replyService {

	@Resource
	private Lc_replyMapper lcreplyMapper;
	
	@Override
	public List<Lc_replyCommand> list(Map<String, Object> map) {
		return lcreplyMapper.list(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		return lcreplyMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(Lc_replyCommand lcrCommand) {
		lcreplyMapper.insertReply(lcrCommand);
	}

	@Override
	public void updateReply(Lc_replyCommand lcrCommand) {
		lcreplyMapper.updateReply(lcrCommand);
	}

	@Override
	public void deleteReply(Integer lcr_num) {
		lcreplyMapper.deleteReply(lcr_num);
	}

	@Override
	public void deleteReplyByLcNum(Integer lc_num) {
		lcreplyMapper.deleteReplyByLcNum(lc_num);
	}
}
