package kr.spring.study.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.study.domain.StudyCommand;
import kr.spring.study.domain.StudyReplyCommand;

public interface StudyService {
	//ºÎ¸ð±Û
	@Transactional(readOnly=true)
	public List<StudyCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(StudyCommand study);
	@Transactional(readOnly=true)
	public StudyCommand selectBoard(Integer num);
	public void update(StudyCommand study);
	public void delete(Integer num);
	
	//´ñ±Û
	@Transactional(readOnly=true)
	public List<StudyReplyCommand> studyReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String,Object> map);
	public void insertReply(StudyReplyCommand studyReply);
	public void updateReply(StudyReplyCommand studyReply);
	public void deleteReply(Integer re_tnum);
}
