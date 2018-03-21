package kr.spring.lecture.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.lecture.domain.LecturePointCommand;
import kr.spring.lecture.domain.LectureReplyCommand;

@Transactional
public interface LectureReplyService {
	@Transactional
	public LectureReplyCommand myReply(Map<String, Object> map);
	
	@Transactional(readOnly=true)
	public List<LectureReplyCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String, Object> map);
	public void insertReply(LectureReplyCommand lrCommand, Map<String, Object> map);
	public void updateReply(LectureReplyCommand lrCommand);
	public void deleteReply(Integer lr_num);
	
	public void deleteReplyByLNum(Integer l_num);
	
	public void averagePoint(Integer l_num);

	@Transactional(readOnly=true)
	public LecturePointCommand lecturePoint(Integer l_num);
}