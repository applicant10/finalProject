package kr.spring.lecture.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;

import kr.spring.lecture.domain.Lc_replyCommand;

public interface Lc_replyMapper {
	public List<Lc_replyCommand> list(Map<String, Object> map);
	public int getRowCountReply(Map<String, Object> map);
	public void insertReply(Lc_replyCommand lcrCommand);
	public void updateReply(Lc_replyCommand lcrCommand);
	public void deleteReply(Integer lcr_num);
	
	@Delete("delete from lc_reply WHERE lc_num=#{lc_num}")
	public void deleteReplyByLcNum(Integer lc_num);
}
