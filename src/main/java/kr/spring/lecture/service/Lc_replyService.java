package kr.spring.lecture.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.Lc_replyCommand;

@Transactional
public interface Lc_replyService {
	@Transactional(readOnly=true)
	public List<Lc_replyCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String, Object> map);
	public void insertReply(Lc_replyCommand lcrCommand);
	public void updateReply(Lc_replyCommand lcrCommand);
	public void deleteReply(Integer lcr_num);
	
	public void deleteReplyByLcNum(Integer lc_num);

}